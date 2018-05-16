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

//////Espresiones//////
double k0=   47.53329785678049  * (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k0);

//////ifs//////
if( ( 60.19289051106958  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 68.85037631821376  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k1=  ( 12.111766667791251  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 89.05750664230234  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k1);


}else{
if( ( 47.0946572186391  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 25.68608236878522  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k2=   12.35290269461366  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k2);
}if( ( 63.08088647141265  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 83.03687879894804  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k3=  ( 27.6166955437217  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 72.32632791710672  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k3);
}}


//////whiles//////
int i5 = 0;
while(i5<1 && ( ( 78.19048195871888  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 8.121587460254617  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

if( ( 98.20199870832779  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 8.136498055484973  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k6=  ( 74.08101197009104  * (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k6);


}else{
if( ( 64.05927101628478  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 41.63072139934368  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k7=  ( 72.02145606823332  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 6.059436007474206  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k7);
}if( ( 80.21670787357058  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 6.824057570950632  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k8=  ( 31.964725309312882  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k8);
}}


i5++;
}


//////fors//////


//////Espresiones//////
double k9=   50.54703340676809  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k9);
}
public char[] get_result_bool(int ini, int fin ) {
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
		
	return result_tmp_bool.toString().substring(ini, fin%(result_tmp_bool.toString().length())).toCharArray();
	}
public char[] get_result_num(int ini, int fin) {
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
		
		return result_tmp_num.toString().substring(ini, fin%(result_tmp_bool.toString().length())).toCharArray();	}

}
