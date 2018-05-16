package tfgGroupID.tfgArtefactID;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static int[] parse2(String args) {
		String tmp_inputs=args;
		//String s="1,2,3,4,5,6,7,8,9,10,11,12,13";
		ArrayList<Integer> tmp_inputs2=new ArrayList<Integer>();
		int p=0;
		String num="";
		while(p<tmp_inputs.length()) {
			if(tmp_inputs.charAt(p)!=',') {
				num+=tmp_inputs.charAt(p);
			}else {
				if(num!="") {
					tmp_inputs2.add(new Integer(num).intValue());
					num="";
				}
			}
			p++;
		}

		int[] test_inputs=new int[tmp_inputs2.size()];
		for (int i = 0; i < tmp_inputs2.size(); i++) {
			test_inputs[i]=tmp_inputs2.get(i);
			System.out.println(tmp_inputs2.get(i));
		}
		return test_inputs;
	}
	public static double[] parse(String args) {
		String tmp_inputs=args;
		//String s="1,2,3,4,5,6,7,8,9,10,11,12,13";
		ArrayList<Double> tmp_inputs2=new ArrayList<Double>();
		int p=0;
		String num="";
		while(p<tmp_inputs.length()) {
			if(tmp_inputs.charAt(p)!=',') {
				num+=tmp_inputs.charAt(p);
			}else {
				if(num!="") {
					tmp_inputs2.add(new Double(num).doubleValue());
					num="";
				}
			}
			p++;
		}

		double[] test_inputs=new double[tmp_inputs2.size()];
		for (int i = 0; i < tmp_inputs2.size(); i++) {
			test_inputs[i]=tmp_inputs2.get(i);
			System.out.println(tmp_inputs2.get(i));
		}
		return test_inputs;
	}

	public static void exe(String[] args ) {
		int num_ifs=(new Integer(args[0])).intValue();
		int num_while=new Integer(args[1]).intValue();
		int size_while=new Integer(args[2]).intValue();
		int num_for=new Integer(args[3]).intValue();
		int size_for=new Integer(args[4]).intValue();
		int size_cond=new Integer(args[5]).intValue();
		int size_expLogics=new Integer(args[6]).intValue();
		int size_expArit=new Integer(args[7]).intValue();
		double[] test_inputs=parse(args[8]);
		String ruta=getCurrentPath();
		String nom_test=args[10];
		String nom_program=args[11];
		int num_exp_seguida=new Integer(args[12]).intValue();
		int num_funcion=new Integer(args[13]).intValue();
		int[] decision_inputs=parse2(args[14]);//actualizdo

		System.out.println("<===============");
		System.out.println("num_ifs");
		System.out.println(num_ifs);
		System.out.println("num_while");
		System.out.println(num_while);
		System.out.println("size_while");
		System.out.println(size_while);
		System.out.println("num_for");
		System.out.println(num_for);
		System.out.println("size_for");
		System.out.println(size_for);
		System.out.println("size_cond");
		System.out.println(size_cond);
		System.out.println("size_expLogics");
		System.out.println(size_expLogics);
		System.out.println("size_expArit");
		System.out.println(size_expArit);
		System.out.println("test_inputs");

		for (int i = 0; i < test_inputs.length; i++) {
			System.out.println(test_inputs[i]);
		}

		System.out.println("ruta");
		System.out.println(ruta);
		System.out.println("nom_test");
		System.out.println(nom_test);
		System.out.println("nom_program");
		System.out.println(nom_program);
		System.out.println("num_exp_seguida");
		System.out.println(num_exp_seguida);
		System.out.println("num_funcion");
		System.out.println(num_funcion);
		System.out.println("decision_inputs");

		for (int i = 0; i < decision_inputs.length; i++) {
			System.out.println(decision_inputs[i]);
		}


		Generardor2 g=new Generardor2(nom_test, nom_program, test_inputs, decision_inputs, num_ifs, num_while, size_while,  num_for,  size_for, size_cond,
				size_expLogics, size_expArit,num_exp_seguida,num_funcion);

		GeneraFichero.crear(ruta,g.nom_test+".java",g.programa_test);
		GeneraFichero.crear(ruta,g.nom_program+".java",g.s);
	}
	
	public static void main(String[] args) {
		//debug();
		exe(args);
	};
	private static String getCurrentPath() {
		String current=null;
		try {
			current = new java.io.File( "." ).getCanonicalPath();
		} catch (IOException e) {
			System.out.println("ERROR: Error al obtener el path del fichero");
		}
		return current + "/ficherosCreados";
	}

};
