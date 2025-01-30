import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        TreeSet<CompteCourant> hashSetComptes = new TreeSet<>();
        Logger logger = Logger.getLogger(Main.class.getName());
        Adresse a = new Adresse("lmzar", "ait melloul ", 80000, 23);
        Adresse a2 = new Adresse("tamazart", "ait melloul ", 80000, 23);
        Adresse a3 = new Adresse("l9li3a", "ait melloul ", 80000, 21);


        Titulaire t1 = new Titulaire("mohamed", "boufous", 122, a);
        Titulaire t2 = new Titulaire("abdo", "boufous", 1, a2);
        Titulaire t3 = new Titulaire("hassan", "zahir", 20, a3);
        Titulaire t4 = new Titulaire("rachid", "zahir", 20, a3);
        HashSet<Titulaire> titulaireHash = new HashSet<>();

        try {
            titulaireHash.add(t1);
            titulaireHash.add(t2);
            titulaireHash.add(t3);
            titulaireHash.add(t4);

        } catch (NullPointerException e) {
            e.getMessage();

        }


        CompteCourant c1 = new CompteCourant(1, 1000, t1, true, 10000);
        CompteCourant c2 = new CompteCourant(2, 9999, t2, false, 100);
        CompteCourant c3 = new CompteCourant(3, 0, t3, true, 1000);


        try {


            c3.retirer(1000000);


        } catch (invalidmount | non_decouvert | Limite_decouvert e) {
            logger.info(e.getMessage());
        }
        try {


            c2.retirer(1000000);


        } catch (invalidmount | non_decouvert | Limite_decouvert e) {
            logger.info(e.getMessage());
        }
        try {


            c1.transferer(c3, 2000000);


        } catch (invalidmount | non_decouvert | Limite_decouvert e) {
            logger.info(e.getMessage());
        }
            try {

                hashSetComptes.add(c1);
                hashSetComptes.add(c2);
                hashSetComptes.add(c3);


                System.out.println("l'affichage des comptesCourants ");
                for (CompteCourant element : hashSetComptes) {
                    element.afficherCompteCourant();
                }
                System.out.println("l'affichage des titulaires ");
                for (Titulaire t : titulaireHash) {
                    System.out.println(t);
                }

            } catch (NullPointerException e) {
                e.getMessage();

            }
           int  seuil =700 ;
        ArrayList<CompteCourant> Comptes = new ArrayList<>() ;
            Comptes.add(c1);
            Comptes.add(c2);
            Comptes.add(c3);

           /* Comptes.sort(new Comparator<CompteCourant>(){
                @Override
                public int compare(CompteCourant o1 , CompteCourant o2) {

                    return Double.compare(Math.abs(o1.getSolde()-seuil )  , Math.abs(o2.getSolde() -seuil))  ;

                }
        }
        );
*/


        Comptes.sort(( o1 ,  o2) -> (Double.compare(Math.abs(o1.getSolde()-seuil )  , o2.getSolde() )));
       //   Comptes.sort(CompteCourant::comparerSolde);



        System.out.println("-------------------------------l'affichage des Comptes---------------------- ");
        for(CompteCourant compte : Comptes)
        {
compte.afficherCompte();
        }




        }
    }
