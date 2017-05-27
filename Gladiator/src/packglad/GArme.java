package packglad;

import java.util.ArrayList;

import metier.Arme;

public class GArme {
    private static Integer idaNext = 1;
    private static ArrayList<Arme> armes = new ArrayList<Arme>();

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

    public static void ajouterArme(String nom, Integer puissanceOff, Integer puissanceDef) {
        armes.add(new Arme(idaNext, nom, puissanceOff, puissanceDef));
        idaNext++;
    }

    public static ArrayList<Arme> listerArme() {
        return armes;
    }
}
