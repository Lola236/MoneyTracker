import java.util.ArrayList;
import java.util.List;

public class Overzicht {
    private String maand;
    private List<Uitgave> uitgaven;

    public Overzicht(String maand) {
        this.maand = maand;
        this.uitgaven = new ArrayList<>();
    }

    public void categoriseerTransactie(Transactie transactie) {
        if (transactie.berekenSaldo() < 0 && transactie.getDatum().startsWith(maand)) {
            Uitgave uitgave = new Uitgave(transactie.getBedrag(), transactie.getDatum(), transactie.getBeschrijving(), transactie.getCategorie());
            uitgaven.add(uitgave);
        }
    }

    public double berekenTotaalUitgaven() {
        double totaal = 0.0;
        for (Uitgave uitgave : uitgaven) {
            totaal += uitgave.berekenSaldo();
        }
        return totaal;
    }
    public double berekenTotalUitgaven(List<Transactie> transacties) {
        double totaal = 0.0;
        for (Transactie transactie : transacties) {
            if (transactie.berekenSaldo() < 0 && transactie.getDatum().startsWith(maand)) {
                totaal += transactie.berekenSaldo();
            }
        }
        return totaal;
    }

    public List<Uitgave> filterTransactiesOpMaand(String maand) {
        List<Uitgave> gefiltered = new ArrayList<>();
        for (Uitgave uitgave : uitgaven) {
            if (uitgave.getDatum().startsWith(maand)) {
              gefiltered.add(uitgave);
            }
        }
        return gefiltered;
    }

    public void toonMaandoverzicht(){
        System.out.println("Maandoverzicht voor: " + maand);
        if (uitgaven.isEmpty()) {
            System.out.println("Geen uitgaven geregistreerd.");
        } else {
            for (Uitgave uitgave : uitgaven) {
                System.out.println("- " + uitgave.getDatum() + ": " + uitgave.getBeschrijving() + " (€" + uitgave.getBedrag() + ")");
            }
            System.out.println("Totaal uitgaven: €" + berekenTotaalUitgaven());
        }
    }

    public String getMaand(){
        return maand;
    }

    public List<Uitgave> getUitgaven() {
        return uitgaven;
    }
}
