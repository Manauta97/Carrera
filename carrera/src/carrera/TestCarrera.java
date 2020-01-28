package carrera;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCarrera {

	Coche c;

	@BeforeEach
	void configurar() {
		c = new Coche("Raul", 10, 150, false);
	}

	@Test
	void test1() {

		c.acelerarTest(50);
		assertEquals(c.getVelocidad(), 50);
	}

	@Test
	void test2() {

		c.acelerarTest(200);
		assertEquals(0, c.getVelocidad());
	}

	// Test de comprobar los estados, si pasa de 200 el estado pasa a ser
	// accidentado etc;

	@Test
	void test3() {

		c.acelerarTest(200);
		assertTrue(c.getEstado().equalsIgnoreCase("accidentado"));

	}

	@Test
	void test4() {

		c.setKmRecoridos(150);
		c.acelerarTest(1);
		assertEquals("terminado",c.getEstado());
		

	}

}
