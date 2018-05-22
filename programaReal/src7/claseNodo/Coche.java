package claseNodo;

import java.util.Arrays;

import claseNodo.figura2D.*;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Figura3D;
import claseNodo.figura3D.Tetraedro;

public class Coche {
	private Circulo[] rueda;
	private Figura2D[] sillas;
	private Figura3D cuerpo;
	private String color;
	private int matricula;
	private String marca;


	public Coche(Circulo[] rueda, Cuadrado[] sillas, Cubo cuerpo, String marca, int matricula, String color) {
		super();
		this.rueda = rueda;
		this.sillas = sillas;
		this.cuerpo = cuerpo;
		this.color = color;
		this.matricula = matricula;
		this.marca=marca;
	}

	public Coche(Coche c) {
		super();
		this.rueda = c.rueda;
		this.sillas = c.sillas;
		this.cuerpo = c.cuerpo;
		this.color = c.color;
		this.matricula = c.matricula;
		this.marca=c.marca;
	}

	public String getRueda() {
		if(this.rueda==null) {
			return "no tiene rueda";
		}else {
			String s="";
			for(int i=0; i<this.rueda.length;i++) {
				s+=this.rueda[i].toString();
			}
			return s;
		}
		
	}

	public String addRueda(Circulo rueda) {
		if(rueda!=null) {
			Circulo[] tmp=new Circulo[this.rueda.length+1];
			for(int i=0; i<this.rueda.length;i++) {
				tmp[i]=this.rueda[i];
			}
			tmp[this.rueda.length]=rueda;

			this.rueda=tmp;

		}else {
			return "no tiene rueda";
		}

		String s="";
		for(int i=0; i<this.rueda.length;i++) {
			s+=this.rueda[i].toString();
		}

		return s;
	}

	public String getSillas() {
		if(this.sillas==null) {
			return "no tiene silla";
		}
		
		String s="";
		for(int i=0; i<this.sillas.length;i++) {
			s+=this.sillas[i].toString();
		}
		return s;
	}

	public String addSillas(Figura2D silla) {
		if(silla!=null) {
			Figura2D[] tmp=new Figura2D[this.sillas.length+1];
			for(int i=0;i<this.sillas.length;i++) {
				tmp[i]=sillas[i];
			}
			tmp[this.sillas.length]=silla;
			this.sillas=tmp;
		}else {
			return "no tiene sillas";
		}

		String s="";
		for(int i=0; i<this.sillas.length;i++) {
			s+=this.sillas[i].toString();
		}

		return s;

	}


	public String getCuerpo() {
		return cuerpo.toString();
	}

	public String setCuerpo(Figura3D tetraedro) {
		if(tetraedro!=null) {
			this.cuerpo=tetraedro;
		}else {
			return "no tiene cuerpo";
		}


		return this.cuerpo.toString();
	}

	public String getColor() {
		if(color!=null) {
			return color;
		}else {
			return "no tiene color";
		}

	}

	public String setColor(String color) {
		this.color = color;
		return color;
	}

	public int getMatricula() {
		return matricula;
	}

	public boolean setMatricula(int matricula) {

		this.matricula=matricula;
		return true;

	}

	public String getMarca() {
		return marca;
	}

	public String setMarca(String marca) {
		this.marca = marca;
		return this.marca;
	}



	public String toString() {
		String s="";
		if(this.rueda!=null) {
			for(int i=0;i<this.rueda.length;i++) {
				s+=this.rueda[i].toString();
			}
		}else {
			s="no tiene rueda aun";
		}



		return "Coche [rueda=" + s + ", sillas=" + Arrays.toString(sillas) + ", cuerpo=" + cuerpo
				+ ", color=" + color + ", matricula=" + matricula + ", marca=" + marca + ", getRueda()="
				+ getRueda() + ", getSillas()=" + getSillas() + ", getCuerpo()="
				+ getCuerpo() + ", getColor()=" + getColor() + ", getMatricula()=" + getMatricula() + ", getMarca()="
				+ getMarca() +  "]";
	}

}
