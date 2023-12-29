package Modele;

public class Admin {
    private Compte compte;
    private String nom;
    private String prenom;
    public Compte getCompte(){
        return compte;
    }
    public String getNom(){
        return  nom;
    }
    public String getPrenom(){
        return  prenom;
    }
    public void setCompte(Compte compte){
        this.compte = compte;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
}
