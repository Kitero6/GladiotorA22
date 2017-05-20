package packglad;

import java.util.Collection;

public class Mirmillon extends Gladiateur {
    /**
     * @attribute
     */
    private static Integer c_poidsMax;

    /**
     * @attribute
     */
    private Integer poids;

    /**
     * @associates <{packglad.Arme}>
     */
    private static Collection c_armeUtilisable;

    /**
     * @associates <{packglad.Gladiateur}>
     */
    private Collection aggresseurs;

    public Mirmillon(Integer idg, String nom, Integer poids, Ethnie e) {
    }

    public String getType() { return "Mirmillon"; }

    public void rapport() {
    }

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
    }

    public static void c_setPoidMax(Integer poids) {
    }

    public static void c_listeArmeDispo() {
    }

    public static void c_autoriserArme(Arme a) {
    }
}
