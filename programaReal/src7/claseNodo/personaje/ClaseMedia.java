package claseNodo.personaje;

import java.util.Arrays;

import claseNodo.Coche;
import claseNodo.House;
import claseNodo.Imprimir;

public class ClaseMedia extends Persona{
	private House[] house=new House[1];
	private Coche[] coche=new Coche[1];

	public ClaseMedia(Coche c, House h,String nombre, String apellidos, int edad, boolean casado, String dni) {
		super(nombre, apellidos, edad, casado, dni);
		coche[0]=c;
		house[0]=h;
		// TODO Auto-generated constructor stub
	}

	public String setHouse(House nuevo) {
		if(nuevo!=null) {
			if(this.house[0]!=null) {
				this.house[0]=nuevo;
				return this.house[0].toString();
			}else {
				return "no tiene casa para sustituir";
			}
		}else {
			return "no ha sido poder construir una casa";
		}
	}

	public String getHouse() {
		// TODO Auto-generated method stub
		if(this.house[0]!=null) {
			String s="";
			for(int i=0; i<house.length;i++) {
				s+=house[i].toString();
			}
			return s;
		}else {
			return "no tiene casa";
		}
		
	}


	public int getNumHouse() {
		// TODO Auto-generated method stub
		if(this.house[0]==null) {
			return 0;
		}else {
			return house.length;
		}
		
	}


	public String getCoche() {
		// TODO Auto-generated method stub
		if(this.coche[0]!=null) {
			String s="";
			for(int i=0; i<coche.length;i++) {
				s+=coche[i].toString();
			}
			return s;
		}else {
			return "no tiene coche";
		}
	}

		public int getNumCoche() {
			// TODO Auto-generated method stub
			if(this.coche[0]==null) {
				return 0;
			}else {
				return this.coche.length;
			}
			
		}


		public String toString() {
			return "ClaseMedia [house=" + Arrays.toString(house) + ", coche=" + Arrays.toString(coche) + ", getHouse()="
					+ getHouse() + ", getNumHouse()=" + getNumHouse() + ", getCoche()="
					+ getCoche() + ", getNumCoche()=" + getNumCoche() + ", getNombre()=" + getNombre()
					+ ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", isCasado()=" + isCasado()
					+ ", getDni()=" + getDni() + "]";
		}

		public String setCoche(Coche coche2) {
			// TODO Auto-generated method stub
			if(coche2!=null) {
				if(this.coche[0]!=null) {
					this.coche[0]=coche2;
					return this.coche[0].toString();
				}else {
					return "no tiene coche";
				}
			}else {
				return "no tiene coche";
			}

		}

		public String addCoche(Coche nueva) {
			Coche[] tmp=new Coche[this.house.length+1];
			for(int i=0;i<this.house.length;i++) {
				tmp[i]=coche[i];
			}

			tmp[tmp.length-1]=nueva;
			this.coche=tmp;

			String s="";
			for(int i=0; i<this.coche.length;i++) {
				s+=this.coche[i].toString();
			}

			return s;
		}


	}
