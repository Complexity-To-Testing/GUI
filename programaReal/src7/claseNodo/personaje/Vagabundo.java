package claseNodo.personaje;

import java.util.Arrays;

import claseNodo.Coche;
import claseNodo.House;
import claseNodo.Posicion;
import claseNodo.figura2D.Circulo;
import claseNodo.figura2D.Cuadrado;
import claseNodo.figura2D.Rectangulo;
import claseNodo.figura3D.Cubo;
import claseNodo.figura3D.Figura3D;
import claseNodo.figura3D.Tetraedro;

public class Vagabundo extends Persona{
	private House[] houses=null;
	private Coche[] coche=null;

	public Vagabundo(String nombre, String apellidos, int edad, boolean casado, String dni) {
		super(nombre, apellidos, edad, casado, dni);

		if(edad <0) {
			this.setEdad(10);
		}
		// TODO Auto-generated constructor stub
	}

	

	
	public String getHouse() {
		// TODO Auto-generated method stub
		if(super.getEdad()>40) {
			Cubo cubo=new Cubo(new Cuadrado(22.2),12.8);
			Tetraedro tedraedro=new Tetraedro(new Rectangulo(12, 13), 4);
			Figura3D figura3D[]={cubo,tedraedro};
			this.houses=new House[1];
			this.houses[0]=new House(figura3D,new Posicion(1,1),"xyz");
			if(super.getEdad()>50) {
				this.houses=null;
				return "no house";
			}else {
				return "1";
			}
		}else {
			return "no tiene casa";
		}
		
	}

	
	public int getNumHouse() {
		// TODO Auto-generated method stub
		if(houses==null) {
			return 0;
		}else {
			return houses.length;
		}
	}

	
	public String getCoche() {
		// TODO Auto-generated method stub
		if(getEdad()>40) {
			Circulo[] ruedas= {new Circulo(2),new Circulo(2),new Circulo(2),new Circulo(2)};
			Cuadrado[] sillas= {new Cuadrado(1),new Cuadrado(1),new Cuadrado(1),new Cuadrado(1)};
			Cubo cuerpo=new Cubo(new Cuadrado(2),12);
			Coche[] coches= {new Coche(ruedas,sillas,cuerpo,"honda",1234,"negro"),new Coche(ruedas,sillas,cuerpo,"mercedes",1234,"negro")};
			this.coche=coches;
			if(getEdad()>60) {
				this.coche=null;
				return "0";
			}
			else {
				return "2";
			}
		}
		return "0";
	}

	
	public int getNumCoche() {
		// TODO Auto-generated method stub
		if(this.coche!=null) {
			return this.coche.length;
		}else {
			return 0;
		}
		
	}



	
	public String toString() {
		return "Vagabundo [getHouse()=" + getHouse() + ", getNumHouse()=" + getNumHouse()
				+ ", getCoche()=" + getCoche() + ", getNumCoche()=" + getNumCoche() + ", getNombre()="
				+ getNombre() + ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", isCasado()="
				+ isCasado() + ", getDni()=" + getDni() + "]";
	}

	
}
