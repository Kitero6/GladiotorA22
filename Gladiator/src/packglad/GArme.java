package packglad;

import java.util.ArrayList;

import metier.Arme;

public class GArme {
    private static Integer idaNext = 1;
    private static ArrayList<Arme> armes = new ArrayList<Arme>();

    public static Arme ajouterArme(String nom, Integer puissanceOff, Integer puissanceDef) {
        // On verifie qu'une Arme du même nom n'existe pas
        Arme a = null;
        boolean trouve = false;
        int i = 0;
        while (i < armes.size() && !trouve) {
            if (armes.get(i).getNom() == nom) {
                a = armes.get(i);
                trouve = true;
            }
            i++;
        }
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
