package tp.pr2.reglas;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
import tp.pr3.exception.MovimientoInvalido;

public class ReglasJuegoCuatroEnLinea {
	private static int numFichIguales = 3;
	
	static public boolean cuatroEnLinea(Tablero tablero, Ficha turno,int fila, int columna) throws MovimientoInvalido{
		boolean ok = false;
		
		if(comprobarColumna(columna,tablero)){
			ok=true;
		}
		else if(comprobarFilas(fila, tablero)){
			ok=true;
		}
		else if(comprobar1Diagonal(fila,columna,tablero )){
			ok=true;
		}
		else if(comprobar2Diagonal(fila, columna,tablero)){
			ok=true;
		}
		return ok;
	}
	static private boolean comprobarColumna(int c, Tablero tablero) throws MovimientoInvalido{
		boolean encontrado=false;
				int total = 0;
				for(int i = 0; i < tablero.getFilas() - 1 && total != numFichIguales; i++){
					if(tablero.getFicha(i, c)== Ficha.VACIA){
						total=0;
					}
					else if(tablero.getFicha(i, c)==tablero.getFicha(i+1, c)){
						total++;
					}
					else{
						total=0;
					}
				}
				if(total==numFichIguales){
					encontrado=true;
				}
					
				return encontrado;
		}
	static private boolean comprobarFilas(int f, Tablero tablero) throws MovimientoInvalido{
				boolean encontrado = false;
				int total = 0;
				for(int j = 0; j < tablero.getColumnas()-1  && total != numFichIguales; j++){
						if(tablero.getFicha(f,j)== Ficha.VACIA){
							total=0;
						}
						else if(tablero.getFicha(f, j)==tablero.getFicha(f, j + 1)){
							total++;
						}
						else{
							total=0;
						}
				}
				
				if(total == numFichIguales){
						encontrado = true;
				}
			return encontrado;
	}
	static private boolean comprobar1Diagonal(int fila, int columna,Tablero tablero ) throws MovimientoInvalido{
				
				boolean encontrado = false;
				int nuevaColumna = columna;
				int nuevaFila = fila;
				int total=0;
				
				while(nuevaColumna > 0 && nuevaFila>0){
					nuevaColumna--;
					nuevaFila--;
				}
				while(nuevaColumna < tablero.getColumnas() -1 && nuevaFila <tablero.getFilas()-1 && total!=numFichIguales){
					if(tablero.getFicha( nuevaFila, nuevaColumna)==Ficha.VACIA){
						total=0;
					}
					else if (tablero.getFicha( nuevaFila, nuevaColumna)==tablero.getFicha(nuevaFila + 1, nuevaColumna + 1)){
						total++;
					
					}
					else{
						total=0;
					}
					nuevaColumna++;
					nuevaFila++;
				}
				if(total==numFichIguales){
					encontrado=true;
				}
				return encontrado;
		}
	static private boolean comprobar2Diagonal(int fila, int columna,Tablero tablero) throws MovimientoInvalido{ 
			boolean encontrado = false;
				int nuevaColumna = columna;
				int nuevaFila = fila;
				int total=0;
			    
				while(nuevaColumna <  tablero.getColumnas()-1  && nuevaFila > 0){
					nuevaColumna++;
					nuevaFila--;
				}
				while(nuevaColumna > 0 && nuevaFila <tablero.getFilas()-1 && total!=numFichIguales){
					if(tablero.getFicha(nuevaFila, nuevaColumna)==Ficha.VACIA){
						total = 0;
					}
					else if (tablero.getFicha(nuevaFila, nuevaColumna)==tablero.getFicha(nuevaFila + 1,nuevaColumna  - 1)){
						total++;
					}
					else{
						total = 0;
					}
					nuevaColumna--;
					nuevaFila++;
				}
				if(total==numFichIguales){
					encontrado=true;
				}
				return encontrado;
	}
}

