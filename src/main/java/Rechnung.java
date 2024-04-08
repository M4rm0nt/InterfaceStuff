import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Rechnung {
    private final List<Leistung> leistungen;

    public Rechnung() {
        this.leistungen = new ArrayList<>();
    }

    public void addPosition(Leistung leistung) {
        this.leistungen.add(leistung);
    }

    public BigDecimal getGesamtsumme() {
        BigDecimal gesamtsumme = BigDecimal.ZERO;
        for (Leistung leistung : leistungen) {
            gesamtsumme = gesamtsumme.add(leistung.executeBerechneBetrag());
        }
        return gesamtsumme.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getGesamtsummeOhneAufwand() {
        BigDecimal gesamtsummeOhneAufwand = BigDecimal.ZERO;
        for (Leistung leistung : leistungen) {
            gesamtsummeOhneAufwand = gesamtsummeOhneAufwand.add(leistung.getPreis());
        }
        return gesamtsummeOhneAufwand.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rechnung:\n");
        for (Leistung leistung : leistungen) {
            sb.append("\t").append(leistung).append("\n");
        }
        sb.append("Gesamtsumme ohne Aufwand: ").append(getGesamtsummeOhneAufwand()).append("\n");
        sb.append("Gesamtsumme inklusive Aufwand: ").append(getGesamtsumme()).append("\n");
        return sb.toString();
    }
}