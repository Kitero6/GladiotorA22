package packglad;

import java.util.ArrayList;

import metier.Arme;

public class GArme {
    /**
     * @attribute
     */
    private static Integer idaNext = 1;

    /**
     * @associates <{metier.Arme}>
     */
    private static ArrayList<Arme> armes;

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
