package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class GEthnie {
    /**
     * @attribute
     */
    private static Integer ideNext;

    /**
     * @associates <{packglad.Ethnie}>
     */
    private static ArrayList<Ethnie> ethnies;

    public static void ajouterGladiateur(Ethnie e, Gladiateur g) {
        for(int i =0; i< ethnies.size(); i++){
            if(ethnies.get(i) == e) {
                ethnies.get(i)
            }
        }
        
    }

    public static void listerEthnie() {
    }

    public static void listerGladiateur(Ethnie e) {
    }

    public static void ajouteurEthnie(String nom) {
    }

    public static Ethnie chercherEthnie(Integer ide) { // Fais en sorte que la fonction retourne null si l'ethnie n'existe pas
        return null;
    }

    public static Ethnie getEthnieGladiateur(Gladiateur g) { return null;
    }
}
