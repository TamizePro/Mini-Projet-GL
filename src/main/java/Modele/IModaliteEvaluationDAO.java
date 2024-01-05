package Modele;

import java.util.List;

public interface IModaliteEvaluationDAO {
    //
    public boolean AddModaliteEvaluation(ModaliteEvaluation modal, Integer code_note);
    public boolean DeleteModaliteEvaluation(ModaliteEvaluation modal);
    public boolean UpdateModaliteEvaluationByCode(ModaliteEvaluation modal, Integer code_note);
    public ModaliteEvaluation GetModaliteEvaluationByCode(int code);
    public List<ModaliteEvaluation> GetAllModaliteEvaluation();
}
