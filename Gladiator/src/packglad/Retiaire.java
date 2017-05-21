package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class Retiaire extends Gladiateur {
    @Override
    public void rapport() {
        // On fait le rapport du gladiateur normal
        super.rapport();
        // Et on ajoute l'exception du Retiaire (l'agilité)
        System.out.println(String.format(" et mon agilité est de %d."));
    }

    public String getType() {
        return "Retiaire";
    }
    
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
    private static ArrayList<Arme>
        c_armeUtilisable;

    public Retiaire(Integer idg, String nom, Integer agilite, Ethnie e) {
        this.idg = idg;
        this.vie = Gladiateur.c_getVieInitiale();
        this.nom = nom;
        this.force = c_forceInitiale;
        if (agilite > c_agiliteMax) agilite = c_agiliteMax;
        else if (agilite < 0) agilite = 0;
        this.agilite = agilite;
        GEthnie.ajouterGladiateur(e, this);
    }

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
        // On prend la somme de la puissance défensive
        // en pour pouvoir la soustraire aux dégâts
        int puissDefTotal = 0;
        for (Arme a : this.armes) {
            puissDefTotal += a.getPuissDefensive();
        }
        // On calcul les dégâts qui vont être infligé à notre Gladiateur 
        int degatInflige = degat - puissDefTotal;
        if (degatInflige <  0) degatInflige = 0;
        this.vie -= degatInflige;
    }

    public static ArrayList<Arme> c_listeArmeDispo() {
        return new ArrayList<Arme>(c_armeUtilisable);
    }

    public static void c_autoriserArme(Arme a) {
        // On cherche si l'arme n'est pas déjà autorisée
        boolean trouve = false;
        int i = 0;
        while (i < c_armeUtilisable.size() && !trouve) {
            if (a == c_armeUtilisable.get(i)) {
                trouve = true;
            }                
            i++;
        }
        // Et si elle ne l'est pas on l'ajoute
        if (!trouve) c_armeUtilisable.add(a);
    }

    public static void c_setForceInitiale(Integer force) {
        c_forceInitiale = force;
    }

    public static void c_setAgiliteMax(Integer agi) {
        c_agiliteMax = agi;
    }
}
