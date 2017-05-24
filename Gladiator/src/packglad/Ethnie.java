package packglad;

import java.util.ArrayList;
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
    private ArrayList<Gladiateur> listeGladiateur;

    public Ethnie(Integer ide, String nom) {
        this.ide = ide;
        this.nom = nom;
    }
    
    public String getNom() { return this.nom; };

    public Integer getScore() {         
        int res= 0; //Score total
        for(int i =0; i<this.listeGladiateur.size(); i++){
            if( this.listeGladiateur.get(i).getEtat() == "en forme") {
                res += 10;
            }
            else if (this.listeGladiateur.get(i).getEtat()=="blesse"){
                res +=5;
            }
        }
        return res;
    }
}
