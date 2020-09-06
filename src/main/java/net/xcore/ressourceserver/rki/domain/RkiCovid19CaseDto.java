package net.xcore.ressourceserver.rki.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDateTime;
import net.xcore.ressourceserver.rki.util.RKIDateAndTimeDeserializer;
import net.xcore.ressourceserver.rki.util.RKIDateAndTimeDeserializer2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RkiCovid19CaseDto {

  public String Altersgruppe;
  public String Altersgruppe2;
  public int AnzahlFall;
  public int AnzahlGenesen;
  public int AnzahlTodesfall;
  public String Bundesland;
  @JsonDeserialize(using = RKIDateAndTimeDeserializer2.class)
  public LocalDateTime Datenstand;
  public String Geschlecht;
  public int IdBundesland;
  public String IdLandkreis;
  public int IstErkrankungsbeginn;
  public String Landkreis;
  @JsonDeserialize(using = RKIDateAndTimeDeserializer.class)
  public LocalDateTime Meldedatum;
  public int NeuGenesen;
  public int NeuerFall;
  public int NeuerTodesfall;
  public int ObjectId;
  public LocalDateTime DatensatzDatum;
  @JsonDeserialize(using = RKIDateAndTimeDeserializer.class)
  public LocalDateTime Refdatum;

  private Logger logger = LoggerFactory.getLogger(RkiCovid19CaseDto.class);
  public RkiCovid19CaseDto() {
  }

  public RkiCovid19CaseDto(RkiCovid19Case rcase) {
    RkiCovid19CaseKey key = rcase.getCaseKey();
    if (key != null) {
      ObjectId = key.getObjectId();
      DatensatzDatum = key.getDatensatzDatum();
    } else {
      logger.warn("Warning, got empty case key");
    }
    Altersgruppe = rcase.getAltersgruppe();
    Altersgruppe2 = rcase.getAltersgruppe2();
    AnzahlFall = rcase.getAnzahlFall();
    AnzahlGenesen = rcase.getAnzahlGenesen();
    AnzahlTodesfall = rcase.getAnzahlTodesfall();
    Bundesland = rcase.getBundesland();
    Datenstand = rcase.getDatenstand();
    Geschlecht = rcase.getGeschlecht();
    IdBundesland = rcase.getIdBundesland();
    IdLandkreis = rcase.getIdLandkreis();
    IstErkrankungsbeginn = rcase.getIstErkrankungsbeginn();
    Landkreis = rcase.getLandkreis();
    Meldedatum = rcase.getMeldedatum();
    NeuGenesen = rcase.getNeuGenesen();
    NeuerFall = rcase.getNeuerFall();
    NeuerTodesfall = rcase.getNeuerTodesfall();
    Refdatum = rcase.getRefdatum();
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
        ", Refdatum=" + Refdatum +
        '}';
  }
}