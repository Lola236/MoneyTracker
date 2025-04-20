public class Uitgave extends Transactie {
    public Uitgave(double bedrag, String datum, String beschrijving, Categorie categorie) {
        super(bedrag, datum, beschrijving, categorie);
    }

    @Override
    public double berekenSaldo() {
        return getBedrag();
    }
    @Override
    public String getType() {
        return "uitgave";
}
}
