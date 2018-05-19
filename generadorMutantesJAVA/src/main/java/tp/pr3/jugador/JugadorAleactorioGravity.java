package tp.pr3.jugador;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class JugadorAleactorioGravity extends Jugador{
	@Override
	protected void obtenFilaColumna(Tablero tab, Ficha color) throws MovimientoInvalido {
		boolean fin = false;
		int columna = 0;
		int fila = 0;
		while(!(tab.completo()) && !fin){
			fila = (int)(tab.getFilas()*Math.random());
			columna = (int)(tab.getColumnas()*Math.random());
			if(tab.getFicha( fila ,columna)==Ficha.VACIA)
				fin = true;
		}
		
		this.columna = columna;
		this.fila = fila;
	}

}
