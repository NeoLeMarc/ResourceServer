package net.xcore.resourceserver.rki.domain.mariadb;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import net.xcore.resourceserver.rki.domain.RkiCovid19CaseKey;

@Embeddable
public class MariaDbRkiCovid19CaseKey implements RkiCovid19CaseKey, Serializable {

  private int objectId;

  private LocalDateTime datensatzDatum;

  public void setObjectId(int objectId) {
    this.objectId = objectId;
  }

  public void setDatensatzDatum(LocalDateTime datensatzDatum) {
    this.datensatzDatum = datensatzDatum;
  }

  public MariaDbRkiCovid19CaseKey(RkiCovid19CaseKey caseKey) {
    objectId = caseKey.getObjectId();
    datensatzDatum = caseKey.getDatensatzDatum();
  }

  public MariaDbRkiCovid19CaseKey(int objectId, LocalDateTime datensatzDatum) {
    this.objectId = objectId;
    this.datensatzDatum = datensatzDatum;
  }

  public MariaDbRkiCovid19CaseKey() {
    objectId = 0;
    datensatzDatum = LocalDateTime.now();
  }

  @Override
  @Column(name = "ObjectId")
  public int getObjectId() {
    return objectId;
  }

  @Override
  @Column(name = "DatensatzDatum")
  public LocalDateTime getDatensatzDatum() {
    return datensatzDatum;
  }
}
