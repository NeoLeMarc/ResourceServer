package net.xcore.ressourceserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import net.xcore.ressourceserver.rki.dao.CassandraRkiCovid19CaseDao;
import net.xcore.ressourceserver.rki.dao.MariaDbCovid19CaseRepository;
import net.xcore.ressourceserver.rki.domain.RKIFeatureCollectionDto;
import net.xcore.ressourceserver.rki.domain.RKIFeatureDto;
import net.xcore.ressourceserver.rki.domain.RkiCovid19Case;
import net.xcore.ressourceserver.rki.domain.RkiCovid19CaseDto;
import net.xcore.ressourceserver.rki.domain.RkiCovid19CaseKey;
import net.xcore.ressourceserver.rki.domain.cassandra.CassandraRkiCovid19Case;
import net.xcore.ressourceserver.rki.domain.cassandra.CassandraRkiCovid19CaseKey;
import net.xcore.ressourceserver.rki.domain.mariadb.MariaDbRkiCovid19Case;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RessourceserverApplication {

  Logger logger = LoggerFactory.getLogger(RessourceserverApplication.class);

  @Autowired
  private CassandraRkiCovid19CaseDao dao;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MariaDbCovid19CaseRepository repository;

  @PostConstruct
  public void setUp() {
    objectMapper.registerModule(new JavaTimeModule());
  }

  public static void main(String[] args) {
    SpringApplication.run(RessourceserverApplication.class, args);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return "Hello " + name + '!';
  }


  @GetMapping("/rkidata/cases")
  public List<RkiCovid19CaseDto> getRkidata() {
    List<? extends RkiCovid19Case> covidCases = dao.fetchAll();
    List<RkiCovid19CaseDto> dtos = makeRkiCovid19CaseDtos(
        covidCases);
    return dtos;
  }

  @GetMapping("/rkidata/case")
  public RkiCovid19CaseDto getRkidataCase() {
    RkiCovid19Case covidCase = dao.fetchOne();
    RkiCovid19CaseDto dto = new RkiCovid19CaseDto((covidCase));
    return dto;
  }


  private static List<RkiCovid19CaseDto> makeRkiCovid19CaseDtos(
      Iterable<? extends RkiCovid19Case> covidCases) {
    List<RkiCovid19CaseDto> dtos = new ArrayList<>();
    for (RkiCovid19Case covidCase : covidCases) {
      RkiCovid19CaseDto rkiCovid19CaseDto = new RkiCovid19CaseDto(covidCase);
      dtos.add(rkiCovid19CaseDto);
    }
    return dtos;
  }

  @GetMapping("/rkidata/relational/cases")
  public List<RkiCovid19CaseDto> getRkiRelationalData() {
    Iterable<? extends RkiCovid19Case> covidCases = repository.findAll();
    List<RkiCovid19CaseDto> dtos = makeRkiCovid19CaseDtos(
        covidCases);
    return dtos;
  }


  @PostMapping("/rkidata/relational/sync")
  public String triggerRkiRelationalSync() {
    List<? extends RkiCovid19Case> covidCases = dao.fetchAll();
    List<MariaDbRkiCovid19Case> mariaDbCovidCases = new ArrayList<>();
    logger.info("Started relational database sync");
    int i = 0;
    for (RkiCovid19Case covidCase : covidCases) {
      mariaDbCovidCases.add(new MariaDbRkiCovid19Case(covidCase));
      if(i++ % 1000 == 0){
        repository.saveAll(mariaDbCovidCases);
        mariaDbCovidCases = new ArrayList<>();
        logger.info("Synced {} entries to relational database", i);
      }
    }
    repository.saveAll(mariaDbCovidCases);
    logger.info("Finished relational database sync");
    return "OK";
  }

  @PostMapping(value = "/rkidata/feature", consumes = "application/json", produces = "application/json")
  public RkiCovid19CaseDto postRkiFeatureData(@RequestBody RKIFeatureDto feature) {
    return feature.properties;
  }

  @PostMapping(value = "/rkidata/case", consumes = "application/json", produces = "application/json")
  public RkiCovid19CaseDto postRkiCaseData(@RequestBody RkiCovid19CaseDto rkiCase) {
    return rkiCase;
  }

  @PostMapping(value = "/rkidata/features", consumes = "application/json", produces = "application/json")
  public RKIFeatureCollectionDto postRkiFeatureCollectionData(
      @RequestBody RKIFeatureCollectionDto features) {
    for (RKIFeatureDto feature : features.features) {
      RkiCovid19Case covid19Case = new CassandraRkiCovid19Case(feature.properties);
      RkiCovid19CaseKey key = new CassandraRkiCovid19CaseKey(covid19Case.getCaseKey().getObjectId(),
          LocalDateTime.now());
      covid19Case.setCaseKey(key);
      dao.create(covid19Case);
    }
    return features;
  }
}
