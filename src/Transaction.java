public interface Transaction {
    void deposer(double amount) throws invalidmount;

    void retirer(double amount) throws invalidmount, Limite_decouvert,non_decouvert;

    void transferer(CompteCourant destination, double montant) throws invalidmount, Limite_decouvert, non_decouvert;

    default void deposer(double montant, CompteCourant destination) throws invalidmount {
        if (montant<0) {
            throw new invalidmount("Invalid montant");
        }
        System.out.println("deposer " + montant);
        destination.deposer(destination.getSolde() + montant);


    }

    default void retirer(double montant, CompteCourant destination) throws invalidmount ,Limite_decouvert , non_decouvert {
        if (montant<0) {
            throw new invalidmount("Invalid montant");
        }
        System.out.println("retirer");
        destination.setSolde(destination.getSolde() - montant);
    }

}
