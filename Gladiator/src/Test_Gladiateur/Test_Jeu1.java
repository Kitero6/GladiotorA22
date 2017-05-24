package Test_Gladiateur;

import java.util.ArrayList;

import metier.*;
import packglad.*;


public class Test_Jeu1 {
    
    
    
    public static void main(String[] args) {
        
        
    //Test creation et liste des Armes
        //test du getionaire
        GArme.ajouterArme("Excalibur", 900, 0);
        GArme.ajouterArme("Cotte_Epineuse", 0, 100);
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
           System.out.println(les_gladiateurs.get(i).rapport());
       }
       
       
       //ajout d'armes
       alfred.receveoirArme(les_arme.get(4));
       alfred.receveoirArme(les_arme.get(3));
       ArrayList<Arme> arme_alfred = alfred.declarerArme();
       
       for(int i =0; i < arme_alfred.size();i++) {
           System.out.println(arme_alfred.get(i).getNom());
       }
       
        
        
   }
    
}
