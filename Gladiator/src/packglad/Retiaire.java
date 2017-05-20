package packglad;

import java.util.Collection;

public class Retiaire extends Gladiateur {
    /**
     * @attribute
     */
    private static Integer c_agiliteMax;

    /**
     * @attribute
     */
    private Integer agilite;

    /**
     * @attribute
     */
    private static Integer c_forceInitiale = 30;

    /**
     * @associates <{packglad.Arme}>
     */
    private static Collection c_armeUtilisable;

    public Retiaire(Integer idg, String nom, Integer agilite, Ethnie e) {
    }

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
    }

    public static void c_listeArmeDispo() {
    }

    public static void c_autoriserArme(Arme a) {
    }

    public static void c_setForceInitiale(Integer force) {
    }

    public static void c_setAgiliteMax(Integer agi) {
    }

    public String getType() {
        return "Retiaire";
    }
}
