import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Compte {
    private int numeroDeCompte;
    private LocalDate dateDeCreation;
    private double solde;
    private Titulaire titulaire;

    public int getNumeroDeCompte() {
        return numeroDeCompte;
    }

    public void setNumeroDeCompte(int numeroDeCompte) {
        this.numeroDeCompte = numeroDeCompte;
    }

    public LocalDate getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDate dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Titulaire getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Titulaire titulaire) {
        this.titulaire = titulaire;
    }

    public Compte(int numeroDeCompte, double solde, Titulaire titulaire) {
        this.numeroDeCompte = numeroDeCompte;
        this.dateDeCreation = LocalDate.now();
        this.solde = solde;
        this.titulaire = titulaire;
    }

    public void afficherCompte() {
        System.out.println("information de Compte ");
        System.out.println("Numero de compte: " + getNumeroDeCompte());
        System.out.println("Date de creation: " + getDateDeCreation());
        System.out.println("Solde: " + getSolde());
        System.out.println("Tutulaire: " + getTitulaire());


    }
}
