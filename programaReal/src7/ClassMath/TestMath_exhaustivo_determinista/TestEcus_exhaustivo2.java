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
		
		for (int i = -100; i < 100; i++) {
			
			x0[0]=i;
				assertEquals(new Ecuaciones().ecu0(x0)+"",new Ecuaciones().ecu0(x0)+"");
			

		}
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu0(null)+"",new Ecuaciones().ecu0(null)+"");

		
		double[] x1=Util.generaEntrada(vista.getArgEcus(1)); 
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu1(x1)+"",new Ecuaciones().ecu1(x1)+"");
		
		double[] x2=Util.generaEntrada(vista.getArgEcus(2));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu2(x2)+"",new Ecuaciones().ecu2(x2)+"");
		assertEquals(new Ecuaciones().ecu2(null)+"",new Ecuaciones().ecu2(null)+"");

		
		double[] x3=Util.generaEntrada(vista.getArgEcus(3));
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu3(null)+"",new Ecuaciones().ecu3(null)+"");
		for(int j=-200; j<200; j++) {
			for (int i = 0; i < x3.length; i++) {
				x3[i]=j;
			}
			assertEquals(new Ecuaciones().ecu3(x3)+"",new Ecuaciones().ecu3(x3)+"");

		}
		
		
		double[] x4=Util.generaEntrada_determinista(vista.getArgEcus(4),default_num);
		assertNotNull("should not be null", new Ecuaciones());	
		assertEquals(new Ecuaciones().ecu4(x4)+"",new Ecuaciones().ecu4(x4)+"");
		
		
		assertNotNull("should not be null", new Ecuaciones());	
		double[] x5=new double [400];
		for (int i = -100; i < 300; i++) {
			x5[i+100]=i;
		}
		assertEquals(new Ecuaciones().ecu5(x5)+"",new Ecuaciones().ecu5(x5)+"");

		assertEquals(new Ecuaciones().ecu5(null)+"",new Ecuaciones().ecu5(null)+"");
	
		assertNotNull("should not be null", new Ecuaciones());	
		double[] x6=new double [400];
		for (int i = -100; i < 300; i++) {
			x6[i+100]=i;
		}
		assertEquals(new Ecuaciones().ecu6(x6)+"",new Ecuaciones().ecu6(x6)+"");
		assertEquals(new Ecuaciones().ecu6(null)+"",new Ecuaciones().ecu6(null)+"");

	}
	

}
