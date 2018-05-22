package claseNodo.figura2D;


public class Rectangulo implements Figura2D {
	private double ladoCorto=0;
	private double ladoLargo=0;

	public Rectangulo(double ladoCorto, double ladoLargo) {
		super();
		if(ladoCorto<0 || ladoLargo<0) {

			this.ladoCorto = 10;
			this.ladoLargo = 10;
		}else {
			if(ladoCorto < ladoLargo ) {
				this.ladoCorto = ladoCorto;
				this.ladoLargo = ladoLargo;
			}else {
				this.ladoCorto =ladoLargo;
				this.ladoLargo = ladoCorto;
			}
			
		}

	}

	public Rectangulo(Rectangulo r) {
		if(r!=null) {
			ladoLargo=r.getLadoLargo();
			ladoCorto=r.getLadoCorto();
		}


	}


	public double getArea2D() {
		// TODO Auto-generated method stub
		return ladoCorto*ladoLargo;
	}


	public double perimetro() {
		// TODO Auto-generated method stub
		return ladoCorto*2+ladoLargo*2;
	}


	public double getLadoCorto() {
		return ladoCorto;
	}

	public double setLadoCorto(double ladoCorto) {
		
			this.ladoCorto = ladoCorto;
			return this.ladoCorto;
		

	}

	public double getLadoLargo() {
		return ladoLargo;
	}

	public double setLadoLargo(double ladoLargo) {
		
			this.ladoLargo = ladoLargo;
			return this.ladoLargo;
		
		
	}


	public String toString() {
		return "Rectangulo [ladoCorto=" + ladoCorto + ", ladoLargo=" + ladoLargo + ", getArea2D()=" + getArea2D()
		+ ", perimetro()=" + perimetro() + ", getLadoCorto()=" + getLadoCorto() + ", getLadoLargo()="
		+ getLadoLargo() + "]";
	}



}
