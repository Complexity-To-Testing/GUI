package claseNodo.figura3D;

import claseNodo.figura2D.Cuadrado;
import claseNodo.figura2D.Rectangulo;

public class Tetraedro implements Figura3D  {
	private Rectangulo rectangulo;
	private double altura=0;
	
	
	public Tetraedro(Rectangulo rectangulo, double altura) {
		super();
		this.rectangulo = rectangulo;
		this.altura = altura;
	}


	public double getArea3D() {
		// TODO Auto-generated method stub
		return 4*rectangulo.getArea2D();
	}

	
	public double getAltura() {
		// TODO Auto-generated method stub
		return altura;
	}

	
	public double getVolumen() {
		// TODO Auto-generated method stub
		return Math.sqrt(2)/12*Math.pow(rectangulo.getLadoLargo(), 2);
	}

	
	public String getFiguraBase() {
		// TODO Auto-generated method stub
		return rectangulo.toString();
	}

	
	public String toString() {
		return "Tetraedro [rectangulo=" + rectangulo + ", altura=" + altura + ", getArea3D()=" + getArea3D()
				+ ", getAltura()=" + getAltura() + ", getVolumen()=" + getVolumen() + ", getFiguraBase()="
				+ getFiguraBase() +  "]";
	}


	public double setAltura(double i) {
		// TODO Auto-generated method stub
		altura=i;
		return altura;
	}

	
}
