package Test.TestClaseNodo_otras_exhaustiva;

import static org.junit.Assert.*;

import org.junit.Test;

import claseNodo.House;
import claseNodo.Posicion;
import claseNodo.figura2D.Circulo;
import claseNodo.figura3D.Cilindro;

public class TestPosicion_exhaustiva {

	@Test
	public void test() {
		for(int x=-100;x<100;x++) {
			for(int y=-100;y<100;y++) {
				Posicion pos=new Posicion(x,y);
				assertNotNull("should not be null", new Posicion(x,y));
				assertEquals(pos.toString(),pos.toString());
				assertEquals(pos.getX(),pos.getX());
				assertEquals(pos.getY(),pos.getY());

				assertEquals(pos.setX(y),pos.setX(y));
				assertEquals(pos.setY(x),pos.setY(x));
			}
		}


	}

}
