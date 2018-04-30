package tfgGroupID.tfgArtefactID;

 /*
  * BUG:
  * 1) dentro del cuerpo de bucle For o While o de Ifs o Else no abarca
  * otro tipo de bucle o ifs con anidacion.
  * 2) numero de expresiones simples seguidos por defecto sale 2
  * 3)el valor de los operandos numericos esta en el rango de [1-100)
  * 4)En el caso de una operacion de division, el denominador siempre es positivo mayor igual que 1
  */

 public class Generardor {
 	private int contVar=0;//para evitar problema de declaracion de varible con los bucles
 	public String s="";
 	public String programa_test="";
 	public String nom_test="";
 	public String nom_program="";
 	public String tipo="int ";
 	public int size_expLogics;
 	public int size_expArit;
 	public Generardor(String nom_test,String nom_program,double[] test_inputs,int num_ifs,
 			int num_while,int size_while, int num_for, int size_for,int size_cond,
 			int size_expLogics,int size_expArit) {
 		this.nom_program=nom_program;
 		this.nom_test=nom_test;
 		this.size_expArit=size_expArit;
 		this.size_expLogics=size_expLogics;
 		/*
 		 * generar programa testeador
 		 */
 		programa_test+="import static org.junit.Assert.*;\r\n" +
 				"\r\n" +
 				"import java.util.ArrayList;\r\n" +
 				"\r\n" +
 				"public class "+nom_test+"{\r\n" +
 				"\r\n" +
 				"	@org.junit.Test\r\n" +
 				"	public void test() {\r\n" +
 				"		\n";

 		//declaracion de variables necesarios
 		programa_test+="double[] inputs={"+test_inputs[0];
 		for(int i=1;i<test_inputs.length;i++) {
 			programa_test+=","+test_inputs[i];
 		}
 		programa_test+="};\n";

 		//funcion assert
 		programa_test+="assertArrayEquals(new "+nom_program+"(inputs).get_result_num(),new "+nom_program+"(inputs).get_result_num(),0);\r\n" +
 				"		assertArrayEquals(new "+nom_program+"(inputs).get_result_bool(),new "+nom_program+"(inputs).get_result_bool());\r\n";
 		//fin de funcion test
 		programa_test+="\n}";
 		//fin de clase programa_test
 		programa_test+="\n}";
 		//////////////////////////////////////////
 		/*
 		 * generar programa testeado
 		 */
 		//declarar
 		s="import java.util.ArrayList;\r\n" +
 				"\r\n" +
 				"public class "+nom_program +"{\r\n" +
 				"	private int p_num=0;\r\n" +
 				"	private ArrayList<Double> result_tmp_num=new ArrayList<Double>();\r\n" +
 				"	private double[] result_final_num;\r\n" +
 				"	private ArrayList<Boolean> result_tmp_bool=new ArrayList<Boolean>();\r\n" +
 				"	private boolean[] result_final_bool;\r\n" +
 				"	private double[] inputs_num;\r\n" +
 				"	public "+nom_program+"(double[] inputs_num) {\r\n" +
 				"		this.inputs_num=inputs_num;\r\n" +
 				"	}\n";


 		s+="private void exe() {\n";
 		//generar codigos no bucles aleatoriamente
 		int n=2;
 		for(int i=0; i<n;i++) {
 			s+=exp_simple()+"\n";
 		}

 		//generar codigo ifs
 		s+=getIfs(num_ifs)+"\n";

 		//generar codigo whiles
 		s+=getWhiles(num_while, size_while, size_cond)+"\n";

 		//generar codigo fors
 		s+=getFors(num_for, size_for)+"\n";

 		//generar codigos no bucles aleatoriamente
 		for(int i=0; i<n;i++) {
 			s+=exp_simple()+"\n";
 		}

 		//fin de funcion exe
 		s+="}\n";

 		//otras funciones necesarios para el testing
 		s+="public boolean[] get_result_bool() {\r\n" +
 				"		exe();\r\n" +
 				"		result_final_bool=new boolean[result_tmp_bool.size()];\r\n" +
 				"		for(int i=0;i<result_tmp_bool.size();i++) {\r\n" +
 				"			result_final_bool[i]=result_tmp_bool.get(i);\r\n" +
 				"		}\r\n" +
 				"		return result_final_bool;\r\n" +
 				"	}\r\n" +
 				"\r\n" +
 				"	public double[] get_result_num() {\r\n" +
 				"		exe();\r\n" +
 				"		result_final_num=new double[result_tmp_num.size()];\r\n" +
 				"		for(int i=0;i<result_tmp_num.size();i++) {\r\n" +
 				"			result_final_num[i]=result_tmp_num.get(i);\r\n" +
 				"		}\r\n" +
 				"		return result_final_num;\r\n" +
 				"	}\n";
 		//fin de clase
 		s+="}";
 	}

 	public Generardor() {
 	}

 	public String getBool() {
 		// TODO Auto-generated method stub
 		String s=(Math.random()>0.5 ? " true " : " false ");
 		return  s;

 	}

 	//de momento rango es entre 1 y 100
 	public String getNum() {
 		// TODO Auto-generated method stub
 		return  " "+getRandomArbitrary(1, 100)+" ";
 	}

 	public String op_logic() {
 		// TODO Auto-generated method stub
 		String s=(Math.random()>0.5 ? " && " : " || ");
 		return  s;

 	}

 	public String op_rel() {
 		// TODO Auto-generated method stub
 		switch((int)getRandomArbitrary(0, 6)) {
 		case 0:
 			return  " > ";
 		case 1:
 			return  " >= ";
 		case 2:
 			return  " < ";
 		case 3:
 			return  " <= ";
 		case 4:
 			return  " != ";
 		case 5:
 			return  " == ";

 		default:
 			return  " > ";
 		}

 	}



 	public String op_art() {
 		// TODO Auto-generated method stub
 		switch((int)getRandomArbitrary(0, 4)) {
 		case 0:
 			return  " + ";
 		case 1:
 			return  " - ";
 		case 2:
 			return  " / ";
 		case 3:
 			return  " * ";
 		default:
 			return  " + ";
 		}
 	}

 	public String exp_a() {
 		String op1=op_art();
 		String op2=op_art();
 		String s1="";
 		String s2="";
 		String input="(p_num<inputs_num.length ? inputs_num[p_num++] : 5) ";

 		if(op1!=" / ") {
 			s1=" "+getNum()+op1+input+" ";

 		}else {
 			String tmp="("+(Math.random()>0.5 ? "-" : "")+"Math.abs("+"(int)"+input+")+1"+")";
 			s1=" "+getNum()+op1+tmp+" ";
 		}

 		if(op2!=" / "){
 			s2=" ("+getNum()+op2+input+") ";
 		}else {
 			String tmp="("+(Math.random()>0.5 ? "-" : "")+"Math.abs("+"(int)"+input+")+1"+")";
 			s2=" ("+getNum()+op2+tmp+") ";
 		}


 		String s=(Math.random()>0.5 ? s1 : s2);
 		return  s;
 	}

 	/*
 	 * num significa numero de expresiones de tipo
 	 * operando operador opedando
 	 */
 	public String exp_as(int num) {
 		if(num==0) {
 			return "";
 		}
 		String s=""+exp_a();
 		for(int i=0;i<num-1;i++) {
 			String op=op_art();

 			/*if(op==" / ") {
 				String tmp="("+(Math.random()>0.5 ? "-" : "")+"Math.abs("+"(int)"+exp_a()+")+1"+")";
 				s=s+op+tmp;
 			}else {
 				s=s+op+exp_a();
 			}
 			 */
 			s=s+op+getRandomArbitrary(1, 100);
 		}
 		return  s;
 	}

 	public String exp_logic() {
 		String s2=" ("+getNum()+op_rel()+"(p_num<inputs_num.length ? inputs_num[p_num++] : 5)"+") ";
 		return s2;
 	}

 	/*
 	 * num significa numero de expresiones de tipo
 	 * operando operador opedando
 	 */
 	public String exp_logics(int num) {
 		if(num==0) {
 			return "";
 		}
 		String s=""+exp_logic();
 		for(int i=0;i<num;i++) {
 			s=s+op_logic()+exp_logic();
 		}
 		return  s;
 	}

 	/*
 	 * num es numero de iteracio
 	 *
 	 */
 	public String condFor(int i) {
 		String var="i"+contVar;
 		contVar++;

 		int ini;
 		int fin;
 		String op1=(Math.random()>0.5 ? "<" : ">");
 		String op2="";
 		if(op1=="<") {
 			op2=" ++ ";
 			ini=(int)getRandomArbitrary(0, i);
 			fin=ini+i;
 		}else {
 			op2=" -- ";
 			ini=i;
 			fin=0;
 		}

 		String s="int "+var+"="+ini+";"+var+op1+fin+";"+var+op2;
 		return  s;
 	}

 	/*
 	 * la expresion dentro de la condicion del bucle while es la combinaicon de
 	 * expresion logica basicas. El numero de la expresion logica basica es entre
 	 * 1 y 5
 	 */
 	public String condWhile() {
 		int x=(int)getRandomArbitrary(1, 6);
 		String s=(Math.random()>0.5 ?  exp_logic() :  exp_logics(x));

 		return   s;
 	}

 	/*
 	 * la expresion dentro de la condicion del if es la combinaicon de
 	 * expresion logica basicas. El numero de la expresion logica basica es entre
 	 * 1 y 5
 	 */
 	public String condIf() {

 		int x=(int)getRandomArbitrary(1, 6);
 		String s= (Math.random()>0.5 ?  exp_logic() :  exp_logics(x));

 		return  s;
 	}

 	public String getIfs(int x) {
 		if(x==0) {
 			return exp_simple();
 		}else {
 			String s=getIfs(x-1);
 			return  "if"+"("+condIf()+")"
 			+"{\n"+exp_simple()+"\n"+s+"\n"+exp_simple()+"\n}"
 			+"else "+"{\n"+exp_simple()+getIfs((int)getRandomArbitrary(0, x-1))+exp_simple()+"\n}";
 		}
 	}



 	public String getFors(int num_anidacion,int num_iteracion) {
 		if(num_anidacion == 0) {
 			return exp_simple();
 		}else {
 			String s="for("+condFor(num_iteracion)+"){\n"+
 					exp_simple()+"\n"+getFors(num_anidacion-1,num_iteracion)+exp_simple()+"\n"+"\n}";
 			return  s;
 		}
 	}

 	//la longitud de la expresion dentro del la condicion bucle while
 	public String getWhiles(int num_anidacion,int num_iteracion, int size_cond) {
 		String toReturn="";
 		if(num_anidacion==0) {
 			return exp_simple();
 		}else {
 			String var="i"+contVar;
 			contVar++;
 			String declare_var="int "+var;
 			String var_resta=var+"--;";
 			String var_suma=var+"++;";
 			String op=(Math.random()>0.5 ? "<" :">");
 			String cuerpo="\n"+exp_simple()+getWhiles(num_anidacion-1,num_iteracion,size_cond)+exp_simple();

 			if(op=="<") {
 				declare_var=declare_var+" = 0"+";\n";
 				String finCond=var+op+num_iteracion+" "+"&&"+" ("+exp_logics(size_cond)+")";
 				toReturn=declare_var+"while("+finCond+"){\n"+cuerpo+"\n"+var_suma+"\n}\n";
 			}else {
 				declare_var=declare_var+" = "+num_iteracion+";\n";
 				String finCond=var+op+"0 "+"&&"+" ("+exp_logics(size_cond)+")";
 				toReturn=declare_var+"while("+finCond+"){\n"+cuerpo+"\n"+var_resta+"\n}";
 			}



 		}
 		return   toReturn;
 	}




 	/*
 	 * Bug, no incluye bucles ni Ifs
 	 * Como son expresiones completas de tipo var = expresion,
 	 * la variable var puede ser el valor que se usa para testing
 	 */
 	public String exp_simple() {
 		// exp_as | exp_logics | exp_a | exp_logic
 		String s;
 		String result;
 		switch((int)getRandomArbitrary(0, 2)) {
 		case 0:
 			s=  exp_as((int)getRandomArbitrary(1,this.size_expArit+1));
 			result="double k"+contVar+"= "+s+";\n";
 			result=result+"result_tmp_num.add"+"("+"k"+contVar+")"+";";
 			contVar++;
 			return  result;
 		case 1:
 			s=   exp_logics((int)getRandomArbitrary(1,this.size_expLogics+1));
 			result="boolean k"+contVar+"= "+s+";\n";
 			result=result+"result_tmp_bool.add"+"("+"k"+contVar+")"+";";
 			contVar++;
 			return  result;
 		default:
 			s=  exp_as((int)getRandomArbitrary(1,this.size_expArit+1));
 			result="double k"+contVar+"= "+s+";\n";
 			result=result+"result_tmp_num.add"+"("+"k"+contVar+")"+";";
 			contVar++;
 			return  result;
 		}

 	}

 	// Returns random between [ min, max )
 	public double getRandomArbitrary(int min, int max) {
 		return  (Math.random() * (max - min) + min);
 	}
 }
