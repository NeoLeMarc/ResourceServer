package net.xcore.resourceserver.rki.dao;

import net.xcore.resourceserver.rki.domain.mariadb.MariaDbRkiCovid19Case;
import net.xcore.resourceserver.rki.domain.mariadb.MariaDbRkiCovid19CaseKey;
import org.springframework.data.repository.CrudRepository;

public interface MariaDbCovid19CaseRepository extends CrudRepository<MariaDbRkiCovid19Case, MariaDbRkiCovid19CaseKey> {
}
