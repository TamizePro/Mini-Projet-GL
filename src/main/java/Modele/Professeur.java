package Modele;

import java.util.List;

public class Professeur {
    private Compte compte;
    private String nom;
    private String prenom;
    private String specialite;
    private long code;
    List<ElementModule> elementModules;

    public Professeur(ProfesseurBuilder prf) {
        this.compte = prf.getCompte();
        this.nom = prf.getNom();
        this.prenom = prf.getPrenom();
        this.specialite = prf.getSpecialite();
        this.code = prf.getCode();
        this.elementModules = prf.getElementModules();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Professeur))
            return false;
        Professeur oo = (Professeur) o;
        return oo.nom.equals(nom) && oo.prenom.equals(prenom)
            && oo.specialite.equals(specialite) && oo.code == code;
    }

    public Compte getCompte()
    {
        return compte;
    }

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
}
