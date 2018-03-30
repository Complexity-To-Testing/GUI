package ClassMath;

import java.util.LinkedList;

public class ControlMath {
	private Ecuaciones ecus;



	public ControlMath(int[] secuenciaOps, double[] result, LinkedList<double[]> entradas) {
		// TODO Auto-generated constructor stub
		if(secuenciaOps==null) {
			//System.out.println("Error de secuenciaOps");
		}else if(result == null) {
			//System.out.println("Error de result");
		}else if(entradas == null) {
			//System.out.println("Error de entradas");
		}else if( secuenciaOps!=null && result!=null && entradas!=null) {
			//printEntrada(entradas);
			this.ecus=new Ecuaciones();
			int i=0;
			while(i<secuenciaOps.length && secuenciaOps[i]>-1) {
				result[i]=select(entradas.get(i),secuenciaOps[i]);
				i++;
			}
		}else {
			this.ecus=new Ecuaciones();
			//System.out.println("error de instanciacion");
		}

	}

	public ControlMath() {
		// TODO Auto-generated constructor stub
		this.ecus=new Ecuaciones();
	}


	public double select(double[] entrada, int index) {
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
