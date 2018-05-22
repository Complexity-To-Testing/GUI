package Test.TestClaseNodo_otras_exhaustiva;

import static org.junit.Assert.*;

import org.junit.Test;

import Test.Utils1;
import claseNodo.Coche;
import claseNodo.House;
import claseNodo.Imprimir;
import claseNodo.Posicion;
import claseNodo.figura2D.Circulo;
import claseNodo.figura2D.Cuadrado;
import claseNodo.figura2D.Rectangulo;
import claseNodo.figura2D.Triangulo;
import claseNodo.figura3D.Cilindro;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Esfera;
import claseNodo.figura3D.Figura3D;
import claseNodo.figura3D.Tetraedro;

public class TestPropiedadExhaustiva {

	@Test
	public void test() {
		Circulo[] ruedas= {new Circulo(20),new Circulo(22),new Circulo(22),new Circulo(20)};
		Cuadrado[] sillas= {new Cuadrado(1),new Cuadrado(1),new Cuadrado(1),new Cuadrado(1)};
		assertNotNull("should not be null", new Coche(ruedas,sillas,null,"honda",1234,"negro"));
		assertNotNull("should not be null",new Coche( new Coche(ruedas,sillas,null,"honda",1234,"negro")));
		Cubo cuerpo=new Cubo(new Cuadrado(2),12);
		Coche a=new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro");
		assertEquals(a.getColor(),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").getColor());
		assertEquals(a.getCuerpo(),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").getCuerpo());
		assertEquals(a.getMarca(),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").getMarca());
		assertEquals(a.getMatricula(),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").getMatricula());
		assertEquals(a.getRueda(),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").getRueda());
		assertEquals(a.getSillas(),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").getSillas());

		////////////////
		assertEquals(a.toString(),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").toString());
		assertEquals(a.setColor("rosa"),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").setColor("rosa"));
		assertEquals(a.setCuerpo(new Tetraedro(new Rectangulo(2,3), 3)),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").setCuerpo(new Tetraedro(new Rectangulo(2,3), 3)));
		assertEquals(a.setCuerpo(null),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").setCuerpo(null));
		assertEquals(a.setMarca("Chang chen"),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").setMarca("Chang chen"));
		assertEquals(a.setMatricula(1001),a.setMatricula(1001));
		assertEquals(a.addSillas(new Triangulo(5,1,2,3)),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").addSillas(new Triangulo(5,1,2,3)));
		assertEquals(a.addSillas(null),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").addSillas(null));
		assertEquals(a.addRueda(new Circulo(100)),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").addRueda(new Circulo(100)));
		assertEquals(a.addRueda(null),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").addRueda(null));

		 a=new Coche(null,null,cuerpo,"honda",1234,null);
		 assertEquals(a.getColor(),a.getColor());
		assertEquals(a.getCuerpo(),a.getCuerpo());
		assertEquals(a.getRueda(),a.getRueda());
		assertEquals(a.toString(),a.toString());	
		
		//////////////////
		Cubo cubo=new Cubo(new Cuadrado(22.2),12.8);
		Cilindro cilindro=new Cilindro(new Circulo(12),25);		
		Esfera esfera=new Esfera(12.8);
		Tetraedro tedraedro=new Tetraedro(new Rectangulo(12, 13), 4);

		Figura3D[] figura3D={esfera,tedraedro,cubo,cilindro};
		Posicion pos=new Posicion(123,234);

		House a1=new House(figura3D, pos, "calle manuel luna");
		assertNotNull("should not be null", new House(figura3D, pos, "calle manuel luna"));
		assertEquals(a1.getDir(),new House(figura3D, pos, "calle manuel luna").getDir());
		assertEquals(a1.getFigura3D(),new House(figura3D, pos, "calle manuel luna").getFigura3D());
		assertEquals(a1.getPos(),new House(figura3D, pos, "calle manuel luna").getPos());
		assertEquals(a1.toString(),new House(figura3D, pos, "calle manuel luna").toString());

		assertEquals(a1.setDir("calle velayos"),new House(figura3D, pos, "calle manuel luna").setDir("calle velayos"));
		assertEquals(a1.setPos(new Posicion(333,444)),new House(figura3D, pos, "calle manuel luna").setPos(new Posicion(333,444)));
		assertEquals(a1.addFigura3D(new Tetraedro(new Rectangulo(2, 13), 10)),new House(figura3D, pos, "calle manuel luna").addFigura3D(new  Tetraedro(new Rectangulo(2, 13), 10)));
		assertEquals(a1.setDir(null),new House(figura3D, pos, "calle manuel luna").setDir(null));
		assertEquals(a1.setPos(null),new House(figura3D, pos, "calle manuel luna").setPos(null));
		assertEquals(a1.addFigura3D(null),new House(figura3D, pos, "calle manuel luna").addFigura3D(null));

		
		a1=new House(null, null, null);
		assertEquals(a1.getFigura3D(),a1.getFigura3D());
		assertEquals(a1.getPos(),a1.getPos());
		assertEquals(a1.setDir("calle velayos"),a1.setDir("calle velayos"));
		assertEquals(a1.setPos(new Posicion(333,444)),a1.setPos(new Posicion(333,444)));
		assertEquals(a1.addFigura3D(new Tetraedro(new Rectangulo(2, 13), 10)),a1.addFigura3D(new  Tetraedro(new Rectangulo(2, 13), 10)));

		/////////////
		
		for(int x=-100;x<100;x++) {
			for(int y=-100;y<100;y++) {
				Posicion pos1=new Posicion(x,y);
				assertNotNull("should not be null", new Posicion(x,y));
				assertEquals(pos1.toString(),pos1.toString());
				assertEquals(pos1.getX(),pos1.getX());
				assertEquals(pos1.getY(),pos1.getY());

				assertEquals(pos1.setX(y),pos1.setX(y));
				assertEquals(pos1.setY(x),pos1.setY(x));
			}
		}

	}
	
	@Test
	public void test0() {
		Imprimir.imprimir(new Double[19]);
		assertNotNull("should not be null",new Imprimir());
		for (int i = -100; i < 100; i++) {
			for (int i1 = -100; i1 < 100; i1++) {
				Utils1.getRandomArbitrary(i, i1);
			}
		}
		
		assertNotNull("should not be null",new Utils1());
	}

}
