package metier;

import java.util.Collection;

public class Ethnie {
    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */
    private Integer ide;

    /**
     * @associates <{metier.Gladiateur}>
     */
    private Collection listeGladiateur;

    public Ethnie(Integer ide, String nom) {
        
    }

    public Integer getScore() {
    }

    public String getNom() {
    }

    public Integer getIde() {
    }

    public void ajouterGladiateur(Gladiateur g) {
    }
}
