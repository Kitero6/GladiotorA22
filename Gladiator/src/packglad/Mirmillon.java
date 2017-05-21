package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class Mirmillon extends Gladiateur {
    @Override
    public void prendreCoup(Integer degat, Gladiateur gAggresseur) {
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
        // Vu que c'est un Mirmillon on retien l'aggresseur
        if (!aggresseurs.contains(gAggresseur)) {
            aggresseurs.add(gAggresseur);
        }
    }

    public String getType() { return "Mirmillon"; }
    
    /**
     * @attribute
     */
    private static Integer c_poidsMax;

    /**
     * @attribute
     */
    private Integer poids;

    /**
     * @associates <{packglad.Arme}>
     */
    private static ArrayList<Arme> c_armeUtilisable;

    /**
     * @associates <{packglad.Gladiateur}>
     */
    private ArrayList<Gladiateur> aggresseurs;

    public Mirmillon(Integer idg, String nom, Integer poids, Ethnie e) {
        this.idg = idg;
        this.vie = Gladiateur.c_getVieInitiale();
        this.nom = nom;
        if (poids > c_poidsMax) poids = c_poidsMax;
        else if (poids < 0) poids = 0;
        this.poids = poids;
        this.force = poids / 2;
        GEthnie.ajouterGladiateur(e, this);
    }

    public void rapport() {
        // On fait le rapport du Gladiateur de base
        super.rapport();
        
        // On rajoute les particularités du Mirmillon (poids et aggresseurs)
        System.out.println(String.format(" et mon poids est de %d."));
        
        String SAggresseurs = "";
        for (Gladiateur g : aggresseurs) {
            SAggresseurs += "'" + g.getNom() + "' ";
        }
        System.out.println(SAggresseurs);
    }

    public static void c_setPoidMax(Integer poids) {
        c_poidsMax = poids;
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
}
