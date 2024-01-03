package Modele;

import java.util.List;

public class EtudiantBuilder implements IEtudiantBuilder {
    private long code;
    private String nom;
    private String prenom;
    private List<ElementModule> elementModules;
    private List<Note> noteslist;

    public EtudiantBuilder(long code, String nom, String prenom)
    {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public EtudiantBuilder elementModules(List<ElementModule> elementmodules)
    {
        this.elementModules = elementmodules;
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

    public List<ElementModule> getElementModules() {
        return elementModules;
    }

    public List<Note> getNoteslist() {
        return noteslist;
    }
}
