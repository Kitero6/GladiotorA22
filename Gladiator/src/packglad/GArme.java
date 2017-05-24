package packglad;

import java.util.ArrayList;
import java.util.Collection;

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
        for(int i =0; i< armes.size(); i++) {
            if(armes.get(i).getIda()==ida) {
                a = armes.get(i);
            }
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
