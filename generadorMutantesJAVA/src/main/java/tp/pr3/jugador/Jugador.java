package tp.pr3.jugador;

import java.util.InputMismatchException;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr2.movimiento.Movimiento;
import tp.pr3.exception.DatosIncorrectos;
import tp.pr3.exception.MovimientoInvalido;
import tp.pr3.factoria.FactoriaJuego;



abstract public class Jugador {
	// ATRIBUTOS
	protected int fila;
	protected int columna;
	
	// METODOS
	protected abstract void obtenFilaColumna(Tablero tab, Ficha color) throws MovimientoInvalido;
	public Movimiento getMovimiento(FactoriaJuego factoria,
				Tablero tab, Ficha color) throws DatosIncorrectos, MovimientoInvalido{ // lanzar error
			try{
				this.obtenFilaColumna(tab, color);
				return factoria.creaMovimiento(this.fila, this.columna, color);
			}
			catch (InputMismatchException e){
				throw new DatosIncorrectos("Los datos introducidos no son numericos");
			}
	}
}