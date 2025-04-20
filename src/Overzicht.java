import java.util.ArrayList;
import java.util.List;

public class Overzicht {
    private String maand;
    private List<Transactie> inkomsten;
    private List<Transactie> uitgaven;

    public Overzicht(String maand) {
        this.maand = maand;
        this.inkomsten = new ArrayList<>();
        this.uitgaven = new ArrayList<>();
    }

    public void categoriseerTransactie(Transactie transactie) {
        if (transactie.getDatum().startsWith(maand)) {
            if (transactie.getType().equalsIgnoreCase("inkomst")) {
                inkomsten.add(transactie);
            } else if (transactie.getType().equalsIgnoreCase("uitgave")) {
                uitgaven.add(transactie);
            }
        }
    }

    public double berekenTotaalInkomsten() {
        double totaal = 0.0;
        for (Transactie inkomst : inkomsten) {
            totaal += inkomst.getBedrag();
        }
        return totaal;
    }
    public double berekenTotaalUitgaven() {
        double totaal = 0.0;
        for (Transactie uitgave : uitgaven) {
            totaal += uitgave.getBedrag();
        }
        return totaal;
    }

    public void toonMaandoverzicht() {
        System.out.println("Maandoverzicht voor: " + maand);

        if (inkomsten.isEmpty()) {
            System.out.println("\nGeen inkomsten geregistreerd.");
        } else {
            System.out.println("\nInkomsten:");
            for (Transactie t : inkomsten) {
                System.out.println("+ " + t.getDatum() + ": " + t.getBeschrijving() + " (€" + t.getBedrag() + ")");
            }
        }

        if (uitgaven.isEmpty()) {
            System.out.println("\n Geen uitgaven geregistreerd.");
        } else {
            System.out.println("\nUitgaven:");
            for (Transactie t : uitgaven) {
                System.out.println("- " + t.getDatum() + ": " + t.getBeschrijving() + " (€" + t.getBedrag() + ")");
            }
        }

        System.out.println("\n Totaal inkomsten: €" + berekenTotaalInkomsten());
        System.out.println("Totaal uitgaven: €" + berekenTotaalUitgaven());
    }
}