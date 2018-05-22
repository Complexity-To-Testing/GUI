package ClassMath.TestMath;

import ClassMath.Vista;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestVista {

	 public static double getRandomArbitrary(int min, int max) {
			return Math.random() * (max - min) + min;
		}
	

	@Test
	public void test() {
		//0,1,2,3, 4, 5, 6
		//1,2,2,3,-1,-1,-1
		/*
		 * inicializar datos necesarios
		 */
		LinkedList<Integer> decisiones=new LinkedList<Integer> ();
		LinkedList<Integer> decisiones1;
		LinkedList<Integer> decisiones2;
		for(int i=0;i<3;i++) {
			decisiones.add(i);
		}
		LinkedList<double[]> entradas=new LinkedList<double[]>();
		Vista vista=new Vista();
		for(int op=0; op<decisiones.size();op++) {
			entradas.add(Util.generaEntrada(vista.getArgEcus(op)));
		}
		
		 
		/**
		 *parte de testing , como es aleatorio, solamente cubre todas las funciones, no todas las sentencias en cada funcion
		 */
		
		//aleatorio
		int op=(int) getRandomArbitrary(0, 7);
		
		double[] a=Util.generaEntrada(vista.getArgEcus(op));
		//System.out.println("a length: "+a.length);
		assertArrayEquals(new Vista().add(op,a), new Vista().add(op,a));
	
		decisiones1=new LinkedList<Integer> (decisiones);
		decisiones2=new LinkedList<Integer>(decisiones);
		
		assertArrayEquals(new Vista(decisiones1,entradas).add(op,a), 
				new Vista(decisiones2,entradas).add(op,a));
		
	
		int res=(int)getRandomArbitrary(0, 7);
		assertEquals(new Vista(decisiones,entradas).getResult(res),new Vista(decisiones,entradas).getResult(res));

		decisiones1=new LinkedList<Integer> (decisiones);
		decisiones2=new LinkedList<Integer>(decisiones);
		assertEquals(new Vista(decisiones1,entradas).getArgEcus(op), new Vista(decisiones2,entradas).getArgEcus(op) );

		 
		//parte comun, que no se afecta por usar aleatorio y exhaustivo
		assertNotNull("should not be null", new Vista(decisiones,entradas));	
		assertNotNull("should not be null", new Vista());

		
	}



}
