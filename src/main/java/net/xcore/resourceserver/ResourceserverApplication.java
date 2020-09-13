package net.xcore.resourceserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import net.xcore.resourceserver.config.VaultMariaDbConfig;
import net.xcore.resourceserver.rki.dao.CassandraCovid19CaseRepository;
import net.xcore.resourceserver.rki.dao.CassandraRkiCovid19CaseDao;
import net.xcore.resourceserver.rki.dao.MariaDbCovid19CaseRepository;
import net.xcore.resourceserver.rki.domain.RKIFeatureCollectionDto;
import net.xcore.resourceserver.rki.domain.RKIFeatureDto;
import net.xcore.resourceserver.rki.domain.RkiCovid19Case;
import net.xcore.resourceserver.rki.domain.RkiCovid19CaseDto;
import net.xcore.resourceserver.rki.domain.RkiCovid19CaseKey;
import net.xcore.resourceserver.rki.domain.cassandra.CassandraRkiCovid19Case;
import net.xcore.resourceserver.rki.domain.cassandra.CassandraRkiCovid19CaseKey;
import net.xcore.resourceserver.rki.domain.mariadb.MariaDbRkiCovid19Case;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(VaultMariaDbConfig.class)
public class ResourceserverApplication {

  private static final Logger logger = LoggerFactory.getLogger(ResourceserverApplication.class);

  @Autowired
  private CassandraRkiCovid19CaseDao dao;

  @Autowired
  private CassandraCovid19CaseRepository cassandraRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MariaDbCovid19CaseRepository repository;

  VaultMariaDbConfig vaultConfiguration;

  ResourceserverApplication(VaultMariaDbConfig config) {
    vaultConfiguration = config;
  }

  @PostConstruct
  public void setUp() {
    objectMapper.registerModule(new JavaTimeModule());
    logger.info("----------------------------------------");
    logger.info("Configuration properties");
    logger.info("   mariadb.username is {}", vaultConfiguration.getUsername());
    logger.info("   mariadb.password is {}", vaultConfiguration.getPassword());
    logger.info("   mariadb.url is {}", vaultConfiguration.getUrl());
    logger.info("----------------------------------------");
  }

  public static void main(String[] args) {
    SpringApplication.run(ResourceserverApplication.class, args);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return "Hello " + name + '!';
  }


  @GetMapping("/rkidata/cases")
  public List<RkiCovid19CaseDto> getRkidata() {
    List<? extends RkiCovid19Case> covidCases = dao.fetchAll();
    List<RkiCovid19CaseDto> dtos = makeRkiCovid19CaseDtos(covidCases);
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
    logger.info("Started relational database sync");
    saveCasesInMariaDb(covidCases);
    logger.info("Finished relational database sync");
    return "OK";
  }

  @PostMapping("/rkidata/relational/missing/sync")
  public String triggerRkiRelationalSyncOfMissing() {
    List<LocalDateTime> datasetsInCassandra = dao.getDistinctDatensatzDatum();
    List<LocalDateTime> datasetsInMariaDb = repository.getDistinctDatensatzDatum();
    List<LocalDateTime> missing = new ArrayList<>();

    for (LocalDateTime datensatzDatum : datasetsInCassandra) {
      if (dayInSet(datensatzDatum, datasetsInMariaDb)) {
        logger.info("{} already in MariaDB - skipping", datensatzDatum);
      } else {
        missing.add(datensatzDatum);
        logger.info("{} NOT in MariaDB - syncing", datensatzDatum);
        List<? extends RkiCovid19Case> covidCases = dao.fetchByDatensatzDatum(datensatzDatum);
        logger.info("Started relational database sync for {}", datensatzDatum);
        saveCasesInMariaDb(covidCases);
        logger.info("Finished relational database sync for {}", datensatzDatum);
      }
    }
    return "Synced: " + missing;
  }

  private static boolean dayInSet(LocalDateTime datensatzDatum,
      List<LocalDateTime> datensatzDatumList) {
    for (LocalDateTime datensatzFromList : datensatzDatumList) {
      if (LocalDate.from(datensatzDatum).equals(LocalDate.from(datensatzFromList))) {
        return true;
      }
    }
    return false;
  }


  private void saveCasesInMariaDb(List<? extends RkiCovid19Case> covidCases) {
    List<MariaDbRkiCovid19Case> mariaDbCovidCases = new ArrayList<>();
    int i = 0;
    for (RkiCovid19Case covidCase : covidCases) {
      mariaDbCovidCases.add(new MariaDbRkiCovid19Case(covidCase));
      if (i++ % 1000 == 0) {
        repository.saveAll(mariaDbCovidCases);
        mariaDbCovidCases = new ArrayList<>();
        logger.info("Synced {} entries to relational database", i);
      }
    }
    repository.saveAll(mariaDbCovidCases);
  }

  @PostMapping(value = "/rkidata/feature", consumes = "application/json", produces = "application/json")
  public RkiCovid19CaseDto postRkiFeatureData(@RequestBody RKIFeatureDto feature) {
    return feature.properties;
  }

  @PostMapping(value = "/rkidata/case", consumes = "application/json", produces = "application/json")
  public RkiCovid19CaseDto postRkiCaseData(@RequestBody RkiCovid19CaseDto rkiCase) {
    return rkiCase;
  }

  @GetMapping(value = "/rkidata/test", produces = "application/json")
  public RkiCovid19CaseDto rkiFetchOneTester() {
    LocalDateTime datensatzDatum = LocalDateTime.of(2020, 9, 6, 2, 0, 0);
    List<? extends RkiCovid19Case> cases = dao.fetchByDatensatzDatum(datensatzDatum, 1);
    return new RkiCovid19CaseDto(cases.get(0));
  }

  @PostMapping(value = "/rkidata/features", consumes = "application/json", produces = "application/json")
  public RKIFeatureCollectionDto postRkiFeatureCollectionData(
      @RequestBody RKIFeatureCollectionDto features) {
    LocalDateTime maxDateTime;
    if (!features.features.isEmpty()) {
      maxDateTime = features.features.get(0).properties.Refdatum;
    } else {
      maxDateTime = LocalDateTime.of(2018, 01, 1, 0, 0);
    }
    for (RKIFeatureDto feature : features.features) {
      if (feature.properties.Refdatum.isAfter(maxDateTime)) {
        maxDateTime = feature.properties.Refdatum;
      }
    }
    for (RKIFeatureDto feature : features.features) {
      RkiCovid19Case covid19Case = new CassandraRkiCovid19Case(feature.properties);
      RkiCovid19CaseKey key = new CassandraRkiCovid19CaseKey(covid19Case.getCaseKey().getObjectId(),
          maxDateTime);
      covid19Case.setCaseKey(key);
      dao.create(covid19Case);
    }
    return features;
  }
}
