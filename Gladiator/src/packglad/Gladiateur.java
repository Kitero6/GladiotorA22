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
    
    // Fonctio, qui ressort l'�tat du Gladiateur
    public String getEtat() {
        String etat;
        if (this.vie < 10) {
            etat = "moribond";
        } else if (this.vie <= 50) {
            etat = "bless�";
        } else {
            etat = "en forme";
        }
        return etat;
    }
    

    public void receveoirArme(Arme a) {
        // Le gladiateur re�oit l'arme seuleument si il ne l'a pas d�j� d'�quip�
        if (this.verifArmeDispo(a)) {
            armes.add(a);
        }
    }
    
    public void perdreArme(Arme a) {
        armes.remove(a);
    }
    
    public void frapper(Gladiateur gVictime, Arme a) {
        // On calcul les d�g�ts de base qui vont
        // �tre inflig� au Gladiateur gVictime
        int degat = this.force + a.getPuissOffensive();
        gVictime.prendreCoup(degat, this);
    }
    
    public abstract void prendreCoup(Integer degat, Gladiateur gAgresseur);

    // Fonction qui v�rie si le gladiateur ne poss�de pas
    // l'amre pass�e en param�tre
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
        System.out.println(String.format("Ave Caesar, %s N�%d : %s, j'appartiens � l'ethnie des %s",
                                         this.getType(),
                                         this.idg,
                                         this.nom,
                                         GEthnie.getEthnieGladiateur(this).getNom()));
    }

    public void saluer() {
        System.out.println(String.format("Ave C�sar ! Je suis %s de l'�thnie %s, mon identifiant est le N�%d. %s Je suis %s, c'est � dire que j'ai %d point(s) de vie(s). Ma force est de %s"));
    } 

    public void declarerArme() {
    }
}
