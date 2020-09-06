package net.xcore.ressourceserver.rki.dao;

import java.util.List;
import java.util.Optional;
import net.xcore.ressourceserver.rki.domain.cassandra.CassandraRkiCovid19Case;
import net.xcore.ressourceserver.rki.domain.RkiCovid19Case;
import net.xcore.ressourceserver.rki.domain.cassandra.CassandraRkiCovid19Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

@Service
public class CassandraRkiCovid19CaseDao {

  @Autowired
  private CassandraTemplate cassandraTemplate;

  public RkiCovid19Case fetchOne() {
<<<<<<< HEAD:src/main/java/net/xcore/ressourceserver/rki/dao/RkiCovid19CaseDao.java
    Optional<? extends RkiCovid19Case> rkiCase = cassandraTemplate.query(CassandraRkiCovid19Case.class).one();
=======
    Optional<? extends RkiCovid19Case> rkiCase = cassandraTemplate
        .query(CassandraRkiCovid19Case.class).first();
>>>>>>> cd2b0638d4cc23a6b558e615c1b5ab4346910220:src/main/java/net/xcore/ressourceserver/rki/dao/CassandraRkiCovid19CaseDao.java
    if (rkiCase.isPresent()) {
      RkiCovid19Case covidCase = rkiCase.get();
      return covidCase;
    }
    return null;
  }

  public List<? extends RkiCovid19Case> fetchAll() {
    return cassandraTemplate.query(CassandraRkiCovid19Case.class).all();
  }

  public void create(RkiCovid19Case covid19Case) {
    cassandraTemplate.insert(covid19Case);
  }
}
