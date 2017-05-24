package packglad;

import java.util.ArrayList;

import metier.Gladiateur;
import metier.Mirmillon;
import metier.Retiaire;

public class GGladiateur {
    /**
     * @attribute
     */
    private static Integer idgNext = 1;

    /**
     * @associates <{metier.Gladiateur}>
     */
    private static ArrayList<Gladiateur> gladiateurs;

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
        }
        return gTrouve;
    }

    public static void supprimerGladiateur(Gladiateur g) {
        gladiateurs.remove(g);
    }
}
