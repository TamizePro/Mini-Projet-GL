package Modele;

import java.util.List;

public class ModaliteEvaluationBuilder implements IModaliteEvaluationBuilder {
    private int code;
    private String nom;
    private float coefficient;
    private List<Note> notes_liste;

    public ModaliteEvaluationBuilder(String nom, float coefficient)
    {
        this.nom = nom;
        this.coefficient = coefficient;
    }

    public ModaliteEvaluation build()
    {
        return new ModaliteEvaluation(this);
    }

    @Override
    public ModaliteEvaluationBuilder code(int code)
    {
        this.code = code;
        return this;
    }

    @Override
    public ModaliteEvaluationBuilder notes_liste(List<Note> notes)
    {
        this.notes_liste = notes;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public List<Note> getNotes_liste()
    {
        return notes_liste;
    }
}
