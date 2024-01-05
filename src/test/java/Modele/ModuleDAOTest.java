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
public class ModuleDAOTest {
	private ModuleDAO moduleDAO;

	@BeforeEach
	public void init() {
		this.moduleDAO = new ModuleDAO(MySQLConnection.getInstance());
	}

	@Test
	@Order(1)
	public void shouldAddModule() {
		// TODO: initialize args
		Module mod;
		//Integer code_elmodul;
		mod = new ModuleBuilder("ML", "s2").build();
		boolean actualValue = moduleDAO.AddModule(mod, null);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	@Order(2)
	public void shouldGetAllModule() {
		List<Module> actualValue = moduleDAO.GetAllModule();
		List<Module> realval = new ArrayList();
		realval.add(new ModuleBuilder("ML", "s2").code(1).Vald(false).build());
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}

	@Test
	@Order(3)
	public void shouldGetModuleByCode() {
		// TODO: initialize args
		int code;
		code = 1;
		Module actualValue = moduleDAO.GetModuleByCode(code);
		Module realval = new ModuleBuilder("ML", "s2").code(1).Vald(false).build();
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be equals");
	}

	@Test
	@Order(4)
	public void shouldUpdateModuleByCode() {
		// TODO: initialize args
		Module mod;
		mod = new ModuleBuilder("ML", "s5").Vald(false).code(1).build();
		boolean actualValue = moduleDAO.UpdateModuleByCode(mod, null);
		// TODO: assert scenario
		assertTrue(actualValue, "Updating compte should return true on success");
	}

	@Test
	@Order(5)
	public void shouldDeleteModule() {
		// TODO: initialize args
		Module mod;
		mod = new ModuleBuilder("ML", "s5").Vald(false).code(1).build();
		boolean actualValue = moduleDAO.DeleteModule(mod);
		// TODO: assert scenario
		assertTrue(actualValue, "Deleting compte should return true on success");
	}
}
