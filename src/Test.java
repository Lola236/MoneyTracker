public class Test {
    public static void main(String[] args) {
        testTransactieWordtGoedToegevoegd();
        testTipsBijHogeUitgave();
        testMaandoverzichtBerekening();
    }

    public static void testTransactieWordtGoedToegevoegd() {
        Categorie categorie = new Categorie("Boodschappen");
        Transactie transactie = new Uitgave(50.0, "2025-04-10", "Jumbo", categorie);
        categorie.voegTransactieToe(transactie);

        if (categorie.getTransactie().size() == 1 &&
        categorie.getTransactie().get(0).getBeschrijving().equals("Jumbo")) {
            System.out.println("Test1 is gelukt: Transactie is goed toegevoegd.");
        } else {
            System.out.println("Test1 is mislukt: Transactie is niet goed opgeslagen.");
        }
    }

    public static void testTipsBijHogeUitgave() {
        Categorie categorie = new Categorie("Energie");
        categorie.voegTransactieToe(new Uitgave(150.0, "2025-04-10", "Eneco", categorie));
        Tips tips = new Tips(categorie);
        String tekst = tips.genereerTip();

        if (tekst.contains("veel uitgegeven")) {
            System.out.println("Test2 is gelukt: Tips bij hoge uitgave klopt.");
        } else {
            System.out.println("Test2 is mislukt: Verkeerde tip gegenereerd.");
        }
    }

    public static void testMaandoverzichtBerekening() {
        Categorie categorie = new Categorie("Extra");
        Transactie uitgave1 = new Uitgave(10.0, "2025-04-10", "Sushi", categorie);
        Transactie uitgave2 = new Uitgave(20.0, "2025-04-10", "Film", categorie);
        Transactie inkomst = new Uitgave(30.0, "2025-04-10", "Tikkie", categorie);

        Overzicht overzicht = new Overzicht("2025-04");
        overzicht.categoriseerTransactie(uitgave1);
        overzicht.categoriseerTransactie(uitgave2);
        overzicht.categoriseerTransactie(inkomst);

        double verwachtTotaal = 50.0;
        double echtTotaal = overzicht.berekenTotaalUitgaven();

        if (echtTotaal == verwachtTotaal) {
            System.out.println("Test3 is gelukt: Maandoverzicht telt €" + echtTotaal + "correct op.");
        } else {
            System.out.println("Test3 is mislukt: Verwacht €" + verwachtTotaal + ", maar kreeg €" + echtTotaal);
        }
    }
}
