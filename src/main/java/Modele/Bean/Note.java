package Modele.Bean;

public class Note {
    private int code;
    private float note;
    private boolean etudiant_absent;

    public Note(int code, float note, boolean etudiantAbsent) {
        this.code = code;
        this.note = note;
        this.etudiant_absent = etudiantAbsent;
    }

    public Note(float note, boolean etudiantAbsent) {
        this.note = note;
        this.etudiant_absent = etudiantAbsent;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Note))
            return false;
        Note oo = (Note) o;
        return oo.code == code && oo.note == note && oo.etudiant_absent == etudiant_absent;
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
}
