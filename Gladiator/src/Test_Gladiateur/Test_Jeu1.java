package Test_Gladiateur;

import java.util.ArrayList;

import metier.*;
import packglad.*;


public class Test_Jeu1 {
    
    
    
    public static void main(String[] args) {
        
    //Test creation et liste des Armes
        //test du getionaire
        GArme.ajouterArme("Excalibur", 100, 0);
        GArme.ajouterArme("Cotte_Epineuse", 0, 60);
       GArme.ajouterArme("Ak47",50, 0);
       GArme.ajouterArme("Epee_de_l'amitier", 10, 0);
       GArme.ajouterArme("Serviette", 0, 10);
        
        ArrayList<Arme> les_arme =  GArme.listerArme();
        
       System.out.println("Liste Armes :");
        //Affiche la liste des armes créer
        for(int i=0; i< les_arme.size();i++) {
            System.out.println(les_arme.get(i).description());
        }
        
    //Test creation et liste Ethnie   
       GEthnie.ajouteurEthnie("Noobs"); // ide = 1
       GEthnie.ajouteurEthnie("Pros");  // ide = 2
       GEthnie.ajouteurEthnie("test");
       
       ArrayList<Ethnie> les_ethnies = GEthnie.listerEthnie();
       System.out.println();
       
       System.out.println("Liste Des Ethnies :");
       for(int i=0; i< les_ethnies.size();i++) {
           System.out.println(les_ethnies.get(i).getIde()+" "+les_ethnies.get(i).getNom());
       }
    
    //Test Creaiton et liste des Gladiateurs
       
       //Créer gladiateur
       GGladiateur.ajouterMirmillon("Alfred", 20);
       GGladiateur.ajouterRetiaire("Martin", 15);
       GGladiateur.ajouterMirmillon("megafatty", 100);
       GGladiateur.ajouterRetiaire("Intouchable", 50);
       
       //liste gladiateur
       ArrayList<Gladiateur> les_gladiateurs = GGladiateur.listerGladiateur();
       
       Integer alfred = les_gladiateurs.get(0).getIdg();       
       Integer fatty = les_gladiateurs.get(2).getIdg();
       
       //cherche gladiateur
       //Integer intouch = GGladiateur.chercherGladiateur(4).getIdg();

       //Ne pas confondre idg et l'indice dans une liste!
       
       
       //Cherche Ethnie
       Integer noobs = GEthnie.chercherEthnie(1).getIde(); // ide = 1
       Integer pros = GEthnie.chercherEthnie(2).getIde(); // ide = 2
       
       //atribtion ethnie a gladiateur
       GEthnie.ajouterGladiateur(GEthnie.chercherEthnie(noobs), GGladiateur.chercherGladiateur(alfred));
       GEthnie.ajouterGladiateur(GEthnie.chercherEthnie(pros), GGladiateur.chercherGladiateur(fatty)); //Introuvable quand on le cherche
       
       
       //Liste tout les rapports des gladiateurs
       System.out.println();
       System.out.println("Liste des gladiateurs :");
       for(int i =1; i <= les_gladiateurs.size();i++) {
           String nomEthnie = GEthnie.getEthnieGladiateur(GGladiateur.chercherGladiateur(i)).getNom();
           System.out.println(GGladiateur.chercherGladiateur(i).rapport(nomEthnie));
           System.out.println();
       }
       
       // Autorisation d'armes aux Mirmillon
       GGladiateur.autoriserArmeMirmillon(GArme.chercherArme(1));
       GGladiateur.autoriserArmeMirmillon(GArme.chercherArme(2));
       GGladiateur.autoriserArmeMirmillon(GArme.chercherArme(3));
       GGladiateur.autoriserArmeMirmillon(GArme.chercherArme(4));
       GGladiateur.autoriserArmeMirmillon(GArme.chercherArme(5));
       
       //ajout d'armes
       GGladiateur.chercherGladiateur(alfred).receveoirArme(GArme.chercherArme(4));
       GGladiateur.chercherGladiateur(alfred).receveoirArme(GArme.chercherArme(5));
       ArrayList<Arme> arme_alfred = GGladiateur.chercherGladiateur(alfred).declarerArme();
       
       System.out.println();
       System.out.println("Arme Alfred :");
       for(int i =0; i < arme_alfred.size();i++) {
           System.out.println(arme_alfred.get(i).getNom());
       }
       
       GGladiateur.chercherGladiateur(fatty).receveoirArme(GArme.chercherArme(1));
       GGladiateur.chercherGladiateur(fatty).receveoirArme(GArme.chercherArme(2));
    
       ArrayList<Arme> arme_fatty = GGladiateur.chercherGladiateur(fatty).declarerArme();
       
       System.out.println();
       System.out.println("Arme Fatty : ");
       for(int i = 0; i < arme_fatty.size();i++) {
           System.out.println(arme_fatty.get(i).getNom());           
       }
       System.out.println();
       
       //Combat de Fatty vs Alfred
       System.out.println("Debut Combat!");
       GGladiateur.chercherGladiateur(alfred).frapper(GGladiateur.chercherGladiateur(fatty), GArme.chercherArme(3));
       GGladiateur.chercherGladiateur(fatty).frapper(GGladiateur.chercherGladiateur(alfred), GArme.chercherArme(0));
       
       //fin du combat 
       System.out.println(GGladiateur.chercherGladiateur(fatty).rapport(GEthnie.getEthnieGladiateur(GGladiateur.chercherGladiateur(fatty)).getNom()));
       System.out.println(GGladiateur.chercherGladiateur(alfred).rapport(GEthnie.getEthnieGladiateur(GGladiateur.chercherGladiateur(alfred)).getNom()));
       
       //Score final
       System.out.println("Score Noobs : "+GEthnie.chercherEthnie(noobs).getScore());
       System.out.println("Score Pros : "+GEthnie.chercherEthnie(pros).getScore());
       
        
   }
    
}