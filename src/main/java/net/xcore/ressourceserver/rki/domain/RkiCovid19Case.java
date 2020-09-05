package net.xcore.ressourceserver.rki.domain;

import java.time.Instant;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("rki_covid19_case")
public class RkiCovid19Case {

  private final String altersgruppe;
  private final String altersgruppe2;
  private final int anzahlFall;
  private final int anzahlGenesen;
  private final int anzahlTodesfall;
  private final String bundesland;
  private final Instant datenstand;
  private final String geschlecht;
  private final int idBundesland;
  private final String idLandkreis;
  private final int istErkrankungsbeginn;
  private final String landkreis;
  private final Instant meldedatum;
  private final int neuGenesen;
  private final int neuerFall;
  private final int neuerTodesfall;
  @PrimaryKey
  private final RkiCovid19CaseKey caseKey;
  private final Instant refdatum;

  @SuppressWarnings("ConstructorWithTooManyParameters")
  public RkiCovid19Case(String altersgruppe, String altersgruppe2, int anzahlFall,
      int anzahlGenesen,
      int anzahlTodesfall, String bundesland, Instant datenstand, String geschlecht,
      int idBundesland, String idLandkreis, int istErkrankungsbeginn, String landkreis,
      Instant meldedatum, int neuGenesen, int neuerFall, int neuerTodesfall,
      RkiCovid19CaseKey caseKey, Instant refdatum) {
    this.altersgruppe = altersgruppe;
    this.altersgruppe2 = altersgruppe2;
    this.anzahlFall = anzahlFall;
    this.anzahlGenesen = anzahlGenesen;
    this.anzahlTodesfall = anzahlTodesfall;
    this.bundesland = bundesland;
    this.datenstand = datenstand;
    this.geschlecht = geschlecht;
    this.idBundesland = idBundesland;
    this.idLandkreis = idLandkreis;
    this.istErkrankungsbeginn = istErkrankungsbeginn;
    this.landkreis = landkreis;
    this.meldedatum = meldedatum;
    this.neuGenesen = neuGenesen;
    this.neuerFall = neuerFall;
    this.neuerTodesfall = neuerTodesfall;
    this.caseKey = caseKey;
    this.refdatum = refdatum;
  }

  public RkiCovid19Case(RkiCovid19CaseDto dto) {
    RkiCovid19CaseKey key = new RkiCovid19CaseKey(dto.ObjectId, dto.DatensatzDatum);
    this.caseKey = key;
    this.altersgruppe = dto.Altersgruppe;
    this.altersgruppe2 = dto.Altersgruppe2;
    this.anzahlFall = dto.AnzahlFall;
    this.anzahlGenesen = dto.AnzahlGenesen;
    this.anzahlTodesfall = dto.AnzahlTodesfall;
    this.bundesland = dto.Bundesland;
    this.datenstand = dto.Datenstand;
    this.geschlecht = dto.Geschlecht;
    this.idBundesland = dto.IdBundesland;
    this.idLandkreis = dto.IdLandkreis;
    this.istErkrankungsbeginn = dto.IstErkrankungsbeginn;
    this.landkreis = dto.Landkreis;
    this.meldedatum = dto.Meldedatum;
    this.neuGenesen = dto.NeuGenesen;
    this.neuerFall = dto.NeuerFall;
    this.neuerTodesfall = dto.NeuerTodesfall;
    this.refdatum = dto.Refdatum;
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

  public Instant getDatenstand() {
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

  public Instant getMeldedatum() {
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

  public Instant getRefdatum() {
    return refdatum;
  }

  ;

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