package net.xcore.ressourceserver.rki.dao;

import java.util.Optional;
import net.xcore.ressourceserver.rki.domain.RkiCovid19Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

@Service
public class RkiCovid19CaseDao {

  @Autowired
  private CassandraTemplate cassandraTemplate;

  public RkiCovid19Case fetchOne() {
    Optional<RkiCovid19Case> rkiCase = cassandraTemplate.query(RkiCovid19Case.class).one();
    if (rkiCase.isPresent()) {
      RkiCovid19Case covidCase = rkiCase.get();
      return covidCase;
    }
    return null;
  }
}
