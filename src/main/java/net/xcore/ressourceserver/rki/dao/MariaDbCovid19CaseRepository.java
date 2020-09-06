package net.xcore.ressourceserver.rki.dao;

import net.xcore.ressourceserver.rki.domain.mariadb.MariaDbRkiCovid19Case;
import net.xcore.ressourceserver.rki.domain.mariadb.MariaDbRkiCovid19CaseKey;
import org.springframework.data.repository.CrudRepository;

public interface MariaDbCovid19CaseRepository extends CrudRepository<MariaDbRkiCovid19Case, MariaDbRkiCovid19CaseKey> {
}
