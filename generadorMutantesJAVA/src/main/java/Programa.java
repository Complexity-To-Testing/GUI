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
boolean k0=  ( 78.90089738161397  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 62.13772475523406  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k0);
boolean k1=  ( 5.1117538311874755  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 35.6351671900444  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k1);
double k2=  ( 98.36576075896724  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k2);
boolean k3=  ( 2.4868221925727294  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 92.69996492974333  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k3);
boolean k4=  ( 75.14521031152317  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 67.88759452301728  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k4);
boolean k5=  ( 32.22373139329879  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 72.0443925087803  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k5);
double k6=   98.43137335866614  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k6);
boolean k7=  ( 22.997168232802423  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 98.43240634308133  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k7);
double k8=   74.80131039484316  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k8);
double k9=   28.623581430281625  * (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k9);
double k10=  ( 90.60533300483894  * (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k10);
double k11=   32.9227810748228  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k11);

//////ifs//////
if( ( 84.0103455684705  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 3.3993306743192746  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k12=   85.74043610483818  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k12);
boolean k13=  ( 22.521872472949923  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 13.812680747115461  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k13);
boolean k14=  ( 64.64000371986708  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 18.028217062929276  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k14);
boolean k15=  ( 11.391872666059875  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 60.879635701370574  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k15);
double k16=  ( 48.47690902991256  + (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k16);
double k17=   37.94835711408151  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k17);
boolean k18=  ( 72.21233206292509  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 88.81925667475168  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k18);
double k19=   18.428883496180344  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k19);
boolean k20=  ( 46.045442421672064  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 60.97547271740218  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k20);
boolean k21=  ( 34.43034268840632  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 81.28984673855688  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k21);
double k22=   67.72489270602894  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k22);
double k23=   69.0237908186477  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k23);


}else{
if( ( 97.69690279449728  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 37.64516742169369  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k24=  ( 64.37859580317014  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k24);
}if( ( 8.55052677300463  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 30.07248874516772  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k25=   37.916797136299095  * (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k25);
}}


//////whiles//////
int i27 = 1;
while(i27>0 && ( ( 16.198790509401626  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 17.757650142940996  < (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

if( ( 47.658001992867455  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 22.83226194285514  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k28=   15.741372776694824  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k28);
boolean k29=  ( 27.706904628354838  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 53.83804612302981  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k29);
boolean k30=  ( 35.745877444558936  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 64.94153282547259  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k30);
boolean k31=  ( 20.627612396766853  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 39.60264044349466  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k31);
double k32=  ( 48.66993458130045  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k32);
double k33=   29.93783836819589  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k33);
double k34=   22.859884443366266  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k34);
boolean k35=  ( 35.113065084099524  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 67.42501106256957  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k35);
boolean k36=  ( 71.22735750071045  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 86.135535492572  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k36);
boolean k37=  ( 55.008114382536874  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 11.8959389273984  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k37);
boolean k38=  ( 30.16807359642706  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 35.9417295288893  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k38);
double k39=   2.871631171555412  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k39);


}else{
if( ( 38.879423717513184  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 80.98302401635515  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k40=  ( 30.394072630156966  + (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k40);
}if( ( 62.03268178561689  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 4.247748402937596  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k41=  ( 23.267520835104058  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k41);
}}


int i42 = 1;
while(i42>0 && ( ( 99.1185511217355  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 58.74561963818525  == (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

if( ( 58.23388587013239  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 76.41194359459784  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k43=   64.9993009937121  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k43);
boolean k44=  ( 59.961029355369305  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 19.075223577299433  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k44);
boolean k45=  ( 12.348970661942309  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 54.92361133587005  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k45);
double k46=   23.663392885586816  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k46);
double k47=   48.52335203931102  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k47);
double k48=   48.591702672599524  * (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k48);
boolean k49=  ( 22.373065416750133  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 49.0798208658398  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k49);
double k50=   73.00995694535001  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k50);
double k51=  ( 92.64138119432766  + (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k51);
boolean k52=  ( 97.7824067414263  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 85.16635502736364  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k52);
boolean k53=  ( 90.67710646389934  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 94.94373951612937  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k53);
boolean k54=  ( 91.06370630887928  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 31.83183613940197  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k54);


}else{
if( ( 79.06626859083745  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 27.38516721675364  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k55=  ( 6.972322740965167  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 74.40003820505619  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k55);
}if( ( 8.9859864951853  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 51.255002870904626  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k56=  ( 67.58184283483632  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 76.35969789523256  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k56);
}}


int i57 = 0;
while(i57<1 && ( ( 51.80212117473487  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 38.45752376120008  != (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

boolean k58=  ( 86.4639572567831  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 49.35710021670131  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k58);

int i59 = 1;
while(i59>0 && ( ( 26.757486566029634  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 29.546453181163933  < (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

double k60=   7.430099371185089  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k60);

int i61 = 0;
while(i61<1 && ( ( 53.03643978603849  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 65.2818260566379  > (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

boolean k62=  ( 17.589678176984187  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 77.27333982462481  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k62);

int i63 = 0;
while(i63<1 && ( ( 65.19510539979356  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 27.490714434912164  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

boolean k64=  ( 37.656432810781375  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 76.04915788198907  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k64);

int i65 = 0;
while(i65<1 && ( ( 69.30263435677865  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 77.81467348384655  != (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

if( ( 91.05725982114916  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 93.70688207667749  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k66=  ( 31.65369442885041  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 18.900026614843263  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k66);
double k67=   37.4658149416538  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k67);
boolean k68=  ( 15.160382605677476  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 11.616928150208597  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k68);
double k69=   78.05005144940563  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k69);
boolean k70=  ( 36.86529291359154  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 49.01828135877435  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k70);
double k71=  ( 96.0908792266976  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k71);
boolean k72=  ( 94.32742491809094  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 90.79717251313406  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k72);
boolean k73=  ( 69.67202286122175  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 27.24407234258488  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k73);
boolean k74=  ( 7.704226981502146  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 35.60123545330346  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k74);
boolean k75=  ( 19.958969270821346  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 92.52386329954862  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k75);
double k76=   30.681001796774346  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k76);
double k77=  ( 47.907769931302845  + (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k77);


}else{
if( ( 29.495258751142927  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 29.668990885219113  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k78=  ( 68.69229025460092  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 19.216166266270825  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k78);
}if( ( 49.061485270739006  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 53.99950682801327  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k79=  ( 17.313851609620322  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 50.565182927032716  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k79);
}}


int i80 = 1;
while(i80>0 && ( ( 65.19721658254147  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 20.44330220251471  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

boolean k81=  ( 5.283065656470516  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 2.223130118620775  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k81);

int i82 = 1;
while(i82>0 && ( ( 40.66176886887747  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 18.30873221139544  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

if( ( 86.13687785599413  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 64.10317699553121  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k83=  ( 22.59407533893187  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 47.64313197184157  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k83);
boolean k84=  ( 44.36144509228069  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 98.35328969357305  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k84);
boolean k85=  ( 39.57344043889151  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 3.6193352563239647  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k85);
double k86=  ( 22.083223793388647  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k86);
boolean k87=  ( 31.91856671416732  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 5.512396137628315  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k87);
boolean k88=  ( 81.26193103728163  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 65.65756636723962  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k88);
double k89=  ( 29.295254415724198  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k89);
double k90=  ( 54.70377814692928  * (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k90);
boolean k91=  ( 70.77376123213391  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 6.848429015654802  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k91);
double k92=  ( 53.566078846874596  + (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k92);
double k93=  ( 81.65701102696656  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k93);
double k94=  ( 29.85538414727072  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k94);


}else{
if( ( 38.68374360917572  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 15.23580985385577  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k95=  ( 67.34057639700875  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 61.6183272013636  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k95);
}if( ( 66.15881416154615  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 30.331882797821535  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k96=  ( 21.009372660246015  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k96);
}}


int i97 = 1;
while(i97>0 && ( ( 35.04980463583175  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 50.2677869473587  < (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

boolean k98=  ( 49.404091164631964  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 89.28192457426441  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k98);

int i99 = 1;
while(i99>0 && ( ( 57.41490015426843  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 35.824562215058734  > (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

if( ( 64.99693217404479  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 47.22034290782114  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k100=  ( 99.1028796630213  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 51.23480713519946  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k100);
boolean k101=  ( 26.591008339906658  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 86.70537334115272  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k101);
double k102=   38.693844236293636  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k102);
boolean k103=  ( 95.87997795122136  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 68.89548770346697  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k103);
double k104=   47.98800152645265  * (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k104);
boolean k105=  ( 78.84318274847146  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 88.47787005562195  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k105);
boolean k106=  ( 58.30589315037849  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 25.888012716847673  > (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k106);
double k107=  ( 79.33536379104218  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k107);
boolean k108=  ( 26.353690655885465  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 84.25461577069551  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k108);
boolean k109=  ( 85.68655741297653  == (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 67.67470423572807  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k109);
double k110=  ( 70.90248022017046  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k110);
double k111=  ( 54.202392223495174  * (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k111);


}else{
if( ( 58.38314140169233  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 47.103925902476654  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k112=   30.15488931418488  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k112);
}if( ( 46.86697646443392  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 62.461932973291674  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k113=  ( 17.830136451042744  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 55.29358044176761  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k113);
}}


int i114 = 0;
while(i114<1 && ( ( 76.47767360147269  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 62.97461293243244  < (inputs_num[(p_num++)%(inputs_num.length-1)])) )){

if( ( 45.546112420930086  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 25.21148974690304  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k115=  ( 38.34491974888863  * (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k115);
boolean k116=  ( 23.78897643381752  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 80.77779281975549  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k116);
boolean k117=  ( 46.10339190402394  > (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 24.161980171149064  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k117);
double k118=   43.793811844537395  + (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k118);
double k119=   73.53890398722244  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k119);
boolean k120=  ( 61.03609441899977  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 90.21740453729281  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k120);
boolean k121=  ( 48.81368585928238  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 54.20534275997467  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k121);
double k122=   76.95245617820986  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k122);
boolean k123=  ( 24.69153172013091  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 75.3725025484295  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k123);
boolean k124=  ( 14.505004462455156  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 87.46356432370405  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k124);
double k125=  ( 51.83698701945834  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k125);
boolean k126=  ( 29.64978223831416  != (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 19.713610465306168  <= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k126);


}else{
if( ( 26.044931153330594  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 53.65355804689069  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
double k127=  ( 6.3822738876148115  * (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k127);
}if( ( 3.7621778481317354  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 21.390151249517068  < (inputs_num[(p_num++)%(inputs_num.length-1)])) ){
boolean k128=  ( 73.56744460983491  >= (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 80.82416395722028  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k128);
}}


i114++;
}
i99--;
}i97--;
}i82--;
}i80--;
}i65++;
}
i63++;
}
i61++;
}
i59--;
}i57++;
}
i42--;
}i27--;
}

//////fors//////


//////Espresiones//////
double k129=   51.17271034434049  - (inputs_num[(p_num++)%(inputs_num.length-1)])  ;
result_tmp_num.add(k129);
double k130=   51.01551104217305  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k130);
double k131=  ( 37.24608360356671  + (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k131);
double k132=  ( 60.51660634737956  / (Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k132);
boolean k133=  ( 73.6638178852535  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 6.041525968129004  == (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k133);
double k134=  ( 64.75457350857819  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k134);
double k135=   14.828989724969588  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1) ;
result_tmp_num.add(k135);
double k136=  ( 4.6726667476495765  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k136);
double k137=  ( 56.173516161186356  - (inputs_num[(p_num++)%(inputs_num.length-1)]) ) ;
result_tmp_num.add(k137);
boolean k138=  ( 29.203664614354267  <= (inputs_num[(p_num++)%(inputs_num.length-1)]))  ||  ( 17.774226098065697  != (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k138);
boolean k139=  ( 10.662953190491994  < (inputs_num[(p_num++)%(inputs_num.length-1)]))  &&  ( 93.12733983739179  >= (inputs_num[(p_num++)%(inputs_num.length-1)])) ;
result_tmp_bool.add(k139);
double k140=  ( 81.76086783401301  / (-Math.abs((int)(inputs_num[(p_num++)%(inputs_num.length-1)]) )+1)) ;
result_tmp_num.add(k140);
}
public boolean[] get_result_bool(int ini, int fin ) {
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
		
	boolean[] a=new boolean[result_tmp_bool.size()];
		for (int i = ini; i < (fin<=result_tmp_bool.size()?fin : result_tmp_bool.size()); i++) {
			a[i]=result_tmp_bool.get(i);
		}
		return a;	}
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
		
		double[] a=new double[result_tmp_num.size()];
		for (int i = ini; i < (fin<=result_tmp_num.size()?fin : result_tmp_num.size()); i++) {
			a[i]=result_tmp_num.get(i);
		}
		return a;	}

}
