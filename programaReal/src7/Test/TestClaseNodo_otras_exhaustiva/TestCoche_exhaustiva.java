package Test.TestClaseNodo_otras_exhaustiva;

import static org.junit.Assert.*;

import org.junit.Test;

import claseNodo.Coche;
import claseNodo.figura2D.Circulo;
import claseNodo.figura2D.Cuadrado;
import claseNodo.figura2D.Rectangulo;
import claseNodo.figura2D.Triangulo;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Tetraedro;

public class TestCoche_exhaustiva {

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

	}

}
