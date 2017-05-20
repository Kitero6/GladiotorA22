package packglad;

import java.util.Collection;

public class Ethnie {
    /**
     * @attribute
     */
    private Integer ide;

    /**
     * @attribute
     */
    private String nom;

    /**
     * @associates <{packglad.Gladiateur}>
     */
    private Collection listeGladiateur;

    public Ethnie(Integer ide, String nom) {
    }
    
    public String getNom() { return this.nom; };

    public Integer getScore() { return null;
    }
}
