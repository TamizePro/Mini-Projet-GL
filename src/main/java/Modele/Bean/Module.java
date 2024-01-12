package Modele.Bean;

import java.util.List;

public class Module {
    private int code;
    private String nom;
    private String semestre;
    private boolean validation;
    private List<ElementModule> elmods;

    public Module(ModuleBuilder modb) {
        this.code = modb.getCode();
        this.nom = modb.getNom();
        this.semestre = modb.getSemestre();
        this.validation = modb.isValidation();
        this.elmods = modb.getElmods();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Module))
            return false;
        Module oo = (Module) o;
        return oo.code == code && oo.nom.equals(nom)
            && oo.semestre.equals(semestre) && oo.validation == validation;
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

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public List<ElementModule> getElmods() {
        return elmods;
    }

    public void setElmods(List<ElementModule> elmods) {
        this.elmods = elmods;
    }
}
