package Test.TestClaseNodo_otras;

import static org.junit.Assert.*;

import org.junit.Test;

import claseNodo.House;
import claseNodo.Posicion;
import claseNodo.figura2D.Circulo;
import claseNodo.figura3D.Cilindro;

public class TestPosicion {

	@Test
	public void test() {
		Posicion pos=new Posicion(123,234);
		assertNotNull("should not be null", new Posicion(123,234));
		assertEquals(pos.toString(),new Posicion(123,234).toString());
		assertEquals(pos.getX(),new Posicion(123,234).getX());
		assertEquals(pos.getY(),new Posicion(123,234).getY());
		
		assertEquals(pos.setX(102),new Posicion(123,234).setX(102));
		assertEquals(pos.setY(102),new Posicion(123,234).setY(102));

	}

}
