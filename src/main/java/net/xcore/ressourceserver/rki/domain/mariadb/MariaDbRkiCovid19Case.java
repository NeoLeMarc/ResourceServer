package net.xcore.ressourceserver.rki.domain.mariadb;

import java.time.LocalDateTime;
import net.xcore.ressourceserver.rki.domain.RkiCovid19Case;
import net.xcore.ressourceserver.rki.domain.RkiCovid19CaseKey;

public class MariaDbRkiCovid19Case implements RkiCovid19Case {

  private String altersgruppe;
  private String altersgruppe2;
  private int anzahlFall;
  private int anzahlGenesen;
  private int anzahlTodesfall;
  private String bundesland;
  private LocalDateTime datenstand;
  private String geschlecht;
  private int idBundesland;
  private String idLandkreis;
  private int istErkrankungsbeginn;
  private String landkreis;
  private LocalDateTime meldedatum;
  private int neuGenesen;
  private int neuerFall;
  private int neuerTodesfall;
  private RkiCovid19CaseKey caseKey;
  private LocalDateTime refDatum;

  @Override
  public void setAltersgruppe(String altersgruppe) {
    this.altersgruppe = altersgruppe;
  }

  @Override
  public void setAltersgruppe2(String altersgruppe2) {
    this.altersgruppe2 = altersgruppe2;
  }

  @Override
  public void setAnzahlFall(int anzahlFall) {
    this.anzahlFall = anzahlFall;
  }

  @Override
  public void setAnzahlGenesen(int anzahlGenesen) {
    this.anzahlGenesen = anzahlGenesen;
  }

  @Override
  public void setAnzahlTodesfall(int anzahlTodesfall) {
    this.anzahlTodesfall = anzahlTodesfall;
  }

  @Override
  public void setBundesland(String bundesland) {
    this.bundesland = bundesland;
  }

  @Override
  public void setDatenstand(LocalDateTime datenstand) {
    this.datenstand = datenstand;
  }

  @Override
  public void setGeschlecht(String geschlecht) {
    this.geschlecht = geschlecht;
  }

  @Override
  public void setIdBundesland(int idBundesland) {
    this.idBundesland = idBundesland;
  }

  @Override
  public void setIdLandkreis(String idLandkreis) {
    this.idLandkreis = idLandkreis;
  }

  @Override
  public void setIstErkrankungsbeginn(int istErkrankungsbeginn) {
    this.istErkrankungsbeginn = istErkrankungsbeginn;
  }

  @Override
  public void setLandkreis(String landkreis) {
    this.landkreis = landkreis;
  }

  @Override
  public void setMeldedatum(LocalDateTime meldedatum) {
    this.meldedatum = meldedatum;
  }

  @Override
  public void setNeuGenesen(int neuGenesen) {
    this.neuGenesen = neuGenesen;
  }

  @Override
  public void setNeuerFall(int neuerFall) {
    this.neuerFall = neuerFall;
  }

  @Override
  public void setNeuerTodesfall(int neuerTodesfall) {
    this.neuerTodesfall = neuerTodesfall;
  }

  @Override
  public void setCaseKey(RkiCovid19CaseKey caseKey) {
    this.caseKey = caseKey;
  }

  @Override
  public void setRefdatum(LocalDateTime refdatum) {
    refDatum = refdatum;
  }

  @Override
  public String getAltersgruppe() {
    return altersgruppe;
  }

  @Override
  public String getAltersgruppe2() {
    return altersgruppe2;
  }

  @Override
  public int getAnzahlFall() {
    return anzahlFall;
  }

  @Override
  public int getAnzahlGenesen() {
    return anzahlGenesen;
  }

  @Override
  public int getAnzahlTodesfall() {
    return anzahlTodesfall;
  }

  @Override
  public String getBundesland() {
    return bundesland;
  }

  @Override
  public LocalDateTime getDatenstand() {
    return datenstand;
  }

  @Override
  public String getGeschlecht() {
    return geschlecht;
  }

  @Override
  public int getIdBundesland() {
    return idBundesland;
  }

  @Override
  public String getIdLandkreis() {
    return idLandkreis;
  }

  @Override
  public int getIstErkrankungsbeginn() {
    return istErkrankungsbeginn;
  }

  @Override
  public String getLandkreis() {
    return landkreis;
  }

  @Override
  public LocalDateTime getMeldedatum() {
    return meldedatum;
  }

  @Override
  public int getNeuGenesen() {
    return neuGenesen;
  }

  @Override
  public int getNeuerFall() {
    return neuerFall;
  }

  @Override
  public int getNeuerTodesfall() {
    return neuerTodesfall;
  }

  @Override
  public RkiCovid19CaseKey getCaseKey() {
    return caseKey;
  }

  @Override
  public LocalDateTime getRefdatum() {
    return refDatum;
  }
}
