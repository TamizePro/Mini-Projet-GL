package Modele.DAO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import Modele.Bean.*;
import Modele.MySQLConnection;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ElementModuleDAOTest {
	private ElementModuleDAO elementModuleDAO;

	@BeforeEach
	public void init() {
		this.elementModuleDAO = new ElementModuleDAO(MySQLConnection.getInstance());
	}

	@Test
	@Order(1)
	public void shouldAddElementModule() {
		// TODO: initialize args
		ElementModule elmod;
		//int code_modal;
		elmod = new ElementModuleBuilder("math", 0.9f).build();
		boolean actualValue = elementModuleDAO.AddElementModule(elmod, null);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	@Order(2)
	public void shouldGetAllElementModule() {
		List<ElementModule> actualValue = elementModuleDAO.GetAllElementModule();
		List<ElementModule> realval = new ArrayList();
		realval.add(new ElementModuleBuilder("math", 0.9f).code(1).validation(false).build());
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}

	@Test
	@Order(3)
	public void shouldGetElementModuleByCode() {
		// TODO: initialize args
		int code;
		code = 1;
		ElementModule actualValue = elementModuleDAO.GetElementModuleByCode(code);
		ElementModule realval = new ElementModuleBuilder("math", 0.9f).code(code).validation(false).build();
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be equals");
	}

	@Test
	@Order(4)
	public void shouldUpdateElementModuleByCode() {
		// TODO: initialize args
		ElementModule elmod;
		//int code_modal;
		elmod = new ElementModuleBuilder("GL", 0.5f).code(1).validation(true).build();
		boolean actualValue = elementModuleDAO.UpdateElementModuleByCode(elmod, null);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}

	@Test
	@Order(5)
	public void shouldDeleteElementModule() {
		// TODO: initialize args
		ElementModule elmod;
		elmod = new ElementModuleBuilder("GL", 0.5f).code(1).build();
		boolean actualValue = elementModuleDAO.DeleteElementModule(elmod);
		// TODO: assert scenario
		assertTrue(actualValue, "Deleting compte should return true on success");
	}
}
