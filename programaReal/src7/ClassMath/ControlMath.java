package ClassMath;

import java.util.LinkedList;

public class ControlMath {
	private Ecuaciones ecus;
	

	public ControlMath() {
		// TODO Auto-generated constructor stub
		this.ecus=new Ecuaciones();
	}


	public ControlMath(LinkedList<Integer> secuenciaOps, LinkedList<Double> result, LinkedList<double[]> entradas) {
		this.ecus=new Ecuaciones();
		int i=0;
		while(i<secuenciaOps.size()) {
			result.add(select(entradas.get(i),secuenciaOps.get(i)));
			i++;
		}
	}




	public double select(double[] entrada, Integer index) {
	
			switch(index) {
			case 0:
				return ecus.ecu0(entrada);
			case 1:
				return ecus.ecu1(entrada);
			case 2:
				return ecus.ecu2(entrada);
			case 3:
				return ecus.ecu3(entrada);
			case 4:
				return ecus.ecu4(entrada);
			case 5:
				return ecus.ecu5(entrada);
			case 6:
				return ecus.ecu6(entrada);

			default:
				return Byte.MIN_VALUE;
			}
		

	}
}
