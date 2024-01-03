package Modele;

import java.util.List;
import java.util.Set;

public class Etudiant {
    private long code;
    private String nom;
    private String prenom;
    private List<Note> noteslist;
    private Set<Etd_elementmodul> etd_elementmoduls;

    public Etudiant(EtudiantBuilder etdbuilder) {
        this.code = etdbuilder.getCode();
        this.nom = etdbuilder.getNom();
        this.prenom = etdbuilder.getPrenom();
        this.etd_elementmoduls = etdbuilder.getEtd_elementmoduls();
        this.noteslist = etdbuilder.getNoteslist();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Etudiant))
            return false;
        Etudiant oo = (Etudiant) o;
        return oo.code == code && oo.nom.equals(nom) && oo.prenom.equals(prenom);
    }

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Etd_elementmodul> getEtd_elementmoduls() {
        return etd_elementmoduls;
    }

    public void setEtd_elementmoduls(Set<Etd_elementmodul> etd_elementmoduls) {
        this.etd_elementmoduls = etd_elementmoduls;
    }

    public List<Note> getNoteslist() {
        return noteslist;
    }

    public void setNoteslist(List<Note> noteslist) {
        this.noteslist = noteslist;
    }
}
