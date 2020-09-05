package net.xcore.ressourceserver.rki.domain;

import java.time.LocalDateTime;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("rki_covid19_case")
public class RkiCovid19Case {

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
  @PrimaryKey
  private RkiCovid19CaseKey caseKey;
  private LocalDateTime refdatum;

  public RkiCovid19Case() {
  }

  public void setAltersgruppe(String altersgruppe) {
    this.altersgruppe = altersgruppe;
  }

  public void setAltersgruppe2(String altersgruppe2) {
    this.altersgruppe2 = altersgruppe2;
  }

  public void setAnzahlFall(int anzahlFall) {
    this.anzahlFall = anzahlFall;
  }

  public void setAnzahlGenesen(int anzahlGenesen) {
    this.anzahlGenesen = anzahlGenesen;
  }

  public void setAnzahlTodesfall(int anzahlTodesfall) {
    this.anzahlTodesfall = anzahlTodesfall;
  }

  public void setBundesland(String bundesland) {
    this.bundesland = bundesland;
  }

  public void setDatenstand(LocalDateTime datenstand) {
    this.datenstand = datenstand;
  }

  public void setGeschlecht(String geschlecht) {
    this.geschlecht = geschlecht;
  }

  public void setIdBundesland(int idBundesland) {
    this.idBundesland = idBundesland;
  }

  public void setIdLandkreis(String idLandkreis) {
    this.idLandkreis = idLandkreis;
  }

  public void setIstErkrankungsbeginn(int istErkrankungsbeginn) {
    this.istErkrankungsbeginn = istErkrankungsbeginn;
  }

  public void setLandkreis(String landkreis) {
    this.landkreis = landkreis;
  }

  public void setMeldedatum(LocalDateTime meldedatum) {
    this.meldedatum = meldedatum;
  }

  public void setNeuGenesen(int neuGenesen) {
    this.neuGenesen = neuGenesen;
  }

  public void setNeuerFall(int neuerFall) {
    this.neuerFall = neuerFall;
  }

  public void setNeuerTodesfall(int neuerTodesfall) {
    this.neuerTodesfall = neuerTodesfall;
  }

  public void setCaseKey(RkiCovid19CaseKey caseKey) {
    this.caseKey = caseKey;
  }

  public void setRefdatum(LocalDateTime refdatum) {
    this.refdatum = refdatum;
  }

  public RkiCovid19Case(RkiCovid19CaseDto dto) {
    RkiCovid19CaseKey key = new RkiCovid19CaseKey(dto.ObjectId, dto.DatensatzDatum);
    caseKey = key;
    altersgruppe = dto.Altersgruppe;
    altersgruppe2 = dto.Altersgruppe2;
    anzahlFall = dto.AnzahlFall;
    anzahlGenesen = dto.AnzahlGenesen;
    anzahlTodesfall = dto.AnzahlTodesfall;
    bundesland = dto.Bundesland;
    datenstand = dto.Datenstand;
    geschlecht = dto.Geschlecht;
    idBundesland = dto.IdBundesland;
    idLandkreis = dto.IdLandkreis;
    istErkrankungsbeginn = dto.IstErkrankungsbeginn;
    landkreis = dto.Landkreis;
    meldedatum = dto.Meldedatum;
    neuGenesen = dto.NeuGenesen;
    neuerFall = dto.NeuerFall;
    neuerTodesfall = dto.NeuerTodesfall;
    refdatum = dto.Refdatum;
  }

  public String getAltersgruppe() {
    return altersgruppe;
  }

  public String getAltersgruppe2() {
    return altersgruppe2;
  }

  public int getAnzahlFall() {
    return anzahlFall;
  }

  public int getAnzahlGenesen() {
    return anzahlGenesen;
  }

  public int getAnzahlTodesfall() {
    return anzahlTodesfall;
  }

  public String getBundesland() {
    return bundesland;
  }

  public LocalDateTime getDatenstand() {
    return datenstand;
  }

  public String getGeschlecht() {
    return geschlecht;
  }

  public int getIdBundesland() {
    return idBundesland;
  }

  public String getIdLandkreis() {
    return idLandkreis;
  }

  public int getIstErkrankungsbeginn() {
    return istErkrankungsbeginn;
  }

  public String getLandkreis() {
    return landkreis;
  }

  public LocalDateTime getMeldedatum() {
    return meldedatum;
  }

  public int getNeuGenesen() {
    return neuGenesen;
  }

  public int getNeuerFall() {
    return neuerFall;
  }

  public int getNeuerTodesfall() {
    return neuerTodesfall;
  }

  public RkiCovid19CaseKey getCaseKey() {
    return caseKey;
  }

  public LocalDateTime getRefdatum() {
    return refdatum;
  }

  @Override
  public String toString() {
    return "RkiCovid19Case{" +
        "altersgruppe='" + altersgruppe + '\'' +
        ", altersgruppe2='" + altersgruppe2 + '\'' +
        ", anzahlFall=" + anzahlFall +
        ", anzahlGenesen=" + anzahlGenesen +
        ", anzahlTodesfall=" + anzahlTodesfall +
        ", bundesland='" + bundesland + '\'' +
        ", datenstand=" + datenstand +
        ", geschlecht='" + geschlecht + '\'' +
        ", idBundesland=" + idBundesland +
        ", idLandkreis='" + idLandkreis + '\'' +
        ", istErkrankungsbeginn=" + istErkrankungsbeginn +
        ", landkreis='" + landkreis + '\'' +
        ", meldedatum=" + meldedatum +
        ", neuGenesen=" + neuGenesen +
        ", neuerFall=" + neuerFall +
        ", neuerTodesfall=" + neuerTodesfall +
        ", caseKey=" + caseKey +
        ", refdatum=" + refdatum +
        '}';
  }
}