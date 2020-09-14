package net.xcore.resourceserver.rki.dao;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MariaDbCovid19CaseRepositoryIntegrationTest {

  @Autowired
  MariaDbCovid19CaseRepository repository;

  @Test
  public void testGetDistinctDatensatzDatum(){
    List<LocalDateTime> datensatzDatumList = repository.getDistinctDatensatzDatum();
    for(LocalDateTime datensatzDatum : datensatzDatumList){
      System.out.println(datensatzDatum);
    }
  }

}
