package metier;

import java.util.ArrayList;
import java.util.Collection;

public class Retiaire extends Gladiateur {
    /**
     * @attribute
     */
    private static Integer c_forceInitiale = 30;

    /**
     * @attribute
     */
    private static Integer c_agiliteMax = 50;

    /**
     * @attribute
     */
    private Integer agilite;

    /**
     * @associates <{metier.Arme}>
     */
    private static ArrayList<Arme> c_armeUtilisable;

    public Retiaire(Integer idg, String nom, Integer agilite) {
        super(idg, nom);
        if (agilite > c_agiliteMax) agilite = c_agiliteMax;
        else if (agilite < 0) agilite = 0;
        this.agilite = agilite;
    }

    public Integer getForce() { return c_forceInitiale; }
    
    public String getType() { return "Retiaire"; }
    
    public static void c_setForceInitiale(Integer force) { c_forceInitiale = force; }
    
    public static void c_setAgiliteMax(Integer agi) { c_agiliteMax = agi; }
    
    public static ArrayList<Arme> c_listeArmeDispo() { return new ArrayList<Arme>(c_armeUtilisable); }
    
    public static void c_autoriserArme(Arme a) {
        // On cherche si l'arme n'est pas d�j� autoris�e
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

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
        // On prend la somme de la puissance d�fensive
        // en pour pouvoir la soustraire aux d�g�ts
        int puissDefTotal = 0;
        for (Arme a : this.getArmes()) {
            puissDefTotal += a.getPuissDef();
        }
        
        // On calcul les d�g�ts qui vont �tre inflig� � notre Gladiateur 
        int degatInflige = degat - puissDefTotal;
        if (degatInflige <  0) degatInflige = 0;
        
        // Puis on inflige les d�g�ts
        this.setVie(this.getVie() - degatInflige);
        if (this.getVie() < 0) this.setVie(0);
    }
    
    public String rapport() {
        // On fait le rapport du Gladiateur de base
        String rapport = super.rapport();
        
        // On rajoute les particularit�s du Mirmillon (poids et aggresseurs)
        rapport += String.format("Mon poids est de %d. Et mes aggresseurs sont : ",
                                 this.agilite);
        return rapport;
    }
}