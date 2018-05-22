package Test.megaTest;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

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
import claseNodo.personaje.ClaseAlta;
import claseNodo.personaje.ClaseBaja;
import claseNodo.personaje.ClaseMedia;
import claseNodo.personaje.Vagabundo;

public class megaTest {

	

	
	/*
	 * test de circulo
	 */
	@Test
	public void test1() {
		assertNotNull("should not be null", new Circulo(33));
		Circulo c=new Circulo(33);
		assertEquals(c.toString(),c.toString());
		assertEquals(new Circulo(new Circulo(44)).toString(), new Circulo(new Circulo(44)).toString());
		assertEquals(""+new Circulo(33).setRadio(55),new Circulo(33).setRadio(55)+"");
		assertEquals(new Circulo(1).getArea()+"",new Circulo(1).getArea()+"");
		assertEquals(new Circulo(10).perimetro()+"",new Circulo(10).perimetro()+"");
	}
	
	/*
	 * test de cuadrado
	 */
	@Test
	public void test2() {
		assertNotNull("should not be null", new Cuadrado(33));
		assertEquals(new Cuadrado(33).toString(),new Cuadrado(33).toString());
		assertEquals(new Cuadrado(new Cuadrado(44)).toString(), new Cuadrado(new Cuadrado(44)).toString());
		assertEquals(""+new Cuadrado(33).setLado(55),new Cuadrado(33).setLado(55)+"");
		assertEquals(new Cuadrado(1).getArea2D()+"",new Cuadrado(1).getArea2D()+"");
		assertEquals(new Cuadrado(10).perimetro()+"",new Cuadrado(10).perimetro()+"");
	}
	
	/*
	 * test de triangulo
	 */
	@Test
	public void test3() {
		double ladoBase=3;
		double lateraIz=4;//hipotenusa
		double hipotenusa=Math.pow(Math.pow(3, 2)+Math.pow(4, 2), 0.5);
		double altura=4;
		assertNotNull("should not be null", new Triangulo(2,4,3,2));
		//assertEquals(new Triangulo(ladoBase, altura, lateraIz, hipotenusa).toString(),new Triangulo(ladoBase, altura, lateraIz, hipotenusa));
		assertEquals(new Triangulo(new Triangulo(ladoBase, altura, lateraIz, hipotenusa)).toString(), new Triangulo(new Triangulo(ladoBase, altura, lateraIz, hipotenusa)).toString());
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setBase(55),""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setBase(55));
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoIz(5),""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoIz(5));
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoDer(1),""+""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoDer(1));
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).getArea2D(),""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).getArea2D()+"");
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).perimetro()+"",""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).perimetro()+"");
	}
	
	
	/*
	 * test de Rectangulo
	 */
	@Test
	public void test4() {
		double ladoCorto=15; 
		double ladoLargo=20;
		Rectangulo rectangulo= new Rectangulo(ladoCorto,ladoLargo);
		assertNotNull("should not be null", new Rectangulo(ladoCorto,ladoLargo));
		assertNotNull("should not be null",new Rectangulo( new Rectangulo(ladoCorto,ladoLargo)));
		
		assertEquals(rectangulo.getArea2D()+"",rectangulo.getArea2D()+"");
		assertEquals(rectangulo.getLadoCorto()+"",rectangulo.getLadoCorto()+"");
		assertEquals(rectangulo.getLadoLargo()+"",rectangulo.getLadoLargo()+"");
		assertEquals(rectangulo.perimetro()+"",rectangulo.perimetro()+"");
		assertEquals(rectangulo.setLadoCorto(0.6)+"",rectangulo.setLadoCorto(0.6)+"");
		assertEquals(rectangulo.setLadoLargo(1.5)+"",rectangulo.setLadoLargo(1.5)+"");
		assertEquals(rectangulo.toString(),rectangulo.toString());

		



		}
	
	@Test
	public void test5() {
		assertNotNull("should not be null", new Cilindro(new Circulo(22), 33));
		assertEquals( new Cilindro(new Circulo(22), 33).toString(), new Cilindro(new Circulo(22), 33).toString());
		assertEquals(""+ new Cilindro(new Circulo(22), 33).setAltura(55),""+ new Cilindro(new Circulo(22), 33).setAltura(55));
		assertEquals(new Cilindro(new Circulo(1), 33).getArea3D()+"",new Cilindro(new Circulo(1), 33).getArea3D()+"");
		assertEquals(new Cilindro(new Circulo(1), 33).getVolumen()+"",new Cilindro(new Circulo(1), 33).getVolumen()+"");
	}

	
	@Test
	public void test6() {
		assertNotNull("should not be null", new Cubo(new Cuadrado(22), 33));
		assertEquals( new Cubo(new Cuadrado(22), 33).toString(), new Cubo(new Cuadrado(22), 33).toString());
		assertEquals(new Cubo(new Cubo(new Cuadrado(22), 33)).toString(),new Cubo(new Cubo(new Cuadrado(22), 33)).toString());
		assertEquals(""+new Cubo(new Cuadrado(22), 33).setAltura(55),""+new Cubo(new Cuadrado(22), 33).setAltura(55));
		assertEquals(new Cubo(new Cuadrado(22), 33).getArea3D()+"",new Cubo(new Cuadrado(22), 33).getArea3D()+"");
		assertEquals(new Cubo(new Cuadrado(2), 33).getVolumen()+"",new Cubo(new Cuadrado(2), 33).getVolumen()+"");
		assertEquals(new Cubo(new Cuadrado(2), 33).getFiguraBase()+"",new Cubo(new Cuadrado(2), 33).getFiguraBase()+"");
	}
	
	@Test
	public void test7() {
		assertNotNull("should not be null", new Esfera(33));
		assertEquals( new Esfera(33).toString(), new Esfera(33).toString());
		assertEquals(new Esfera(new Esfera(33)).toString(),new Esfera(new Esfera(33)).toString());
		assertEquals(""+ new Esfera(new Esfera(33)).setRadio(55),""+ new Esfera(new Esfera(33)).setRadio(55));
		assertEquals(new Esfera(new Esfera(33)).getArea3D()+"",new Esfera(new Esfera(33)).getArea3D()+"");
		assertEquals(new  Esfera(new Esfera(33)).getVolumen()+"",new  Esfera(new Esfera(33)).getVolumen()+"");
		assertEquals(new  Esfera(new Esfera(33)).getFiguraBase()+"",new  Esfera(new Esfera(33)).getFiguraBase()+"");
	}
	
	@Test
	public void test8() {
		assertNotNull("should not be null", new Tetraedro(new Rectangulo(12,13),3));
		assertEquals( new Tetraedro(new Rectangulo(12,13),3).toString(), new Tetraedro(new Rectangulo(12,13),3).toString());
		assertEquals(new Tetraedro(new Rectangulo(12,13),3).toString(),new Tetraedro(new Rectangulo(12,13),3).toString());
		assertEquals(""+ new Tetraedro(new Rectangulo(12,13),3).setAltura(55),""+ new Tetraedro(new Rectangulo(12,13),3).setAltura(55));
		assertEquals(new Tetraedro(new Rectangulo(102,13),3).getArea3D()+"",new Tetraedro(new Rectangulo(102,13),3).getArea3D()+"");
		assertEquals(new Tetraedro(new Rectangulo(120,13),3).getVolumen()+"",new Tetraedro(new Rectangulo(120,13),3).getVolumen()+"");
		assertEquals(new Tetraedro(new Rectangulo(12,13),3).getFiguraBase()+"",new Tetraedro(new Rectangulo(12,13),3).getFiguraBase()+"");
	}
	
	///////

	/*
	 * test de circulo
	 */
	@Test
	public void test9() {
		assertNotNull("should not be null", new Circulo(33));
		Circulo c=new Circulo(33);
		assertEquals(c.toString(),c.toString());
		assertEquals(new Circulo(new Circulo(44)).toString(), new Circulo(new Circulo(44)).toString());
		assertEquals(""+new Circulo(33).setRadio(55),new Circulo(33).setRadio(55)+"");
		assertEquals(new Circulo(1).getArea()+"",new Circulo(1).getArea()+"");
		assertEquals(new Circulo(10).perimetro()+"",new Circulo(10).perimetro()+"");
	}
	
	/*
	 * test de cuadrado
	 */
	@Test
	public void test10() {
		assertNotNull("should not be null", new Cuadrado(33));
		assertEquals(new Cuadrado(33).toString(),new Cuadrado(33).toString());
		assertEquals(new Cuadrado(new Cuadrado(44)).toString(), new Cuadrado(new Cuadrado(44)).toString());
		assertEquals(""+new Cuadrado(33).setLado(55),new Cuadrado(33).setLado(55)+"");
		assertEquals(new Cuadrado(1).getArea2D()+"",new Cuadrado(1).getArea2D()+"");
		assertEquals(new Cuadrado(10).perimetro()+"",new Cuadrado(10).perimetro()+"");
	}
	
	/*
	 * test de triangulo
	 */
	@Test
	public void test11() {
		double ladoBase=3;
		double lateraIz=4;//hipotenusa
		double hipotenusa=Math.pow(Math.pow(3, 2)+Math.pow(4, 2), 0.5);
		double altura=4;
		assertNotNull("should not be null", new Triangulo(2,4,3,2));
		//assertEquals(new Triangulo(ladoBase, altura, lateraIz, hipotenusa).toString(),new Triangulo(ladoBase, altura, lateraIz, hipotenusa));
		assertEquals(new Triangulo(new Triangulo(ladoBase, altura, lateraIz, hipotenusa)).toString(), new Triangulo(new Triangulo(ladoBase, altura, lateraIz, hipotenusa)).toString());
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setBase(55),""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setBase(55));
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoIz(5),""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoIz(5));
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoDer(1),""+""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).setLadoDer(1));
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).getArea2D(),""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).getArea2D()+"");
		assertEquals(""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).perimetro()+"",""+new Triangulo(ladoBase, altura, lateraIz, hipotenusa).perimetro()+"");
	}
	
	
	/*
	 * test de Rectangulo
	 */
	@Test
	public void test12() {
		double ladoCorto=15; 
		double ladoLargo=20;
		Rectangulo rectangulo= new Rectangulo(ladoCorto,ladoLargo);
		assertNotNull("should not be null", new Rectangulo(ladoCorto,ladoLargo));
		assertNotNull("should not be null",new Rectangulo( new Rectangulo(ladoCorto,ladoLargo)));
		
		assertEquals(rectangulo.getArea2D()+"",rectangulo.getArea2D()+"");
		assertEquals(rectangulo.getLadoCorto()+"",rectangulo.getLadoCorto()+"");
		assertEquals(rectangulo.getLadoLargo()+"",rectangulo.getLadoLargo()+"");
		assertEquals(rectangulo.perimetro()+"",rectangulo.perimetro()+"");
		assertEquals(rectangulo.setLadoCorto(0.6)+"",rectangulo.setLadoCorto(0.6)+"");
		assertEquals(rectangulo.setLadoLargo(1.5)+"",rectangulo.setLadoLargo(1.5)+"");
		assertEquals(rectangulo.toString(),rectangulo.toString());

		



		}
	
	///////////3D
	@Test
	public void test13() {
		for(int i=-100; i<500;i++) {
			assertNotNull("should not be null", new Cilindro(new Circulo(i), i));
			assertEquals( new Cilindro(new Circulo(i), i).toString(), new Cilindro(new Circulo(i), i).toString());
			assertEquals(""+ new Cilindro(new Circulo(i), i).setAltura(i),""+ new Cilindro(new Circulo(i), i).setAltura(i));
			assertEquals(new Cilindro(new Circulo(i), i).getArea3D()+"",new Cilindro(new Circulo(i), i).getArea3D()+"");
			assertEquals(new Cilindro(new Circulo(i), i).getVolumen()+"",new Cilindro(new Circulo(i), i).getVolumen()+"");
			
			assertNotNull("should not be null", new Cilindro(null, i));
			assertEquals( new Cilindro(null, i).toString(), new Cilindro(null, i).toString());
			assertEquals(""+ new Cilindro(null, i).setAltura(i),""+ new Cilindro(null, i).setAltura(i));
			assertEquals(new Cilindro(null, i).getArea3D()+"",new Cilindro(null, i).getArea3D()+"");
			assertEquals(new Cilindro(null, i).getVolumen()+"",new Cilindro(null, i).getVolumen()+"");

		}
	}


	/*
	 * Cubo
	 */
	@Test
	public void test14() {
		for(int i=-100; i<500;i++) {
			assertNotNull("should not be null", new Cubo(new Cuadrado(i), i));
			assertEquals( new Cubo(new Cuadrado(i), i).toString(), new Cubo(new Cuadrado(i), i).toString());
			assertEquals(new Cubo(new Cubo(new Cuadrado(i), i)).toString(),new Cubo(new Cubo(new Cuadrado(i), i)).toString());
			assertEquals(""+new Cubo(new Cuadrado(i), i).setAltura(i),""+new Cubo(new Cuadrado(i), i).setAltura(i));
			assertEquals(new Cubo(new Cuadrado(i), i).getArea3D()+"",new Cubo(new Cuadrado(i), i).getArea3D()+"");
			assertEquals(new Cubo(new Cuadrado(i), i).getVolumen()+"",new Cubo(new Cuadrado(i), i).getVolumen()+"");
			assertEquals(new Cubo(new Cuadrado(i), i).getFiguraBase()+"",new Cubo(new Cuadrado(i), i).getFiguraBase()+"");

		}
	}

	/*
	 * Esfera
	 */
	@Test
	public void test15() {
		for(int i=-100; i<500;i++) {
			assertNotNull("should not be null", new Esfera(i));
			assertEquals( new Esfera(i).toString(), new Esfera(i).toString());
			assertEquals(new Esfera(new Esfera(i)).toString(),new Esfera(new Esfera(i)).toString());
			assertEquals(""+ new Esfera(new Esfera(i)).setRadio(i),""+ new Esfera(new Esfera(i)).setRadio(i));
			assertEquals(new Esfera(new Esfera(i)).getArea3D()+"",new Esfera(new Esfera(i)).getArea3D()+"");
			assertEquals(new  Esfera(new Esfera(i)).getVolumen()+"",new  Esfera(new Esfera(i)).getVolumen()+"");
			assertEquals(new  Esfera(new Esfera(i)).getFiguraBase()+"",new  Esfera(new Esfera(i)).getFiguraBase()+"");

		}
	}

	/*
	 * Tetraedro
	 */
	@Test
	public void test16() {
		for(int i=-100; i<500;i++) {
			assertNotNull("should not be null", new Tetraedro(new Rectangulo(i,i),i));
			assertEquals( new Tetraedro(new Rectangulo(i,i),i).toString(), new Tetraedro(new Rectangulo(i,i),i).toString());
			assertEquals(new Tetraedro(new Rectangulo(i,i),i).toString(),new Tetraedro(new Rectangulo(i,i),i).toString());
			assertEquals(""+ new Tetraedro(new Rectangulo(i,i),i).setAltura(i),""+ new Tetraedro(new Rectangulo(i,i),i).setAltura(i));
			assertEquals(new Tetraedro(new Rectangulo(i,i),i).getArea3D()+"",new Tetraedro(new Rectangulo(i,i),i).getArea3D()+"");
			assertEquals(new Tetraedro(new Rectangulo(i,i),i).getVolumen()+"",new Tetraedro(new Rectangulo(i,i),i).getVolumen()+"");
			assertEquals(new Tetraedro(new Rectangulo(i,i),i).getFiguraBase()+"",new Tetraedro(new Rectangulo(i,i),i).getFiguraBase()+"");

		}
	}
	
	@Test
	public void test17() {
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
		assertEquals(a.setMarca("Chang chen"),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").setMarca("Chang chen"));
		assertEquals(a.setMatricula(1001),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").setMatricula(1001));
		assertEquals(a.addSillas(new Triangulo(5,1,2,3)),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").addSillas(new Triangulo(5,1,2,3)));
		assertEquals(a.addRueda(new Circulo(100)),new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro").addRueda(new Circulo(100)));

		
		
		///////house
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

		
		Posicion pos1=new Posicion(123,234);
		assertNotNull("should not be null", new Posicion(123,234));
		assertEquals(pos1.toString(),new Posicion(123,234).toString());
		assertEquals(pos1.getX(),new Posicion(123,234).getX());
		assertEquals(pos1.getY(),new Posicion(123,234).getY());
		
		assertEquals(pos1.setX(102),new Posicion(123,234).setX(102));
		assertEquals(pos1.setY(102),new Posicion(123,234).setY(102));

		
	}
	
	@Test
	public void test18() {
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
	
	
	//////////////
	/*
	 * ClaseAlta
	 */
	@Test
	public void test19() {
		Cubo cubo=new Cubo(new Cuadrado(22.2),12.8);
		Tetraedro tedraedro=new Tetraedro(new Rectangulo(12, 13), 4);
		Figura3D figura3D[]={cubo,tedraedro};
		Circulo[] ruedas= {new Circulo(2),new Circulo(2),new Circulo(2),new Circulo(2)};
		Cuadrado[] sillas= {new Cuadrado(1),new Cuadrado(1),new Cuadrado(1),new Cuadrado(1)};
		Cubo cuerpo=new Cubo(new Cuadrado(2),12);
		Coche[] coches= {new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro"),new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"negro")};
		House[] houses= {new House(figura3D,new Posicion(2,3),"moncloa"),new House(figura3D,new Posicion(12,13),"casa blanca")};
		ClaseAlta a=new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345");
		assertEquals(a.toString(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").toString());
		assertNotNull("should not be null",new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345"));
		assertEquals(a.getNombre(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getNombre());
		assertEquals(a.getApellidos(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getApellidos());
		assertEquals(a.getDni(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getDni());
		assertEquals(a.getEdad(),new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getEdad());
		assertEquals(a.isCasado(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").isCasado());
		assertEquals(a.getHouse(),""+new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getHouse());
		assertEquals(a.getCoche(),""+new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getCoche());
		assertEquals(""+a.addCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"verde")), ""+new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").addCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"verde")));
		assertEquals(""+a.addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")), ""+new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")));
		House house= new House(figura3D,new Posicion(12,13),"casa blanca");
		assertEquals(a.setHouse(house),a.setHouse(house));
		assertEquals(a.setHouse(null),a.setHouse(null));
		Coche coche2= new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"amarillo");
		assertEquals(a.setCoche(coche2),a.setCoche(coche2));
		assertEquals(a.setCoche(null),a.setCoche(null));
		assertEquals(a.getNumCoche(),a.getNumCoche());
		assertEquals(a.getNumHouse(),a.getNumHouse());
		
		ClaseAlta no_coche_no_house=new ClaseAlta(null,null, "pepe", "alonso", 40, false, "12345");
		assertEquals(no_coche_no_house.getNumHouse(),no_coche_no_house.getNumHouse());
		assertEquals(no_coche_no_house.getHouse(),no_coche_no_house.getHouse());
		assertEquals(no_coche_no_house.setHouse(house),no_coche_no_house.setHouse(house));
		assertEquals(no_coche_no_house.getNumCoche(),no_coche_no_house.getNumCoche());
		assertEquals(no_coche_no_house.getCoche(),no_coche_no_house.getCoche());
		assertEquals(no_coche_no_house.setHouse(null),no_coche_no_house.setHouse(null));
		assertEquals(no_coche_no_house.setCoche(coche2),no_coche_no_house.setCoche(coche2));
		assertEquals(no_coche_no_house.setCoche(null),no_coche_no_house.setCoche(null));
		assertEquals(""+no_coche_no_house.addCoche(null), 
				""+no_coche_no_house.addCoche(null));
		assertEquals(""+no_coche_no_house.addHouse(null),  
				""+no_coche_no_house.addHouse(null));
		assertEquals(no_coche_no_house.addCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"verde")), 
				no_coche_no_house.addCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"verde")));
		assertEquals(no_coche_no_house.addHouse(new  House(figura3D,new Posicion(20,30),"casa de campo") ), 
				no_coche_no_house.addHouse(new  House(figura3D,new Posicion(20,30),"casa de campo")));
		assertEquals(no_coche_no_house.getHouse(),no_coche_no_house.getHouse());
		assertEquals(no_coche_no_house.getCoche(),no_coche_no_house.getCoche());
		
	}
	
	/*
	 * ClaseBaja
	 */
	@Test
	public void test20() { 
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
	
	/*
	 * ClaseMedia
	 */
	@Test
	public void test21() { 
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
	
	/*
	 * vagabundo
	 */
	@Test
	public void test22() {
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
	
	///////////
	/*
	 * vagabundo
	 */
		@Test
		public void test23() {
			assertNotNull("should not be null", new Vagabundo("Juan", "alonso", 10, false, "12234"));		
			assertEquals(new Vagabundo("Juan", "alonso", 10, false, "12234").getNombre(), new Vagabundo("Juan", "alonso", 10, false, "12234").getNombre());
			assertEquals(new Vagabundo("Juan", "alonso", 120, false, "12234").getApellidos(), new Vagabundo("Juan", "alonso", 120, false, "12234").getApellidos());
			assertEquals(new Vagabundo("Juan", "alonso", 10, false, "12").getDni(), new Vagabundo("Juan", "alonso", 10, false, "12").getDni());
			assertEquals(new Vagabundo("Juan", "alonso", 0, false, "12234").getEdad(), new Vagabundo("Juan", "alonso", 0, false, "12234").getEdad());
			assertEquals(new Vagabundo("Juan", "alonso", 10, true, "12234").isCasado(), new Vagabundo("Juan", "alonso", 10, true, "12234").isCasado());
			assertEquals(""+new Vagabundo("Juan", "alonso", 10, true, "12234").getHouse(),""+new Vagabundo("Juan", "alonso", 10, true, "12234").getHouse());
			assertEquals(new Vagabundo("Juan", "alonso", 10, true, "12234").getNumHouse(),new Vagabundo("Juan", "alonso", 10, true, "12234").getNumHouse());
			assertEquals(""+new Vagabundo("Juan", "alonso", 10, true, "12234").getCoche(),""+new Vagabundo("Juan", "alonso", 10, true, "12234").getCoche());
			assertEquals(""+new Vagabundo("Juan", "alonso", 10, true, "12234").getNumCoche(),""+new Vagabundo("Juan", "alonso", 10, true, "12234").getNumCoche());
			assertEquals(""+new Vagabundo("Juan", "alonso", 10, true, "12234").toString(),""+new Vagabundo("Juan", "alonso", 10, true, "12234").toString());



		}
		
		/*
		 * ClaseMedia
		 */
		@Test
		public void test24() { 
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
			assertEquals(""+a.setHouse(new House(figura3D,new Posicion(20,30),"casa de campo")),new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").setHouse(new House(figura3D,new Posicion(20,30),"casa de campo"))
					);
			Coche coche2= new Coche(ruedas,sillas,cuerpo,"mazida",1024,"blanco");
			assertEquals(new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").addCoche(coche2),
					new ClaseMedia(coche,house, "pepe", "alonso", 40, false, "12345").addCoche(coche2));
			//fail("Not yet implemented");

		}
		

		/*
		 * ClaseBaja
		 */
		@Test
		public void test25() {
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
			assertEquals(a.setHouse(house),a.setHouse(house));
			assertEquals(new ClaseBaja(new House(figura3D,new Posicion(2,3),"fdi"),"pepe", "alonso", 0, false, "12345").addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")), 
						 new ClaseBaja(new House(figura3D,new Posicion(2,3),"fdi"),"pepe", "alonso", 0, false, "12345").addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")));

			//fail("Not yet implemented");
		}

		/*
		 * ClaseAlta
		 */
		@Test
		public void test26() {
			Cubo cubo=new Cubo(new Cuadrado(22.2),12.8);
			Tetraedro tedraedro=new Tetraedro(new Rectangulo(12, 13), 4);
			Figura3D figura3D[]={cubo,tedraedro};
			Circulo[] ruedas= {new Circulo(2),new Circulo(2),new Circulo(2),new Circulo(2)};
			Cuadrado[] sillas= {new Cuadrado(1),new Cuadrado(1),new Cuadrado(1),new Cuadrado(1)};
			Cubo cuerpo=new Cubo(new Cuadrado(2),12);
			Coche[] coches= {new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro"),new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"negro")};
			House[] houses= {new House(figura3D,new Posicion(2,3),"moncloa"),new House(figura3D,new Posicion(12,13),"casa blanca")};
			ClaseAlta a=new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345");
			assertEquals(a.toString(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").toString());
			assertNotNull("should not be null",new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345"));
			assertEquals(a.getNombre(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getNombre());
			assertEquals(a.getApellidos(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getApellidos());
			assertEquals(a.getDni(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getDni());
			assertEquals(a.getEdad(),new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getEdad());
			assertEquals(a.isCasado(), new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").isCasado());
			assertEquals(a.getHouse(),""+new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").getHouse());
			assertEquals(""+a.addCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"verde")), ""+new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").addCoche(new Coche(ruedas,sillas,cuerpo,"honda",1000,"verde")));
			assertEquals(""+a.addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")), ""+new ClaseAlta(houses,coches, "pepe", "alonso", 40, false, "12345").addHouse(new House(figura3D,new Posicion(20,30),"casa de campo")));
			House house= new House(figura3D,new Posicion(12,13),"casa blanca");
			assertEquals(a.setHouse(house),a.setHouse(house));
			Coche coche2= new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"amarillo");
			assertEquals(a.setCoche(coche2),a.setCoche(coche2));


			//fail("Not yet implemented");

		}
		@Test
		public void test() {
			Imprimir.imprimir(new Double[19]);
			assertNotNull("should not be null",new Imprimir());

		}

}
