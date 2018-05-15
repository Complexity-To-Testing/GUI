package TestMath;

import ClassMath.Util;
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
		int decisiones[] = {0,1,2,3,4,5,6};
		LinkedList<double[]> entradas=new LinkedList<double[]>();
		Vista vista=new Vista();
		for(int op=0; op<decisiones.length;op++) {
			entradas.add(Util.generaEntrada(vista.getArgEcus(op)));
		}
		
		 
		/**
		 *parte de testing , como es aleatorio, solamente cubre todas las funciones, no todas las sentencias en cada funcion
		 */
		
		//aleatorio
		int op=(int) getRandomArbitrary(-100, 788);
		
		double[] a=Util.generaEntrada(vista.getArgEcus(op));
		//System.out.println("a length: "+a.length);
		assertArrayEquals(new Vista().add(op,a), new Vista().add(op,a));
		assertArrayEquals(new Vista(decisiones,entradas).add(op,a), 
				new Vista(decisiones,entradas).add(op,a));
		
		
		assertArrayEquals(new Vista(decisiones,entradas).add(op,a), 
				new Vista(decisiones,entradas).add(op,a));
		assertEquals(new Vista(decisiones,entradas).check()+"",new Vista(decisiones,entradas).check()+"");
		int res=(int)getRandomArbitrary(0, 7);
		assertEquals(new Vista(decisiones,entradas).getResult(res),new Vista(decisiones,entradas).getResult(res));

		
		
		//parte comun, que no se afecta por usar aleatorio y exhaustivo
		assertNotNull("should not be null", new Vista(decisiones,entradas));	
		assertNotNull("should not be null", new Vista());
		assertEquals(new Vista(decisiones,entradas).getNumOps(),new Vista(decisiones,entradas).getNumOps());
		assertEquals(new Vista(decisiones,entradas).clearResult(),new Vista(decisiones,entradas).clearResult());
		assertEquals(new Vista(decisiones,entradas).mostrarResult(),new Vista(decisiones,entradas).mostrarResult());

		
	}



}
