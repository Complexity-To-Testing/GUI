package claseNodo.personaje;

import java.util.Arrays;

import claseNodo.Coche;
import claseNodo.House;

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
		return "no tiene casa";
	}

	
	public int getNumHouse() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public String getCoche() {
		// TODO Auto-generated method stub
		return "no tiene coches";
	}

	
	public int getNumCoche() {
		// TODO Auto-generated method stub
		return 0;
	}



	
	public String toString() {
		return "Vagabundo [getHouse()=" + getHouse() + ", getNumHouse()=" + getNumHouse()
				+ ", getCoche()=" + getCoche() + ", getNumCoche()=" + getNumCoche() + ", getNombre()="
				+ getNombre() + ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", isCasado()="
				+ isCasado() + ", getDni()=" + getDni() + "]";
	}

	
}
