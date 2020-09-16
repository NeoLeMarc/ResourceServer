package net.xcore.resourceserver.rki.dao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import net.xcore.resourceserver.rki.domain.RkiCovid19Case;
import net.xcore.resourceserver.rki.domain.cassandra.CassandraRkiCovid19Case;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.AsyncCassandraTemplate;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class CassandraRkiCovid19CaseDao {

  Logger logger = LoggerFactory.getLogger(CassandraRkiCovid19CaseDao.class);

  @Autowired
  private CassandraTemplate cassandraTemplate;

  @Autowired
  private AsyncCassandraTemplate asyncCassandraTemplate;

  @Autowired
  private CqlTemplate cqlTemplate;

  public RkiCovid19Case fetchOne() {
    Optional<? extends RkiCovid19Case> rkiCase = cassandraTemplate
        .query(CassandraRkiCovid19Case.class).first();
    if (rkiCase.isPresent()) {
      RkiCovid19Case covidCase = rkiCase.get();
      return covidCase;
    }
    return null;
  }

  public List<? extends RkiCovid19Case> fetchAll() {
    return cassandraTemplate.query(CassandraRkiCovid19Case.class).all();
  }

  public List<? extends RkiCovid19Case> fetchByDatensatzDatum(LocalDateTime datensatzDatum) {
    return fetchByDatensatzDatum(datensatzDatum, 0);
  }

  public List<? extends RkiCovid19Case> fetchByDatensatzDatum(LocalDateTime datensatzDatum,
      long limit) {
    Query query = Query.query(Criteria.where("datensatzdatum").is(datensatzDatum));
    if (limit > 0) {
      query = query.limit(limit);
    }

    List<? extends
        RkiCovid19Case> cases = cassandraTemplate.select(query, CassandraRkiCovid19Case.class);
    return cases;
  }

  public List<LocalDateTime> getDistinctDatensatzDatum() {
    List<Instant> dateTimes = cqlTemplate
        .queryForList("SELECT distinct datensatzdatum FROM rki_covid19_case",
            Instant.class);

    List<LocalDateTime> localDateTimes = dateTimes.stream().map(instant -> LocalDateTime.ofInstant(instant,
        ZoneId.systemDefault())).collect(Collectors.toList());
    return localDateTimes;
  }

  public void create(RkiCovid19Case covid19Case) {
    asyncCassandraTemplate.insert(covid19Case);
  }
}
