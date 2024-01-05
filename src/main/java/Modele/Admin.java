package Modele;

public class Admin {
    private Compte compte;
    private String nom;
    private String prenom;
    private static Admin admin;

    private Admin(Compte compte, String nom, String prenom){
        this.compte = compte;
        this.nom = nom;
        this.prenom = prenom;
    }
    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Admin))
            return false;
        Admin oo = (Admin) o;
        return oo.compte.equals(compte) && oo.nom.equals(nom) && oo.prenom.equals(prenom);
    }
    public static Admin getInstance(Compte compte, String nom, String prenom){
        if (admin == null)
            admin = new Admin(compte, nom, prenom);
        return admin;
    }
    public Compte getCompte(){
        return compte;
    }
    public String getNom(){
        return  nom;
    }
    public String getPrenom(){
        return  prenom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
}
