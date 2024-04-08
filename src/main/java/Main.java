import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Rechnung rechnung = new Rechnung();

        Leistung beratung = new Leistung("Beratung", new BigDecimal("100.00"));
        beratung.setAufwand(new NormalerAufwand());
        rechnung.addPosition(beratung);

        Leistung programmierung = new Leistung("Programmierung", new BigDecimal("200.00"));
        programmierung.setAufwand(new ErhoehterAufwand());
        rechnung.addPosition(programmierung);

        Leistung schulung = new Leistung("Schulung", new BigDecimal("300.00"));
        schulung.setAufwand(new NormalerAufwand());
        rechnung.addPosition(schulung);

        System.out.println(rechnung);
    }
}