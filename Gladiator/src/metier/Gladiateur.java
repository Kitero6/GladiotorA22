package metier;

import java.util.ArrayList;

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
        this.armes = new ArrayList<Arme>();
    }
    
    // Méthodes abstraites
    public abstract String getType();
    
    public abstract Integer getForce();
    
    public abstract void prendreCoup(Integer degat, Gladiateur gAgresseur);
    
    // Méthodes get set
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
        // Le gladiateur reçoit l'arme seuleument si il ne l'a pas déjà d'équipé
        if (!armeDansListe(armes, a)) {
            // Si il ne l'a pas alors on vérifie qu'il est autorisé
            // à l'utiliser
            if (verifArmeDispo(a)) {
                armes.add(a);
            }
        }
    }
    
    public void perdreArme(Arme a) {
        armes.remove(a);
    }
    
    private Boolean verifArmeDispo(Arme a) {
        // On récupère le type du Gladiateur pour
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
        // le gladiateur est autorisé à l'utiliser
        return armeDansListe(armeDispo, a);
    }

    public void frapper(Gladiateur gVictime, Arme a) {
        // Le Gladiateur ne peut frapper seulement si il est encore en vie
        // et si il possède l'arme avec laquelle on lui demande d'attaquer
        if (this.vie > 0 && armeDansListe(armes, a)) {
            // On calcul les dégâts de base qui vont
            // être infligé au Gladiateur gVictime
            int degat = this.getForce() + a.getPuissOff();
            gVictime.prendreCoup(degat, this);
        }
    }
    
    private boolean armeDansListe(ArrayList<Arme> la, Arme a) {
        // Fonction qui recherche si une Arme a est dans une liste d'Arme la
        boolean trouve = false;
        int i = 0;
        while (i < la.size() && !trouve) {
            if (la.get(i) == a) {
                trouve = true;
            }
            i++;
        }
        return trouve;
    }
    
    public String saluer(String nomEthnie) {
        return String.format("Ave Caesar, %s N°%d : %s, j'appartiens à l'ethnie des %s",
                             this.getType(),
                             this.idg,
                             this.nom,
                             nomEthnie);
    }

    public String rapport(String nomEthnie) {
        String salut = this.saluer(nomEthnie);
        salut += String.format(". Je suis %s (c'est a dire que j'ai %d points de vie)",
                               this.getEtat(),
                               this.vie);
        switch (this.armes.size()) {
        case 0:
            salut += " je n'ai pas d'armes.\n";
            break;
        case 1:
            salut += String.format(" mon arme est : %s\n",
                                   this.armes.get(0).getNom());
            break;
        default:
            salut += " mes armes sont :\n";
            for (Arme a : this.armes) {
                salut +=  a.getNom() + ' ';
            }
            salut += "\n";
            break;
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
