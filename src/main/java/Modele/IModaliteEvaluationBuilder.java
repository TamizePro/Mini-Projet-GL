package Modele;

import java.util.List;

public interface IModaliteEvaluationBuilder {
    //
    public ModaliteEvaluationBuilder code(int code);
    public ModaliteEvaluationBuilder notes_liste(List<Note> notes);
}
