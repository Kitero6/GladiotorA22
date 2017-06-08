package packglad;

import java.util.ArrayList;

import metier.Ethnie;
import metier.Gladiateur;

public class GEthnie {
    private static Integer ideNext = 1;
    private static ArrayList<Ethnie> ethnies = new ArrayList<Ethnie>();

    public static Ethnie ajouteurEthnie(String nom) {
        // On verifie qu'une Ethnie du même nom n'existe pas
        Ethnie e = null;
        boolean trouve = false;
        int i = 0;
        while (i<ethnies.size() && !trouve) {
            if (ethnies.get(i).getNom().equalsIgnoreCase(nom)) {
                e = ethnies.get(i);
                trouve = true;
            }
            i++;
        }
        if (!trouve) {
             e = new Ethnie(ideNext,nom);
            ideNext++;
            ethnies.add(e);
            return e;
        }
        return e;
    }

    public static Ethnie getEthnieGladiateur(Gladiateur g) {
        Ethnie res = new Ethnie(null,null);
        int i =0;
        int j =0;
        boolean trouve = false;
        
        //On parcours la liste des ethnies. ET la liste des gladiateurs DE CHAQUE ETHNIE
        while(i < ethnies.size() && !trouve) {
            Ethnie e = ethnies.get(i);
            ArrayList<Gladiateur>  gladiateurs = e.getListeGladiateur();
            j = 0;
            while (j < gladiateurs.size() && !trouve) {
                if (gladiateurs.get(j).getIdg()==g.getIdg()) {
                    res = e;
                    trouve = true;
                }
                j++;
            }  
            i++;
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
        int i = 0;
        boolean  trouve = false;
        
        //Parcours de tout les ethnies pour trouver le bon ide
        while(i < ethnies.size() && !trouve) {
            Ethnie e = ethnies.get(i);
            if(e.getIde()==ide) {
                res = e;
                trouve = true;
            }
            i++;
        }
        return res;
    }

    public static ArrayList<Gladiateur> listerGladiateur(Ethnie e) {        
        
        Ethnie p = chercherEthnie(e.getIde());
        ArrayList<Gladiateur> res = p.getListeGladiateur();
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