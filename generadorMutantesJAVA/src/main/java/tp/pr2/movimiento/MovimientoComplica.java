package tp.pr2.movimiento;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class MovimientoComplica extends Movimiento {
	private Ficha primeraFicha = Ficha.VACIA;
	public MovimientoComplica(int columna, Ficha turno){
		super(columna, turno);
	}
	public void ejecutaMovimiento(Tablero tablero)throws MovimientoInvalido{
		
	
			this.columnaCorrecta(tablero);
			this.fila= this.buscaFila(this.columna,tablero);
				
			// si la columna no esta llena
			if((this.fila>=0) && (tablero.getFicha(0,this.columna) == Ficha.VACIA) ){
				tablero.ponFicha(this.fila, this.columna, this.turno);
				
			}
			else { 	// dezplazamos hacia abajo
				int n = tablero.getFilas() -1;
				System.out.println(n);
				int c = this.columna;
				primeraFicha=  tablero.getFicha(n,this.columna) ; //para el UNdo
				for(int i = n; i > 0; i-- ) {
					Ficha aux;
					aux = tablero.getFicha(i-1 ,c );
					tablero.ponFicha(i  , c, aux);
				}	
				// ponemos la ficha en la fila superior
				tablero.ponFicha(0  , this.columna,  this.turno);	
			}
		
	}
	public void undo(Tablero tablero) throws MovimientoInvalido{
		if((tablero.getFicha(0,this.columna) == Ficha.VACIA)||(this.primeraFicha==Ficha.VACIA)){
		tablero.ponFicha(this.fila, this.columna, Ficha.VACIA);
		}else {
			for(int i=0;i<tablero.getFilas()-1;i++){
				Ficha aux;
				aux=tablero.getFicha(i+1, this.columna);
				tablero.ponFicha(i, this.columna, aux);
			}
			tablero.ponFicha(tablero.getFilas()-1, this.columna, this.primeraFicha);
		}
	}
}
