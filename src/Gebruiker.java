import java.util.List;
import java.util.ArrayList;

public class Gebruiker {
    private String naam;
    private int gebruikersID;
    private List<Categorie> categories;

    public Gebruiker(String naam, int gebruikersID) {
        this.naam = naam;
        this.gebruikersID = gebruikersID;
        this.categories = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public int getGebruikersID() {
        return gebruikersID;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void voegCategorieToe(String categorieNaam) {
        Categorie nieuweCategorie = new Categorie(categorieNaam);
        categories.add(nieuweCategorie);
    }
    public void voegTransactieToe(Transactie transactie) {
        boolean categorieGevonden = false;

        for (Categorie categorie : categories) {
            if (categorie.getNaam().equalsIgnoreCase(transactie.getCategorie().getNaam())) {
                categorie.voegTransactieToe(transactie);
                categorieGevonden = true;
                break;
            }
        }
    }
        public void bekijkOverzicht() {
            System.out.println("Overzicht voor gebruiker: " + naam);

            for (Categorie categorie : categories) {
                System.out.println("Categorie: " + categorie.getNaam());
                System.out.println("Totaalbedrag: €" + categorie.totaalBedrag());
                System.out.println("Binnen budget? " + (categorie.controleerBudget() ? "Ja" : "Nee"));

                List<Transactie> transacties= categorie.getTransactie();
                if (transacties.isEmpty()) {
                    System.out.println(" (Geen transacties)");
                } else {
                    for (Transactie t : transacties) {
                        System.out.println("   -" + t.getDatum() + ": " + t.getBeschrijving() + " (" + t.berekenSaldo() + ") €" + t.getBedrag());
                    }
                }
            }
        }
    }
