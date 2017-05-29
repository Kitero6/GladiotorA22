package packglad;

import java.util.ArrayList;

import metier.Arme;
import metier.Ethnie;

public class GArme {
    private static Integer idaNext = 1;
    private static ArrayList<Arme> armes = new ArrayList<Arme>();

    public static Arme ajouterArme(String nom, Integer puissanceOff, Integer puissanceDef) {
        // On verifie qu'une Arme du même nom n'existe pas
        boolean trouve = false;
        int i = 0;
        while (i < armes.size() && !trouve) {
            if (armes.get(i).getNom() == nom) trouve = true;
            i++;
        }
        Arme a = new Arme(null, null, null, null);
        if (!trouve) {
            a = new Arme(idaNext, nom, puissanceOff, puissanceDef);
            armes.add(a);
            idaNext++;
        }
        return a;
    }

    public static Arme chercherArme(Integer ida) {
        Arme a = null;
        boolean trouve = false;
        int i =0;
        while(i< armes.size() && !trouve) {
            if(armes.get(i).getIda()==ida) {
                a = armes.get(i);
                trouve = true;
            }
            i++;
        }
        
        return a;
    }
    
    public static ArrayList<Arme> listerArme() {
        return armes;
    }
}
