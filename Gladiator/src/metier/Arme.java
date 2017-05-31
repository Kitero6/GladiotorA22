package metier;

public class Arme {
    private Integer ida;
    private Integer puissDefensive;
    private Integer puissOffensive;
    private String nom;

    public Arme(Integer ida, String nom, Integer pOff, Integer pDef) {
        this.ida = ida;
        this.nom = nom;
        this.puissOffensive = pOff;
        this.puissDefensive = pDef;
    }    

    public String getNom() {
        return this.nom;
    }

    public Integer getIda() {
        return this.ida;
    }

    public Integer getPuissOff() {
        return this.puissOffensive;
    }

    public Integer getPuissDef() {
        return this.puissDefensive;
    }
    
    public String description() {
        //ida | nom | puissance off | puissance def | dispoMir | dispoRet"
        String desc = String.format("id : %-2d | nom : %-10s | Puissance Offensive : %-3d | Puissance Defensive : %-3d",
                                    getIda(),
                                    getNom(),
                                    getPuissOff(),
                                    getPuissDef());
        if (Mirmillon.c_listeArmeDispo().contains(this)) desc += " | dispoMir";
        if (Retiaire.c_listeArmeDispo().contains(this)) desc += " | dispoRet";
        
        return desc;
    }
}
