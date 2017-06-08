package metier;

import java.util.ArrayList;
import java.util.Collection;

public class Mirmillon extends Gladiateur {
    private Integer poids;
    private static Integer c_poidsMax = 100;
    private static ArrayList<Arme> c_armeUtilisable = new ArrayList<Arme>();
    private ArrayList<Gladiateur> aggresseurs;

    public Mirmillon(Integer idg, String nom, Integer poids) {
        super(idg, nom);
        if (poids > c_poidsMax) poids = c_poidsMax;
        else if (poids < 0) poids = 0;
        this.poids = poids;
        this.aggresseurs = new ArrayList<Gladiateur>();
    }

    public Integer getForce() { return this.poids / 2; }
    
    public String getType() { return "Mirmillon"; }

    @Override
    public ArrayList<Gladiateur> getListeAgresseur() { return new ArrayList<Gladiateur>(this.aggresseurs); }
    
    public static void c_setPoidMax(Integer poids) {
        // On empêche de faire en sorte que le poidsMax soit négatif
        if (poids < 0) {
            System.out.println("Poids initial : Initialisé à 0 aulieu de " + poids);
            c_poidsMax = 0;
        }
        else c_poidsMax = poids;
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
        
        // On rajoute les particularités du Mirmillon (poids et aggresseurs)
        rapport += String.format("Mon poids est de %d.",
                                 this.poids);
        
        switch (aggresseurs.size()) {
        case 0:
            rapport += " Je n'ai toujours pas été aggressé";
            break;
        case 1:
            rapport += String.format(" Mon aggresseur est : %s", aggresseurs.get(0).getNom());
            break;
        default:
            rapport += " Mes aggresseurs sont : ";
            for (Gladiateur g : aggresseurs) {
                rapport += String.format("'%s' ", g.getNom());
            }
        }
        
        return rapport;
    }

    
}
