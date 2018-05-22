package ClassMath.TestMath;


public class Util {
	 public static double getRandomArbitrary(int min, int max) {
			return Math.random() * (max - min) + min;
		}
	 
	public static double[] generaEntrada(int size) {
		int defaultNum=100;
		if(size>0) {
			double[] entrada= new double[size];
			for(int i=0; i<size;i++) {
				entrada[i]=getRandomArbitrary(0, 99);
			}
			return entrada;
		}else {
			int len=(int) getRandomArbitrary(defaultNum, defaultNum+99);
			double[] entrada= new double[len];
			for(int i=0; i<len;i++) {
				entrada[i]=getRandomArbitrary(0, 99);
			}
			return entrada;
		}
		
	}
	
	/*
	 * para el numero de las entradas de las funciones que no restringe el numero de entrada
	 */
	public static double[] generaEntrada_determinista(int size, int default_num) {
		if(size>0) {
			double[] entrada= new double[size];
			for(int i=0; i<size;i++) {
				entrada[i]=getRandomArbitrary(0, 99);
			}
			return entrada;
		}else {
			int len=default_num;
			double[] entrada= new double[len];
			for(int i=0; i<len;i++) {
				entrada[i]=getRandomArbitrary(0, 99);
			}
			return entrada;
		}
		
	}
}
