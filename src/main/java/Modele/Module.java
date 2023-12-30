package Modele;

import java.util.List;

public class Module {
    private int code;
    private String nom;
    private String semestre;
    private boolean validation;
    private Filiere filiere;
    private List<ElementModule> elementModuleList;

    public Module(int code, String nom, String semestre, boolean validation, Filiere filiere, List<ElementModule> elementModuleList) {
        this.code = code;
        this.nom = nom;
        this.semestre = semestre;
        this.validation = validation;
        this.filiere = filiere;
        this.elementModuleList = elementModuleList;
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

    public List<ElementModule> getElementModuleList() {
        return elementModuleList;
    }

    public void setElementModuleList(List<ElementModule> elementModuleList) {
        this.elementModuleList = elementModuleList;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
