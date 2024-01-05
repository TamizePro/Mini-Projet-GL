package Modele;

import java.util.List;

public interface IElementModuleBuilder {
    //
    public ElementModuleBuilder code(int code);
    public ElementModuleBuilder validation(boolean val);
    public ElementModuleBuilder modals(List<ModaliteEvaluation> modals);
}
