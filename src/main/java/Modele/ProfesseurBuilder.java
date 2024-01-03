package Modele;

import java.util.List;

public class ProfesseurBuilder implements IProfesseurBuilder {
    private Compte compte;
    private String nom;
    private String prenom;
    private String specialite;
    private long code;
    List<ElementModule> elementModules;

    public ProfesseurBuilder(String nom, String prenom,
        String specialite, Long code)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.code = code;
    }

    public Professeur build()
    {
        return new Professeur(this);
    }

    @Override
    public ProfesseurBuilder elementModules(List<ElementModule> elementmodules)
    {
        this.elementModules = elementmodules;
        return this;
    }

    @Override
    public ProfesseurBuilder compte(Compte compte)
    {
        this.compte = compte;
        return this;
    }

    public List<ElementModule> getElementModules() {
        return elementModules;
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

    public String getSpecialite() {
        return specialite;
    }

    public Compte getCompte() {
        return compte;
    }

    public long getCode() {
        return code;
    }
}
