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
public class ModaliteEvaluationDAOTest {
	private ModaliteEvaluationDAO modaliteEvaluationDAO;

	@BeforeEach
	public void init() {
		this.modaliteEvaluationDAO = new ModaliteEvaluationDAO(MySQLConnection.getInstance());
	}

	@Test
	@Order(1)
	public void shouldAddModaliteEvaluation() {
		// TODO: initialize args
		ModaliteEvaluation modal;
		int code_note;
		code_note = 1;
		modal = new ModaliteEvaluationBuilder("maths", 0.3f).build();
		boolean actualValue = modaliteEvaluationDAO.AddModaliteEvaluation(modal, code_note);
		// TODO: assert scenario
		assertTrue(actualValue, "Adding compte should return true on success");
	}

	@Test
	@Order(2)
	public void shouldGetAllModaliteEvaluation() {
		List<ModaliteEvaluation> actualValue = modaliteEvaluationDAO.GetAllModaliteEvaluation();
		List<ModaliteEvaluation> realval = new ArrayList();
		realval.add(new ModaliteEvaluationBuilder("maths", 0.3f).code(1).build());
		// TODO: assert scenario
		assertTrue(realval.size() == actualValue.size() && realval.containsAll(actualValue)
			&& actualValue.containsAll(realval), "List should be the same");
	}

	@Test
	@Order(3)
	public void shouldGetModaliteEvaluationByCode() {
		// TODO: initialize args
		int code;
		code = 1;
		ModaliteEvaluation actualValue = modaliteEvaluationDAO.GetModaliteEvaluationByCode(code);
		ModaliteEvaluation realval = new ModaliteEvaluationBuilder("maths", 0.3f).code(code).build();
		// TODO: assert scenario
		assertEquals(realval, actualValue, "Objects should be equals");
	}

	@Test
	@Order(4)
	public void shouldUpdateModaliteEvaluationByCode() {
		// TODO: initialize args
		ModaliteEvaluation modal;
		int code_note;
		code_note = 1;
		modal = new ModaliteEvaluationBuilder("maths", 0.9f).code(1).build();
		boolean actualValue = modaliteEvaluationDAO.UpdateModaliteEvaluationByCode(modal, code_note);
		// TODO: assert scenario
		assertTrue(actualValue, "Updation Modal should return true on success");
	}

	@Test
	@Order(5)
	public void shouldDeleteModaliteEvaluation() {
		// TODO: initialize args
		ModaliteEvaluation modal;
		modal = new ModaliteEvaluationBuilder("maths", 0.9f).code(1).build();
		boolean actualValue = modaliteEvaluationDAO.DeleteModaliteEvaluation(modal);
		// TODO: assert scenario
		assertTrue(actualValue, "Deleting modal should return true on success");
	}
}
