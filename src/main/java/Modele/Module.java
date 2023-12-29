package Modele;

public class Module {
    private int code;
    private String nom;
    private String semestre;
    private boolean validation;
    Filiere filiere;

    public Module(int code, String nom, String semestre, boolean validation) {
        this.code = code;
        this.nom = nom;
        this.semestre = semestre;
        this.validation = validation;
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
}
