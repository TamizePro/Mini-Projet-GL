package Modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CompteDAOTest {

	private CompteDAO compteDAO;

	@BeforeEach
	public void init() {
		this.compteDAO = new CompteDAO(MySQLConnection.getInstance());
	}

	@Test
	public void shouldAddCompte() {
		// TODO: initialize args
		Compte compte;
		compte = new Compte("gilles", "hello");
		boolean actualValue = compteDAO.AddCompte(compte);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	public void shouldDeleteCompte() {
		// TODO: initialize args
		Compte compte;
		compte = new Compte("gilles", "hello");
		boolean actualValue = compteDAO.DeleteCompte(compte);
		// TODO: assert scenario
		assertTrue(actualValue, "Deleting compte should return true on success");
	}

	@Test
	public void shouldUpdateCompteByLogin() {
		// TODO: initialize args
		Compte compte;
		String login;
		compte = new Compte("bourama", "hello");
		login = "bourama";
		compte.setLogin("Aalain");
		boolean actualValue = compteDAO.UpdateCompteByLogin(compte, login);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}

	@Test
	public void shouldGetCompte() {
		// TODO: initialize args
		String login;
		String password;
		login = "admin_admin";
		password = "21232f297a57a5a743894a0e4a801fc3";
		Compte realcompte = new Compte(login, password);
		Compte actualValue = compteDAO.GetCompte(login, password);
		// TODO: assert scenario
		assertEquals(realcompte, actualValue, "Objects should be equals");
	}

	@Test
	public void shouldGetAllCompte() {
		compteDAO.UpdateCompteByLogin(new Compte("bourama", "hello"), "Aalain");
		List<Compte> actualValue = compteDAO.GetAllCompte();
		List<Compte> realval = new ArrayList();
		realval.add(new Compte("gg", "ggpwd"));
		realval.add(new Compte("admin_admin", "21232f297a57a5a743894a0e4a801fc3"));
		realval.add(new Compte("bourama", "hello"));
		realval.add(new Compte("alain", "hello"));
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}
}
