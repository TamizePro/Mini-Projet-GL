package Modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

public class CompteDAOTest {

	private CompteDAO compteDAO;

	@BeforeEach
	public void setup() {
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
/*
	@Test
	public void shouldDeleteCompte() {
		// TODO: initialize args
		Compte compte;

		boolean actualValue = compteDAO.DeleteCompte(compte);

		// TODO: assert scenario
	}

	@Test
	public void shouldUpdateCompteByLogin() {
		// TODO: initialize args
		Compte compte;
		String login;

		boolean actualValue = compteDAO.UpdateCompteByLogin(compte, login);

		// TODO: assert scenario
	}

	@Test
	public void shouldGetCompte() {
		// TODO: initialize args
		String login;
		String password;

		Compte actualValue = compteDAO.GetCompte(login, password);

		// TODO: assert scenario
	}

	@Test
	public void shouldGetAllCompte() {
		List<Compte> actualValue = compteDAO.GetAllCompte();

		// TODO: assert scenario
	}*/
}
