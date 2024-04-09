import java.math.BigDecimal;
import java.math.RoundingMode;

public class Leistung {

    private final String beschreibung;
    private final BigDecimal preis;
    private Aufwand aufwand;
    private Steuer steuer;

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

    public void setSteuer(Steuer steuer) {
        this.steuer = steuer;
    }

    public BigDecimal executeBerechneBetrag() {
        if(this.aufwand == null) {
            throw new IllegalStateException("Aufwand ist nicht gesetzt");
        }
        return aufwand.berechneBetrag(this);
    }

    public BigDecimal berechneSteuersatz() {
        if(this.steuer == null) {
            throw new IllegalStateException("Steuer ist nicht gesetzt");
        }
        return steuer.berechneSteuersatz(this);
    }

    @Override
    public String toString() {
        BigDecimal betragInklAufwand = aufwand != null
                ? aufwand.berechneBetrag(this).setScale(2, RoundingMode.HALF_EVEN)
                : preis.setScale(2, RoundingMode.HALF_EVEN);

        BigDecimal steuerBetrag = steuer != null
                ? berechneSteuersatz().setScale(2, RoundingMode.HALF_EVEN)
                : BigDecimal.ZERO;

        BigDecimal gesamtbetrag = preis.add(betragInklAufwand).add(steuerBetrag).setScale(2, RoundingMode.HALF_EVEN);

        return "Leistung: \n" +
                "\tBeschreibung = '" + beschreibung + "',\n" +
                "\tPreis = " + preis + ",\n" +
                "\tAufwand = " + betragInklAufwand + ",\n" +
                "\tSteuer = " + steuerBetrag + ",\n" +
                "\tGesamtbetrag inkl. Aufwand und Steuer = " + gesamtbetrag + "\n";
    }

}
