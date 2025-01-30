import java.util.Objects;

public class Titulaire {
    private String nom;
    private String prenom;
    private int numero;

    private Adresse adresse;

    public Titulaire(String nom, String prenom, int numero, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        if (numero < 0) {
            throw new IllegalArgumentException("Le numero doit etre positif.");
        } else this.numero = numero;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", numero=" + numero + ", adresse=" + adresse + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Titulaire other = (Titulaire) obj;
        return numero == other.numero;
    }


}
