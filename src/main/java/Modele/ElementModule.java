package Modele;

import java.util.List;

public class ElementModule {
    private int code;
    private String nom;
    private float coefficient;
    private boolean validation;
    private List<ModaliteEvaluation> modals;

    public ElementModule(ElementModuleBuilder elmod) {
        this.code = elmod.getCode();
        this.nom = elmod.getNom();
        this.coefficient = elmod.getCoefficient();
        this.validation = elmod.isValidation();
        this.modals = elmod.getModals();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof ElementModule))
            return false;
        ElementModule oo = (ElementModule) o;
        return oo.code == code && oo.nom.equals(nom) && oo.coefficient == coefficient
            && oo.validation == validation;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public List<ModaliteEvaluation> getModals() {
        return modals;
    }

    public void setModals(List<ModaliteEvaluation> modals) {
        this.modals = modals;
    }
}
