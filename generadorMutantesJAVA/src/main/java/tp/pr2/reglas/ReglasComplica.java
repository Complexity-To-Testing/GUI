package tp.pr2.reglas;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class ReglasComplica extends ReglasJuego {
	
	private final static int FILAS =7; // 7
	private final static int COLUMNAS = 4; 
	
	public ReglasComplica(){
		this.ganador = Ficha.VACIA;
	}
	public Tablero iniciaTablero() {	
		return new Tablero(FILAS,COLUMNAS);
	}

	public boolean tablas(Tablero tablero) {
		boolean tablas=false;
		return tablas;
	}

	public Ficha hayGanador(int fila, int columna, Ficha ultimo, Tablero tablero) throws MovimientoInvalido {
		int numGanNegras = 0, numGanBlancas = 0;
		Ficha ganador = Ficha.VACIA;
		
		for(int i = 0; i < FILAS; i++){
			for(int j = 0; j <COLUMNAS; j++){	
					ganador = Ficha.VACIA;
				if(ReglasJuegoCuatroEnLinea.cuatroEnLinea(tablero,ultimo,i,j)){
					if (tablero.getFicha(i ,j ) == Ficha.BLANCA){
						numGanBlancas ++;
					}else if  (tablero.getFicha(i ,j ) == Ficha.NEGRA)
						numGanNegras++;
				}	
			}
		}
		
		if (numGanNegras >numGanBlancas)
			ganador = Ficha.NEGRA;
		else if (numGanBlancas >numGanNegras)
			ganador = Ficha.BLANCA;
		else 
			ganador = Ficha.VACIA;
		return ganador;
	}
	@Override
	public void cambiarDimension(int fila, int col) {
		// TODO Auto-generated method stub
		
	}
}
