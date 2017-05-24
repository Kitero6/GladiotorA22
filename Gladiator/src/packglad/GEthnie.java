package packglad;

import java.util.ArrayList;
import java.util.Collection;

import metier.Ethnie;
import metier.Gladiateur;

public class GEthnie {
    /**
     * @attribute
     */
    private static Integer ideNext;

    /**
     * @associates <{metier.Ethnie}>
     */
    private static ArrayList<Ethnie> ethnies;

    public static void ajouteurEthnie(String nom) {
        Ethnie e = new Ethnie(ideNext,nom);
        ideNext++;
        ethnies.add(e);
    }

    public static Ethnie getEthnieGladiateur(Gladiateur g) {
        Ethnie res = null;
        
        //On parcours la liste des ethnies. ET la liste des gladiateurs DE CHAQUE ETHNIE
        for(int i = 0; i< ethnies.size(); i++) {
            for(int y =0 ; y <ethnies.get(i).getListeGladiateur().size(); y++) {
                if(ethnies.get(i).getListeGladiateur().get(y)==g) {
                    res = ethnies.get(i);
                }
            }
        }
        return res;
    }

    public static ArrayList<Ethnie> listerEthnie() {
        return ethnies;
    }

    public static void ajouterGladiateur(Ethnie e, Gladiateur g) {
        for(int i = 0; i<ethnies.size(); i++) {
            if(ethnies.get(i)==e) {
                ethnies.get(i).ajouterGladiateur(g);
            }
        }
    }

    public static Ethnie chercherEthnie(Integer ide) {
        Ethnie res = null; //ethnie en resultat
        //Parcours de tout les ethnies pour trouver le bon ide
        for(int i = 0; i<ethnies.size(); i++) {
            if(ethnies.get(i).getIde()==ide){
                res = ethnies.get(i);
            }
        }
        return res;
    }

    public static ArrayList<Gladiateur> listerGladiateur(Ethnie e) {
        
        //parcours la liste des ethnies pour trouver la liste des gladiateur de l'ethnie e
        ArrayList<Gladiateur> res = new ArrayList<Gladiateur>();
        for(int i = 0; i<ethnies.size(); i++) {
            if(ethnies.get(i)==e){
                res = ethnies.get(i).getListeGladiateur();
            }
        }
        return res;
    }

    public static ArrayList<Ethnie> vainqueurs() {
        //liste des ou du gagnant(s)
        ArrayList<Ethnie> gagnant = new ArrayList<Ethnie>();
        //cherche le score max
        int scoremax = ethnies.get(0).getScore();
        for(int i=0; i<ethnies.size(); i++) {
            if(scoremax < ethnies.get(i).getScore()) {
                scoremax =ethnies.get(i).getScore();
            }
        }
        
        //cherche les ethnie ayant le score max et les ajoutes a la liste
        for(int i=0; i<ethnies.size(); i++) {
            if(scoremax == ethnies.get(i).getScore()) {
                gagnant.add(ethnies.get(i));
            }
        }
        return gagnant;
    }
}
