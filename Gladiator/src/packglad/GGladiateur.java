package packglad;

import java.util.ArrayList;

import metier.Gladiateur;
import metier.Mirmillon;
import metier.Retiaire;
import metier.Arme;

public class GGladiateur {
    /**
     * @attribute
     */
    private static Integer idgNext = 1;

    /**
     * @associates <{metier.Gladiateur}>
     */
    private static ArrayList<Gladiateur> gladiateurs;
    
    public GGladiateur () {
        gladiateurs = new ArrayList<Gladiateur>();
        idgNext = 1;
    }

    public static ArrayList<Gladiateur> listerGladiateur() { return new ArrayList<Gladiateur>(gladiateurs); }

    public static void ajouterMirmillon(String nom, Integer poids) {
        gladiateurs.add(new Mirmillon(idgNext, nom, poids));
        idgNext++;
    }
    
    public static void ajouterRetiaire(String nom, Integer agi) {
        gladiateurs.add(new Retiaire(idgNext, nom, agi));
        idgNext++;
    }

    public static Gladiateur chercherGladiateur(Integer idg) {
        boolean trouve = false;
        Gladiateur gTrouve = null;
        int i = 0;
        while (i < gladiateurs.size() && !trouve) {
            Gladiateur g = gladiateurs.get(i);
            if(g.getIdg() == idg) {
                gTrouve = g;
                trouve = true;
            }
            i++;
        }
        return gTrouve;
    }

    public static void supprimerGladiateur(Gladiateur g) {
        gladiateurs.remove(g);
    }

    public static void autoriserArmeMirmillon(Arme a) {
        Mirmillon.c_autoriserArme(a);
    }
    
    public static void autoriserArmeRetiaire(Arme a) {
        Retiaire.c_autoriserArme(a);
    }
}
