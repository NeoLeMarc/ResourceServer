package net.xcore.ressourceserver.rki.domain;

import java.time.LocalDateTime;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class RkiCovid19CaseKey {

  @PrimaryKeyColumn(name = "objectId", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
  private final int objectId;

  @PrimaryKeyColumn(name = "datensatzDatum", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  @CassandraType(type = Name.TIMESTAMP)
  private final LocalDateTime datensatzDatum;

  public RkiCovid19CaseKey(int objectId, LocalDateTime datensatzDatum) {
    this.objectId = objectId;
    this.datensatzDatum = datensatzDatum;
  }

  public int getObjectId() {
    return objectId;
  }

  public LocalDateTime getDatensatzDatum() {
    return datensatzDatum;
  }
}
