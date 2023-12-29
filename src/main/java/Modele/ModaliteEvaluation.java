package Modele;

public class ModaliteEvaluation {
    private int code;
    private String nom;
    private int coefficient;
    ElementModule elementModule;

    public ModaliteEvaluation(int code, String nom, int coefficient) {
        this.code = code;
        this.nom = nom;
        this.coefficient = coefficient;
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
}
