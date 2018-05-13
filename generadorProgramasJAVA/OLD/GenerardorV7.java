package tfgGroupID.tfgArtefactID;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Generardor {
	private int contVar=0;//para evitar problema de declaracion de varible con los bucles
	public String s="";
	public String programa_test="";
	public String nom_test="";
	public String nom_program="";
	public String tipo="int ";
	public int size_expLogics;
	public int size_expArit;
	public int num_exp_seguida;
	public int size_cond;
	public int num_while;
	public int num_ifs;
	public int num_for;
	public int size_while;
	public int size_for;
	public int num_funcion;
	public int[] decision_inputs;
	public int ini;//el comienzo del nivel de profundidad de probacion
	public int fin;//el fin del nivel de profundidad de probacion
	public int num_participacion_bool=0;
	public int num_participacion_int=0;
	
	public Generardor(String nom_test,String nom_program,double[] test_inputs,int[] decision_inputs,int num_ifs,
			int num_while,int size_while, int num_for, int size_for,int size_cond,
			int size_expLogics,int size_expArit,int num_exp_seguida,int num_funcion,int ini, int fin) throws Exception {
		this.nom_program=nom_program;
		this.nom_test=nom_test;
		this.size_expArit=size_expArit;
		this.size_expLogics=size_expLogics;
		this.num_exp_seguida=num_exp_seguida;
		this.size_cond=size_cond;
		this.num_while=num_while;
		this.num_for=num_for;
		this.num_ifs=num_ifs;
		this.size_for=size_for;
		this.size_while=size_while;
		this.num_funcion=num_funcion;
		this.decision_inputs=decision_inputs;
		this.ini=ini;
		this.fin=fin;


		/*
		 * generar programa testeado
		 */
		//declarar
		s="import java.util.ArrayList;\r\n" +
				"\r\n" +
				"public class "+nom_program+"{\r\n" +
				"	private int p_num=1;\r\n" +
				"	private ArrayList<Double> result_tmp_num=new ArrayList<Double>();\r\n" +
				"	private double[] result_final_num;\r\n" +
				"	private ArrayList<Boolean> result_tmp_bool=new ArrayList<Boolean>();\r\n" +
				"	private boolean[] result_final_bool;\r\n" +
				"	private double[] inputs_num;\r\n" +
				"	private int[]decisiones;///////nuevo atributo\r\n" +
				"	public "+nom_program+"(double[] inputs_num,int[] decisiones) {\r\n" +
				"		this.inputs_num=inputs_num;\r\n" +
				"		this.decisiones=decisiones;\r\n" +
				"	}\n";


		for(int i=0; i<num_funcion;i++) {

			s+="private void exe"+i+"() {\n";
			//generar codigos no bucles aleatoriamente
			int n=num_exp_seguida;
			s+=getExpresiones(n);

			//generar codigo ifs
			s+=getIfs(num_ifs)+"\n";

			//generar codigo whiles
			s+=getWhiles(num_while, size_while)+"\n";

			//generar codigo fors
			s+=getFors(num_for, size_for)+"\n";

			//generar codigos no bucles aleatoriamente
			s+=getExpresiones(n);

			//fin de funcion exe
			s+="}\n";

		}


		//otras funciones necesarios para el testing
		//get_result_bool
		s+="public boolean[] get_result_bool(int ini, int fin) {\r\n" +
				"		for(int i=0;i<decisiones.length;i++) {\r\n" +
				"			switch (decisiones[i]) {\r\n" +
				"			case 0:\r\n" +
				"				exe0();\r\n" +
				"				break;\n";

		if(num_funcion>1) {
			for(int i=1;i<num_funcion;i++) {
				s+="case "+i+":\r\n" +
						"				exe"+i+"();\r\n" +
						"				break;\n";
			}
		}

		s+="default:\r\n" +
				"				exe0();\r\n" +
				"				break;\r\n" +
				"			}\r\n" +
				"		}\r\n" +
				"		\r\n" +
				"		result_final_bool=new boolean[result_tmp_bool.size()];\r\n" +
				"		for(int i=ini;i<(fin < result_tmp_bool.size() ? fin : result_tmp_bool.size());i++) {\r\n" +
				"			result_final_bool[i]=result_tmp_bool.get(i);\r\n" +
				"		}\r\n" +
				"		return result_final_bool;\r\n" +
				"	}\n";


		//get_result_num
		s+="public double[] get_result_num(int ini, int fin) {\r\n" +
				"		for(int i=0;i<decisiones.length;i++) {\r\n" +
				"			switch (decisiones[i]) {\r\n" +
				"			case 0:\r\n" +
				"				exe0();\r\n" +
				"				break;\n";

		if(num_funcion>1) {
			for(int i=1;i<num_funcion;i++) {
				s+="case "+i+":\r\n" +
						"				exe"+i+"();\r\n" +
						"				break;\n";
			}
		}

		s+="default:\r\n" +
				"				exe0();\r\n" +
				"				break;\r\n" +
				"			}\r\n" +
				"		}\r\n" +
				"		\r\n" +
				"		result_final_num=new double[result_tmp_num.size()];\r\n" +
				"		for(int i=ini;i<(fin < result_tmp_num.size() ? fin : result_tmp_num.size());i++) {\r\n" +
				"			result_final_num[i]=result_tmp_num.get(i);\r\n" +
				"		}\r\n" +
				"		return result_final_num;\r\n" +
				"	}\n";


		s+="\n}";//cierre de la clase

		int fin_bool=0;
		int fin_int=0;
		if(ini <=fin && ini<test_inputs.length && fin<=test_inputs.length) {
			System.out.println(ini+","+fin+","+test_inputs.length);
			if(fin > num_participacion_bool+num_participacion_int) {
				System.out.println("cambio el valor de fin");
				fin_bool=num_participacion_bool-1;
				fin_int=num_participacion_int-1;
			}

			System.out.println("fin_bool:"+fin_bool+","+"fin_int"+fin_int);
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

			programa_test+="int[] decision_inputs={"+decision_inputs[0];
			for(int i=1;i<decision_inputs.length;i++) {
				programa_test+=","+decision_inputs[i];
			}
			programa_test+="};\n";


			//funcion assert
			programa_test+="assertArrayEquals(new "+nom_program+"(inputs,decision_inputs).get_result_num("+ini+","+fin_int+"),new "+nom_program+"(inputs,decision_inputs).get_result_num("+ini+","+fin_int+"),0);\r\n" +
					"		assertArrayEquals(new "+nom_program+"(inputs,decision_inputs).get_result_bool("+ini+","+fin_bool+"),new "+nom_program+"(inputs,decision_inputs).get_result_bool("+ini+","+fin_bool+"));\r\n";
			//fin de funcion test
			programa_test+="\n}";
			//fin de clase programa_test
			programa_test+="\n}";
			//////////////////////////////////////////

		}else {
			throw new Exception("error de los valores de ini y fin de comprobacion");
		}

		System.out.println(num_participacion_bool+", "+num_participacion_int);
	}

	public Generardor() {
	}

	/**
	 *
	 * @param n es el numero de expresiones seguidas
	 * @return
	 */
	public String getExpresiones(int n) {
		String s="";
		for(int i=0; i<n;i++) {
			s+=exp_simple()+"\n";
		}
		return s;
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
		//String input="(p_num<inputs_num.length ? inputs_num[p_num++] : "+getNum()+") ";
		String input="(inputs_num[(inputs_num.length-1)%(p_num++)]) ";
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
	 * num significa numero de operador aritmeticas que tiene
	 */
	public String exp_as(int num) {
		if(num==0) {
			return "";
		}
		String s=""+exp_a();
		for(int i=0;i<num-1;i++) {
			String op=op_art();
			s=s+op+getRandomArbitrary(1, 100);
		}
		return  s;
	}

	public String exp_logic() {
		//String s2=" ("+getNum()+op_rel()+"(p_num<inputs_num.length ? inputs_num[p_num++] : "+getNum()+")"+") ";
		String s2=" ("+getNum()+op_rel()+"(inputs_num[(inputs_num.length-1)%(p_num++)])) ";


		return s2;
	}

	/*
	 * num significa numero de operador logica que tiene
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




	public String condIf() {
		String s=  exp_logics(size_cond);

		return  s;
	}

	public String getIfs(int x) {
		if(x==0) {
			return getExpresiones(num_exp_seguida);
		}else {
			/*String s=getIfs(x-1);
			return  "if"+"("+condIf()+")"
			+"{\n"+getExpresiones(num_exp_seguida)+"\n"+s+"\n"+getExpresiones(num_exp_seguida)+"\n}"
			+"else "+"{\n"+getExpresiones(num_exp_seguida)+getIfs(x-1)+getExpresiones(num_exp_seguida)+"\n}";
			 */
			String s="";
			for(int i=0;i<x;i++) {
				s+="if"+"("+condIf()+"){\n"+getExpresiones(num_exp_seguida)+"\n";
			}

			for(int i=0;i<x;i++) {
				//s+="\n}"+"else{\n"+getExpresiones(num_exp_seguida)+"}\n";

				s+="\n}"+"else{\n";
				for(int j=0;j<x;j++) {
					s+="if"+"("+condIf()+"){\n"+getExpresiones(num_exp_seguida)+"\n}";

				}

				s+="}\n";
			}

			return s;
		}

	}





	public String getFors(int num_anidacion,int num_iteracion) {
		if(num_anidacion == 0) {
			return exp_simple();
		}else {
			String s="for("+condFor(num_iteracion)+"){\n"+
					getExpresiones(num_exp_seguida)+"\n"+getFors(num_anidacion-1,num_iteracion)+getExpresiones(num_exp_seguida)+"\n"+"\n}";
			return  s;
		}
	}

	public String getWhiles(int num_anidacion,int num_iteracion) {
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
			String cuerpo="\n"+getExpresiones(num_exp_seguida)+getWhiles(num_anidacion-1,num_iteracion)+getExpresiones(num_exp_seguida);

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





	public String exp_simple() {

		String s;
		String result;
		switch((int)getRandomArbitrary(0, 2)) {
		case 0:
			this.num_participacion_int++;
			s=  exp_as(this.size_expArit);
			result="double k"+contVar+"= "+s+";\n";
			result=result+"result_tmp_num.add"+"("+"k"+contVar+")"+";";
			contVar++;
			return  result;
		case 1:
			this.num_participacion_bool++;
			s=   exp_logics(this.size_expLogics);
			result="boolean k"+contVar+"= "+s+";\n";
			result=result+"result_tmp_bool.add"+"("+"k"+contVar+")"+";";
			contVar++;
			return  result;
		default:
			this.num_participacion_int++;
			s=  exp_as(this.size_expArit);
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
