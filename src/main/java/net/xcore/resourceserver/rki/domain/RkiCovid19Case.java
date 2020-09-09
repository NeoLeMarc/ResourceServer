package net.xcore.resourceserver.rki.domain;

import java.time.LocalDateTime;

public interface RkiCovid19Case {

  void setAltersgruppe(String altersgruppe);

  void setAltersgruppe2(String altersgruppe2);

  void setAnzahlFall(int anzahlFall);

  void setAnzahlGenesen(int anzahlGenesen);

  void setAnzahlTodesfall(int anzahlTodesfall);

  void setBundesland(String bundesland);

  void setDatenstand(LocalDateTime datenstand);

  void setGeschlecht(String geschlecht);

  void setIdBundesland(int idBundesland);

  void setIdLandkreis(String idLandkreis);

  void setIstErkrankungsbeginn(int istErkrankungsbeginn);

  void setLandkreis(String landkreis);

  void setMeldedatum(LocalDateTime meldedatum);

  void setNeuGenesen(int neuGenesen);

  void setNeuerFall(int neuerFall);

  void setNeuerTodesfall(int neuerTodesfall);

  void setCaseKey(RkiCovid19CaseKey caseKey);

  void setRefdatum(LocalDateTime refdatum);

  String getAltersgruppe();

  String getAltersgruppe2();

  int getAnzahlFall();

  int getAnzahlGenesen();

  int getAnzahlTodesfall();

  String getBundesland();

  LocalDateTime getDatenstand();

  String getGeschlecht();

  int getIdBundesland();

  String getIdLandkreis();

  int getIstErkrankungsbeginn();

  String getLandkreis();

  LocalDateTime getMeldedatum();

  int getNeuGenesen();

  int getNeuerFall();

  int getNeuerTodesfall();

  RkiCovid19CaseKey getCaseKey();

  LocalDateTime getRefdatum();
}
