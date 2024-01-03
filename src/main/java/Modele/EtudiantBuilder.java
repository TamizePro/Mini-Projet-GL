package Modele;

import java.util.List;
import java.util.Set;

public class EtudiantBuilder implements IEtudiantBuilder {
    private long code;
    private String nom;
    private String prenom;
    private List<Note> noteslist;
    private Set<Etd_elementmodul> etd_elementmoduls;

    public EtudiantBuilder(long code, String nom, String prenom)
    {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public EtudiantBuilder etd_elementmoduls(Set<Etd_elementmodul> etd_elementmodul)
    {
        this.etd_elementmoduls = etd_elementmodul;
        return this;
    }

    @Override
    public EtudiantBuilder noteslist(List<Note> notes)
    {
        this.noteslist = notes;
        return this;
    }

    public Etudiant build() {return new Etudiant(this);}

    public long getCode() {return code;}

    public String getPrenom() {return prenom;}

    public String getNom() {return nom;}

    public Set<Etd_elementmodul> getEtd_elementmoduls() {
        return etd_elementmoduls;
    }

    public List<Note> getNoteslist() {
        return noteslist;
    }
}
