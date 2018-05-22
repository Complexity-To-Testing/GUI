package claseNodo.figura2D;

import claseNodo.Figura;

public class Circulo implements FiguraEsferica2D, Figura{
	private double radio;

	public Circulo(Circulo c) {
		this.radio=c.getRadio();
	}
	public Circulo(double radio) {
		super();
		this.radio = radio;
	}

	public double setRadio(double radio) {
		
			this.radio = radio;
			return radio;
		
		
	}
	
	public double getRadio() {
		// TODO Auto-generated method stub
		return radio;
	}

	
	public double getArea() {
		// TODO Auto-generated method stub
		if(this.radio>0) {
			return 2*Math.PI*radio;
		}else {
			return -1;
		}
	}

	
	public double perimetro() {
		// TODO Auto-generated method stub
		if(radio>0) {
			return Math.PI*Math.pow(radio, 2);
		}else {
			return -1;
		}
		
	}
	
	
	public String toString() {
		return "Circulo [radio=" + radio + ", getRadio()=" + getRadio() + ", getArea()=" + getArea() + ", perimetro()="
				+ perimetro() + "]";
	}
	
	
	
}
