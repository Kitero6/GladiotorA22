package metier;

import java.util.Collection;

public abstract class Gladiateur {
    /**
     * @attribute
     */
    private Integer vie;

    /**
     * @attribute
     */
    private static Integer c_vieInitiale = 200;

    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */
    private Integer idg;

    /**
     * @associates <{metier.Arme}>
     */
    protected Collection armes;

    public Gladiateur(Integer idg, String nom, Integer vie) {
    }

    public void frapper(Gladiateur gVictime, Arme a) {
    }

    public abstract String getType();

    public Integer getIdg() {
    }

    public void perdreArme(Arme a) {
    }

    public Collection declarerArme() {
    }

    public String getEtat() {
    }

    public String rapport() {
    }

    public static Integer c_getVieInitiale() {
    }

    public static void c_setVieInitiale(Integer vie) {
    }

    public String saluer() {
    }

    public void receveoirArme(Arme a) {
    }

    private Boolean verifArmeDispo(Arme a) {
    }

    public abstract void prendreCoup(Integer degat, Gladiateur gAgresseur);

    public abstract Integer getForce();

    public Collection getListeAgresseur() {
    }
}
