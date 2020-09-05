package net.xcore.ressourceserver;

import java.util.Optional;
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

  public static void main(String[] args) {
    SpringApplication.run(RessourceserverApplication.class, args);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue ="World") String name){
    return "Hello " + name + '!';
  }
  @Autowired
  CassandraTemplate cassandraTemplate;

  @GetMapping("/rkidata")
  public String getRkidata(){
    Optional<RkiCovid19Case> rkiCase = cassandraTemplate.query(RkiCovid19Case.class).one();
    return rkiCase.get().toString();
  }

  @PostMapping(value="/rkidata", consumes = "application/json", produces = "application/json")
  public RkiCovid19CaseDto postRkidata(@RequestBody RkiCovid19CaseDto rkiCase) {
    return rkiCase;
  }
}
