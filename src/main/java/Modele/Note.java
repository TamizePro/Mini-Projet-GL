package Modele;

public class Note {
    private int code;
    private float note;
    private boolean etudiant_absent;
    private Etudiant etudiant;
    private ModaliteEvaluation modaliteEvaluation;

    public Note(int code, float note, boolean etudiantAbsent, Etudiant etudiant, ModaliteEvaluation modaliteEvaluation) {
        this.code = code;
        this.note = note;
        etudiant_absent = etudiantAbsent;
        this.etudiant = etudiant;
        this.modaliteEvaluation = modaliteEvaluation;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isEtudiant_absent() {
        return etudiant_absent;
    }

    public void setEtudiant_absent(boolean etudiant_absent) {
        this.etudiant_absent = etudiant_absent;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public ModaliteEvaluation getModaliteEvaluation() {
        return modaliteEvaluation;
    }

    public void setModaliteEvaluation(ModaliteEvaluation modaliteEvaluation) {
        this.modaliteEvaluation = modaliteEvaluation;
    }
}
