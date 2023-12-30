package Modele;

import java.util.List;

public class ElementModule {
    private int code;
    private String nom;
    private int coefficient;
    private boolean validation;
    private Professeur professeur;
    private Module module;
    private List<Etudiant> etudiants;
    private List<Filiere> filieres;
    private List<ModaliteEvaluation> modaliteEvaluationList;

    public ElementModule(int code, String nom, int coefficient, boolean validation, Professeur professeur, Module module, List<Etudiant> etudiants, List<Filiere> filieres, List<ModaliteEvaluation> modaliteEvaluations) {
        this.code = code;
        this.nom = nom;
        this.coefficient = coefficient;
        this.validation = validation;
        this.professeur = professeur;
        this.module = module;
        this.etudiants = etudiants;
        this.filieres = filieres;
        this.modaliteEvaluationList = modaliteEvaluations;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public List<ModaliteEvaluation> getModaliteEvaluationList() {
        return modaliteEvaluationList;
    }

    public void setModaliteEvaluationList(List<ModaliteEvaluation> modaliteEvaluationList) {
        this.modaliteEvaluationList = modaliteEvaluationList;
    }
}
