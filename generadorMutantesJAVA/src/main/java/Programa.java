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
boolean k0=  ( 81.38964373054944  < (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 90.19582685447541  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k0);
if( ( 86.83488531586936  > (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 64.92711829857129  < (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
double k1=  ( 17.19094070525462  + (inputs_num[(inputs_num.length-1)%(p_num++)]) ) ;
result_tmp_num.add(k1);


}else{
if( ( 74.17498726726744  >= (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 32.18181550259666  != (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
boolean k2=  ( 46.383998329200935  != (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 63.35790723471527  < (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k2);

}}

int i3 = 1;
while(i3>0 && ( ( 13.564175969457779  < (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 75.23312093802267  <= (inputs_num[(inputs_num.length-1)%(p_num++)])) )){

boolean k4=  ( 40.21078039988842  != (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 17.248777731077777  != (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k4);
boolean k5=  ( 68.02182454072606  != (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 37.51189599410036  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k5);boolean k6=  ( 6.570787088440074  <= (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 4.114776633522785  != (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k6);

i3--;
}
for(int i7=1;i7>0;i7 -- ){
boolean k8=  ( 36.61599091128781  != (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 24.58841369623077  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k8);

boolean k9=  ( 83.94799538885883  != (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 6.954008809559652  != (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k9);boolean k10=  ( 87.00830807025605  < (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 31.713713221238667  < (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k10);


}
boolean k11=  ( 99.5204313401547  < (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 26.73058339000306  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k11);
}
public boolean[] get_result_bool(int hasta_x) {
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
		for(int i=0;i<(hasta_x<=result_tmp_num.size()?hasta_x : result_tmp_num.size());i++) {
			result_final_bool[i]=result_tmp_bool.get(i);
		}
		return result_final_bool;
	}
public double[] get_result_num(int hasta_x) {
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
		for(int i=0;i<(hasta_x<=result_tmp_num.size()?hasta_x : result_tmp_num.size());i++) {
			result_final_num[i]=result_tmp_num.get(i);
		}
		return result_final_num;
	}

}
