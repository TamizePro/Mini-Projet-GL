package Modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NoteDAOTest {
	private NoteDAO noteDAO;

	@BeforeEach
	public void init() {
		this.noteDAO = new NoteDAO(MySQLConnection.getInstance());
	}

	@Test
	@Order(1)
	public void shouldAddNote() {
		// TODO: initialize args
		Note note;
		note = new Note(19.5f, true);
		boolean actualValue = noteDAO.AddNote(note);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	@Order(2)
	public void shouldGetNoteByCode() {
		// TODO: initialize args
		int code;
		code = 1;
		Note realval = new Note(code, 19.5f, true);
		Note actualValue = noteDAO.GetNoteByCode(code);
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be equals");
	}

	@Test
	@Order(3)
	public void shouldUpdateNoteByCode() {
		// TODO: initialize args
		Note note;
		note = new Note(1, 19.75f, false);
		boolean actualValue = noteDAO.UpdateNoteByCode(note);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}

	@Test
	@Order(4)
	public void shouldGetAllNote() {
		List<Note> actualValue = noteDAO.GetAllNote();
		List<Note> realval = new ArrayList();
		realval.add(new Note(1, 19.75f, false));
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}

	@Test
	@Order(5)
	public void shouldDeleteNote() {
		// TODO: initialize args
		Note note;
		note = new Note(1, 19.75f, false);
		boolean actualValue = noteDAO.DeleteNote(note);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}
}
