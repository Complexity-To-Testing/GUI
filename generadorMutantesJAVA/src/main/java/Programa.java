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
double k0=  ( 95.75301173866566  / (Math.abs((int)(inputs_num[(inputs_num.length-1)%(p_num++)]) )+1)) ;
result_tmp_num.add(k0);
if( ( 81.0196220360987  >= (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 7.778154094192819  < (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
boolean k1=  ( 79.82640931794629  >= (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 79.63720793410349  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k1);

if( ( 58.58759871375315  != (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 64.52782942848208  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
double k2=  ( 87.79855913639902  / (-Math.abs((int)(inputs_num[(inputs_num.length-1)%(p_num++)]) )+1)) ;
result_tmp_num.add(k2);


}else{
if( ( 93.12607856042263  > (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 87.41069632905504  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
double k3=  ( 27.707096374660892  / (-Math.abs((int)(inputs_num[(inputs_num.length-1)%(p_num++)]) )+1)) ;
result_tmp_num.add(k3);

}if( ( 89.21897420186721  <= (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 5.068962870194186  < (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
boolean k4=  ( 76.28403093334784  <= (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 27.98889589928162  <= (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k4);

}}

}else{
if( ( 44.38950167659823  < (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 41.0384294414157  != (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
double k5=  ( 93.43097978545059  - (inputs_num[(inputs_num.length-1)%(p_num++)]) ) ;
result_tmp_num.add(k5);

}if( ( 2.1150346610764474  == (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 25.05671580045822  > (inputs_num[(inputs_num.length-1)%(p_num++)])) ){
double k6=   39.11637730459132  / (Math.abs((int)(inputs_num[(inputs_num.length-1)%(p_num++)]) )+1) ;
result_tmp_num.add(k6);

}}

int i7 = 1;
while(i7>0 && ( ( 20.893862300244393  >= (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 42.66302424369643  > (inputs_num[(inputs_num.length-1)%(p_num++)])) )){

double k8=  ( 40.37754087406161  / (-Math.abs((int)(inputs_num[(inputs_num.length-1)%(p_num++)]) )+1)) ;
result_tmp_num.add(k8);
double k9=  ( 90.91008634114507  - (inputs_num[(inputs_num.length-1)%(p_num++)]) ) ;
result_tmp_num.add(k9);boolean k10=  ( 22.65089886008366  >= (inputs_num[(inputs_num.length-1)%(p_num++)]))  ||  ( 43.259863712896475  != (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k10);

i7--;
}
for(int i11=1;i11>0;i11 -- ){
double k12=  ( 49.791309436098786  - (inputs_num[(inputs_num.length-1)%(p_num++)]) ) ;
result_tmp_num.add(k12);

boolean k13=  ( 86.87762179218838  == (inputs_num[(inputs_num.length-1)%(p_num++)]))  &&  ( 25.10843168626716  < (inputs_num[(inputs_num.length-1)%(p_num++)])) ;
result_tmp_bool.add(k13);double k14=   10.159799805887005  / (Math.abs((int)(inputs_num[(inputs_num.length-1)%(p_num++)]) )+1) ;
result_tmp_num.add(k14);


}
double k15=   97.50090232168  / (Math.abs((int)(inputs_num[(inputs_num.length-1)%(p_num++)]) )+1) ;
result_tmp_num.add(k15);
}
public boolean[] get_result_bool(int ini, int fin) {
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
		for(int i=ini;i<(fin < result_tmp_bool.size() ? fin : result_tmp_bool.size());i++) {
			result_final_bool[i]=result_tmp_bool.get(i);
		}
		return result_final_bool;
	}
public double[] get_result_num(int ini, int fin) {
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
		for(int i=ini;i<(fin < result_tmp_num.size() ? fin : result_tmp_num.size());i++) {
			result_final_num[i]=result_tmp_num.get(i);
		}
		return result_final_num;
	}

}
