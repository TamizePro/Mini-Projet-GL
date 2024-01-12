package Modele.DAO;
import Modele.Bean.*;

import java.util.List;

public interface INoteDAO {
    //
    public boolean AddNote(Note note);
    public boolean DeleteNote(Note note);
    public boolean UpdateNoteByCode(Note note);
    public Note GetNoteByCode(int code);
    public List<Note> GetAllNote();
}
