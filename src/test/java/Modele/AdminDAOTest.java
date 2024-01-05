package Modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;

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
		compte = new Compte("admin_admin", "21232f297a57a5a743894a0e4a801fc3");
		Admin actualValue = adminDAO.getAdmin(compte);
		Admin realval = Admin.getInstance(compte, "GNEME", "Gilles");
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be the same");
	}
}
