package Test_Gladiateur;

import java.util.ArrayList;

import metier.*;
import packglad.*;


public class Test_Jeu1 {
    
    
    
    public static void main(String[] args) {
        
        new GArme();
        new GGladiateur();
        new GEthnie();
        
    //Test creation et liste des Armes
        //test du getionaire
        GArme.ajouterArme("Excalibur", 100, 0);
        GArme.ajouterArme("Cotte_Epineuse", 0, 60);
       GArme.ajouterArme("Ak47",666, 0);
       GArme.ajouterArme("Epee_de_l'amitier", 1, 0);
       GArme.ajouterArme("Serviette", 0, 1);
        
        ArrayList<Arme> les_arme =  GArme.listerArme();
        
        //Affiche la liste des armes créer
        for(int i=0; i< les_arme.size();i++) {
            System.out.println(les_arme.get(i).description());
        }
        
    //Test creation et liste Ethnie        
        GEthnie.ajouteurEthnie("Trolls");
       GEthnie.ajouteurEthnie("Noobs");
       GEthnie.ajouteurEthnie("Pros");
       
       ArrayList<Ethnie> les_ethnies = GEthnie.listerEthnie();
       
       for(int i=0; i< les_ethnies.size();i++) {
           System.out.println(les_ethnies.get(i).getNom());
       }
    
    //Test Creaiton et liste des Gladiateurs
       
       //Créer gladiateur
       GGladiateur.ajouterMirmillon("Alfred", 20);
       GGladiateur.ajouterRetiaire("Martin", 15);
       GGladiateur.ajouterMirmillon("megafatty", 100);
       GGladiateur.ajouterRetiaire("Intouchable", 50);
       
       //liste gladiateur
       ArrayList<Gladiateur> les_gladiateurs = GGladiateur.listerGladiateur();
       
       Gladiateur alfred = les_gladiateurs.get(0);
       Gladiateur martin = les_gladiateurs.get(1);
       Gladiateur fatty = les_gladiateurs.get(2);
       
       //cherche gladiateur
       Gladiateur intouch = GGladiateur.chercherGladiateur(3);
       
       
       //Cherche Ethnie
       Ethnie trolls = GEthnie.chercherEthnie(0);
       Ethnie noobs = GEthnie.chercherEthnie(1);
       Ethnie pros = GEthnie.chercherEthnie(2);
       
       //atribtion ethnie a gladiateur
       GEthnie.ajouterGladiateur(noobs, alfred);
       GEthnie.ajouterGladiateur(noobs, martin);
       GEthnie.ajouterGladiateur(pros, fatty);
       GEthnie.ajouterGladiateur(pros, intouch);
       
       //Liste tout les rapports des gladiateurs
       for(int i =0; i < les_gladiateurs.size();i++) {
           System.out.println(les_gladiateurs.get(i).rapport(GEthnie.getEthnieGladiateur(GGladiateur.chercherGladiateur(i)).getNom()));
       }
       
       // Autorisation d'armes aux Retiaires
       GGladiateur.autoriserArmeMirmillon(GArme.chercherArme(3));
       
       //ajout d'armes
       alfred.receveoirArme(GArme.chercherArme(4));
       alfred.receveoirArme(GArme.chercherArme(3));
       ArrayList<Arme> arme_alfred = alfred.declarerArme();
       
       for(int i =0; i < arme_alfred.size();i++) {
           System.out.println(arme_alfred.get(i).getNom());
           
       }
       
       fatty.receveoirArme(GArme.chercherArme(1));
       fatty.receveoirArme(GArme.chercherArme(2));
    
       ArrayList<Arme> arme_fatty = fatty.declarerArme();
       
       for(int i = 0; i < arme_fatty.size();i++) {
           System.out.println(arme_fatty.get(i).getNom());           
       }
       
       //Combat de Fatty vs Alfred
       alfred.frapper(fatty, GArme.chercherArme(3));
       fatty.frapper(alfred, GArme.chercherArme(0));
       
       //fin du combat 
       System.out.println(fatty.rapport(GEthnie.getEthnieGladiateur(fatty).getNom()));
       System.out.println(alfred.rapport(GEthnie.getEthnieGladiateur(alfred).getNom()));
       
       //Score final
       System.out.println("Score Noobs : "+noobs.getScore());
       System.out.println("Score Pros : "+pros.getScore());
       
        
   }
    
}
