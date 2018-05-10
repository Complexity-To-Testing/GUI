import java.util.ArrayList;

public class Programa{
	private int p_num=1;
	private ArrayList<Double> result_tmp_num=new ArrayList<Double>();
	private double[] result_final_num;
	private ArrayList<Boolean> result_tmp_bool=new ArrayList<Boolean>();
	private boolean[] result_final_bool;
	private double[] inputs_num;
	private int[]decisiones;///////nuevo atributo
	public Programa(double[] inputs_num,int[] decisiones) {
		this.inputs_num=inputs_num;
		this.decisiones=decisiones;
	}
private void exe0() {
boolean k0=  ( 77.90322737700379  <= (inputs_num[inputs_num.length%(p_num++)]))  ||  ( 52.39012903104373  == (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k0);
boolean k1=  ( 89.81457385300747  >= (inputs_num[inputs_num.length%(p_num++)]))  ||  ( 4.229123955823525  == (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k1);
double k2=  ( 16.17792623683975  - (inputs_num[inputs_num.length%(p_num++)]) ) ;
result_tmp_num.add(k2);
boolean k3=  ( 90.2928555192957  == (inputs_num[inputs_num.length%(p_num++)]))  ||  ( 54.48714803769895  < (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k3);
double k4=  ( 19.062358216622183  + (inputs_num[inputs_num.length%(p_num++)]) ) ;
result_tmp_num.add(k4);
double k5=   36.2180679811391  - (inputs_num[inputs_num.length%(p_num++)])  ;
result_tmp_num.add(k5);
boolean k6=  ( 60.374651304007585  != (inputs_num[inputs_num.length%(p_num++)]))  ||  ( 37.93092617852057  >= (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k6);
boolean k7=  ( 16.182346517066097  == (inputs_num[inputs_num.length%(p_num++)]))  &&  ( 71.66037456205896  != (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k7);

boolean k8=  ( 51.29762816837297  != (inputs_num[inputs_num.length%(p_num++)]))  ||  ( 11.976935166380848  == (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k8);
double k9=  ( 21.702629829705216  / (Math.abs((int)(inputs_num[inputs_num.length%(p_num++)]) )+1)) ;
result_tmp_num.add(k9);
double k10=   72.2835225827963  + (inputs_num[inputs_num.length%(p_num++)])  ;
result_tmp_num.add(k10);
double k11=  ( 21.36650130916607  - (inputs_num[inputs_num.length%(p_num++)]) ) ;
result_tmp_num.add(k11);
boolean k12=  ( 55.862188858013475  <= (inputs_num[inputs_num.length%(p_num++)]))  ||  ( 77.43687796279745  >= (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k12);
boolean k13=  ( 76.61876716835523  == (inputs_num[inputs_num.length%(p_num++)]))  &&  ( 62.133135392425515  == (inputs_num[inputs_num.length%(p_num++)])) ;
result_tmp_bool.add(k13);
}
public boolean[] get_result_bool() {
		for(int i=0;i<decisiones.length;i++) {
			switch (decisiones[i]) {
			case 0:
				exe0();
				break;
default:
				exe0();
				break;
			}
		}
		
		result_final_bool=new boolean[result_tmp_bool.size()];
		for(int i=0;i<result_tmp_bool.size();i++) {
			result_final_bool[i]=result_tmp_bool.get(i);
		}
		return result_final_bool;
	}
public double[] get_result_num() {
		for(int i=0;i<decisiones.length;i++) {
			switch (decisiones[i]) {
			case 0:
				exe0();
				break;
default:
				exe0();
				break;
			}
		}
		
		result_final_num=new double[result_tmp_num.size()];
		for(int i=0;i<result_tmp_num.size();i++) {
			result_final_num[i]=result_tmp_num.get(i);
		}
		return result_final_num;
	}

}
