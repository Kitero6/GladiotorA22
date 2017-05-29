package packmain;

import java.util.ArrayList;
import java.util.Collection;

import packglad.Facade;

public class Test0 {


    public static void main(String[] args) {
        Integer numret, valret;
        System.out.println("----> 0. Lancement du jeu d'essai ============");
        Facade.lancerJeuDEssai();
        System.out.println("----> 1. Creation d'un retiaire ");
        numret = Facade.creerRetiaire("Retor     ", 40, 3);
        System.out.println(Facade.faireRapport(numret));
        //
        System.out.println("----> 2. Creation d'un mirmillon ");
        numret = Facade.creerMirmillon("Mirmor    ", 60, 2);
        System.out.println(Facade.faireRapport(numret));
        //
        System.out.println("----> 3. Creation d'une arme ");
        numret = Facade.creerUneArme("lance", 80, 10);
        System.out.println(Facade.decrireArme(numret));

        System.out.println("----> 4. Autoriser cette arme aux mirmillons ");
        Facade.autoriserArmeAuxMirmillons(numret);
        System.out.println("----> 5. Autoriser cette arme aux retiaires ");
        Facade.autoriserArmeAuxRetiaires(numret);
        //
        System.out.println("----> 6. Armes disponibles pour Mirmillons");
        for (Integer i : Facade.listerArmesDispoMirmillon()) {
            System.out.println("        " + Facade.decrireArme(i));
        }
        System.out.println();
        System.out.println("----> 7. Armes disponibles pour Retiaires ");

        for (Integer i : Facade.listerArmesDispoRetiaire()) {
            System.out.println("        " + Facade.decrireArme(i));
        }
        System.out.println();
        System.out.println("----->12. Donner l'arme :7 (lance) au gladiateur N?7 Retor");
        valret = Facade.donnerUneArme(7, 7);
        System.out.println("----->12. Donner une arme interdite 4:Bouclier au gladiateur N?7 Retor");
        valret = Facade.donnerUneArme(4, 7);
        System.out.println();
        System.out.println("----->8. Debut du combat : Les gladiateurs saluent et d?clarent leurs armes ================");

        for (Integer idg : Facade.listerTousGladiateurs()) {
            System.out.print("        " + Facade.faireSaluerGladiateur(idg));
            System.out.print(" ; Mes armes : ");
            for (Integer ida : Facade.declarerArmes(idg))
                System.out.print(Facade.nomDeLArme(ida) + ", ");
            System.out.println();
        }
        //
        System.out.println();
        System.out.println("----->13. Frapper( agresseur:1, agress?: 4, arme utilis?e:2 )");
        valret = Facade.frapper(1, 4, 2);
        System.out.println("----->13. Frapper( agresseur:7, agress?: 4, arme utilis?e:7 )");
        valret = Facade.frapper(7, 4, 7);
        System.out.println("----->13. Frapper( agresseur:4, agress?: 1, arme utilis?e:4 )");
        valret = Facade.frapper(4, 1, 4);
        System.out.println("----->14. Desarmer ( desarm?:1 , arme retir?e:2(trident) )  ");
        Facade.desarmer(1, 2);
        System.out.println();
        System.out.println("----->15. Fin du combat  ");

        System.out.println("    ====== Tous les scores ==============");
        for (Integer ide : Facade.listerEthnies())
            System.out.println(Facade.decrireEthnie(ide));
        System.out.println();
        System.out.println("    ====== rapports ==============");

        for (Integer idg : Facade.listerTousGladiateurs())
            System.out.println(Facade.faireRapport(idg));
        System.out.println("    ===== vainqueurs ===============");
        for (Integer ide : Facade.vainqueurs())
            System.out.println(Facade.decrireEthnie(ide));
    }

}

