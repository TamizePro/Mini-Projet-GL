package Modele.DAO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import Modele.Bean.*;
import Modele.MySQLConnection;

public class AdminDAOTest {
	private AdminDAO adminDAO;

	@BeforeEach
	public void init() {
		this.adminDAO = new AdminDAO(MySQLConnection.getInstance());
	}

	@Test
	public void shouldGetAdmin() {
		// TODO: initialize args
		Compte compte;
		compte = new Compte("admin_admin", "3dd408f20375d691865c823a2cb5b15c");
		Admin actualValue = adminDAO.getAdmin(compte);
		Admin realval = Admin.getInstance(compte, "GNEME", "Gilles");
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be the same");
	}
}
