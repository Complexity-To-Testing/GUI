package tp.pr2.reglas;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public abstract class ReglasJuego {
	
	public Ficha ganador;
	//METODOS
	public Ficha jugadorInicial(){
		return Ficha.BLANCA;
	}
	public Ficha siguienteTurno(Ficha ultimo) {
		if(ultimo==Ficha.BLANCA)
			ultimo = Ficha.NEGRA;
		else ultimo = Ficha.BLANCA;	
		return ultimo;
	}	
	//METODOS ABSTRACTOS
	public abstract boolean tablas(Tablero tablero);
	public abstract Ficha hayGanador(int fila, int columna, Ficha ultimo, Tablero tablero) throws MovimientoInvalido;
	public abstract Tablero iniciaTablero();
	public abstract void  cambiarDimension(int fila, int   col);
}
