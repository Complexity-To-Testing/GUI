package claseNodo.figura3D;

import claseNodo.figura2D.Circulo;

public class Esfera implements Figura3D{
	private double radio;

	

	public Esfera(double i) {
		super();
		this.radio=i;
		
	}
	
	public Esfera(Esfera e) {
		super();
		this.radio = e.radio;
	}
	
	
	public double getArea3D() {
		// TODO Auto-generated method stub
		return 4*Math.PI*radio;
	}

	
	public double getAltura() {
		// TODO Auto-generated method stub
		return getRadio()*2;
	}

	
	public double getVolumen() {
		// TODO Auto-generated method stub
		return 4.0/3.0*((int)Math.PI*Math.pow(this.getRadio(), 3));
	}

	
	public double getRadio() {
		// TODO Auto-generated method stub
		return this.radio; 
	}

	@Override
	public String toString() {
		return "Esfera [radio=" + radio + ", getArea3D()=" + getArea3D() + ", getAltura()=" + getAltura()
				+ ", getVolumen()=" + getVolumen() + ", getRadio()=" + getRadio() + "]";
	}

	
	public String getFiguraBase() {
		// TODO Auto-generated method stub
		return "no tiene base";
	}

	public Double setRadio(double i) {
		// TODO Auto-generated method stub
		this.radio=i;
		return this.radio;
	}

	
	


}
