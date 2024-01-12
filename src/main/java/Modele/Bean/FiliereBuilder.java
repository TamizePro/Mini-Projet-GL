package Modele.Bean;

import java.util.List;
import java.util.Set;

public class FiliereBuilder implements IFiliereBuilder {
    private int code;
    private String nom;
    private Set<Filiere_elementmodul> fil_elementmoduls;
    private List<Module> modules;

    public FiliereBuilder(int code, String nom)
    {
        this.code = code;
        this.nom = nom;
    }

    @Override
    public FiliereBuilder Fil_elementmoduls(Set<Filiere_elementmodul> fil_elementmoduls)
    {
        this.fil_elementmoduls = fil_elementmoduls;
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

    public Set<Filiere_elementmodul> getFil_elementmoduls() {
        return fil_elementmoduls;
    }

    public List<Module> getModules() {
        return modules;
    }

    public Filiere build()
    {
        return new Filiere(this);
    }
}
