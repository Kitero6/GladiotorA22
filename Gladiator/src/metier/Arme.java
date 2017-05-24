package metier;

public class Arme {
    /**
     * @attribute
     */
    private Integer ida;

    /**
     * @attribute
     */
    private Integer puissDefensive;

    /**
     * @attribute
     */
    private Integer puissOffensive;

    /**
     * @attribute
     */
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
        //ida | nom | puissance off | puissance def"
        return "id : "+getIda()+" | nom : "+getNom()+"| Puissance Offensive : "+getPuissOff()+"| Puissance Defensive : "+getPuissDef();
    }
}
