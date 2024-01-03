package Modele;

import java.util.List;

public interface IEtudiantBuilder {
    //
    public EtudiantBuilder elementModules(List<ElementModule> elementmodules);
    public EtudiantBuilder noteslist(List<Note> notes);
}
