package metier;

import java.util.ArrayList;

public class Ethnie {
    private String nom;
    private Integer ide;
    private ArrayList<Gladiateur> listeGladiateur;

    public Ethnie(Integer ide, String nom) {
        this.ide = ide;
        this.nom = nom;
        this.listeGladiateur = new ArrayList<Gladiateur>();
    }

    public Integer getIde() {
        return this.ide;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public ArrayList<Gladiateur> getListeGladiateur() {
        return this.listeGladiateur;
    }

    public Integer getScore() {
        //Parcours tout les gladiateurs de l'ethnie et verifie leur etat
        int res = 0;
        for(int i =0; i<this.listeGladiateur.size(); i++) {
            if(this.listeGladiateur.get(i).getEtat() == "en forme") {
                res += 10;
            }
            else if (this.listeGladiateur.get(i).getEtat() == "blesse"){
                res +=5;
            }
        }
        return res;
    }

    public void ajouterGladiateur(Gladiateur g) {
        this.listeGladiateur.add(g);
    }

}