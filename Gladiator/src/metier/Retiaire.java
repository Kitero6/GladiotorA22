package metier;

import java.util.ArrayList;

public class Retiaire extends Gladiateur {
    private static Integer c_forceInitiale = 30;
    private static Integer c_agiliteMax = 50;
    private Integer agilite;
    private static ArrayList<Arme> c_armeUtilisable  = new ArrayList<Arme>();

    public Retiaire(Integer idg, String nom, Integer agilite) {
        super(idg, nom);
        if (agilite > c_agiliteMax) agilite = c_agiliteMax;
        else if (agilite < 0) agilite = 0;
        this.agilite = agilite;
    }

    public Integer getForce() { return c_forceInitiale; }
    
    public String getType() { return "Retiaire"; }
    
    public static void c_setForceInitiale(Integer force) { 
        // On empêche de mettre une forceInitiale négative
        if (force < 0) {
            System.out.println("Force initiale : Initialisée à 0 aulieu de " + force);
            c_forceInitiale = 0;
        }
        else c_forceInitiale = force;
    }
    
    public static void c_setAgiliteMax(Integer agi) { 
        // On empêche de mettre une agilitéMax négative
        if (agi< 0){ 
            System.out.println("Agilite initiale : Initialisée à 0 aulieu de " + agi);
            c_agiliteMax = 0;
        }
        else c_agiliteMax = agi;
    }
    
    public static ArrayList<Arme> c_listeArmeDispo() { return new ArrayList<Arme>(c_armeUtilisable); }
    
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

    public void prendreCoup(Integer degat, Gladiateur gAgresseur) {
        // On prend la somme de la puissance défensive
        // en pour pouvoir la soustraire aux dégâts
        int puissDefTotal = 0;
        for (Arme a : this.getArmes()) {
            puissDefTotal += a.getPuissDef();
        }
        
        // On calcul les dégâts qui vont être infligé à notre Gladiateur 
        int degatInflige = degat - puissDefTotal;
        if (degatInflige <  0) degatInflige = 0;
        
        // Puis on inflige les dégâts
        this.setVie(this.getVie() - degatInflige);
        if (this.getVie() < 0) this.setVie(0);
    }
    
    @Override
    public String rapport(String nomEthnie) {
        // On fait le rapport du Gladiateur de base
        String rapport = super.rapport(nomEthnie);
        
        // On rajoute les particularités du Mirmillon (poids et aggresseurs)
        rapport += String.format(" Mon agilite est de %d.",
                                 this.agilite);
        return rapport;
    }    
}
