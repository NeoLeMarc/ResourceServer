package net.xcore.resourceserver.rki.dao;

import net.xcore.resourceserver.rki.domain.cassandra.CassandraRkiCovid19Case;
import net.xcore.resourceserver.rki.domain.cassandra.CassandraRkiCovid19CaseKey;
import org.springframework.data.repository.CrudRepository;

public interface CassandraCovid19CaseRepository extends
    CrudRepository<CassandraRkiCovid19Case, CassandraRkiCovid19CaseKey> {
}
