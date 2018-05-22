package claseNodo;

public class Posicion {
	private int x=0;
	private int y=0;
	public Posicion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int setX(int x) {
		if(x>0) {
			this.x = x;
			return x;
		}else {
			return -1;
		}
		
	}
	public int getY() {
		return y;
	}
	public int setY(int y) {
		if(y>0) {
			this.y = y;
			return y;
		}else {
			return -1;
		}
	}
	
	
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}
	
}
