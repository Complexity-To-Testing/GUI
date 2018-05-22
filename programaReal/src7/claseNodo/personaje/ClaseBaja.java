package claseNodo.personaje;

import java.util.Arrays;

import claseNodo.Coche;
import claseNodo.House;
import claseNodo.Imprimir;

public class ClaseBaja extends Persona{
	private House[] house=new House[1];
	private Coche[] coche=null;
	

	public ClaseBaja(House h, String nombre, String apellidos, int edad, boolean casado, String dni) {
		super(nombre, apellidos, edad, casado, dni);
		house[0]=h;
		// TODO Auto-generated constructor stub
	}   
   
	
	public String getHouse() {
		// TODO Auto-generated method stub
		String s="";
		for(int i=0; i<house.length;i++) {
			s+=house[i];
		}
		return s;
	}

	

	
	public int getNumHouse() {
		// TODO Auto-generated method stub
		return this.house.length;
	}
	
	public String setHouse(House nuevo) {
		if(nuevo!=null) {
			this.house[0]=nuevo;
			return this.house.toString();
		}else {
			return this.house.toString();
		}
	}

	public String addHouse(House nueva) {
		House[] tmp=new House[this.house.length+1];
		for(int i=0;i<this.house.length;i++) {
			tmp[i]=this.house[i];
		}
		
		tmp[tmp.length-1]=nueva;
		this.house=tmp;
		
		String s="";
		for(int i=0;i<house.length;i++) {
			s+=house[i].toString();
		}
		System.out.println(s);
		return s;
	}
	
	
	public String getCoche() {
		// TODO Auto-generated method stub
		if(this.coche!=null) {
			String s="";
			for(int i=0; i<this.coche.length;i++) {
				s+=this.coche[i].toString();
			}
			return s;
		}
		
		return "no tiene coche";
	}
	
	public String setCoche(Coche nuevo) {
		if(nuevo!=null) {
			this.coche=new Coche[1];
			coche[0]=nuevo;
			return this.coche[0].toString();
		}
		return "no tiene coche";
	}

	
	public int getNumCoche() {
		// TODO Auto-generated method stub
		if(this.coche==null) {
			return 0;
		}else {
			return this.coche.length;
		}
		
	}

	@Override
	public String toString() {
		return "ClaseBaja [house=" + Arrays.toString(house) + ", coche=" + Arrays.toString(coche) + ", getHouse()="
				+ getHouse() + ", getNumHouse()=" + getNumHouse() + ", getCoche()="
				+ getCoche() + ", getNumCoche()=" + getNumCoche() + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", isCasado()=" + isCasado()
				+ ", getDni()=" + getDni() + "]";
	}
	
}

