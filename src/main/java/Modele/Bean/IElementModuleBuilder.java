package Modele.Bean;

import java.util.List;
import java.util.Set;

public interface IElementModuleBuilder {
    //
    public ElementModuleBuilder code(int code);
    public ElementModuleBuilder validation(boolean val);
    public ElementModuleBuilder modals(List<ModaliteEvaluation> modals);
    public ElementModuleBuilder etd_elementmodul(Set<Etd_elementmodul> etd_elementmodul);
    public ElementModuleBuilder filiere_elementmodul(Set<Filiere_elementmodul> filiere_elementmodul);
}
