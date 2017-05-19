package packglad;

import java.util.Collection;

public class Facade {
    public static Integer lancerJeu() {return null;
        //initialise les param�tres du jeu avec les valeurs par d�faut
    }
    public static void lancerJeuDEssai() {
        //System.out.println("============ Creation des 3 ethnies ============");
        //System.out.println("============ Creation des 6 Armes  ============");    
        //System.out.println("============ Creation des 6 Gladiateurs  ============");
        //System.out.println("============ Attribution des 15 armes  ============");
    }
    public static void parametrage(Integer vieInit, Integer forceRet, Integer poidsMax, Integer agilMax) {
        //permet de modifier la valeur des param�tres du jeu
    }

//Les gladiateurs
    public static Integer creerRetiaire(String nom, Integer agilite, Integer ide) {
    }
    public static Integer creerMirmillon(String nom, Integer poids, Integer ide) {
    }
    public static Collection<Integer> listerTousGladiateurs() {
        //retourne la liste des idg de tous les gladiateurs
    }    
    public static Collection<Integer> listerAgresseurs(Integer idg) {
        //  retourne la liste des idg des agresseurs du gladiateur idg (si idg est un mirmillon sinon rien)
    }  
    public static String faireSaluerGladiateur(Integer idg) {
        //retourne la phrase de salut : "Ave Caesar...." du gladiateur idg
    }
    public static String faireRapport(Integer idg) {
        //retourne le rapport du gladiateur idg (cf �nonc�)
    }
    public static Collection<Integer> declarerArmes(Integer idg) {
        // retourne la liste des ida des armes du gladiateur idg
    }
    public static Integer supprimerGlad(Integer idg) {
    }

// Les armes
    public static Integer creerUneArme(String nom, Integer puissOff, Integer puissDef) {
    }
    public static Integer autoriserArmeAuxMirmillons(Integer ida) {
    }
    public static Integer autoriserArmeAuxRetiaires(Integer ida) {
    }
    public static Integer donnerUneArme(Integer ida, Integer idg) {
        //donne l'arme ida au gladiateur idg
    }
    public static Collection<Integer> listerArmesDispoMirmillon() {
        //retourne la liste des ida des armes disponibles aux mirmillons
    }
    public static Collection<Integer> listerArmesDispoRetiaire() {
        //retourne la liste des ida des armes disponibles aux r�tiaires
    }
    public static String decrireArme(Integer ida) {
        //renvoie en String la description de l'arme (cf p4 de l'�nonc�) ida,nom,valOff,ValDef, dispoMir,dispoRet
    }

// Les ethnies 
    public static Collection<Integer> listerEthnies() {
        //retourne la liste des ide de toutes les ethnies
    }
    public static Collection<Integer> listerGladiateursDEthnie(Integer ide) {
        //liste des idg des gladiateurs de l'ethnie ide
    }
    public static String decrireEthnie(Integer ide) {
        //Renvoie la description de l'ethnie : ide,nom,score)
    }
    public static Integer getScore(Integer ide) {
        //retourne le score de l'ethnie ide
    }
 
//combat 
    public static Integer frapper(Integer idgAgresseur, Integer idgVictime, Integer ida) {
        //le gladiateur idgAgresseur frappe le gladiateur idgVictime � l'aide de l'arme ida
    }
    public static Integer desarmer(Integer idgVictime, Integer ida) {
        //d�pouille le gladiateur idgVictime de son arme ida
    }
    public static Collection<Integer> vainqueurs() {
        //renvoie le ou les ide de l'ethnie (des ethnies ex aequo) gagnante/s
    } 
    
//Pour les tests unitaires
    public static String nomDeLArme(Integer ida) {
        }
    public static String nomDuGladiateur(Integer idg) {
        }
    public static String nomDeLEthnie(Integer ide) {
    }  

}