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
  private int objectId;

  public CassandraRkiCovid19CaseKey() {
  }

  public void setObjectId(int objectId) {
    this.objectId = objectId;
  }

  public void setDatensatzDatum(LocalDateTime datensatzDatum) {
    this.datensatzDatum = datensatzDatum;
  }

  @PrimaryKeyColumn(name = "datensatzDatum", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  @CassandraType(type = Name.TIMESTAMP)
  private LocalDateTime datensatzDatum;

  public CassandraRkiCovid19CaseKey(int objectId, LocalDateTime datensatzDatum) {
    this.objectId = objectId;
    this.datensatzDatum = datensatzDatum;
  }

  public CassandraRkiCovid19CaseKey(RkiCovid19CaseKey caseKey) {
    datensatzDatum = caseKey.getDatensatzDatum();
    objectId = caseKey.getObjectId();
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
