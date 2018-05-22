package ClassMath.TestMath;

import ClassMath.ControlMath;
import ClassMath.Vista;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestControl {
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
		for(int i=0;i<2;i++) {
			decisiones.add(i);
		}
				int size=decisiones.size();
				LinkedList<double[]> entradas=new LinkedList<double[]>();
				Vista vista=new Vista();
			
				for(int op=0; op<decisiones.size();op++) {
					entradas.add(Util.generaEntrada(vista.getArgEcus(decisiones.get(op))));
				}
				
				System.out.println("size: "+entradas.size());
				
				
		assertNotNull("should not be null", 
				new ControlMath(decisiones, new LinkedList<Double>(), entradas));	
		assertNotNull("should not be null", 
				new ControlMath());	
		
		  
	}

}
















