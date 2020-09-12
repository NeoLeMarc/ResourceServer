package net.xcore.resourceserver.rki.dao;

import java.time.LocalDateTime;
import java.util.List;
import net.xcore.resourceserver.rki.domain.mariadb.MariaDbRkiCovid19Case;
import net.xcore.resourceserver.rki.domain.mariadb.MariaDbRkiCovid19CaseKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MariaDbCovid19CaseRepository extends
    CrudRepository<MariaDbRkiCovid19Case, MariaDbRkiCovid19CaseKey> {

  @Query("SELECT DISTINCT(cas.caseKey.datensatzDatum) from MariaDbRkiCovid19Case as cas")
  public List<LocalDateTime> getDistinctDatensatzDatum();
}
