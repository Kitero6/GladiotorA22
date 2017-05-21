package packglad;

public class Arme {
    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */
    private Integer puissOffensive;

    /**
     * @attribute
     */
    private Integer puissDefensive;

    /**
     * @attribute
     */
    private Integer ida;

    public Arme(Integer ida, String nom, Integer pOff, Integer pDef) {
        this.ida = ida;
        this.nom = nom;
        this.puissOffensive = pOff;
        this.puissDefensive = pDef;
    }
    
    public Integer getIda() { return this.ida; }
    
    public String getNom() { return this.nom; }
    
    public Integer getPuissOffensive() { return this.puissOffensive; }
    
    public Integer getPuissDefensive() { return this.puissDefensive; }

    public void description() {
    }
}
