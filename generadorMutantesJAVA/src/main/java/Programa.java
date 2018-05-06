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
boolean k0=  ( 96.24521050568649  == (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 57.530463633463576  != (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k0);
boolean k1=  ( 6.908457705152684  != (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  ||  ( 51.22684342369856  <= (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k1);
if( ( 11.9599652085995  >= (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ){
boolean k3=  ( 90.64096181038605  < (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  ||  ( 90.37752222094889  <= (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k3);
double k2=   10.360827168292987  * (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k2);
double k4=   43.68677140717796  / (Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1) ;
result_tmp_num.add(k4);
}else {
double k5=   11.290118503845363  + (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k5);double k6=   26.695905995873872  + (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k6);double k7=   42.75631204969682  + (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k7);
}
int i8 = 0;
while(i8<1 && ( ( 62.8820386877274  >= (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 15.59237538996897  > (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) )){

boolean k9=  ( 54.99648151130021  >= (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  &&  ( 86.73332585492157  >= (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k9);boolean k10=  ( 10.99731003576883  < (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  ||  ( 63.58143547971887  > (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k10);double k11=   61.60515930897106  - (p_num<inputs_num.length ? inputs_num[p_num++] : 5)  ;
result_tmp_num.add(k11);
i8++;
}

for(int i12=1;i12>0;i12 -- ){
double k13=  ( 19.606999927209575  / (-Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1)) ;
result_tmp_num.add(k13);
boolean k14=  ( 1.0455365129870182  != (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  ||  ( 67.51804816644622  == (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k14);double k15=   76.06655404693119  / (-Math.abs((int)(p_num<inputs_num.length ? inputs_num[p_num++] : 5) )+1) ;
result_tmp_num.add(k15);

}
boolean k16=  ( 21.82447940004371  == (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  ||  ( 84.49045849232812  == (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k16);
boolean k17=  ( 47.981343197385314  <= (p_num<inputs_num.length ? inputs_num[p_num++] : 5))  ||  ( 65.2189676706757  != (p_num<inputs_num.length ? inputs_num[p_num++] : 5)) ;
result_tmp_bool.add(k17);
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
