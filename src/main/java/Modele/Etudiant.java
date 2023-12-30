package Modele;

import java.util.List;

public class Etudiant {
    private long code;
    private String nom;
    private String prenom;
    private List<ElementModule> elementModules;
    private List<Note> notes;

    public Etudiant(long code, String nom, String prenom, List<ElementModule> elementModules, List<Note> notes) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.elementModules = elementModules;
        this.notes = notes;
    }

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<ElementModule> getElementModules() {
        return elementModules;
    }

    public void setElementModules(List<ElementModule> elementModules) {
        this.elementModules = elementModules;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
