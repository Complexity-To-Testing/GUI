package ClassMath.TestMath_exhaustivo_determinista;

import ClassMath.Vista;
import ClassMath.TestMath.Util;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class test_vista_exhauxtivo2 {

	/*
	 * se usa la funcion generaEntrada_determinista. Es decir, el numero de entrada para las funciones que no restringe nuemro de
	 * entradas es determinado por usuario
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
		int defualt_num=100;

		for(int op=0; op<decisiones.size();op++) {
			entradas.add(Util.generaEntrada_determinista(vista.getArgEcus(op),defualt_num));
		}

		//exhauxtivo
		for(int op=0;op<decisiones.size();op++) {
			//System.out.println("-------------");
			//System.out.println("op: "+op);
			int index=decisiones.get(op);//sacar la posicion donde guarda la opcion tomada
			int size=vista.getArgEcus(index);
			double[] a=Util.generaEntrada_determinista(size,defualt_num);
			//System.out.println("longitud de entrada: "+a.length);
			assertArrayEquals(new Vista().add(op,a), new Vista().add(op,a));

			
			
			decisiones1=new LinkedList<Integer> (decisiones);
			decisiones2=new LinkedList<Integer>(decisiones);
			
			assertArrayEquals(new Vista(decisiones1,entradas).add(op,a), 
					new Vista(decisiones2,entradas).add(op,a));
			
			decisiones1=new LinkedList<Integer> (decisiones);
			decisiones2=new LinkedList<Integer>(decisiones);
			assertArrayEquals(new Vista(decisiones1,entradas).add(op,a), 
					new Vista(decisiones2,entradas).add(op,a));
			

		}

		
		for(int op=0;op<10;op++) {
			decisiones1=new LinkedList<Integer> (decisiones);
			decisiones2=new LinkedList<Integer>(decisiones);
			assertEquals(new Vista(decisiones1,entradas).getResult(op),new Vista(decisiones2,entradas).getResult(op));
			
			decisiones1=new LinkedList<Integer> (decisiones);
			decisiones2=new LinkedList<Integer>(decisiones);
			assertEquals(new Vista(decisiones1,entradas).getArgEcus(op), new Vista(decisiones2,entradas).getArgEcus(op) );
		}

		//parte comun, que no se afecta por usar aleatorio y exhaustivo
		assertNotNull("should not be null", new Vista(decisiones,entradas));	
		assertNotNull("should not be null", new Vista());	

	}

}







