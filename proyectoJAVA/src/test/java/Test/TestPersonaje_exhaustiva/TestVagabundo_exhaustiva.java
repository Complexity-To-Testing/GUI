package Test.TestPersonaje_exhaustiva;

import static org.junit.Assert.*;

import org.junit.Test;

import claseNodo.personaje.Vagabundo;

public class TestVagabundo_exhaustiva {

	/*
	 * vagabundo
	 */
	@Test
	public void test1() {
		for(int edad=-100;edad<100;edad++) {
			assertNotNull("should not be null", new Vagabundo("Juan", "alonso", edad, false, "12234"));		
			assertEquals(new Vagabundo("Juan", "alonso", edad, false, "12234").getNombre(), new Vagabundo("Juan", "alonso", edad, false, "12234").getNombre());
			assertEquals(new Vagabundo("Juan", "alonso", edad, false, "12234").getApellidos(), new Vagabundo("Juan", "alonso", edad, false, "12234").getApellidos());
			assertEquals(new Vagabundo("Juan", "alonso", edad, false, "12").getDni(), new Vagabundo("Juan", "alonso", edad, false, "12").getDni());
			assertEquals(new Vagabundo("Juan", "alonso", edad, false, "12234").getEdad(), new Vagabundo("Juan", "alonso", edad, false, "12234").getEdad());
			assertEquals(new Vagabundo("Juan", "alonso", edad, true, "12234").isCasado(), new Vagabundo("Juan", "alonso", edad, true, "12234").isCasado());
			assertEquals(""+new Vagabundo("Juan", "alonso", edad, true, "12234").getHouse(),""+new Vagabundo("Juan", "alonso", edad, true, "12234").getHouse());
			assertEquals(new Vagabundo("Juan", "alonso", edad, true, "12234").getNumHouse(),new Vagabundo("Juan", "alonso", edad, true, "12234").getNumHouse());
			assertEquals(""+new Vagabundo("Juan", "alonso", edad, true, "12234").getCoche(),""+new Vagabundo("Juan", "alonso", edad, true, "12234").getCoche());
			assertEquals(""+new Vagabundo("Juan", "alonso", edad, true, "12234").getNumCoche(),""+new Vagabundo("Juan", "alonso", edad, true, "12234").getNumCoche());
			assertEquals(""+new Vagabundo("Juan", "alonso", edad, true, "12234").toString(),""+new Vagabundo("Juan", "alonso", edad, true, "12234").toString());

		}

	}
}
