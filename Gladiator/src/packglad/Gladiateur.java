package packglad;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Gladiateur {
    /**
     * @attribute
     */
    protected Integer idg;

    /**
     * @attribute
     */
    protected Integer force;

    /**
     * @attribute
     */
    protected String nom;

    /**
     * @attribute
     */
    private static Integer c_vieInitiale = 200;

    /**
     * @attribute
     */
    protected Integer vie;

    /**
     * @associates <{packglad.Arme}>
     */
    protected ArrayList<Arme> armes;

    public Integer getIdg() { return this.idg; }
    
    public String getNom() { return this.nom; }
    
    public static Integer c_getVieInitiale() { return c_vieInitiale; }
    
    public static void c_setVieInitiale(Integer vie) { c_vieInitiale = vie; }
    
    public abstract String getType();
    
    // Fonction, qui ressort l'�tat du Gladiateur
    public String getEtat() {
        String etat;
        if (this.vie < 10) {
            etat = "moribond";
        } else if (this.vie <= 50) {
            etat = "blesse";
        } else {
            etat = "en forme";
        }
        return etat;
    }
    

    public void receveoirArme(Arme a) {
        // Le gladiateur re�oit l'arme seuleument si il ne l'a pas d�j� d'�quip�
        boolean trouve = false;
        int i = 0;
        while (i < armes.size() && !trouve) {
            if (a == armes.get(i)) {
                trouve = true;
            }
            i++;
        }
        if (!trouve) {
            // Si il ne l'a pas alors on v�rifie qu'il est autoris�
            // l'utiliser
            if (verifArmeDispo(a)) {
                armes.add(a);
            }
        }
    }
    
    public void perdreArme(Arme a) {
        armes.remove(a);
    }
    
    public void frapper(Gladiateur gVictime, Arme a) {
        // Le Gladiateur ne peut frapper seulement si il est encore en vie
        if (this.vie > 0) {
            // On calcul les d�g�ts de base qui vont
            // �tre inflig� au Gladiateur gVictime
            int degat = this.force + a.getPuissOffensive();
            gVictime.prendreCoup(degat, this);
        }
    }
    
    public abstract void prendreCoup(Integer degat, Gladiateur gAgresseur);

    // Fonction qui v�rie si le gladiateur ne poss�de pas
    // l'amre pass�e en param�tre
    private Boolean verifArmeDispo(Arme a) {
        // On r�cup�re le type du Gladiateur pour
        // pouvoir savoir quelle liste d'arme dispo il faut regarder
        ArrayList<Arme> armeDispo;
        String type = this.getType();
        switch (type) {
        case "Mirmillon":
            armeDispo = Mirmillon.c_listeArmeDispo();
            break;
        case "Retiaire":
            armeDispo = Retiaire.c_listeArmeDispo();
            break;
        default:
            armeDispo = new ArrayList<Arme>();
        }
        
        // Puis on parcourt la liste afin de savoir si
        // le gladiateur est autoris� � l'utiliser
        boolean trouve = false;
        int i = 0;
        while (i < armeDispo.size() && !trouve) {
            if (armeDispo.get(i) == a) {
                trouve = true;
            }
            i++;
        }
        return trouve;
    }

    public void rapport() {
        System.out.println(String.format("Ave Caesar, %s N�%d : %s, j'appartiens � l'ethnie des %s",
                                         this.getType(),
                                         this.idg,
                                         this.nom,
                                         GEthnie.getEthnieGladiateur(this).getNom()));
    }

    public void saluer() {
        System.out.println(String.format("Ave C�sar ! Je suis %s de l'�thnie %s, mon identifiant est le N�%d.",
                                         this.nom,
                                         GEthnie.getEthnieGladiateur(this),
                                         this.idg));
        this.declarerArme();
        System.out.print(String.format("Je suis %s, c'est � dire que j'ai %d point(s) de vie(s). Ma force est de %s",
                                       this.getEtat(),
                                       this.vie,
                                       this.force));
    } 

    public void declarerArme() {
        System.out.print("Mes armes sont : ");
        for (Arme a : armes) {
            System.out.print(String.format("N�%d : '%s'; ",
                             a.getIda(),
                             a.getNom()));
        }
        System.out.println();
    }
}
