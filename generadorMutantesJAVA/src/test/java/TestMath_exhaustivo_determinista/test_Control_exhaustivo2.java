package TestMath_exhaustivo_determinista;

import ClassMath.ControlMath;
import ClassMath.Vista;
import ClassMath.Util;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class test_Control_exhaustivo2 {
	 public static double getRandomArbitrary(int min, int max) {
			return Math.random() * (max - min) + min;
		}

	/*
	 * se usa la funcion generaEntrada_determinista_determinista. Es decir, el numero de entrada para las funciones que no restringe nuemro de
	 * entradas es determinado por usuario
	 */
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
			entradas.add(Util.generaEntrada_determinista(vista.getArgEcus(decisiones[op]),100));
		}


		assertNotNull("should not be null", new ControlMath(null,  new double[decisiones.length], entradas));	
		assertNotNull("should not be null", new ControlMath(decisiones,  null, entradas));	
		assertNotNull("should not be null", new ControlMath(decisiones,  new double[decisiones.length], null));	
		assertNotNull("should not be null", new ControlMath(decisiones,  new double[decisiones.length], entradas));	
		assertNotNull("should not be null", new ControlMath());	

		//se testea la funcion a toda costa
		for(int op=-100;op<100;op++) {
			ControlMath object=new ControlMath(decisiones, new double[decisiones.length], entradas); 
			double[] entrada=Util.generaEntrada_determinista(vista.getArgEcus(op),100);
			assertEquals(object.select(entrada, op)+"",object.select(entrada, op)+"");
			assertEquals(object.select(null, op)+"",object.select(null, op)+"");
			int x=(int) getRandomArbitrary(0, 99);
			assertEquals(object.select(entrada, op-x)+"",object.select(entrada, op-x)+"");
			assertEquals(object.select(null, op-x)+"",object.select(null, op-x)+"");


		}

	}
}













