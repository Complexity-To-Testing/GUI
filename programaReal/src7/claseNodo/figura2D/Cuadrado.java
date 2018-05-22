package claseNodo.figura2D;

public class Cuadrado implements Figura2D {
	
	private double lado=0;
	
	
	public Cuadrado(Cuadrado c) {
		super();
		this.lado = c.lado;
	}

	public Cuadrado(double lado) {
		super();
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	public double setLado(double lado) {
		
			this.lado=lado;
			return this.lado;
		
	}

	
	public double getArea2D() {
		// TODO Auto-generated method stub
		return this.lado*2;
	}

	
	public double perimetro() {
		// TODO Auto-generated method stub
		return this.lado*4;
	}

	
	public String toString() {
		return "Cuadrado [lado=" + lado + ", getLado()=" + getLado() + ", getArea2D()=" + getArea2D() + ", perimetro()="
				+ perimetro() + "]";
	}

}
