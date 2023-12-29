package Modele;

import java.util.List;

public class Filiere {
    private int code;
    private String nom;
    private List<ElementModule> elementModules;

    public Filiere(int code, String nom, List<ElementModule> elementModules) {
        this.code = code;
        this.nom = nom;
        this.elementModules = elementModules;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<ElementModule> getElementModules() {
        return elementModules;
    }

    public void setElementModules(List<ElementModule> elementModules) {
        this.elementModules = elementModules;
    }
}
