package packglad;

import java.util.ArrayList;

import metier.Gladiateur;
import metier.Mirmillon;
import metier.Retiaire;
import metier.Arme;

public class GGladiateur {
    private static Integer idgNext = 1;
    private static ArrayList<Gladiateur> gladiateurs = new ArrayList<Gladiateur>();

    public static ArrayList<Gladiateur> listerGladiateur() { return new ArrayList<Gladiateur>(gladiateurs); }

    public static Gladiateur ajouterMirmillon(String nom, Integer poids) {
        // Deux Gladiateurs peuvent avoir le même nom du coup on ne fait pas de recherche
        Gladiateur g = new Mirmillon(idgNext, nom, poids);
        gladiateurs.add(g);
        idgNext++;
        
        return g;
    }
    
    public static Gladiateur ajouterRetiaire(String nom, Integer agi) {
        // Deux Gladiateurs peuvent avoir le même nom du coup on ne fait pas de recherche
        Gladiateur g = new Retiaire(idgNext, nom, agi);
        gladiateurs.add(g);
        idgNext++;
        
        return g;
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
