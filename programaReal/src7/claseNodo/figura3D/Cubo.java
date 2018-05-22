package claseNodo.figura3D;

import claseNodo.figura2D.Cuadrado;

public class Cubo implements Figura3D{
	private double altura=0;
	private Cuadrado cuadrado;
	
	public Cubo(Cubo c) {
		this.altura=c.altura;
		this.cuadrado=c.cuadrado;
	}
	public Cubo(Cuadrado cuadrado, double altura) {
		super();
		this.altura = altura;
		this.cuadrado = cuadrado;
	}

	
	public double getArea3D() {
		// TODO Auto-generated method stub
		return 6*cuadrado.getArea2D();
	}

	
	public double getAltura() {
		// TODO Auto-generated method stub
		return altura;
	}

	
	public double getVolumen() {
		// TODO Auto-generated method stub
		return altura*cuadrado.getArea2D();
	}

	
	public String getFiguraBase() {
		// TODO Auto-generated method stub
		return cuadrado.toString();
	}
	
	public String toString() {
		return "Cubo [altura=" + altura + ", cuadrado=" + cuadrado + ", getArea3D()=" + getArea3D() + ", getAltura()="
				+ getAltura() + ", getVolumen()=" + getVolumen() + ", getFiguraBase()=" + getFiguraBase()
				+ "]";
	}
	public double setAltura(double i) {
		// TODO Auto-generated method stub
		if(i<0) {
			return this.altura;
		}else {
			this.altura=i;
			return this.altura;
		}
	}

	
}
