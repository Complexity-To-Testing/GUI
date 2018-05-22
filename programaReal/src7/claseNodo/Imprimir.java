package claseNodo;

public class Imprimir {
	public static String imprimir(Object[] o) {
		String s="";
		for(int i=0; i<o.length;i++) {
			s+=o[i];
		}
		return s;
	}
}
