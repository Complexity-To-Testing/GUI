import java.util.ArrayList;

public class Programa{
	private int p_num=0;
	private ArrayList<Double> result_tmp_num=new ArrayList<Double>();
	private double[] result_final_num;
	private ArrayList<Boolean> result_tmp_bool=new ArrayList<Boolean>();
	private boolean[] result_final_bool;
	private double[] inputs_num;
	public Programa(double[] inputs_num) {
		this.inputs_num=inputs_num;
	}
private void exe() {
boolean k0=  ( 39.32855979091139  >= (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 51.19529640248878  >= (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k0);
boolean k1=  ( 24.11615569654739  <= (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 23.632873780958946  < (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k1);
if( ( 13.794562303880626  <= (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 28.556658673897807  == (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ){
double k3=   65.87842543576319  / (Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1) ;
result_tmp_num.add(k3);
double k2=   62.39740171529549  - (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k2);
double k4=   22.83656447218772  * (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k4);
}else {
double k5=   35.09826214143134  / (-Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1) ;
result_tmp_num.add(k5);double k6=  ( 69.06058492150409  / (-Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1)) ;
result_tmp_num.add(k6);double k7=  ( 11.104101724826815  / (-Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1)) ;
result_tmp_num.add(k7);
}
int i8 = 0;
while(i8<1 && ( ( 2.2792830826077717  >= (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  ||  ( 63.80656249048769  <= (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) )){

boolean k9=  ( 2.6415773681442087  > (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 14.387676325213182  <= (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k9);double k10=   37.71273768694642  + (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k10);double k11=  ( 86.75030833709734  * (p_num<inputs_num.length ? inputs_num[p_num++] : 5) ) ;
result_tmp_num.add(k11);
i8++;
}

for(int i12=1;i12>0;i12 -- ){
double k13=  ( 3.346620622544779  - (p_num<inputs_num.length ? inputs_num[p_num++] : 5) ) ;
result_tmp_num.add(k13);
double k14=  ( 30.800590205025966  / (-Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1)) ;
result_tmp_num.add(k14);double k15=  ( 57.15148923428521  - (p_num<inputs_num.length ? inputs_num[p_num++] : 5) ) ;
result_tmp_num.add(k15);

}
boolean k16=  ( 18.36700821062139  > (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 60.312333466736355  < (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k16);
double k17=  ( 41.58255064617306  / (-Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1)) ;
result_tmp_num.add(k17);
}
public boolean[] get_result_bool() {
		exe();
		result_final_bool=new boolean[result_tmp_bool.size()];
		for(int i=0;i<result_tmp_bool.size();i++) {
			result_final_bool[i]=result_tmp_bool.get(i);
		}
		return result_final_bool;
	}

	public double[] get_result_num() {
		exe();
		result_final_num=new double[result_tmp_num.size()];
		for(int i=0;i<result_tmp_num.size();i++) {
			result_final_num[i]=result_tmp_num.get(i);
		}
		return result_final_num;
	}
}
