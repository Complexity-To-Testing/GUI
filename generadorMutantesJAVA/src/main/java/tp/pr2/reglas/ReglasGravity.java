package tp.pr2.reglas;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class ReglasGravity extends ReglasJuego{
	private   int FILAS =9;
	private  int COLUMNAS = 9; 
	
	// CONSTRUCTORA 
	public ReglasGravity (){
		this.ganador = Ficha.VACIA;
	}
	public ReglasGravity (int x,int y){
		this.FILAS=x;
		this.COLUMNAS=y;
		this.ganador = Ficha.VACIA;
	}
	
	@Override
	public boolean tablas(Tablero tablero) { // igual que el conecta 4
		boolean tablas=false;
		if((tablero.completo()) && (ganador==Ficha.VACIA)){
			tablas = true;
		}
		return tablas;
	}

	@Override
	public Ficha hayGanador(int fila, int columna, Ficha ultimo, Tablero tablero) throws MovimientoInvalido {
		Ficha ganador=Ficha.VACIA;
		if(ReglasJuegoCuatroEnLinea.cuatroEnLinea(tablero,ultimo,fila,columna))
			ganador=ultimo;
		
		return ganador;
	}

	@Override
	public Tablero iniciaTablero() {
		return new Tablero(FILAS,COLUMNAS);
	}
	public  void  cambiarDimension(int fila, int   col){
		this.FILAS = fila;
		this.COLUMNAS = col;
	}

}
