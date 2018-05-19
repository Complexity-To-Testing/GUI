package tp.pr3.jugador;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;

public class JugadorAleactorioComplica extends Jugador {
	@Override
	protected void obtenFilaColumna(Tablero tab, Ficha color) {
		this.columna =(int)(tab.getColumnas()*Math.random());
	}
}
