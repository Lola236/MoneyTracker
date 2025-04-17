public class Inkomst extends Transactie {
    public Inkomst(double bedrag, String datum, String beschrijving, Categorie categorie) {
        super(bedrag, datum, beschrijving, categorie);
    }

    @Override
    public double berekenSaldo() {
        return getBedrag();
    }
}
