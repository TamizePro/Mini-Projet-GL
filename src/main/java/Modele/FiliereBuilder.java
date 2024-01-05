package Modele;

import java.util.List;
import java.util.Set;

public class FiliereBuilder implements IFiliereBuilder {
    private int code;
    private String nom;
    private Set<Filiere_elementmodul> etd_elementmoduls;
    private List<Module> modules;

    public FiliereBuilder(int code, String nom)
    {
        this.code = code;
        this.nom = nom;
    }

    @Override
    public FiliereBuilder etd_elementmoduls(Set<Filiere_elementmodul> etd_elementmoduls)
    {
        this.etd_elementmoduls = etd_elementmoduls;
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

    public Set<Filiere_elementmodul> getEtd_elementmoduls() {
        return etd_elementmoduls;
    }

    public List<Module> getModules() {
        return modules;
    }

    public Filiere build()
    {
        return new Filiere(this);
    }
}
