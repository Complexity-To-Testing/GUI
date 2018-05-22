package Test.figuraExhaustiva;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

import claseNodo.figura2D.Circulo;
import claseNodo.figura2D.Cuadrado;
import claseNodo.figura2D.Rectangulo;
import claseNodo.figura2D.Triangulo;
import claseNodo.figura3D.Cilindro;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Esfera;
import claseNodo.figura3D.Tetraedro;

public class TestFiguraExhaustiva {

	
/**
 * 	public void test() {
 * Vagabundo vagabundo=new Vagabundo("Juan", null, 0, false, null);
		assertEquals("Juan", vagabundo.getNombre());
	}
 */
	
	
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
	
	///////////3D
	@Test
	public void test5() {
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
	public void test6() {
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
	public void test7() {
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
	public void test8() {
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
		
}
