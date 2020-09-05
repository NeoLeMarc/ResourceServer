package net.xcore.ressourceserver.rki.domain;

import java.time.LocalDateTime;

public interface RkiCovid19CaseKey {

  int getObjectId();

  LocalDateTime getDatensatzDatum();
}
