package Modele;

import java.util.List;
import java.util.Set;

public class ElementModule {
    private int code;
    private String nom;
    private float coefficient;
    private boolean validation;
    private List<ModaliteEvaluation> modals;
    private Set<Etd_elementmodul> etd_elementmodul;
    private Set<Filiere_elementmodul> filiere_elementmodul;

    public ElementModule(ElementModuleBuilder elmod) {
        this.code = elmod.getCode();
        this.nom = elmod.getNom();
        this.coefficient = elmod.getCoefficient();
        this.validation = elmod.isValidation();
        this.modals = elmod.getModals();
        this.etd_elementmodul = elmod.getEtd_elementmodul();
        this.filiere_elementmodul = elmod.getFiliere_elementmodul();
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

    public Set<Etd_elementmodul> getEtd_elementmodul() {
        return etd_elementmodul;
    }

    public void setEtd_elementmodul(Set<Etd_elementmodul> etd_elementmodul) {
        this.etd_elementmodul = etd_elementmodul;
    }

    public Set<Filiere_elementmodul> getFiliere_elementmodul() {
        return filiere_elementmodul;
    }

    public void setFiliere_elementmodul(Set<Filiere_elementmodul> filiere_elementmodul) {
        this.filiere_elementmodul = filiere_elementmodul;
    }
}
