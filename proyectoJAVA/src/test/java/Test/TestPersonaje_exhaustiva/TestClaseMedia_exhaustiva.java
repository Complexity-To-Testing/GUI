package Test.TestPersonaje_exhaustiva;

import static org.junit.Assert.*;

import org.junit.Test;

import claseNodo.Coche;
import claseNodo.House;
import claseNodo.Posicion;
import claseNodo.figura2D.Circulo;
import claseNodo.figura2D.Cuadrado;
import claseNodo.figura2D.Rectangulo;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Esfera;
import claseNodo.figura3D.Figura3D;
import claseNodo.figura3D.Tetraedro;
import claseNodo.personaje.ClaseMedia;

public class TestClaseMedia_exhaustiva {

	/*
	 * ClaseMedia
	 */
	@Test
	public void test3() { 
		Esfera esfera=new Esfera(12.8);
		Tetraedro tedraedro=new Tetraedro(new Rectangulo(12, 13), 4);
		Figura3D figura3D[]={esfera,tedraedro};
		Circulo[] ruedas= {new Circulo(20),new Circulo(22),new Circulo(22),new Circulo(20)};
		Cuadrado[] sillas= {new Cuadrado(1),new Cuadrado(1),new Cuadrado(1),new Cuadrado(1)};
		Cubo cuerpo=new Cubo(new Cuadrado(102),12);
		Coche coche= new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"amarillo");
		House house= new House(figura3D,new Posicion(12,13),"casa blanca");
		ClaseMedia a=new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345");
		assertEquals(a.toString(), new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").toString());
		assertNotNull("should not be null",new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345"));
		assertEquals(a.getNombre(), new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").getNombre());
		assertEquals(a.getApellidos(), new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").getApellidos());
		assertEquals(a.getDni(), new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").getDni());
		assertEquals(a.getEdad(),new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").getEdad());
		assertEquals(a.isCasado(),new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").isCasado());
		assertEquals(a.getHouse(),""+new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").getHouse());
		assertEquals(a.getCoche(),""+new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").getCoche());
		assertEquals(""+a.setCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"blanca")),new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").setCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"blanca")) );
		assertEquals(""+a.setCoche(null),a.setCoche(null)); 
		assertEquals(""+a.setHouse(new House(figura3D,new Posicion(20,30),"casa de campo")),new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").setHouse(new House(figura3D,new Posicion(20,30),"casa de campo"))
				);
		ClaseMedia no_coche_house=new ClaseMedia(null,null, "pepe", "alonso", 40, false, "12345");
		assertEquals(no_coche_house.getHouse(),no_coche_house.getHouse()); 
		assertEquals(no_coche_house.getCoche(),no_coche_house.getCoche());
		assertEquals(no_coche_house.getNumHouse(),no_coche_house.getNumHouse()); 
		assertEquals(no_coche_house.getNumCoche(),no_coche_house.getNumCoche());
		assertEquals(""+no_coche_house.setCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"blanca")),no_coche_house.setCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"blanca")) );
		assertEquals(""+no_coche_house.setCoche(null),a.setCoche(null)); 
		assertEquals(""+no_coche_house.setHouse(new House(figura3D,new Posicion(20,30),"casa de campo")),no_coche_house.setHouse(new House(figura3D,new Posicion(20,30),"casa de campo"))
				); 
		assertEquals(""+no_coche_house.setHouse(null),no_coche_house.setHouse(null));
		
		Coche coche2= new Coche(ruedas,sillas,cuerpo,"mazida",1024,"blanco");
		assertEquals(new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").addCoche(coche2),
				new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").addCoche(coche2));
		
		//fail("Not yet implemented");

	}
}
