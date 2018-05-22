package ClassMath.TestMath_exhauxtivo;

import ClassMath.Vista;
import ClassMath.TestMath.Util;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class test_vista_exhauxtivo {
	 public static double getRandomArbitrary(int min, int max) {
			return Math.random() * (max - min) + min;
		}

	/*
	 * se usa la funcion generaEntrada. Es decir, el numero de entrada para las funciones que no restringe nuemro de
	 * entradas es aleatorio
	 */

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
		for(int i=0;i<7;i++) {
			decisiones.add(i);
		}
		LinkedList<double[]> entradas=new LinkedList<double[]>();
		Vista vista=new Vista();
		
		for(int op=0; op<100;op++) {
			entradas.add(Util.generaEntrada(vista.getArgEcus(op)));
		}

		//exhauxtivo
		for(int op=0;op<decisiones.size();op++) {
			//System.out.println("-------------");
			//System.out.println("op: "+op);
			
			double[] a=Util.generaEntrada(vista.getArgEcus(decisiones.get(op)));
			assertArrayEquals(new Vista().add(decisiones.get(op),a), new Vista().add(decisiones.get(op),a));

			
			assertArrayEquals(new Vista(decisiones,entradas).add(decisiones.get(op),a), 
					new Vista(decisiones,entradas).add(decisiones.get(op),a));
			
		}
		
		for(int op=-100;op<100;op++) { 
			assertEquals(new Vista(decisiones,entradas).getResult(op),new Vista(decisiones,entradas).getResult(op));
			assertEquals(new Vista(decisiones,entradas).getArgEcus(op),new Vista(decisiones,entradas).getArgEcus(op));
			assertEquals(new Vista(null,entradas).getArgEcus(op),new Vista(null,entradas).getArgEcus(op));
		}
  

		//parte comun, que no se afecta por usar aleatorio y exhaustivo
		int[] d= {5,6,7};
		assertNotNull("should not be null", new Vista(decisiones,entradas));;	
		assertNotNull("should not be null", new Vista());	
		

		

		
	}

}







