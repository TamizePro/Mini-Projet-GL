package Modele.Bean;

import java.util.List;

public class ModuleBuilder implements IModuleBuilder {
    private int code;
    private String nom;
    private String semestre;
    private boolean validation;
    private List<ElementModule> elmods;

    public ModuleBuilder(String nom, String semestre)
    {
        this.nom = nom;
        this.semestre = semestre;
    }

    public Module build()
    {
        return new Module(this);
    }

    @Override
    public ModuleBuilder code(int code)
    {
        this.code = code;
        return this;
    }

    @Override
    public ModuleBuilder Vald(boolean val)
    {
        this.validation = val;
        return this;
    }

    @Override
    public ModuleBuilder elmods(List<ElementModule> elmods)
    {
        this.elmods = elmods;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getSemestre() {
        return semestre;
    }

    public boolean isValidation() {
        return validation;
    }

    public List<ElementModule> getElmods() {
        return elmods;
    }
}
