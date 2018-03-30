package claseNodo.figura2D;


public class Triangulo implements Figura2D{
	private double ladoBase=0;
	private double altura=0;
	private double lateralIz=0;
	private double lateralDer=0;

	public Triangulo(double ladoBase, double altura, double lateralIz, double lateralDer) {
		super();
		if(ladoBase>lateralIz+lateralDer) {
			this.ladoBase = 3;
			this.altura = 3*Math.sin(1.5);
			this.lateralIz = 3;
			this.lateralDer = 3;
		}{
			if(altura < lateralIz && altura < lateralDer) {
				this.ladoBase = ladoBase;
				this.altura = altura;
				this.lateralIz = lateralIz;
				this.lateralDer = lateralDer;
			}else {
				this.ladoBase = 12;
				this.altura = 12*Math.sin(6);
				this.lateralIz = 12;
				this.lateralDer = 12;
			}
			
		}

	}

	public Triangulo(Triangulo t) {
		this.ladoBase = t.ladoBase;
		this.altura = t.altura;
		this.lateralIz = t.lateralIz;
		this.lateralDer = t.lateralDer;
	}


	public double getArea2D() {
		// TODO Auto-generated method stub
		return ladoBase*altura;
	}


	public double perimetro() {
		// TODO Auto-generated method stub
		return lateralIz+lateralDer+ladoBase;
	}


	public String toString() {
		return "Triangulo [ladoBase=" + ladoBase + ", altura=" + altura + ", lateralIz=" + lateralIz + ", lateralDer="
				+ lateralDer + ", getArea2D()=" + getArea2D() + ", perimetro()=" + perimetro() + "]";
	}

	public double setBase(double i) {
		// TODO Auto-generated method stub
		if(i>lateralIz+lateralDer) {
			return this.ladoBase;
		}else {
			this.ladoBase=i;
			return this.ladoBase;
		}
		
	}

	public double setLadoIz(double i) {
		// TODO Auto-generated method stub
		if(this.ladoBase>i+lateralDer) {
			return this.lateralIz;
		}else {
			this.lateralIz=i;
			return this.lateralIz;
		}
	}

	public double setLadoDer(int i) {
		// TODO Auto-generated method stub
		if(this.ladoBase>lateralDer+i) {
			return this.lateralDer;
		}else {
			this.lateralDer=i;
			return this.lateralDer;
		}
	}



}
