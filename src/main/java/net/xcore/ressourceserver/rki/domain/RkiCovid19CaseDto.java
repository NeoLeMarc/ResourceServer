package net.xcore.ressourceserver.rki.domain;

import java.time.Instant;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RkiCovid19CaseDto {

  Logger logger = (Logger) LoggerFactory.getLogger(RkiCovid19Case.class);

  public String Altersgruppe;
  public String Altersgruppe2;
  public int AnzahlFall;
  public int AnzahlGenesen;
  public int AnzahlTodesfall;
  public String Bundesland;
  public Instant Datenstand;
  public String Geschlecht;
  public int IdBundesland;
  public String IdLandkreis;
  public int IstErkrankungsbeginn;
  public String Landkreis;
  public Instant Meldedatum;
  public int NeuGenesen;
  public int NeuerFall;
  public int NeuerTodesfall;
  public int ObjectId;
  public Instant DatensatzDatum;

  public RkiCovid19CaseDto() {
  }

  @Override
  public String toString() {
    return "RkiCovid19CaseDto{" +
        "Altersgruppe='" + Altersgruppe + '\'' +
        ", Altersgruppe2='" + Altersgruppe2 + '\'' +
        ", AnzahlFall=" + AnzahlFall +
        ", AnzahlGenesen=" + AnzahlGenesen +
        ", AnzahlTodesfall=" + AnzahlTodesfall +
        ", Bundesland='" + Bundesland + '\'' +
        ", Datenstand=" + Datenstand +
        ", Geschlecht='" + Geschlecht + '\'' +
        ", IdBundesland=" + IdBundesland +
        ", IdLandkreis='" + IdLandkreis + '\'' +
        ", IstErkrankungsbeginn=" + IstErkrankungsbeginn +
        ", Landkreis='" + Landkreis + '\'' +
        ", Meldedatum=" + Meldedatum +
        ", NeuGenesen=" + NeuGenesen +
        ", NeuerFall=" + NeuerFall +
        ", NeuerTodesfall=" + NeuerTodesfall +
        ", ObjectId=" + ObjectId +
        ", DatensatzDatum=" + DatensatzDatum +
        '}';
  }
}