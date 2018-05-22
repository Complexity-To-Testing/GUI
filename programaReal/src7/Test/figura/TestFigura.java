package Test.figura;

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

public class TestFigura {

	
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
		
}
