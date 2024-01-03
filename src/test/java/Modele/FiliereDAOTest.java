package Modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class FiliereDAOTest {
	private FiliereDAO filiereDAO;

	@BeforeEach
	public void init() {
		this.filiereDAO = new FiliereDAO(MySQLConnection.getInstance());
	}

	@Test
	public void shouldAddFiliere() {
		// TODO: initialize args
		Filiere filiere;
		filiere = new FiliereBuilder(1, "IID").build();
		boolean actualValue = filiereDAO.AddFiliere(filiere);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	public void shouldDeleteFiliere() {
		// TODO: initialize args
		Filiere filiere;
		filiere = new FiliereBuilder(1, "IID").build();
		boolean actualValue = filiereDAO.DeleteFiliere(filiere);
		// TODO: assert scenario
		assertTrue(actualValue, "Deleting compte should return true on success");
	}

	@Test
	public void shouldUpdateFiliereByCode() {
		// TODO: initialize args
		Filiere filiere;
		int code;
		code = 2;
		filiere = new FiliereBuilder(code, "IID").build();
		boolean actualValue = filiereDAO.UpdateFiliereByCode(filiere, code);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}

	@Test
	public void shouldGetFiliereByCode() {
		// TODO: initialize args
		int code;
		code = 3;
		Filiere realval = new FiliereBuilder(code, "GI").build();
		Filiere actualValue = filiereDAO.GetFiliereByCode(code);
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be equals");
	}

	@Test
	public void shouldGetAllFiliere() {
		filiereDAO.UpdateFiliereByCode(new FiliereBuilder(2, "IRIC").build(), 2);
		List<Filiere> actualValue = filiereDAO.GetAllFiliere();
		List<Filiere> realval = new ArrayList();
		realval.add(new FiliereBuilder(2, "IRIC").build());
		realval.add(new FiliereBuilder(3, "GI").build());
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}
}
