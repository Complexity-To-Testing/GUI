package tp.pr3.jugador;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;
public class JugadorAleactorioConecta4 extends Jugador {

	@Override 
	protected void obtenFilaColumna(Tablero tab, Ficha color) throws MovimientoInvalido {
		boolean fin = false;
		int columna = 0;
		while(!(tab.completo()) &&!fin){
			columna = (int)(tab.getColumnas()*Math.random());
			if(tab.getFicha(0, columna)==Ficha.VACIA)
				fin = true;
		}
		this.columna = columna;
	}
}

