package Modele.DAO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import Modele.Bean.*;
import Modele.MySQLConnection;

public class EtudiantDAOTest {
	private EtudiantDAO etudiantDAO;

	@BeforeEach
	public void init() {
		this.etudiantDAO = new EtudiantDAO(MySQLConnection.getInstance());
	}

	@Test
	public void shouldAddEtudiant() {
		// TODO: initialize args
		Etudiant etd;
		etd = new EtudiantBuilder(123, "ggne", "tami").build();
		boolean actualValue = etudiantDAO.AddEtudiant(etd);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	public void shouldDeleteEtudiant() {
		// TODO: initialize args
		Etudiant etd;
		etd = new EtudiantBuilder(123, "ggne", "tami").build();
		boolean actualValue = etudiantDAO.DeleteEtudiant(etd);
		// TODO: assert scenario
		assertTrue(actualValue, "Deleting compte should return true on success");
	}

	@Test
	public void shouldUpdateEtudiantByCode() {
		// TODO: initialize args
		Etudiant etd;
		Long code;
		code = 20L;
		etd = new EtudiantBuilder(code, "Tami", "Alain Jude").build();
		boolean actualValue = etudiantDAO.UpdateEtudiantByCode(etd, code);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}

	@Test
	public void shouldGetEtudiantByCode() {
		// TODO: initialize args
		Long code;
		code = 21L;
		Etudiant realval = new EtudiantBuilder(code, "Test", "test").build();
		Etudiant actualValue = etudiantDAO.GetEtudiantByCode(code);
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be equals");
	}

	@Test
	public void shouldGetAllEtudiant() {
		etudiantDAO.UpdateEtudiantByCode(new EtudiantBuilder(20L, "gg", "ggg").build(), 20L);
		List<Etudiant> actualValue = etudiantDAO.GetAllEtudiant();
		List<Etudiant> realval = new ArrayList();
		realval.add(new EtudiantBuilder(20L, "gg", "ggg").build());
		realval.add(new EtudiantBuilder(21L, "Test", "test").build());
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}
}
