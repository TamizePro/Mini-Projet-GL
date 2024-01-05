package Modele;

import java.util.List;
import java.util.Set;

public class ElementModuleBuilder implements IElementModuleBuilder {
    private int code;
    private String nom;
    private float coefficient;
    private boolean validation;
    private List<ModaliteEvaluation> modals;
    private Set<Etd_elementmodul> etd_elementmodul;
    private Set<Filiere_elementmodul> filiere_elementmodul;

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

    @Override
    public ElementModuleBuilder etd_elementmodul(Set<Etd_elementmodul> etd_elementmodul)
    {
        this.etd_elementmodul = etd_elementmodul;
        return this;
    }

    @Override
    public ElementModuleBuilder filiere_elementmodul(Set<Filiere_elementmodul> filiere_elementmodul)
    {
        this.filiere_elementmodul = filiere_elementmodul;
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
    public Set<Etd_elementmodul> getEtd_elementmodul() {
        return etd_elementmodul;
    }

    public Set<Filiere_elementmodul> getFiliere_elementmodul() {
        return filiere_elementmodul;
    }
}
