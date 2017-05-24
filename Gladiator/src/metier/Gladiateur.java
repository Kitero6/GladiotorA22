package metier;

import java.util.ArrayList;
import java.util.Collection;

import packglad.GEthnie;

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
    private ArrayList<Arme> armes;

    public Gladiateur(Integer idg, String nom) {
        this.idg = idg;
        this.nom = nom;
        this.vie = c_vieInitiale;
    }
    
    // M�thodes abstraites
    public abstract String getType();
    
    public abstract Integer getForce();
    
    public abstract void prendreCoup(Integer degat, Gladiateur gAgresseur);
    
    // M�thodes get set
    public Integer getIdg() { return this.idg; }
    
    public static Integer c_getVieInitiale() { return c_vieInitiale; }

    public static void c_setVieInitiale(Integer vie) { c_vieInitiale = vie; }
    
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
    
    public String getNom() { return this.nom; }

    public Integer getVie() { return vie; }

    public ArrayList<Arme> getArmes() { return armes; }

    public void setVie(Integer vie) { this.vie = vie; }

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

    public void frapper(Gladiateur gVictime, Arme a) {
        // Le Gladiateur ne peut frapper seulement si il est encore en vie
        if (this.vie > 0) {
            // On calcul les d�g�ts de base qui vont
            // �tre inflig� au Gladiateur gVictime
            int degat = this.getForce() + a.getPuissOff();
            gVictime.prendreCoup(degat, this);
        }
    }
    
    public String saluer() {
        return String.format("Ave Caesar, %s N�%d : %s, j'appartiens � l'ethnie des %s",
                             this.getType(),
                             this.idg,
                             this.nom,
                             GEthnie.getEthnieGladiateur(this).getNom());
    }

    public String rapport() {
        String salut = this.saluer();
        salut += String.format(". Je suis %s (c'est a dire que j'ai %d points de vie) mes armes sont :",
                               this.getEtat(),
                               this.vie);
        for (Arme a : this.armes) {
            salut +=  a.description() + '\n';
        }
        return salut;
    }

    public ArrayList<Arme> declarerArme() {
        return new ArrayList<Arme>(this.armes);
    }
    
    public ArrayList<Gladiateur> getListeAgresseur() {
        return null;
    }
}
