package Modele;

import java.util.List;

public class Filiere {
    private int code;
    private String nom;
    private List<ElementModule> elementModules;
    private List<Module> modules;

    public Filiere(FiliereBuilder fil) {
        this.code = fil.getCode();
        this.nom = fil.getNom();
        this.elementModules = fil.getElementModules();
        this.modules = fil.getModules();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Filiere))
            return false;
        Filiere oo = (Filiere) o;
        return oo.code == code && oo.nom.equals(nom);
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
