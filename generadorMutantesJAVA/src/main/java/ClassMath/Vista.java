package ClassMath;

import java.util.LinkedList;


public class Vista {
	private LinkedList<Integer> secuenciaOps;
	private int size=0;
	private LinkedList<Double> result;
	private LinkedList<double[]> entradas;
	//si el valor es -1, significa que la opecion elegido no tiene restriccion del numero de argumentos
	private int[] argEcus={1,2,2,3,-1,-1,-1}; 
	private int maxOp=argEcus.length;

	public Vista() {
		this.secuenciaOps=new LinkedList<Integer>();
		this.result=new LinkedList<Double>();
		this.entradas=new LinkedList<double[]>();
	}

	public Vista(LinkedList<Integer> secuenciaOps, LinkedList<double[]> entradas) {
		this.secuenciaOps = secuenciaOps;
		this.entradas = entradas;
		this.result=new LinkedList<Double>();
		new ControlMath(secuenciaOps, this.result,  entradas);
	}

	
	public int getArgEcus(int x) {
		if(x<argEcus.length) {
			return this.argEcus[x];
		}else {
			return -1;
		}

	}


	public Integer[] add(int op, double[] entrada){
		//se expande el tama�o de la list 
		this.secuenciaOps.add(op);
		this.entradas.add(entrada);
		System.out.println("size ops: "+secuenciaOps.size()+"size entradas"+entradas.size());
		return secuenciaOps.toArray(new Integer[secuenciaOps.size()]);
	}

	//pide un resultado segun la posicion de la operacion
	public String getResult(int index) {
			return this.result.get(index%this.result.size())+"";
		
	}


	


	
}
