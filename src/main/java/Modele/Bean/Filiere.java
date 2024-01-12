package Modele.Bean;

import java.util.List;
import java.util.Set;

public class Filiere {
    private int code;
    private String nom;
    private List<Module> modules;
    private Set<Filiere_elementmodul> fil_elementmoduls;

    public Filiere(FiliereBuilder fil) {
        this.code = fil.getCode();
        this.nom = fil.getNom();
        this.fil_elementmoduls = fil.getFil_elementmoduls();
        this.modules = fil.getModules();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Filiere))
            return false;
        Filiere oo = (Filiere) o;
        return oo.code == code && oo.nom.equals(nom);
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

    public Set<Filiere_elementmodul> getFil_elementmoduls() {
        return fil_elementmoduls;
    }

    public void setFil_elementmoduls(Set<Filiere_elementmodul> fil_elementmoduls) {
        this.fil_elementmoduls = fil_elementmoduls;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
