package packglad;

import java.util.ArrayList;
import java.util.Collection;

import metier.*;


public class Facade {
    public static Integer lancerJeu() {
        //initialise les param?tres du jeu avec les valeurs par d?faut
    }
    public static void lancerJeuDEssai() {
        //System.out.println("============ Creation des 3 ethnies ============");
        //System.out.println("============ Creation des 6 Armes  ============");    
        //System.out.println("============ Creation des 6 Gladiateurs  ============");
        //System.out.println("============ Attribution des 15 armes  ============");
    }
    public static void parametrage(Integer vieInit, Integer forceRet, Integer poidsMax, Integer agilMax) {
        //permet de modifier la valeur des param?tres du jeu
    }

//Les gladiateurs
    public static Integer creerRetiaire(String nom, Integer agilite, Integer ide) {
        Gladiateur g = GGladiateur.ajouterRetiaire(nom, agilite);
        GEthnie.ajouterGladiateur(GEthnie.chercherEthnie(ide), g);
        return 0;
    }
    public static Integer creerMirmillon(String nom, Integer poids, Integer ide) {
        Gladiateur g = GGladiateur.ajouterMirmillon(nom, poids);
        GEthnie.ajouterGladiateur(GEthnie.chercherEthnie(ide), g);
        return 0;
    }
    public static Collection<Integer> listerTousGladiateurs() {
        return getListeIdg(GGladiateur.listerGladiateur());
        //retourne la liste des idg de tous les gladiateurs
    }    
    public static Collection<Integer> listerAgresseurs(Integer idg) {
        Collection<Integer> lIdg = new ArrayList<Integer>();
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        if (g.getType() == "Mirmillon") {
            lIdg = getListeIdg(g.getListeAggresseur());
        }
        return lIdg;
        //  retourne la liste des idg des agresseurs du gladiateur idg (si idg est un mirmillon sinon rien)
    }  
    private static Collection<Integer> getListeIdg(Collection<Gladiateur> lg) {
        Collection<Integer> lIdg = new ArrayList<Integer>();
        for (Gladiateur g : lg) {
            lIdg.add(g.getIdg());
        }
        return lIdg;
    }
    public static String faireSaluerGladiateur(Integer idg) {
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        return g.saluer(GEthnie.getEthnieGladiateur(g).getNom());
        //retourne la phrase de salut : "Ave Caesar...." du gladiateur idg
    }
    public static String faireRapport(Integer idg) {
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        return g.rapport(GEthnie.getEthnieGladiateur(g).getNom());
        //retourne le rapport du gladiateur idg (cf ?nonc?)
    }
    public static Collection<Integer> declarerArmes(Integer idg) {
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        ArrayList<Arme> armes = g.getArmes();
        Collection<Integer> lIda = new ArrayList<Integer>();
        for (Arme a : armes) {
            lIda.add(a.getIda());
        }
        return lIda;
        // retourne la liste des ida des armes du gladiateur idg
    }
    public static Integer supprimerGlad(Integer idg) {
        GGladiateur.supprimerGladiateur(GGladiateur.chercherGladiateur(idg));
        return 0;
    }

// Les armes
    public static Integer creerUneArme(String nom, Integer puissOff, Integer puissDef) {
        GArme.ajouterArme(nom, puissOff, puissDef);
        return 0;
    }
    public static Integer autoriserArmeAuxMirmillons(Integer ida) {
        GGladiateur.autoriserArmeMirmillon(GArme.chercherArme(ida));
        return 0;
;    }
    public static Integer autoriserArmeAuxRetiaires(Integer ida) {
        GGladiateur.autoriserArmeRetiaire(GArme.chercherArme(ida));
        return 0;
    }
    public static Integer donnerUneArme(Integer ida, Integer idg) {
        //donne l'arme ida au gladiateur idg
        GGladiateur.chercherGladiateur(idg).receveoirArme(GArme.chercherArme(ida));
        return 0;
    }
    public static Collection<Integer> listerArmesDispoMirmillon() {
        //retourne la liste des ida des armes disponibles aux mirmillons
        return getIdaListeArme(Mirmillon.c_listeArmeDispo());
    }
    public static Collection<Integer> listerArmesDispoRetiaire() {
        //retourne la liste des ida des armes disponibles aux r?tiaires
        return getIdaListeArme(Retiaire.c_listeArmeDispo());
        
    }
    private static Collection<Integer> getIdaListeArme(Collection<Arme> la) {
        // retourn la liste des ida de la collection passée en parametre
        Collection<Integer> lIda = new ArrayList<Integer>();
        for (Arme a : la) {
            lIda.add(a.getIda());
        }
        return lIda;
    }
    public static String decrireArme(Integer ida) {
        return GArme.chercherArme(ida).description();
        //renvoie en String la description de l'arme (cf p4 de l'?nonc?) ida,nom,valOff,ValDef, dispoMir,dispoRet
    }
    public static String nomDeLArme(Integer ida) {
        return GArme.chercherArme(ida).getNom();
            //renvoie en String juste le nom de l'arme
    }

// Les ethnies 
    public static Collection<Integer> listerEthnies() {
        Collection<Ethnie> le = GEthnie.listerEthnie();
        Collection<Integer> lIde = new ArrayList<Integer>();
        for (Ethnie e : le) {
            lIde.add(e.getIde());
        }
        return lIde;
        //retourne la liste des ide de toutes les ethnies
    }
    public static Collection<Integer> listerGladiateursDEthnie(Integer ide) {
        return getListeIdg(GEthnie.listerGladiateur(GEthnie.chercherEthnie(ide)));
        //liste des idg des gladiateurs de l'ethnie ide
    }
    public static String decrireEthnie(Integer ide) {
        Ethnie e = GEthnie.chercherEthnie(ide);
        return e.getIde() + " " + e.getNom() + " " + e.getScore();
        //Renvoie la description de l'ethnie : ide,nom,score)
    }
    public static Integer getScore(Integer ide) {
        return GEthnie.chercherEthnie(ide).getScore();
        //retourne le score de l'ethnie ide
    }
 
//combat 
    public static Integer frapper(Integer idgAgresseur, Integer idgVictime, Integer ida) {
        Gladiateur agresseur =  GGladiateur.chercherGladiateur(idgAgresseur),
                   victime = GGladiateur.chercherGladiateur(idgVictime);
        Arme a = GArme.chercherArme(ida);
        agresseur.frapper(victime, a);
        //le gladiateur idgAgresseur frappe le gladiateur idgVictime ? l'aide de l'arme ida
        return 0;
    }
    public static Integer desarmer(Integer idgVictime, Integer ida) {
        Gladiateur victime = GGladiateur.chercherGladiateur(idgVictime);
        Arme a = GArme.chercherArme(ida);
        victime.perdreArme(a);
        //d?pouille le gladiateur idgVictime de son arme ida
        return 0;
    }
    public static Collection<Integer> vainqueurs() {
        //renvoie le ou les ide de l'ethnie (des ethnies ex aequo) gagnante/s
    } 
    
//Pour les tests unitaires
    
    public static String nomDuGladiateur(Integer idg) {
        return GGladiateur.chercherGladiateur(idg).getNom();
    }
    public static String nomDeLEthnie(Integer ide) {
        return GEthnie.chercherEthnie(ide).getNom();
    }  

}