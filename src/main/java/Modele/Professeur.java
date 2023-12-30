package Modele;

import java.util.List;

// Modele.Professeur.java
public class Professeur {
    private Compte compte;
    private String nom;
    private String prenom;
    private String specialite;
    private long code;
    private List<ElementModule> elementModules;

    // Constructeur
    public Professeur(Compte compte, String nom, String prenom, String specialite, long code, List<ElementModule> elementModules) {
        this.compte = compte;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.code = code;
        this.elementModules = elementModules;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ElementModule> getElementModules() {
        return elementModules;
    }

    public void setElementModules(List<ElementModule> elementModules) {
        this.elementModules = elementModules;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
