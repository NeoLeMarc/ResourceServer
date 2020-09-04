package net.xcore.ressourceserver.rki.domain;

import java.time.Instant;

public class RkiCovid19CaseKey {
  private final int objectId;
  private final Instant datensatzDatum;

  public RkiCovid19CaseKey(int objectId, Instant datensatzDatum) {
    this.objectId = objectId;
    this.datensatzDatum = datensatzDatum;
  }

  public int getObjectId() {
    return objectId;
  }

  public Instant getDatensatzDatum() {
    return datensatzDatum;
  }
}
