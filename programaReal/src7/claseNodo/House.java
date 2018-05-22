package claseNodo;

import java.util.Arrays;

import claseNodo.figura3D.Figura3D;

public class House implements Direccion {
	private Figura3D[] figura3D=null;
	private Posicion posicion=null;
	private String dir;
	
	public House(Figura3D[] figura3d, Posicion posicion, String dir) {
		super();
		figura3D = figura3d;
		this.posicion = posicion;
		this.dir = dir;
	}
	


	
	public String getPos() {
		// TODO Auto-generated method stub
		if(posicion!=null) {
			return posicion.toString();
		}else {
			return "posicion es nula";
		}
		
	}

	
	public String setPos(Posicion posicion) {
		if(posicion!=null) {
			this.posicion=posicion;
			return posicion.toString();
		}else {
			return "posicion es nula";
		}
	}





	public String getFigura3D() {
		if(this.figura3D!=null) {
			String s="";
			for(int i=0; i<this.figura3D.length;i++) {
				s+=this.figura3D[i].toString();
			}
			return s;
		}else {
			return "aun no tiene figura";
		}
		
	}

	public String addFigura3D(Figura3D figura3d) {
		if(figura3d==null) {
			return "no nueva figura es null";
		}else {
			if(this.figura3D!=null) {
				Figura3D[] tmp = new Figura3D[this.figura3D.length+1];
				for(int i=0; i<this.figura3D.length;i++) {
					tmp[i]=this.figura3D[i];
				}
				tmp[this.figura3D.length]=figura3d;
			}else {
				Figura3D[] tmp = new Figura3D[1];
				tmp[0]=figura3d;
				this.figura3D=tmp;
			}
			
			String s="";
			for(int i=0; i<this.figura3D.length;i++) {
				s+=this.figura3D[i].toString();
			}
			return s;
		}
	}


	public String getDir() {
		return dir;
	}

	public String setDir(String dir) {
		if(dir!=null) {
			this.dir = dir;
			return dir;
		}else {
			return "nueva dir es nulo";
		}
		
	}

	private String getListFigura3D() {
		
			String s="";
			for(int i=0;i<this.figura3D.length;i++) {
				s+=this.figura3D[i].toString();
			}
			return s;
	}


	@Override
	public String toString() {
		return "House [figura3D=" + getListFigura3D() + ", posicion=" + posicion + ", dir=" + dir
				+ ", getPos()=" + getPos() + ", getDir()=" + getDir() + ", getFigura3D()="
				+ getFigura3D() + ", getPos()=" + getPos() + ", getDir()=" + getDir()
				+ "]";
	}

	
	
}
