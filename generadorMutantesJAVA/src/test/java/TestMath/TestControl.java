package TestMath;

import ClassMath.ControlMath;
import ClassMath.Util;
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
				int decisiones[] = {0,1,2,3,4,5,6};
				int size=decisiones.length;
				LinkedList<double[]> entradas=new LinkedList<double[]>();
				Vista vista=new Vista();
			
				for(int op=0; op<decisiones.length;op++) {
					entradas.add(Util.generaEntrada(vista.getArgEcus(decisiones[op])));
				}
				
				System.out.println("size: "+size);
				
				
		assertNotNull("should not be null", 
				new ControlMath(decisiones, new double[decisiones.length], entradas));	
		assertNotNull("should not be null", 
				new ControlMath());	
		
		//se testea la funcion con un numero aleatorio
		int op=(int)getRandomArbitrary(0, 7);
		ControlMath object=new ControlMath(decisiones, new double[decisiones.length], entradas);
		double[] entrada=Util.generaEntrada(vista.getArgEcus(decisiones[op]));
		assertEquals(object.select(entrada, op)+"",object.select(entrada, op)+"");
		
	}

}
















