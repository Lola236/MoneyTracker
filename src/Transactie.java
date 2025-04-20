public abstract class Transactie {
    private double bedrag;
    private String datum;
    private String beschrijving;
    private Categorie categorie;

    public Transactie(double bedrag,String datum, String beschrijving, Categorie categorie) {
      this.bedrag = bedrag;
      this.datum = datum;
      this.beschrijving = beschrijving;
      this.categorie = categorie;
    }
    public double getBedrag() { return bedrag; }
    public String getDatum() { return datum; }
    public String getBeschrijving() { return beschrijving; }
    public Categorie getCategorie() {return categorie; }

    public abstract double berekenSaldo();
    public abstract String getType();
    }

