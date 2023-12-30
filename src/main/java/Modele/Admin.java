package Modele;

public class Admin {
    private static  Admin instance;
    private Compte compte;

    private Admin(Compte compte) {
        this.compte = compte;
    }
    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin(new Compte("Admin","password"));
        }

        return instance;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
