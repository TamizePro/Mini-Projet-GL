package Modele;

import java.util.List;
import java.util.Set;

public interface IEtudiantBuilder {
    //
    public EtudiantBuilder etd_elementmoduls(Set<Etd_elementmodul> etd_elementmodul);
    public EtudiantBuilder noteslist(List<Note> notes);
}
