package tp.pr2.movimiento;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class MovimientoGravity extends Movimiento {

	public MovimientoGravity(int fila,int columna, Ficha turno) {
		super(fila,columna, turno);
		
	}

	@Override
	public void ejecutaMovimiento(Tablero tablero)throws MovimientoInvalido {
			this.columnaCorrecta(tablero); 
			this.filaCorrecta(tablero);
				int NColumnas= tablero.getColumnas()-1;
				int NFilas = tablero.getFilas()-1;
				
				int x = 0;
				int y = 0;
				int fx =0;
				int fy = 0;
						// tama�o de las cordenadas x ,y
						if(fila <=NFilas/2) y = fila;
							else y = NFilas - fila; 
						if(columna <= NColumnas/2) x = columna;
							else x = NColumnas - columna; 
						// imagenes de cada cordenada
						
						
						if (x > y) fx = 0;
						else if (this.columna > NColumnas/2) fx = 1;
						else if(this.columna == NColumnas/2) fx = 0;
						else if(this.columna < NColumnas/2) fx = -1;	
						
						if (y > x ) fy = 0;
						else if (this.fila > NFilas/2) fy = -1;
						else if(this.fila == NFilas/2) fy = 0;
						else if(this.fila < NFilas/2) fy = 1;	
						
						int col = 0;
						int fila = 0;
						
					if((fx==0)&&(fy==0)){ 								// si cae en el centro
						fila=this.fila;
						col=this.columna;
					}
					else if ((fx == -1) && (fy == 1)){  				
						while(tablero.getFicha(fila, col)!= Ficha.VACIA && fila <= NFilas/2 ){ fila++;col++;}
					}
					else if ((fx == 1) && (fy == 1)){col = NColumnas;
						while(tablero.getFicha(fila, col)!= Ficha.VACIA && col >= NFilas/2){ fila++; col--;}
					}
					else if ((fx == -1) && (fy == -1)){fila = NFilas;
						while(tablero.getFicha(fila, col)!= Ficha.VACIA && fila >= NFilas/2){ fila--; col++;}
					}
					else if ((fx == 1) && (fy == -1)){fila = NFilas; col = NColumnas;
						while(tablero.getFicha(fila, col)!= Ficha.VACIA && col >= NColumnas/2){ fila--; col--;}
					}
					else if (fx == 1) { fila = this.fila; col = NColumnas;
						while(tablero.getFicha(fila, col)!= Ficha.VACIA && col >= NColumnas/2){  col--;}
					}
					else if (fx == -1) { fila = this.fila; 
						while(tablero.getFicha(fila, col)!= Ficha.VACIA && col <= NColumnas/2){  col++;}
					}
					else if (fy == 1) {col = this.columna; 
					while(tablero.getFicha(fila, col)!= Ficha.VACIA && fila <= NFilas/2){  fila ++;}
					}
					else if (fy == -1) {col = this.columna; fila = NFilas;
					while(tablero.getFicha(fila, col)!= Ficha.VACIA && fila >= NFilas/2){  fila--;}
					}
					if(tablero.getFicha(this.fila, this.columna) == Ficha.VACIA){
						tablero.ponFicha(fila,col , this.turno);
						this.fila= fila;
						this.columna = col;	
					}else throw new MovimientoInvalido("Movimiento Incorrecto :  Ficha ocupada");
							
	}

	@Override
	public void undo(Tablero tablero) throws MovimientoInvalido {
		tablero.ponFicha(this.fila, this.columna, Ficha.VACIA);
	}

}
