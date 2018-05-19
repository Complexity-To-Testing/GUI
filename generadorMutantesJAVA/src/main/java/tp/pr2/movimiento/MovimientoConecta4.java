package tp.pr2.movimiento;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class MovimientoConecta4 extends Movimiento {
	
	public MovimientoConecta4(int columna, Ficha turno){
		super(columna,turno);
	}
			
	public void ejecutaMovimiento(Tablero tab)throws MovimientoInvalido{

		this.columnaCorrecta(tab);
		this.columnaLlena(tab);
			this.fila= this.buscaFila(this.columna,tab);
			if(this.fila>=0)
			tab.ponFicha(this.fila, this.columna, this.turno);
		
	}
	public void undo(Tablero tablero) throws MovimientoInvalido{
			tablero.ponFicha(this.fila, this.columna, Ficha.VACIA);
	}
}
