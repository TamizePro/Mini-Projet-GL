package Modele;

// Modele.Professeur.java
public class Professeur {
    private Compte compte;
    private String nom;
    private String prenom;
    private String specialite;
    private long code;

    // Constructeur
    public Professeur(Compte compte, String nom, String prenom, String specialite, long code) {
        this.compte = compte;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.code = code;
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
}
