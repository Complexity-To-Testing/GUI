import java.util.ArrayList;

public class Programa{
	private int p_num=0;
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
boolean k0=  ( 10.476079839206905  > (p_num<inputs_num.length ? inputs_num[p_num++] :  65.77475623600554 ))  ||  ( 71.5240772889171  < (p_num<inputs_num.length ? inputs_num[p_num++] :  3.773852015790729 )) ;
result_tmp_bool.add(k0);
if( ( 81.30550952571588  > (p_num<inputs_num.length ? inputs_num[p_num++] :  72.82247658092419 ))  ||  ( 52.17846070612567  >= (p_num<inputs_num.length ? inputs_num[p_num++] :  6.209284007053539 )) ){
double k1=  ( 11.949116370243752  + (p_num<inputs_num.length ? inputs_num[p_num++] :  49.18602130496314 ) ) ;
result_tmp_num.add(k1);


}else{
}

int i2 = 0;
while(i2<1 && ( ( 46.82415863501096  >= (p_num<inputs_num.length ? inputs_num[p_num++] :  60.84606022035742 ))  ||  ( 16.347159464360722  != (p_num<inputs_num.length ? inputs_num[p_num++] :  71.97516169563808 )) )){

double k3=  ( 64.55877794857098  * (p_num<inputs_num.length ? inputs_num[p_num++] :  45.24163127378054 ) ) ;
result_tmp_num.add(k3);
double k4=   90.96155961715097  - (p_num<inputs_num.length ? inputs_num[p_num++] :  15.954651265365127 )  ;
result_tmp_num.add(k4);double k5=  ( 29.002502499334106  + (p_num<inputs_num.length ? inputs_num[p_num++] :  81.21389802178189 ) ) ;
result_tmp_num.add(k5);

i2++;
}

for(int i6=1;i6>0;i6 -- ){
boolean k7=  ( 95.40211281440955  != (p_num<inputs_num.length ? inputs_num[p_num++] :  22.977089375619514 ))  &&  ( 26.03276970138799  != (p_num<inputs_num.length ? inputs_num[p_num++] :  65.15917123230251 )) ;
result_tmp_bool.add(k7);

for(int i8=1;i8>0;i8 -- ){
boolean k9=  ( 81.2809091241765  > (p_num<inputs_num.length ? inputs_num[p_num++] :  74.90440690186972 ))  &&  ( 5.000383686426346  < (p_num<inputs_num.length ? inputs_num[p_num++] :  15.018862470512195 )) ;
result_tmp_bool.add(k9);

for(int i10=0;i10<1;i10 ++ ){
double k11=   15.209527036110373  + (p_num<inputs_num.length ? inputs_num[p_num++] :  31.85061052576345 )  ;
result_tmp_num.add(k11);

for(int i12=0;i12<1;i12 ++ ){
boolean k13=  ( 18.816171106993984  <= (p_num<inputs_num.length ? inputs_num[p_num++] :  91.6594011918266 ))  &&  ( 14.45215116366957  != (p_num<inputs_num.length ? inputs_num[p_num++] :  57.29002610886939 )) ;
result_tmp_bool.add(k13);

for(int i14=0;i14<1;i14 ++ ){
boolean k15=  ( 70.70483295119965  <= (p_num<inputs_num.length ? inputs_num[p_num++] :  22.285668312053176 ))  &&  ( 67.17275880552516  >= (p_num<inputs_num.length ? inputs_num[p_num++] :  25.0280390272761 )) ;
result_tmp_bool.add(k15);

double k16=  ( 40.864032214832946  - (p_num<inputs_num.length ? inputs_num[p_num++] :  66.44955858635194 ) ) ;
result_tmp_num.add(k16);double k17=   54.74094620591272  - (p_num<inputs_num.length ? inputs_num[p_num++] :  11.459996483998806 )  ;
result_tmp_num.add(k17);


}double k18=  ( 43.015048981247574  * (p_num<inputs_num.length ? inputs_num[p_num++] :  95.04060866514459 ) ) ;
result_tmp_num.add(k18);


}double k19=   42.28799072872927  * (p_num<inputs_num.length ? inputs_num[p_num++] :  49.92166259185328 )  ;
result_tmp_num.add(k19);


}boolean k20=  ( 67.94679546517523  <= (p_num<inputs_num.length ? inputs_num[p_num++] :  26.55055847737814 ))  ||  ( 74.66724086819139  == (p_num<inputs_num.length ? inputs_num[p_num++] :  73.59071518168892 )) ;
result_tmp_bool.add(k20);


}double k21=   99.0810893132423  + (p_num<inputs_num.length ? inputs_num[p_num++] :  79.77437126220347 )  ;
result_tmp_num.add(k21);


}
double k22=  ( 68.60399032709809  + (p_num<inputs_num.length ? inputs_num[p_num++] :  94.94226728178286 ) ) ;
result_tmp_num.add(k22);
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
