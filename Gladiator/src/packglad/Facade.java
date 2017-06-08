package packglad;

import java.util.ArrayList;
import java.util.Collection;

import metier.*;


public class Facade {
    public static Integer lancerJeu() {
        //initialise les param?tres du jeu avec les valeurs par d?faut
        parametrage(200, 30, 100, 50);
        return 0;
    }
    public static void lancerJeuDEssai() {
        lancerJeu();
        System.out.println("============ Creation des 3 ethnies ============");
        String[] nomEthnie = { "Gaulois", "Thraces", "Dalmates" };
        for (int i = 0; i < nomEthnie.length; i++) {
            creerEthnie(nomEthnie[i]);
        }
        
        System.out.println("============ Creation des 6 Armes  ============");
        int nGlaive, nTrident, nFilet, nBouclier, nCasque, nJambiere;
        nGlaive = creerUneArme("Glaive", 80, 0);
        autoriserArmeAuxMirmillons(nGlaive);
        autoriserArmeAuxRetiaires(nGlaive);
        
        nTrident = creerUneArme("Trident", 100, 0);
        autoriserArmeAuxRetiaires(nTrident);
        
        nFilet = creerUneArme("Filet", 40, 20);
        autoriserArmeAuxRetiaires(nFilet);
        
        nBouclier = creerUneArme("Bouclier", 40, 40);
        autoriserArmeAuxMirmillons(nBouclier);
        
        nCasque = creerUneArme("Casque", 0, 20);
        autoriserArmeAuxMirmillons(nCasque);
        
        nJambiere = creerUneArme("Jambiere", 0 ,10);
        autoriserArmeAuxMirmillons(nJambiere);
        autoriserArmeAuxRetiaires(nJambiere);
        
        System.out.println("============ Creation des 6 Gladiateurs  ============");
        int nUnix, nInformatix, nCepluplus, nPythonus, nSzervlet, nRamazmjet;
        nUnix = creerRetiaire("Unix", 30, 1);
        nInformatix = creerMirmillon("Informatix", 100, 1);
        nCepluplus = creerRetiaire("Ceplusplus", 40, 2);
        nPythonus = creerMirmillon("Pythonus", 60, 2);
        nSzervlet = creerRetiaire("Szervlet", 50, 3);
        nRamazmjet = creerMirmillon("Ramazmjet", 80, 3);
        
        System.out.println("============ Attribution des 15 armes  ============");
        //Attributions armes Unix
        donnerUneArme(nTrident, nUnix); donnerUneArme(nJambiere, nUnix); donnerUneArme(nFilet, nUnix);
        //Attributions armes Informatix
        donnerUneArme(nGlaive, nInformatix); donnerUneArme(nBouclier, nInformatix); donnerUneArme(nCasque, nInformatix); donnerUneArme(nJambiere,nInformatix);
        //Attributions armes Ceplusplus
        donnerUneArme(nTrident, nCepluplus); donnerUneArme(nJambiere, nCepluplus);
        //Attributions armes Pythonus
        donnerUneArme(nGlaive, nPythonus); donnerUneArme(nBouclier, nPythonus);
        //Attributions armes Szervlet
        donnerUneArme(nGlaive, nSzervlet); donnerUneArme(nJambiere, nSzervlet);
        //Attributions armes Ramazmjet
        donnerUneArme(nBouclier, nRamazmjet); donnerUneArme(nCasque, nRamazmjet);
    }
    public static void parametrage(Integer vieInit, Integer forceRet, Integer poidsMax, Integer agilMax) {
        //permet de modifier la valeur des param?tres du jeu
        Gladiateur.c_setVieInitiale(vieInit);
        Retiaire.c_setForceInitiale(forceRet);
        Mirmillon.c_setPoidMax(poidsMax);
        Retiaire.c_setAgiliteMax(agilMax);
    }

//Les gladiateurs
    public static Integer creerRetiaire(String nom, Integer agilite, Integer ide) {
        // On vérifie que l'ethnie existe
        Ethnie e = GEthnie.chercherEthnie(ide);
        if (e != null) {
            Gladiateur g = GGladiateur.ajouterRetiaire(nom, agilite);
            GEthnie.ajouterGladiateur(e, g);
            return g.getIdg();
        }
        else {
            System.out.println("L'Ethnie n'existe pas.");
            return -1;
        }
    }
    public static Integer creerMirmillon(String nom, Integer poids, Integer ide) {
        // On vérifie que l'ethnie existe
        Ethnie e = GEthnie.chercherEthnie(ide);
        if (e != null) {
            Gladiateur g = GGladiateur.ajouterMirmillon(nom, poids);
            GEthnie.ajouterGladiateur(e, g);
            return g.getIdg();
        }
        else {
            System.out.println(String.format("L'Ethnie %d n'existe pas.", ide));;
            return -1;
        }
    }
    public static Collection<Integer> listerTousGladiateurs() {
        return getListeIdg(GGladiateur.listerGladiateur());
        //retourne la liste des idg de tous les gladiateurs
    }    
    public static Collection<Integer> listerAgresseurs(Integer idg) {
        // On verifie que le gladiateur existe
        Collection<Integer> lIdg = new ArrayList<Integer>();
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        if (g != null) {
            if (g.getType() == "Mirmillon") {
                lIdg = getListeIdg(g.getListeAgresseur());
            }
            return lIdg;
        } else {
            System.out.println(String.format("Le gladiateur %s n'existe pas.", idg));
            return new ArrayList<Integer>();
        }
        //  retourne la liste des idg des agresseurs du gladiateur idg (si idg est un mirmillon sinon rien)
    }  
    private static Collection<Integer> getListeIdg(Collection<Gladiateur> lg) {
        // retourne la liste des idg de la collection de gladiateur donné en paramêtre
        Collection<Integer> lIdg = new ArrayList<Integer>();
        for (Gladiateur g : lg) {
            lIdg.add(g.getIdg());
        }
        return lIdg;
    }
    public static String faireSaluerGladiateur(Integer idg) {
        // On verifie que le gladiateur existe
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        if (g != null) {
            return g.saluer(GEthnie.getEthnieGladiateur(g).getNom());
        } else {
            return String.format("Le gladiateur %s n'existe pas.", idg);
        }
        //retourne la phrase de salut : "Ave Caesar...." du gladiateur idg
    }
    public static String faireRapport(Integer idg) {
        // On verifie que le gladiateur existe
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        if (g != null) {
            return g.rapport(GEthnie.getEthnieGladiateur(g).getNom());
        } else {
            return String.format("Le gladiateur %s n'existe pas.", idg);
        }
        //retourne le rapport du gladiateur idg (cf ?nonc?)
    }
    public static Collection<Integer> declarerArmes(Integer idg) {
        // On verifie que le gladiateur existe
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        if (g != null) {
            ArrayList<Arme> armes = g.getArmes();
            Collection<Integer> lIda = new ArrayList<Integer>();
            for (Arme a : armes) {
                lIda.add(a.getIda());
            }
            return lIda;
        }
        else {
            System.out.println(String.format("Le gladiateur %s n'existe pas.", idg));
            return new ArrayList<Integer>();
        }
        // retourne la liste des ida des armes du gladiateur idg
    }
    public static Integer supprimerGlad(Integer idg) {
        // On verifie que le gladiateur existe
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        if (g != null) {
            GGladiateur.supprimerGladiateur(g);
            return g.getIdg();
        } else {
            System.out.println(String.format("Le gladiateur %s n'existe pas.", idg));
            return -1;
        }
    }

// Les armes
    public static Integer creerUneArme(String nom, Integer puissOff, Integer puissDef) {
        Arme a = GArme.ajouterArme(nom, puissOff, puissDef);
        // On verifie que l'arme n'existe pas encore
        if (a != null) return a.getIda();
        else {
            System.out.println("L'arme existe déjà.");
            return -1;
        }
    }
    public static Integer autoriserArmeAuxMirmillons(Integer ida) {
        // On vérifie que l'arme existe
        Arme a = GArme.chercherArme(ida);
        if (a != null) {
            GGladiateur.autoriserArmeMirmillon(a);
            return 0;
        }
        else {
            System.out.println(String.format("L'arme %d n'existe pas.", ida));
            return -1;
        }
    }
    public static Integer autoriserArmeAuxRetiaires(Integer ida) {
        // On vérifie que l'arme existe
        Arme a = GArme.chercherArme(ida);
        if (a != null) {
            GGladiateur.autoriserArmeRetiaire(a);
            return 0;
        }
        else {
            System.out.println(String.format("L'arme %d n'existe pas.", ida));
            return -1;
        }
    }
    public static Integer donnerUneArme(Integer ida, Integer idg) {
        //donne l'arme ida au gladiateur idg
        // On vérifie que l'arme existe
        Arme a = GArme.chercherArme(ida);
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        if (a != null && g != null) {
            g.receveoirArme(a);
            return 0;
        }
        else {
            System.out.println("Un des arguments n'existe pas.");
            return -1;
        }
    }
    public static Collection<Integer> listerArmes() {
        //retourne la liste des ida des armes
        return getListeIda(GArme.listerArme());
    }
    public static Collection<Integer> listerArmesDispoMirmillon() {
        //retourne la liste des ida des armes disponibles aux mirmillons
        return getListeIda(Mirmillon.c_listeArmeDispo());
    }
    public static Collection<Integer> listerArmesDispoRetiaire() {
        //retourne la liste des ida des armes disponibles aux r?tiaires
        return getListeIda(Retiaire.c_listeArmeDispo());
        
    }
    private static Collection<Integer> getListeIda(Collection<Arme> la) {
        // retourn la liste des ida de la collection passée en parametre
        Collection<Integer> lIda = new ArrayList<Integer>();
        for (Arme a : la) {
            lIda.add(a.getIda());
        }
        return lIda;
    }
    public static String decrireArme(Integer ida) {
        // On vérifie que l'arme existe
        Arme a = GArme.chercherArme(ida);
        if (a != null) {
            return a.description();
        }
        else {
            return String.format("L'arme %d n'existe pas.", ida);
        }
        
        //renvoie en String la description de l'arme (cf p4 de l'?nonc?) ida,nom,valOff,ValDef, dispoMir,dispoRet
    }
    public static String nomDeLArme(Integer ida) {
        // On vérifie que l'arme existe
        Arme a = GArme.chercherArme(ida);
        if (a != null) {
            return a.getNom();
        }
        else {
            return String.format("L'arme %d n'existe pas.", ida);
        }
        //renvoie en String juste le nom de l'arme
    }

// Les ethnies 
    public static void creerEthnie(String nom) {
        // On vérifie que l'ethnie existe déjà
        Ethnie e = GEthnie.ajouteurEthnie(nom);
        if (e == null) System.out.println("Ethnie déjà existante");
    }
    public static Collection<Integer> listerEthnies() {
        return getListeIde(GEthnie.listerEthnie());
        //retourne la liste des ide de toutes les ethnies
    }
    public static Collection<Integer> listerGladiateursDEthnie(Integer ide) {
        // On vérifie que l'ethnie existe
        Ethnie e = GEthnie.chercherEthnie(ide);
        if (e != null) {
            return getListeIdg(GEthnie.listerGladiateur(e));
        }
        else {
            System.out.println(String.format("L'Ethnie %d n'existe pas.", ide));
            return new ArrayList<Integer>();
        }
        //liste des idg des gladiateurs de l'ethnie ide
    }
    public static String decrireEthnie(Integer ide) {
        // On vérifie que l'ethnie existe
        Ethnie e = GEthnie.chercherEthnie(ide);
        if (e != null) return String.format("%-2d %-10s %-3s", e.getIde(), e.getNom(), e.getScore());
        else return String.format("L'Ethnie %d n'existe pas.", ide);
        //Renvoie la description de l'ethnie : ide,nom,score)
    }
    public static Integer getScore(Integer ide) {
        // On vérifie que l'ethnie existe
        Ethnie e = GEthnie.chercherEthnie(ide);
        
        if (e != null) return e.getScore();
        else {
            System.out.println(String.format("L'Ethnie %d n'existe pas.", ide));
            return -1;
        }
        //retourne le score de l'ethnie ide
    }
    private static Collection<Integer> getListeIde(Collection<Ethnie> le) {
        Collection<Integer> lIde = new ArrayList<Integer>();
        for (Ethnie e : le) {
            lIde.add(e.getIde());
        }
        return lIde;
    }
 
//combat 
    public static Integer frapper(Integer idgAgresseur, Integer idgVictime, Integer ida) {
        Gladiateur agresseur =  GGladiateur.chercherGladiateur(idgAgresseur),
                   victime = GGladiateur.chercherGladiateur(idgVictime);
        Arme a = GArme.chercherArme(ida);
        
        // On vérifie que l'aggresseur, la victime et l'arme existe
        if (a != null && agresseur != null && victime != null) {
            agresseur.frapper(victime, a);
            //le gladiateur idgAgresseur frappe le gladiateur idgVictime ? l'aide de l'arme ida
            return 0;
        } else {
            System.out.println(String.format("Un des arguments donné n'existe pas."));
            return -1;
        }
    }
    public static Integer desarmer(Integer idgVictime, Integer ida) {
        Gladiateur victime = GGladiateur.chercherGladiateur(idgVictime);
        Arme a = GArme.chercherArme(ida);
    
        // On vérifie que la victime et l'arme existe
        if (a != null && victime != null) {
            victime.perdreArme(a);
            //d?pouille le gladiateur idgVictime de son arme ida
            return 0;
        } else {
            System.out.println(String.format("Un des arguments donné n'existe pas."));
            return -1;
        }
    }
    public static Collection<Integer> vainqueurs() {
        //renvoie le ou les ide de l'ethnie (des ethnies ex aequo) gagnante/s
        Collection<Ethnie> vainqueurs = GEthnie.vainqueurs();
        return getListeIde(vainqueurs);
    } 
    
//Pour les tests unitaires
    
    public static String nomDuGladiateur(Integer idg) {
        // On vérifie que le gladiateur existe
        Gladiateur g = GGladiateur.chercherGladiateur(idg);
        
        if (g != null) {
            return g.getNom();
        }
        else {
            return String.format("Le gladiateur %d n'existe pas.", idg);
        }
    }
    public static String nomDeLEthnie(Integer ide) {
        // On vérifie que l'ethnie existe
        Ethnie e = GEthnie.chercherEthnie(ide);
        
        if (e != null) {
            return e.getNom();
        }
        else {
            return String.format("L'Ethnie %d n'existe pas.", ide);
        }
    }  

}