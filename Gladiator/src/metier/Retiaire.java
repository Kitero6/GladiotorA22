package metier;

import java.util.Collection;

public class Retiaire extends Gladiateur {
    /**
     * @attribute
     */
    private static Integer c_forceInitiale = 30;

    /**
     * @attribute
     */
    private static Integer c_agiliteMax;

    /**
     * @attribute
     */
    private Integer agilite;

    /**
     * @associates <{metier.Arme}>
     */
    private static Collection c_armeUtilisable;

    public Retiaire(Integer idg, String nom, Integer agilite, Integer vie) {
    }

    public static Collection c_listeArmeDispo() {
    }

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
    }

    public static void c_setForceInitiale(Integer force) {
    }

    public String rapport() {
    }

    public static void c_autoriserArme(Arme a) {
    }

    public String getType() {
    }

    public static void c_setAgiliteMax(Integer agi) {
    }

    public Integer getForce() {
    }
}
