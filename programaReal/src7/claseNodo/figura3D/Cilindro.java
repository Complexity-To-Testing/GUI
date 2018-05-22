package claseNodo.figura3D;

import claseNodo.figura2D.Circulo;

public class Cilindro implements Figura3D {
	Circulo c;
	private double altura=0;

	public Cilindro(Circulo c,double altura) {
		if(c != null || altura >0) {
			this.c=c;
			this.altura=altura;
		}else {
			this.c=new Circulo(3);
			this.altura=3;
		}
		
		// TODO Auto-generated constructor stub
	}
	
	

	
	public double getArea3D() {
		// TODO Auto-generated method stub
		if(c==null) {
			return 0;
		}else {
			return 2*c.getArea()+c.perimetro()*this.altura;

		}
	}

	
	public double getAltura() {
		// TODO Auto-generated method stub
		return this.altura;
	}

	
	public double getVolumen() {
		// TODO Auto-generated method stub
		if(c!=null) {
			return c.getArea()*this.altura;
		}else {
			return 0;
		}
		
	}

	
	public String getFiguraBase() {
		// TODO Auto-generated method stub
		if(c!=null) {
			return c.toString();

		}else {
			return "";
		}
	}

	
	public String toString() {
		return "Cilindro [c=" + c + ", altura=" + altura + ", getArea3D()=" + getArea3D() + ", getAltura()="
				+ getAltura() + ", getVolumen()=" + getVolumen() + ", getFiguraBase()=" + getFiguraBase()
				+  "]";
	}

	public double setAltura(double i) {
		// TODO Auto-generated method stub
		if(altura<0) {
			return this.altura;
		}else {
			this.altura=i;
			return this.altura;
		}
	}
	


	
}
