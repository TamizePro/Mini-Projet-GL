package Modele;

import java.util.List;
public class FiliereBuilder implements IFiliereBuilder {
    private int code;
    private String nom;
    private List<ElementModule> elementModules;
    private List<Module> modules;

    public FiliereBuilder(int code, String nom)
    {
        this.code = code;
        this.nom = nom;
    }

    @Override
    public FiliereBuilder elementModules(List<ElementModule> elementmodules)
    {
        this.elementModules = elementmodules;
        return this;
    }

    @Override
    public FiliereBuilder modules(List<Module> listmodules)
    {
        this.modules = listmodules;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public List<ElementModule> getElementModules() {
        return elementModules;
    }

    public List<Module> getModules() {
        return modules;
    }

    public Filiere build()
    {
        return new Filiere(this);
    }
}
