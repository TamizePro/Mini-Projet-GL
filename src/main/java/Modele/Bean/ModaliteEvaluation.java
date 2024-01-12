package Modele.Bean;

import java.util.List;

public class ModaliteEvaluation {
    private int code;
    private String nom;
    private float coefficient;
    private List<Note> notes_liste;

    public ModaliteEvaluation(ModaliteEvaluationBuilder modal) {
        this.code = modal.getCode();
        this.nom = modal.getNom();
        this.coefficient = modal.getCoefficient();
        this.notes_liste = modal.getNotes_liste();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof ModaliteEvaluation))
            return false;
        ModaliteEvaluation oo = (ModaliteEvaluation) o;
        return oo.code == code && oo.nom.equals(nom) && oo.coefficient == coefficient;
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

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public List<Note> getNotes_liste()
    {
        return notes_liste;
    }

    public void setNotes_liste(List<Note> notes_liste)
    {
        this.notes_liste = notes_liste;
    }
}
