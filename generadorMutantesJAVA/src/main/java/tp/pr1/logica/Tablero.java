package tp.pr1.logica; //Cristhian y Fabian

import tp.pr3.exception.MovimientoInvalido;

public class Tablero {

	// ATRIBUTOS
	private int filas;
	private int columnas;
	private Ficha[][] tablero;
	
	//CONSTRUCTORA
	public Tablero (int nf, int nc){

		this.filas =nf;
		this.columnas =nc;
		this.tablero = new Ficha[this.filas][this.columnas];
		 reset();
	}
	
	// METODOS
	public void reset(){
		for(int j=0; j < this.columnas; j++){
			for (int i = 0; i < this.filas; i ++){
				this.tablero[i][j] = Ficha.VACIA;
			}
		}
	}
	

	public void ponFicha(int f, int c, Ficha ficha) throws MovimientoInvalido{
		if ((f < this.filas && f >= 0)&& (c < this.columnas && c >= 0)){
			this.tablero[f][c] = ficha;
		}
		else{String ms = "";
			if (!(f < this.filas && f >= 0))  ms = "La Columna  " + this.columnas+1;
			else 	if (!(c < this.columnas && c >= 0) ) ms = "La fila  " + this.filas +1;
			
			throw new MovimientoInvalido( ms +" es Incorrecta ");
		} 
		
	}
	public boolean completo(){
		boolean completo = false;
		int j =0;
		int tamano = this.filas *this.columnas;
		int cont =0;
		while(( j < this.filas)){
			int i=0;
			while((i<this.columnas)){
				if(this.tablero[j][i]!=Ficha.VACIA){
					cont ++;
				}
				i++;
			}
			j++;
		}
		if(cont == tamano){
			completo = true;
		}
		return completo;
	}
	
	//Implementacion de la interfaz TableroSoloLectura

	public Ficha getFicha(int f, int c) throws MovimientoInvalido{
		if ((f < this.filas && f >= 0)&& (c < this.columnas && c >= 0)){
			return this.tablero[f][c];
		}
		else {String ms = "";
			if (!(f < this.filas && f >= 0))  ms = "La Columna  " + this.columnas+1;
			else 	if (!(c < this.columnas && c >= 0) ) ms = "La fila  " + this.filas +1;
			throw new MovimientoInvalido( " No es posible acceder a :" + ms );
		}
	}
	public int getFilas(){
		return this.filas;
	}
	public int getColumnas(){
		return this.columnas;
	}
	public String toString(){
		String aux="";
		aux = aux + System.getProperty("line.separator");
		aux += "  ";
		for(int i=1;i<this.getColumnas()+1;i++){
			aux+=" "+i;
		}
		aux = aux + System.getProperty("line.separator");
		for(int i=0;i<this.getFilas();i++){
			if(i<9)
				aux +=  i+1 +" |" ;
			else
				aux +=  i+1 +"|" ;
			for(int j = 0;j<this.getColumnas();j++){
				
				 try {
					if(this.getFicha(i, j)==Ficha.BLANCA){
						 aux = aux + "B ";
					 }
				} catch (MovimientoInvalido e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					if(this.getFicha(i, j)==Ficha.NEGRA){
						 aux = aux + "N ";
						 }
				} catch (MovimientoInvalido e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 try {
					if(this.getFicha(i, j)==Ficha.VACIA){
						 aux = aux +  "  ";
						 }
				} catch (MovimientoInvalido e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				}
			aux += "|";
			aux = aux + System.getProperty("line.separator");
		}
		aux+="  +";
		for(int i=0;i<this.getColumnas();i++){
			aux+="--";
		}
		aux+="+"+System.getProperty("line.separator" );
		

		 return aux;
	}
}
