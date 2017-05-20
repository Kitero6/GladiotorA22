package packglad;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Gladiateur {
    /**
     * @attribute
     */
    private Integer idg;

    /**
     * @attribute
     */
    private Integer force;

    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */
    private static Integer c_vieInitiale = 200;

    /**
     * @attribute
     */
    private Integer vie;

    /**
     * @associates <{packglad.Arme}>
     */
    private ArrayList<Arme> armes;

    public Integer getIdg() { return this.idg; }
    
    public static Integer c_getVieInitiale() { return c_vieInitiale; }
    
    public static void c_setVieInitiale(Integer vie) { c_vieInitiale = vie; }
    
    public abstract String getType();
    
    // Fonctio, qui ressort l'état du Gladiateur
    public String getEtat() {
        String etat;
        if (this.vie < 10) {
            etat = "moribond";
        } else if (this.vie <= 50) {
            etat = "blessé";
        } else {
            etat = "en forme";
        }
        return etat;
    }
    

    public void receveoirArme(Arme a) {
        // Le gladiateur reçoit l'arme seuleument si il ne l'a pas déjà d'équipé
        if (this.verifArmeDispo(a)) {
            armes.add(a);
        }
    }
    
    public void perdreArme(Arme a) {
        armes.remove(a);
    }
    
    public void frapper(Gladiateur gVictime, Arme a) {
        // On calcul les dégâts de base qui vont
        // être infligé au Gladiateur gVictime
        int degat = this.force + a.getPuissOffensive();
        gVictime.prendreCoup(degat, this);
    }
    
    public abstract void prendreCoup(Integer degat, Gladiateur gAgresseur);

    // Fonction qui vérie si le gladiateur ne possède pas
    // l'amre passée en paramètre
    private Boolean verifArmeDispo(Arme a) {
        boolean trouve = false;
        int i = 0;
        while (i < armes.size() && !trouve) {
            if (a == armes.get(i)) {
                trouve = true;
            }
            i++;
        }
        return !false;
    }

    public void rapport() {
        System.out.println(String.format("Ave Caesar, %s N°%d : %s, j'appartiens à l'ethnie des %s",
                                         this.getType(),
                                         this.idg,
                                         this.nom,
                                         GEthnie.getEthnieGladiateur(this).getNom()));
    }

    public void saluer() {
        System.out.println(String.format("Ave César ! Je suis %s de l'éthnie %s, mon identifiant est le N°%d. %s Je suis %s, c'est à dire que j'ai %d point(s) de vie(s). Ma force est de %s"));
    } 

    public void declarerArme() {
    }
}
