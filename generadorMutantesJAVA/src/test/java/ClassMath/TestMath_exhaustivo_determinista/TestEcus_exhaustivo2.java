package ClassMath.TestMath_exhaustivo_determinista;

import org.junit.Test;

import ClassMath.Ecuaciones;
import ClassMath.Vista;
import ClassMath.TestMath.Util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestEcus_exhaustivo2 {
	

	/*
	 * 
	 */
	@Test
	public void test() {
		Vista vista = new Vista();
		int default_num=100;
		double[] x0=Util.generaEntrada(vista.getArgEcus(0));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu0(x0)+"",new Ecuaciones().ecu0(x0)+"");

		double[] x1=Util.generaEntrada(vista.getArgEcus(1)); 
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu1(x1)+"",new Ecuaciones().ecu1(x1)+"");
		
		double[] x2=Util.generaEntrada(vista.getArgEcus(2));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu2(x2)+"",new Ecuaciones().ecu2(x2)+"");
		
		double[] x3=Util.generaEntrada(vista.getArgEcus(3));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu3(x3)+"",new Ecuaciones().ecu3(x3)+"");
		
		double[] x4=Util.generaEntrada_determinista(vista.getArgEcus(4),default_num);
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu4(x4)+"",new Ecuaciones().ecu4(x4)+"");
		
		double[] x5=Util.generaEntrada_determinista(vista.getArgEcus(5),default_num);
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu5(x5)+"",new Ecuaciones().ecu5(x5)+"");
	
		double[] x6=Util.generaEntrada_determinista(vista.getArgEcus(6),default_num);
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu6(x6)+"",new Ecuaciones().ecu6(x6)+"");
		
	}

}
