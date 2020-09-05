package net.xcore.ressourceserver.rki.domain.cassandra;

import java.time.LocalDateTime;
import net.xcore.ressourceserver.rki.domain.RkiCovid19CaseKey;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class CassandraRkiCovid19CaseKey implements RkiCovid19CaseKey {

  @PrimaryKeyColumn(name = "objectId", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
  private final int objectId;

  @PrimaryKeyColumn(name = "datensatzDatum", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  @CassandraType(type = Name.TIMESTAMP)
  private final LocalDateTime datensatzDatum;

  public CassandraRkiCovid19CaseKey(int objectId, LocalDateTime datensatzDatum) {
    this.objectId = objectId;
    this.datensatzDatum = datensatzDatum;
  }

  @Override
  public int getObjectId() {
    return objectId;
  }

  @Override
  public LocalDateTime getDatensatzDatum() {
    return datensatzDatum;
  }
}
