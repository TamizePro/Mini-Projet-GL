package Modele;

import java.util.List;

public class ElementModuleBuilder implements IElementModuleBuilder {
    private int code;
    private String nom;
    private float coefficient;
    private boolean validation;
    private List<ModaliteEvaluation> modals;

    public ElementModuleBuilder(String nom, float coefficient)
    {
        this.nom = nom;
        this.coefficient = coefficient;
    }

    @Override
    public ElementModuleBuilder code(int code)
    {
        this.code = code;
        return this;
    }

    @Override
    public ElementModuleBuilder validation(boolean val)
    {
        this.validation = val;
        return this;
    }

    @Override
    public ElementModuleBuilder modals(List<ModaliteEvaluation> modals)
    {
        this.modals = modals;
        return this;
    }

    public ElementModule build()
    {
        return new ElementModule(this);
    }

    public int getCode() {
        return code;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public String getNom() {
        return nom;
    }

    public boolean isValidation() {
        return validation;
    }

    public List<ModaliteEvaluation> getModals() {
        return modals;
    }
}
