package Modele;

import java.util.List;

public class Filiere {
    private int code;
    private String nom;
    private List<ElementModule> elementModules;
    private List<Module> modules;

    public Filiere(int code, String nom, List<ElementModule> elementModules, List<Module> modules) {
        this.code = code;
        this.nom = nom;
        this.elementModules = elementModules;
        this.modules = modules;
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

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
