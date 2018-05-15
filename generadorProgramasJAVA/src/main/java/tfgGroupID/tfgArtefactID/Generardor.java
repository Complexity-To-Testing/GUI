package tfgGroupID.tfgArtefactID;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;

public class Generardor {
	private int contVar=0;//para evitar problema de declaracion de varible con los bucles
	public String s="";
	public String programa_test="";
	public String[] tests;
	public String[] nom_tests;
	public int size_tests=0;
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
	public int ifsAniCuerpoBucle;
	public int aleatorio;
	public int ini=0;
	public int fin=0;
	public int inc_nivel=0;
	public Generardor(String nom_test,String nom_program,double[] test_inputs,int[] decision_inputs,int num_ifs,
			int num_while,int size_while, int num_for, int size_for,int size_cond,
			int size_expLogics,int size_expArit,int num_exp_seguida,int num_funcion,
			int size_tests,int ifsAniCuerpoBucle,int ini, int fin, int aleatorio) {

		this.nom_program=nom_program;
		this.nom_test=nom_test;
		this.aleatorio=aleatorio;
		this.ini=ini;
		this.fin=fin;
		this.num_funcion=num_funcion;
		this.decision_inputs=decision_inputs;
		this.size_tests=size_tests;
		this.tests=new String[size_tests];
		this.nom_tests=new String[size_tests];

		for(int j=0;j<size_tests;j++) {
			/*
			 * generar programa testeador
			 */
			this.nom_tests[j]=nom_test+(j);
			programa_test+="import static org.junit.Assert.*;\r\n" +
					"\r\n" +
					"import java.util.ArrayList;\r\n" +
					"\r\n" +
					"public class "+this.nom_tests[j]+"{\r\n" +
					"\r\n" +
					"	@org.junit.Test\r\n" +
					"	public void test() {\r\n" +
					"		\n";

			//declaracion de variables necesarios
			//////////codigo que mantener el numero de  inputs segun el numero de test////////////////
			programa_test+="double[] inputs={"+test_inputs[0];
			for(int i=1;i<test_inputs.length;i++) {
				programa_test+=","+test_inputs[i];
			}


			programa_test+="};\n";

			programa_test+="int[] decision_inputs={"+this.decision_inputs[0];
			//System.out.println("ini genera decision inputs: \n");
			for(int i=1;i<j+1;i++) {
				//System.out.println(this.decision_inputs[(i%this.decision_inputs.length)]+";");
				int l=this.decision_inputs.length-1;
				int pos=i%l;
				int tmp=this.decision_inputs[pos];
				programa_test+=","+tmp;
			}
			programa_test+="};\n";
			//System.out.println("fin genera decision inputs: \n");

			this.inc_nivel+=(int)this.fin/size_tests;
			//System.out.println(inc_nivel+"\n");
			//funcion assert
			programa_test+="assertArrayEquals(new "+nom_program
					+"(inputs,decision_inputs).get_result_num("+this.ini+","+(this.ini+inc_nivel)+"),"
					+ "new "+nom_program+"(inputs,decision_inputs).get_result_num("+this.ini+","+(this.ini+inc_nivel)+"),0);\r\n" +
					"		assertArrayEquals(new "+nom_program
					+"(inputs,decision_inputs).get_result_bool("+this.ini+","+(this.ini+inc_nivel)+"),"
					+ "new "+nom_program+"(inputs,decision_inputs).get_result_bool("+this.ini+","+(this.ini+inc_nivel)+"));\r\n" +
					"";
			//fin de funcion test
			programa_test+="\n}";
			//fin de clase programa_test
			programa_test+="\n}";

			this.tests[j]=programa_test;
			programa_test="";
			//////////////////////////////////////////
		}

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


		for(int i=0; i<this.num_funcion;i++) {
			if(this.aleatorio==1) {//si es 1, entonces el codigo es aleatorio
				//System.out.println("ini aleatorio!!\n");
				this.size_for=(int) getRandomArbitrary(1,size_for);
				this.size_while=(int) getRandomArbitrary(1,size_while);
				this.size_expArit=(int) getRandomArbitrary(1,size_expArit+1);
				this.size_expLogics=(int) getRandomArbitrary(1,size_expLogics+1);
				this.num_exp_seguida=(int) getRandomArbitrary(1,num_exp_seguida+1);
				this.size_cond=(int) getRandomArbitrary(1,size_cond+1);
				this.num_while=(int) getRandomArbitrary(1,num_while+1);
				this.num_for=(int) getRandomArbitrary(1,num_for+1);
				this.num_ifs=(int) getRandomArbitrary(1,num_ifs)+1;
				this.ifsAniCuerpoBucle=(int)getRandomArbitrary(1,ifsAniCuerpoBucle+1);
				//System.out.println("fin aleatorio!!\n");
			}else {
				this.size_for=size_for;
				this.size_while=size_while;
				this.size_expArit=size_expArit;
				this.size_expLogics=size_expLogics;
				this.num_exp_seguida=num_exp_seguida;
				this.size_cond=size_cond;
				this.num_while=num_while;
				this.num_for=num_for;
				this.num_ifs=num_ifs;
				this.ifsAniCuerpoBucle=ifsAniCuerpoBucle;
			}

			System.out.printf("size_expArit: %d ,size_expLogics: %d," +
					"num_exp_seguida: %d ,size_cond: %d "
					+ ",num_while: %d ,num_for: %d ,num_ifs: %d,"
					+ "ifsAniCuerpoBucle): %d \n\n",
					this.size_expArit,this.size_expLogics,
					this.num_exp_seguida,this.size_cond,this.num_while,
					this.num_for,this.num_ifs,this.ifsAniCuerpoBucle);


			s+="private void exe"+i+"() {\n";
			//generar codigos no bucles aleatoriamente

			s+=getExpresiones(this.num_exp_seguida);

			//generar codigo ifs
			s+=getIfs(this.num_ifs)+"\n";

			//generar codigo whiles
			s+=getWhiles(this.num_while, this.size_while)+"\n";

			//generar codigo fors
			s+=getFors(this.num_for, this.size_for)+"\n";

			//generar codigos no bucles aleatoriamente
			s+=getExpresiones(this.num_exp_seguida);

			//fin de funcion exe
			s+="}\n";

		}


		//otras funciones necesarios para el testing
		//get_result_bool
		s+="public boolean[] get_result_bool(int ini, int hasta_x) {\r\n" +
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
				"		for(int i=ini;i<(hasta_x<=result_tmp_bool.size()?hasta_x : result_tmp_bool.size());i++) {\r\n" +
				"			result_final_bool[i]=result_tmp_bool.get(i);\r\n" +
				"		}\r\n" +
				"		return result_final_bool;\r\n" +
				"	}\n";


		//get_result_num
		s+="public double[] get_result_num(int ini,int hasta_x) {\r\n" +
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
				"		for(int i=ini;i<(hasta_x<=result_tmp_num.size()?hasta_x : result_tmp_num.size());i++) {\r\n" +
				"			result_final_num[i]=result_tmp_num.get(i);\r\n" +
				"		}\r\n" +
				"		return result_final_num;\r\n" +
				"	}\n";


		s+="\n}";//cierre de la clase
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
		String input="(inputs_num[(p_num++)%(inputs_num.length-1)]) ";
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
		String s2=" ("+getNum()+op_rel()+"(inputs_num[(p_num++)%(inputs_num.length-1)])) ";
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
			String s="";
			for(int i=0;i<x;i++) {
				s+="if"+"("+condIf()+"){\n"+getExpresiones(num_exp_seguida) +"\n";
			}

			for(int i=0;i<x;i++) {
				s+="\n}"+"else{\n";
				for(int j=0;j<2;j++) {
					s+="if"+"("+condIf()+"){\n"+exp_simple()+"\n}";
				}
				s+="}\n";
			}
			return s;
		}
	}



	public String getFors(int num_anidacion,int num_iteracion) {
		if(num_anidacion == 0) {
			return (Math.random()>0.5 ?getExpresiones(num_exp_seguida) :  getIfs(ifsAniCuerpoBucle));
		}

		/*else {
			String s="for("+condFor(num_iteracion)+"){\n"+
					(Math.random()>0.5 ?getExpresiones(num_exp_seguida) :  ifsCuerpoBucle(ifsAniCuerpoBucle))
					+"\n"+getFors(num_anidacion-1,num_iteracion)+"\n"+
					(Math.random()>0.5 ?getExpresiones(num_exp_seguida) :  ifsCuerpoBucle(ifsAniCuerpoBucle))
					+"\n}";
			return  s;
		}	*/
		String s="";
		for(int i=1;i<num_anidacion;i++) {
			s+="for("+condFor(num_iteracion)+"){\n"+
					(Math.random()>0.5 ?getExpresiones(num_exp_seguida) :  getIfs(ifsAniCuerpoBucle))
					+"\n";
		}

		for(int i=1;i<num_anidacion;i++) {
			s+=(Math.random()>0.5 ?getExpresiones(num_exp_seguida) :  getIfs(ifsAniCuerpoBucle))
					+"\n}";
		}

		return s;
	}

	public String getWhiles(int num_anidacion,int num_iteracion) {
		String toReturn="";
		if(num_anidacion==0) {
			return exp_simple();
		}else {

			String var="i"+contVar;
			contVar++;
			String declare_var="int "+var;

			/*
			String var_resta=var+"--;";
			String var_suma=var+"++;";

			String op=(Math.random()>0.5 ? "<" :">");
			String cuerpo="\n"+(Math.random()>0.5 ?getExpresiones(num_exp_seguida) :  getIfs(ifsAniCuerpoBucle))+'\n'
					+getWhiles(num_anidacion-1,num_iteracion)
					+(Math.random()>0.5 ?getExpresiones(num_exp_seguida) :  getIfs(ifsAniCuerpoBucle));

			if(op=="<") {
				declare_var=declare_var+" = 0"+";\n";
				String finCond=var+op+num_iteracion+" "+"&&"+" ("+exp_logics(size_cond)+")";
				toReturn=declare_var+"while("+finCond+"){\n"+cuerpo+"\n"+var_suma+"\n}\n";
			}else {
				declare_var=declare_var+" = "+num_iteracion+";\n";
				String finCond=var+op+"0 "+"&&"+" ("+exp_logics(size_cond)+")";
				toReturn=declare_var+"while("+finCond+"){\n"+cuerpo+"\n"+var_resta+"\n}";
			}
			 */

			LinkedList<String> ops=new LinkedList<String>();
			LinkedList<String> vars=new LinkedList<String>();
			for(int i=0;i<num_anidacion;i++) {
				var="i"+contVar;
				 vars.add(var);
				contVar++;
				 declare_var="int "+var;


				String op=(Math.random()>0.5 ? "<" :">");
				ops.add(op);
				String cuerpo="\n"+(Math.random()>0.5 ?exp_simple() :  getIfs(ifsAniCuerpoBucle))+'\n';
				if(op=="<") {
					declare_var=declare_var+" = 0"+";\n";
					String finCond=var+op+num_iteracion+" "+"&&"+" ("+exp_logics(size_cond)+")";
					toReturn+=declare_var+"while("+finCond+"){\n"+cuerpo+"\n";
				}else {
					declare_var=declare_var+" = "+num_iteracion+";\n";
					String finCond=var+op+"0 "+"&&"+" ("+exp_logics(size_cond)+")";
					toReturn+=declare_var+"while("+finCond+"){\n"+cuerpo+"\n";
				}

			}

			for(int i=0;i<num_anidacion;i++) {
				System.out.printf("i: %d\n",i);
				String op=ops.removeLast();
				if(op=="<") {
					toReturn+=vars.removeLast()+"++;"+"\n}\n";
				}else {
					toReturn+=vars.removeLast()+"--;"+"\n}";
				}
			}
		}
		return   toReturn;
	}





	public String exp_simple() {
		String s;
		String result;
		switch((int)getRandomArbitrary(0, 2)) {
		case 0:
			s=  exp_as(this.size_expArit);
			result="double k"+contVar+"= "+s+";\n";
			result=result+"result_tmp_num.add"+"("+"k"+contVar+")"+";";
			contVar++;
			return  result;
		case 1:
			s=   exp_logics(this.size_expLogics);
			result="boolean k"+contVar+"= "+s+";\n";
			result=result+"result_tmp_bool.add"+"("+"k"+contVar+")"+";";
			contVar++;
			return  result;
		default:
			s=  exp_as(this.size_expArit);
			result="double k"+contVar+"= "+s+";\n";
			result=result+"result_tmp_num.add"+"("+"k"+contVar+")"+";";
			contVar++;
			return  result;
		}

	}

	// Returns random between [ min, max )
	public double getRandomArbitrary(int min, int max) {
		double x=(Math.random() * (max - min) + min);
		//System.out.println(x+"\n");
		return x;
	}

}
