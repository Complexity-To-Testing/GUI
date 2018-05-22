package Test.TestClaseNodo_otras;

import static org.junit.Assert.*;

import org.junit.Test;

import claseNodo.Coche;
import claseNodo.House;
import claseNodo.Posicion;
import claseNodo.figura2D.Circulo;
import claseNodo.figura2D.Cuadrado;
import claseNodo.figura2D.Rectangulo;
import claseNodo.figura3D.Cilindro;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Esfera;
import claseNodo.figura3D.Figura3D;
import claseNodo.figura3D.Tetraedro;

public class TestHouse {

	@Test
	public void test() {
		Cubo cubo=new Cubo(new Cuadrado(22.2),12.8);
		Cilindro cilindro=new Cilindro(new Circulo(12),25);		
		Esfera esfera=new Esfera(12.8);
		Tetraedro tedraedro=new Tetraedro(new Rectangulo(12, 13), 4);
		
		Figura3D[] figura3D={esfera,tedraedro,cubo,cilindro};
		Posicion pos=new Posicion(123,234);
		
		House a=new House(figura3D, pos, "calle manuel luna");
		assertNotNull("should not be null", new House(figura3D, pos, "calle manuel luna"));
		assertEquals(a.getDir(),new House(figura3D, pos, "calle manuel luna").getDir());
		assertEquals(a.getFigura3D(),new House(figura3D, pos, "calle manuel luna").getFigura3D());
		assertEquals(a.getPos(),new House(figura3D, pos, "calle manuel luna").getPos());
		assertEquals(a.toString(),new House(figura3D, pos, "calle manuel luna").toString());

		assertEquals(a.setDir("calle velayos"),new House(figura3D, pos, "calle manuel luna").setDir("calle velayos"));
		assertEquals(a.setPos(new Posicion(333,444)),new House(figura3D, pos, "calle manuel luna").setPos(new Posicion(333,444)));
		assertEquals(a.addFigura3D(new Tetraedro(new Rectangulo(2, 13), 10)),new House(figura3D, pos, "calle manuel luna").addFigura3D(new  Tetraedro(new Rectangulo(2, 13), 10)));



	}

}
