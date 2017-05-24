package metier;

import java.util.ArrayList;
import java.util.Collection;

public class Mirmillon extends Gladiateur {
    /**
     * @attribute
     */
    private Integer poids;

    /**
     * @attribute
     */
    private static Integer c_poidsMax = 100;

    /**
     * @associates <{metier.Arme}>
     */
    private static ArrayList<Arme> c_armeUtilisable;

    /**
     * @associates <{metier.Gladiateur}>
     */
    private ArrayList<Gladiateur> aggresseurs;

    public Mirmillon(Integer idg, String nom, Integer poids) {
        super(idg, nom);
        if (poids > c_poidsMax) poids = c_poidsMax;
        else if (poids < 0) poids = 0;
        this.poids = poids;
    }

    public Integer getForce() { return this.poids / 2; }
    
    public String getType() { return "Mirmillon"; }

    public ArrayList<Gladiateur> getListeAgresseur() { return new ArrayList<Gladiateur>(this.aggresseurs); }
    
    public static void c_setPoidMax(Integer poids) { c_poidsMax = poids; }
    
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
        
        this.setVie(this.getVie() - degatInflige);
        if (this.getVie() < 0) this.setVie(0);
        
        // Vu que c'est un Mirmillon on retien l'aggresseur
        if (!aggresseurs.contains(gAgresseur)) {
            aggresseurs.add(gAgresseur);
        }
    }

    @Override
    public String rapport(String nomEthnie) {
        // On fait le rapport du Gladiateur de base
        String rapport = super.rapport(nomEthnie);
        
        // On rajoute les particularit�s du Mirmillon (poids et aggresseurs)
        rapport += String.format("Mon poids est de %d. Et mes aggresseurs sont : ",
                                 this.poids);
        
        for (Gladiateur g : aggresseurs) {
            rapport += String.format("'%s' ", g.getNom());
        }
        return rapport;
    }

    
}
