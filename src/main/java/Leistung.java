import java.math.BigDecimal;
import java.math.RoundingMode;

public class Leistung {

    private final String beschreibung;
    private final BigDecimal preis;
    private Aufwand aufwand;

    public Leistung(String beschreibung, BigDecimal preis) {
        this.beschreibung = beschreibung;
        this.preis = preis;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public void setAufwand(Aufwand aufwand) {
        this.aufwand = aufwand;
    }

    public BigDecimal executeBerechneBetrag() {
        if(this.aufwand == null) {
            throw new IllegalStateException("Aufwand ist nicht gesetzt");
        }
        return aufwand.berechneBetrag(this);
    }

    @Override
    public String toString() {
        BigDecimal betragInklAufwand = aufwand != null
                ? aufwand.berechneBetrag(this).setScale(2, RoundingMode.HALF_EVEN)
                : preis.setScale(2, RoundingMode.HALF_EVEN);

        return "Leistung: " +
                "Beschreibung = '" + beschreibung + '\'' +
                ", Preis = " + preis +
                ", Preis inklusive Aufwand = " + betragInklAufwand;
    }

}
