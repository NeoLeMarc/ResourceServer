package net.xcore.ressourceserver.rki.domain;

import java.time.Instant;
import org.codehaus.jackson.annotate.JsonProperty;

public class RkiCovid19CaseDto {
        private String altersgruppe;
        private String altersgruppe2;
        private int anzahlFall;
        private int anzahlGenesen;
        private int anzahlTodesfall;
        private String bundesland;
        private Instant datenstand;
        private String geschlecht;
        private int idBundesland;
        private String idLandkreis;
        private int istErkrankungsbeginn;
        private String landkreis;
        private Instant meldedatum;
        private int neuGenesen;
        private int neuerFall;
        private int neuerTodesfall;
        private int objectId;
        private Instant datensatzDatum;


        @Override
        public String toString() {
                return "RkiCovid19CaseDto{" +
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
                    ", objectId=" + objectId +
                    ", datensatzDatum=" + datensatzDatum +
                    '}';
        }

        public RkiCovid19CaseDto() {
        }

        @JsonProperty("Altersgruppe")
        public String getAltersgruppe() {
                return altersgruppe;
        }

        @JsonProperty("Altersgruppe")
        public void setAltersgruppe(String altersgruppe) {
                this.altersgruppe = altersgruppe;
        }

        @JsonProperty("Altersgruppe2")
        public String getAltersgruppe2() {
                return altersgruppe2;
        }

        @JsonProperty("Altersgruppe2")
        public void setAltersgruppe2(String altersgruppe2) {
                this.altersgruppe2 = altersgruppe2;
        }

        @JsonProperty("AnzahlFall")
        public int getAnzahlFall() {
                return anzahlFall;
        }

        @JsonProperty("AnzahlFall")
        public void setAnzahlFall(int anzahlFall) {
                this.anzahlFall = anzahlFall;
        }
                                 @JsonProperty("AnzahlGenesen")
        public int getAnzahlGenesen() {
                return anzahlGenesen;
        }

        public void setAnzahlGenesen(int anzahlGenesen) {
                this.anzahlGenesen = anzahlGenesen;
        }

        public int getAnzahlTodesfall() {
                return anzahlTodesfall;
        }

        public void setAnzahlTodesfall(int anzahlTodesfall) {
                this.anzahlTodesfall = anzahlTodesfall;
        }

        public String getBundesland() {
                return bundesland;
        }

        public void setBundesland(String bundesland) {
                this.bundesland = bundesland;
        }

        public Instant getDatenstand() {
                return datenstand;
        }

        public void setDatenstand(Instant datenstand) {
                this.datenstand = datenstand;
        }

        public String getGeschlecht() {
                return geschlecht;
        }

        public void setGeschlecht(String geschlecht) {
                this.geschlecht = geschlecht;
        }

        public int getIdBundesland() {
                return idBundesland;
        }

        public void setIdBundesland(int idBundesland) {
                this.idBundesland = idBundesland;
        }

        public String getIdLandkreis() {
                return idLandkreis;
        }

        public void setIdLandkreis(String idLandkreis) {
                this.idLandkreis = idLandkreis;
        }

        public int getIstErkrankungsbeginn() {
                return istErkrankungsbeginn;
        }

        public void setIstErkrankungsbeginn(int istErkrankungsbeginn) {
                this.istErkrankungsbeginn = istErkrankungsbeginn;
        }

        public String getLandkreis() {
                return landkreis;
        }

        public void setLandkreis(String landkreis) {
                this.landkreis = landkreis;
        }

        public Instant getMeldedatum() {
                return meldedatum;
        }

        public void setMeldedatum(Instant meldedatum) {
                this.meldedatum = meldedatum;
        }

        public int getNeuGenesen() {
                return neuGenesen;
        }

        public void setNeuGenesen(int neuGenesen) {
                this.neuGenesen = neuGenesen;
        }

        public int getNeuerFall() {
                return neuerFall;
        }

        public void setNeuerFall(int neuerFall) {
                this.neuerFall = neuerFall;
        }

        public int getNeuerTodesfall() {
                return neuerTodesfall;
        }

        public void setNeuerTodesfall(int neuerTodesfall) {
                this.neuerTodesfall = neuerTodesfall;
        }

        public int getObjectId() {
                return objectId;
        }

        public void setObjectId(int objectId) {
                this.objectId = objectId;
        }

        public Instant getDatensatzDatum() {
                return datensatzDatum;
        }

        public void setDatensatzDatum(Instant datensatzDatum) {
                this.datensatzDatum = datensatzDatum;
        }
}