package net.xcore.resourceserver.rki.dao;

import java.time.LocalDateTime;
import java.util.List;
import net.xcore.resourceserver.rki.domain.RkiCovid19Case;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CassandraRkiCovid19CaseDaoIntegrationTest {

  public static final LocalDateTime WELL_KNOWN_DATE_IN_DATABASE = LocalDateTime
      .of(2020, 9, 6, 2, 0, 0);
  @Autowired
  private CassandraRkiCovid19CaseDao dao;

  @Test
  public void testFetchByDatensatzDatum() {
    List<? extends RkiCovid19Case> cases = dao.fetchByDatensatzDatum(WELL_KNOWN_DATE_IN_DATABASE, 1);
    System.out.println(cases.get(0));
  }

  @Test
  public void testFetchDistinctDatensatzDatum() {
    List<LocalDateTime> datensatzDatums = dao.getDistinctDatensatzDatum();
    for(LocalDateTime datensatzDatum : datensatzDatums){
      System.out.println(datensatzDatum);
    }
  }

}
