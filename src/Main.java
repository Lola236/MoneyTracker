import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer je naam in: ");
        String naam = scanner.nextLine();

        System.out.println("Voer je gebruikersID in (in cijfers); ");
        int gebruikersID = scanner.nextInt();
        scanner.nextLine();

        Gebruiker gebruiker = new Gebruiker(naam, gebruikersID);
        System.out.println("Een account is aangemaakt voor " + gebruiker.getNaam() + " (ID: " + gebruiker.getGebruikersID() + ")\n");

        System.out.println("Voer de naam van een categorie in: ");
        String categorieNaam = scanner.nextLine();

        gebruiker.voegCategorieToe(categorieNaam);
        Categorie categorie = new Categorie(categorieNaam);

        System.out.println(" Wat is je budgetlimiet voor deze categorie?: ");
        double budgetlimiet = scanner.nextDouble();
        scanner.nextLine();
        categorie.setBudgetlimiet(budgetlimiet);

        System.out.println("Wil je een transactie toevoegn? (ja/nee): ");
        String antwoord = scanner.nextLine();

        if (antwoord.equalsIgnoreCase("ja")) {
            System.out.println("Is het een inkomst of uitgave?: ");
            String type = scanner.nextLine();

            System.out.println("Bedrag: ");
            double bedrag = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Datum (YYYY-MM-DD): ");
            String datum = scanner.nextLine();

            System.out.println("Beschrijving: ");
            String beschrijving = scanner.nextLine();

            Transactie transactie;
            if (type.equalsIgnoreCase("inkomst")) {
                transactie = new Inkomst(bedrag, datum, beschrijving, categorie);
            } else {
                transactie = new Uitgave(bedrag, datum, beschrijving, categorie);
            }

            gebruiker.voegTransactieToe(transactie);
        }

        System.out.println("\n Overzicht:");
        gebruiker.bekijkOverzicht();

        Tips tip = new Tips(categorie);
        System.out.println("\n Bespaartip:");
        System.out.println(tip.genereerTip());

        System.out.println("\nVoor welke maand wil je het overzicht tonen?: ");
        String gekozenMaand = scanner.nextLine();

        Overzicht overzicht = new Overzicht(gekozenMaand);

        for (Categorie categorie1 : gebruiker.getCategories()){
            for (Transactie transactie : categorie1.getTransactie()){
                overzicht.categoriseerTransactie(transactie);
            }
        }

        System.out.println("\n Maandoverzicht:");
        overzicht.toonMaandoverzicht();

        scanner.close();
    }
}