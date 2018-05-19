package tp.pr2.reglas;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class ReglasConecta4 extends ReglasJuego {
	private final static int FILAS = 6; 
	private final static int COLUMNAS = 5; 
	
	public ReglasConecta4(){
		this.ganador = Ficha.VACIA;
	}
	
	public Tablero iniciaTablero(){
		
		return new Tablero(FILAS,COLUMNAS);
	}

	public boolean tablas(Tablero tablero){
		boolean tablas=false;
		if((tablero.completo()) && (ganador==Ficha.VACIA)){
			tablas = true;
		}
		return tablas;
	}
	public Ficha hayGanador(int fila, int columna, Ficha ultimo, Tablero tablero) throws MovimientoInvalido{
		Ficha ganador=Ficha.VACIA;
		if(ReglasJuegoCuatroEnLinea.cuatroEnLinea(tablero,ultimo,fila,columna))
			ganador=ultimo;
		
		return ganador;
	}

	@Override
	public void cambiarDimension(int fila, int col) {
		// TODO Auto-generated method stub
		
	}
}
