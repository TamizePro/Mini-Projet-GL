package Modele.Bean;

import java.util.List;

public interface IProfesseurBuilder {
    //
    public ProfesseurBuilder elementModules(List<ElementModule> elementmodules);
    public ProfesseurBuilder compte(Compte compte);
}
