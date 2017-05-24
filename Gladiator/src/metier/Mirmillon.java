package metier;

import java.util.Collection;

public class Mirmillon extends Gladiateur {
    /**
     * @attribute
     */
    private Integer poids;

    /**
     * @attribute
     */
    private static Integer c_poidsMax;

    /**
     * @associates <{metier.Arme}>
     */
    private static Collection c_armeUtilisable;

    /**
     * @associates <{metier.Gladiateur}>
     */
    private Collection aggresseurs;

    public Mirmillon(Integer idg, String nom, Integer poids, Integer vie) {
    }

    public static void c_setPoidMax(Integer poids) {
    }

    public static void c_autoriserArme(Arme a) {
    }

    public String getType() {
    }

    public String rapport() {
    }

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
    }

    public static Collection c_listeArmeDispo() {
    }

    public Integer getForce() {
    }

    public Collection getListeAgresseur() {
    }
}
