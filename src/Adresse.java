import java.util.Objects;

public class Adresse {
    private String rue;
    private String ville;
    private int codePostal;
    private int numero;

    public Adresse(String rue, String ville, int codePostal, int numero) {
        this.rue = rue;
        this.ville = ville;

        if (codePostal <= 0) {
            throw new IllegalArgumentException("Le code postal doit etre positif.");
        } else
            this.codePostal = codePostal;
        if (numero <= 0) {
            throw new IllegalArgumentException("Le numero doit etre positif.");
        } else
            this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public int getNumero() {
        return numero;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return
                "rue= " + rue +
                        ", ville=   " + ville +
                        ", codePostal= " + codePostal +
                        ", numero= " + numero +
                        '}';
    }




}
