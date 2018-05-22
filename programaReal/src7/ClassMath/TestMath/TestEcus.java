package ClassMath.TestMath;

import org.junit.Test;

import ClassMath.Ecuaciones;
import ClassMath.Vista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestEcus {


	/*
	 * 
	 */
	@Test
	public void test() {
		Vista vista = new Vista();



		double[] x0=Util.generaEntrada(vista.getArgEcus(0));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu0(x0)+"",new Ecuaciones().ecu0(x0)+"");

		/*
		double[] x1=Util.generaEntrada(vista.getArgEcus(1)); 
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu1(x1)+"",new Ecuaciones().ecu1(x1)+"");

		double[] x2=Util.generaEntrada(vista.getArgEcus(2));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu2(x2)+"",new Ecuaciones().ecu2(x2)+"");

		double[] x3=Util.generaEntrada(vista.getArgEcus(3));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu3(x3)+"",new Ecuaciones().ecu3(x3)+"");

		double[] x4=Util.generaEntrada(vista.getArgEcus(4));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu4(x4)+"",new Ecuaciones().ecu4(x4)+"");

		double[] x5=Util.generaEntrada(vista.getArgEcus(5));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu5(x5)+"",new Ecuaciones().ecu5(x5)+"");

		double[] x6=Util.generaEntrada(vista.getArgEcus(6));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu6(x6)+"",new Ecuaciones().ecu6(x6)+"");
	*/
	}

}
