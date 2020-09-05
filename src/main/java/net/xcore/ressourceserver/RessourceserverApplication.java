package net.xcore.ressourceserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Optional;
import javax.annotation.PostConstruct;
import net.xcore.ressourceserver.rki.domain.RKIFeatureDto;
import net.xcore.ressourceserver.rki.domain.RkiCovid19Case;
import net.xcore.ressourceserver.rki.domain.RkiCovid19CaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RessourceserverApplication {

  @Autowired
  private ObjectMapper objectMapper;

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

  @Autowired
  CassandraTemplate cassandraTemplate;

  @GetMapping("/rkidata/case")
  public RkiCovid19CaseDto getRkidata() {
    Optional<RkiCovid19Case> rkiCase = cassandraTemplate.query(RkiCovid19Case.class).one();
    if (rkiCase.isPresent()) {
      RkiCovid19Case covidCase = rkiCase.get();
      RkiCovid19CaseDto rkiCovid19CaseDto = new RkiCovid19CaseDto(covidCase);
      return rkiCovid19CaseDto;
    }
    return null;

  }

  @PostMapping(value = "/rkidata/feature", consumes = "application/json", produces = "application/json")
  public RkiCovid19CaseDto postRkiFeatureData(@RequestBody RKIFeatureDto feature) {
    return feature.properties;
  }

  @PostMapping(value = "/rkidata/case", consumes = "application/json", produces = "application/json")
  public RkiCovid19CaseDto postRkiCaseData(@RequestBody RkiCovid19CaseDto rkiCase) {
    return rkiCase;
  }
}
