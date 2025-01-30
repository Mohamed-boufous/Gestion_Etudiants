import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.logging.Logger;


public class CompteCourant extends Compte implements Transaction, Comparable<CompteCourant> {
    private boolean decouvert;
    private double limiteDecouvert;
    private LocalDateTime dateDerniereTransaction;
    private  static Logger logger = Logger.getLogger(CompteCourant.class.getName());




    public CompteCourant(int numeroDeCompte, double solde, Titulaire titulaire, boolean decouvert, double limiteDecouvert) {
        super(numeroDeCompte, solde, titulaire);
        this.decouvert = decouvert;
        this.limiteDecouvert = -limiteDecouvert;
        this.dateDerniereTransaction = super.getDateDeCreation().atStartOfDay();
    }

    @Override
    public void deposer(double montant) throws invalidmount {
        if (montant < 0) {
            throw new invalidmount("le montnat est incorrect ");
        } else if (montant > 0) {
            setSolde(getSolde() + montant);
            System.out.println("nouveaux solde de compte " + getNumeroDeCompte() + " est  " + getSolde());
            this.dateDerniereTransaction = LocalDateTime.now();

        } else System.out.println("Impossible de deposit dans le compte " + getNumeroDeCompte());
    }

    @Override
    public void retirer(double amount) throws invalidmount ,Limite_decouvert , non_decouvert {

        if (amount < 0) {
            throw new invalidmount("Le montant est incorrect.");
        }


        if (decouvert) {

            if (getSolde() - amount >= limiteDecouvert) {
                setSolde(getSolde() - amount);
                 System.out.println("Nouveau solde du compte " + getNumeroDeCompte() + " est : " + getSolde());
                this.dateDerniereTransaction = LocalDateTime.now();
            } else {
                throw new Limite_decouvert( "Impossible de retirer. Solde insuffisant pour le compte  car depassemnt de decouvert : " + getNumeroDeCompte());
            }
        }

        else {
            if (getSolde() - amount >= 0) {
                setSolde(getSolde() - amount);
                System.out.println("Nouveau solde du compte " + getNumeroDeCompte() + " est : " + getSolde());
                this.dateDerniereTransaction = LocalDateTime.now();
            } else {

                throw new non_decouvert( "Impossible de retirer. Solde insuffisant pour le compte decouvert non autoriser  : " + getNumeroDeCompte());
            }
        }
    }

    @Override

    public void transferer(CompteCourant destination, double montant) throws invalidmount ,Limite_decouvert , non_decouvert  {



                   this.retirer(montant);

                   destination.deposer(montant);


    }
public int comparerSolde (CompteCourant o2 )
{
    return  Double.compare(this.getSolde() , o2.getSolde()) ;

}
    void afficherCompteCourant() {
        afficherCompte();


    }


    public boolean isDecouvert() {
        return decouvert;
    }

    public void setDecouvert(boolean decouvert) {
        this.decouvert = decouvert;
    }

    public double getLimiteDecouvert() {
        return limiteDecouvert;
    }

    public void setLimiteDecouvert(double limiteDecouvert) {
        this.limiteDecouvert = limiteDecouvert;
    }

    public LocalDateTime getDateDerniereTransaction() {
        return dateDerniereTransaction;
    }

    public void setDateDerniereTransaction(LocalDateTime dateDerniereTransaction) {
        this.dateDerniereTransaction = dateDerniereTransaction;
    }

    @Override
    public int compareTo(CompteCourant o) {
        if (this.getDateDerniereTransaction().compareTo(o.getDateDerniereTransaction()) == 0) {
            if (super.getNumeroDeCompte() == o.getNumeroDeCompte()) {
                return 0;

            } else {
                return 1;

            }
        }
        return this.getDateDerniereTransaction().compareTo(o.getDateDerniereTransaction());


    }
}
