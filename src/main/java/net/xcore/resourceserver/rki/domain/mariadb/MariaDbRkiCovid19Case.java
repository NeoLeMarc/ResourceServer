package net.xcore.resourceserver.rki.domain.mariadb;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import net.xcore.resourceserver.rki.domain.RkiCovid19Case;
import net.xcore.resourceserver.rki.domain.RkiCovid19CaseKey;

@Entity
@Table(name = "rki_covid19_case")
public class MariaDbRkiCovid19Case implements RkiCovid19Case, Serializable {

  @Column(name = "Altersgruppe")
  private String altersgruppe;
  @Column(name = "Altersgruppe2")
  private String altersgruppe2;
  @Column(name = "AnzahlFall")
  private int anzahlFall;
  @Column(name = "AnzahlGenesen")
  private int anzahlGenesen;
  @Column(name = "AnzahlTodesfall")
  private int anzahlTodesfall;
  @Column(name = "Bundesland")
  private String bundesland;
  @Column(name = "Datenstand")
  private LocalDateTime datenstand;
  @Column(name = "Geschlecht")
  private String geschlecht;
  @Column(name = "IdBundesland")
  private int idBundesland;
  @Column(name = "IdLandkreis")
  private String idLandkreis;
  @Column(name = "IstErkrankungsbeginn")
  private int istErkrankungsbeginn;
  @Column(name = "Landkreis")
  private String landkreis;
  @Column(name = "Meldedatum")
  private LocalDateTime meldedatum;
  @Column(name = "NeuGenesen")
  private int neuGenesen;
  @Column(name = "NeuerFall")
  private int neuerFall;
  @Column(name = "NeuerTodesfall")
  private int neuerTodesfall;

  public MariaDbRkiCovid19Case() {
  }

  @EmbeddedId
  @AttributeOverrides({
      @AttributeOverride(name = "objectId", column = @Column(name = "ObjectId")),
      @AttributeOverride(name = "datensatzDatum", column = @Column(name = "DatensatzDatum"))})
  private MariaDbRkiCovid19CaseKey caseKey;
  @Column(name = "RefDatum")
  private LocalDateTime refDatum;

  public MariaDbRkiCovid19Case(RkiCovid19Case covidCase) {
    caseKey = new MariaDbRkiCovid19CaseKey(covidCase.getCaseKey());
    altersgruppe = covidCase.getAltersgruppe();
    altersgruppe2 = covidCase.getAltersgruppe2();
    anzahlFall = covidCase.getAnzahlFall();
    anzahlGenesen = covidCase.getAnzahlGenesen();
    anzahlTodesfall = covidCase.getAnzahlTodesfall();
    bundesland = covidCase.getBundesland();
    datenstand = covidCase.getDatenstand();
    geschlecht = covidCase.getGeschlecht();
    idBundesland = covidCase.getIdBundesland();
    idLandkreis = covidCase.getIdLandkreis();
    istErkrankungsbeginn = covidCase.getIstErkrankungsbeginn();
    landkreis = covidCase.getLandkreis();
    meldedatum = covidCase.getMeldedatum();
    neuerFall = covidCase.getNeuerFall();
    neuerTodesfall = covidCase.getNeuerTodesfall();
    neuGenesen = covidCase.getNeuGenesen();
    refDatum = covidCase.getRefdatum();
  }

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
  public void setCaseKey(RkiCovid19CaseKey caseKey) {
    this.caseKey = new MariaDbRkiCovid19CaseKey(caseKey);
  }

  @Override
  public LocalDateTime getRefdatum() {
    return refDatum;
  }
}
