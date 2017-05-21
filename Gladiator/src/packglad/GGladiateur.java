package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class GGladiateur {
    /**
     * @attribute
     */
    private static Integer idgNext = 1;

    /**
     * @associates <{packglad.Gladiateur}>
     */
    private static ArrayList<Gladiateur> gladiateurs = new ArrayList<Gladiateur>();

    public static void ajouterMirmillon(String nom, Integer poids, Integer ideEthnie) {
        Ethnie e = GEthnie.chercherEthnie(ideEthnie);
        if (e != null) {
            Gladiateur g = new Mirmillon(idgNext, nom, poids, e);
            gladiateurs.add(g);
            idgNext++;
        }
    }
    
    public static void ajouterRetiaire(String nom, Integer agi, Integer ideEthnie) {
        Ethnie e = GEthnie.chercherEthnie(ideEthnie);
        if (e != null) {
            Gladiateur g = new Retiaire(idgNext, nom, agi, e);
            gladiateurs.add(g);
            idgNext++;
        }
    }

    public static Gladiateur chercherGladiateur(Integer idg) { 
        // On cherche le gladiateur
        boolean trouve = false;
        int i = 0;
        while (i < gladiateurs.size() && !trouve) {
            if (gladiateurs.get(i).getIdg() == idg) {
                trouve = true;
            }
            i++;
        }
        
        // On v�rifie si il a �t� trouv� ou non
        Gladiateur g;
        // Si il n'a pas �t� trouv� on return null
        if (!trouve) {
            g = null;
        // Sinon on ressort le gladiateur trouv�
        } else {
            g = gladiateurs.get(i-1);
        }
        return g;
    }

    public static void listerGladiateur() {
        for (Gladiateur g : gladiateurs) {
            g.rapport();
        }
    }

    public static void supprimerGladiateur(Gladiateur g) {
        gladiateurs.remove(g);
    }

    
}
