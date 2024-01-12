package Services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.sql.*;
import Modele.MySQLConnection;

import Modele.Bean.Compte;
import Modele.DAO.CompteDAO;
import Services.AuthService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthServiceTest {
	private AuthService authService;

	@BeforeEach
	public void init() {
		this.authService = new AuthService(MySQLConnection.getInstance());
	}

	@Test
	public void shouldHashPassword() {
		// TODO: initialize args
		String password;
		password = "ILoveJava";
		String hass = "35454B055CC325EA1AF2126E27707052";
		String actualValue = authService.hashPassword(password).toUpperCase();
		// TODO: assert scenario
		assertTrue(actualValue.equals(hass));
	}

	@Test
	public void shouldAuthenticate() {
		// TODO: initialize args
		Compte actualValue = authService.authenticate("admin_admin", "21232f297a57a5a743894a0e4a801fc3");
		Compte realval = new Compte("admin_admin", "21232f297a57a5a743894a0e4a801fc3");
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be the same");
	}
}
