import java.util.List;
import java.util.ArrayList;

public class Categorie {
    private String naam;
    private double budgetlimiet;
    private List<Transactie> transacties;

    public Categorie(String naam) {
        this.naam = naam;
        this.budgetlimiet = 0.0;
        this.transacties = new ArrayList<>();
    }
    public String getNaam() {return naam;
    }
    public void setNaam(String naam) {this.naam = naam;
    }
    public double getBudgetlimiet() {return budgetlimiet;
    }
    public void setBudgetlimiet(double budgetlimiet) {this.budgetlimiet = budgetlimiet;
    }
    public void voegTransactieToe(Transactie transactie) {this.transacties.add(transactie);
    }
    public double totaalBedrag(){
        double totaal = 0.0;
        for(Transactie transactie : transacties){
            totaal += transactie.berekenSaldo();
        }
        return totaal;
    }

    public boolean controleerBudget(){
        return Math.abs(totaalBedrag()) <= budgetlimiet;
    }

    public List<Transactie> getTransactie() {
        return transacties;
    }
}
