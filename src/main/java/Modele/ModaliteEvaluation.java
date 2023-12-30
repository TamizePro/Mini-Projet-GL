package Modele;

import java.util.List;

public class ModaliteEvaluation {
    private int code;
    private String nom;
    private int coefficient;
    private ElementModule elementModule;
    private List<Note> notes;

    public ModaliteEvaluation(int code, String nom, int coefficient, ElementModule elementModule, List<Note> notes) {
        this.code = code;
        this.nom = nom;
        this.coefficient = coefficient;
        this.elementModule = elementModule;
        this.notes = notes;
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

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public ElementModule getElementModule() {
        return elementModule;
    }

    public void setElementModule(ElementModule elementModule) {
        this.elementModule = elementModule;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
