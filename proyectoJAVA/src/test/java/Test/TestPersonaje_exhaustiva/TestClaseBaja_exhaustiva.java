package Test.TestPersonaje_exhaustiva;

import static org.junit.Assert.*;

import org.junit.Test;

import claseNodo.Coche;
import claseNodo.House;
import claseNodo.Posicion;
import claseNodo.figura2D.Circulo;
import claseNodo.figura2D.Cuadrado;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Figura3D;
import claseNodo.personaje.ClaseAlta;
import claseNodo.personaje.ClaseBaja;

public class TestClaseBaja_exhaustiva {

	/*
	 * ClaseBaja
	 */
	@Test
	public void test2() {
		Cubo cubo=new Cubo(new Cuadrado(22.2),12.8);
		Figura3D figura3D[]={cubo};
		Circulo[] ruedas= {new Circulo(20),new Circulo(22),new Circulo(22),new Circulo(20)};
		Cuadrado[] sillas= {new Cuadrado(1),new Cuadrado(1),new Cuadrado(1),new Cuadrado(1)};
		Cubo cuerpo=new Cubo(new Cuadrado(102),12);
		House house= new House(figura3D,new Posicion(2,3),"fdi");
		ClaseBaja a=new ClaseBaja(new House(figura3D,new Posicion(2,3),"fdi"),"pepe", "alonso", 0, false, "12345");
		assertNotNull("should not be null", new ClaseBaja(new House(figura3D,new Posicion(2,3),"fdi"),"pepe", "alonso", 0, false, "12345"));
		assertEquals(a.toString(), a.toString());
		assertEquals(a.getNombre(),a.getNombre());
		assertEquals(a.getApellidos(), a.getApellidos());
		assertEquals(a.getDni(), a.getDni());
		assertEquals(a.getEdad(),a.getEdad());
		assertEquals(a.isCasado(), a.isCasado());
		assertEquals(a.getHouse(),a.getHouse());
		assertEquals(a.getNumHouse(),a.getNumHouse());
		assertEquals(a.setCoche(new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"azul")),a.setCoche(new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"azul")));
		assertEquals(a.setCoche(null),a.setCoche(null));
		assertEquals(a.getCoche(),a.getCoche());
		assertEquals(a.setHouse(house),a.setHouse(house)); 
		assertEquals(a.setHouse(null),a.setHouse(null));
		assertEquals(new ClaseBaja(new House(figura3D,new Posicion(2,3),"fdi"),"pepe", "alonso", 0, false, "12345").addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")), 
					 new ClaseBaja(new House(figura3D,new Posicion(2,3),"fdi"),"pepe", "alonso", 0, false, "12345").addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")));

		a.setCoche(new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"azul"));
		assertEquals(a.getNumCoche(),a.getNumCoche());
		//fail("Not yet implemented");
	}

}
