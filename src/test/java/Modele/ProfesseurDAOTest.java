package Modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProfesseurDAOTest {
	private ProfesseurDAO professeurDAO;

	@BeforeEach
	public void init() {
		this.professeurDAO = new ProfesseurDAO(MySQLConnection.getInstance());
	}

	@Test
	public void shouldAddProfesseur() {
		// TODO: initialize args
		Professeur professeur;
		professeur = new ProfesseurBuilder("Nom",
			"Prenom", "Maths", 12L).compte(new Compte("bourama", "hello")).build();
		boolean actualValue = professeurDAO.AddProfesseur(professeur);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	public void shouldDeleteProfesseur() {
		// TODO: initialize args
		Professeur professeur;
		professeur = new ProfesseurBuilder("Nom",
			"Prenom", "Maths", 12L).compte(new Compte("bourama", "hello")).build();
		boolean actualValue = professeurDAO.DeleteProfesseur(professeur);
		// TODO: assert scenario
		assertTrue(actualValue, "Deleting compte should return true on success");
	}

	@Test
	public void shouldUpdateProfesseurByCode() {
		// TODO: initialize args
		Professeur professeur;
		Long code;
		code = 13L;
		professeur = new ProfesseurBuilder("Hello",
			"World", "Maths", code).compte(new Compte("gg", "ggpwd")).build();
		boolean actualValue = professeurDAO.UpdateProfesseurByCode(professeur, code);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}

	@Test
	public void shouldGetProfesseurByCode() {
		// TODO: initialize args
		Long code;
		Compte compte;
		code = 14L;
		compte = new Compte("admin_admin", "21232f297a57a5a743894a0e4a801fc3");
		Professeur realval = new ProfesseurBuilder("Nomd", "Prenoms", "Maths", code).compte(compte).build();
		Professeur actualValue = professeurDAO.GetProfesseurByCode(code, compte);
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be equals");
	}

	/*@Test
	public void shouldGetAllProfesseur() {
		professeurDAO.UpdateProfesseurByCode(new ProfesseurBuilder("Nom", "Prenom", "Maths", 13L)
		.compte(new Compte("bourama", "hello"))
		.build(), 13L);
		List<Professeur> actualValue = professeurDAO.GetAllProfesseur();
		List<Professeur> realval = new ArrayList();
		realval.add(new ProfesseurBuilder("Nom", "Prenom", "Maths", 13L).build());
		realval.add(new ProfesseurBuilder("Nomd", "Prenoms", "Maths", 14L).build());
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}*/
}
