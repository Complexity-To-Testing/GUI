package Test.ClaseImprimir;

import static org.junit.Assert.*;

import org.junit.Test;

import Test.Utils1;
import claseNodo.Imprimir;
import claseNodo.personaje.ClaseAlta;

public class testImprimir {

	@Test
	public void test() {
		Imprimir.imprimir(new Double[19]);
		assertNotNull("should not be null",new Imprimir());
		Utils1.getRandomArbitrary(0, 100);
		assertNotNull("should not be null",new Utils1());
	}

}
