package tp.pr2.movimiento;
import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.ColumnaIncorrecta;
import tp.pr3.exception.ColumnaLlena;
import tp.pr3.exception.FilaIncorrecta;
import tp.pr3.exception.MovimientoInvalido;


public abstract class Movimiento {
	// ATRIBUTOS 
	protected int columna;
	protected Ficha turno;
	protected int fila;
	
	// 	CONSTRUCTORA 
	public Movimiento(int columna, Ficha turno){
		this.columna=columna;
		this.turno=turno;
		}
	public Movimiento(int fila,int columna, Ficha turno){ // constructora para gravity
		this.columna=columna;
		this.turno=turno;
		this.fila = fila;
		}
	// METODOS 
	public abstract void ejecutaMovimiento(Tablero tablero) throws MovimientoInvalido;
	public abstract void undo(Tablero tablero) throws MovimientoInvalido;
	public Ficha getTurno(){
		return this.turno;
	}
	public  int buscaFila(int c, Tablero tablero) throws MovimientoInvalido{
		int fila =tablero.getFilas()-1;
		Ficha fichaAux = tablero.getFicha(fila,c);
		boolean terminado = false;
		if ((tablero.getFicha(0, c)) == Ficha.VACIA){
			while((fichaAux!=Ficha.VACIA) && !terminado ){
				fila--;
				if(fila >= 0) {
				fichaAux = tablero.getFicha(fila,c);
				}
				else terminado = true;
			}
		}
		else fila = 0;

		return fila;
	}
	public int getColumna(){
		return this.columna;
	}
	public int getFila(){
		return this.fila;
	}
	public Ficha getJugador(){ 
		return this.turno; 
	}
	public void columnaCorrecta(Tablero tab)throws ColumnaIncorrecta{
		if (columna < tab.getColumnas() && columna >= 0){
			
		}
		else throw new ColumnaIncorrecta("la columna "  + (this.columna+1) +" es Incorrecta ");
	}
	public void filaCorrecta(Tablero tab)throws FilaIncorrecta{
		if (fila < tab.getFilas() && fila >= 0){
			
		}else throw new FilaIncorrecta("La fila " + (this.fila+1) +" es Inorrecta " );
		
		
	}
	public void columnaLlena(Tablero tab)throws MovimientoInvalido{
		if (tab.getFicha(0, columna) == Ficha.VACIA){
			
		}
		else throw new ColumnaLlena("La columna " +(this.columna+1) +" esta llena !!");
			
	}
	
}
