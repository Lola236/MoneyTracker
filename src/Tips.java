public class Tips {
    private String tekst;
    private Categorie categorie;

    public Tips(Categorie categorie) {
        this.categorie = categorie;
        this.tekst = "";
    }
    public String genereerTip() {
        double totaal = Math.abs(categorie.totaalBedrag());
        String naam = categorie.getNaam();

        if (totaal == 0) {
            tekst = "Je hebt nog niks uitgegeven aan de categorie '" + naam + "'. Goed bezig!";
        } else if (totaal > 100) {
            tekst = "Je hebt veel uitgegeven aan '" + naam + "'.Kijk of je kunt besparen op vaste lasten.";
        } else if (totaal > 50) {
            tekst = "Let op: in de categorie '" + naam + "'zit je al boven de €50. Misschien moet je iets minder uitgeven.";
        } else {
            tekst = "Uitgaven in '" + naam + "' zijn laag. Goed bezig!";
        }
        return tekst;
    }
    public String getTekst(){
        return tekst;
    }
    public Categorie getCategorie(){
        return categorie;
    }
}
