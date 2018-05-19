package tp.pr1.logica; //Cristhian y Fabian
import tp.pr2.movimiento.Movimiento;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.exception.MovimientoInvalido;

import java.util.Stack;
public class Partida {
	
	//ATRIBUTOS
	private Ficha turno; 
	private Tablero tablero;		
	private boolean terminada;		
	public static int MAX_UNDO = 2;
	private Ficha ganador; 
	private ReglasJuego reglas;
	private Stack<Movimiento> undoStack;//
	
	//CONSTRUCTORAS
	public Partida(ReglasJuego reglas){
		this.reset(reglas);// (con arg ReglasJuego)
		
	}
	
	//METODOS
	public void setTurno(Ficha turno){
		this.turno = turno;
	}
	public ReglasJuego getReglasJuego(){
		return this.reglas;
	}
	public Ficha getGanador(){
		return ganador;
	}
	public Ficha getTurno(){
		return this.turno;
	}
	public Tablero getTablero(){
		return this.tablero;
	}
	public String toString(){
		String cadenaPartida="";
		String turn="";
		cadenaPartida = this.tablero.toString()+System.getProperty("line.separator") ;
		if(this.turno==Ficha.BLANCA){
			 turn = "Blancas";
			 cadenaPartida += "juegan  " + turn;
		}
		else if(this.turno==Ficha.NEGRA){
			 turn = "Negras";
			 cadenaPartida += "juegan  " + turn;
		 } 
		return cadenaPartida;
	}	
 	public boolean partidaTerminada(){
		if(reglas.tablas(this.tablero)){
			this.terminada = true;
		}
		return this.terminada;
	}
 
 	public void ejecutaMovimiento(Movimiento mv)  {// AREGLAR
 		
 	if(!this.terminada) {

		try {
			mv.ejecutaMovimiento(this.tablero);
		} catch (MovimientoInvalido movimientoInvalido) {
			movimientoInvalido.printStackTrace();
		}
		try {
			ganador = reglas.hayGanador(mv.getFila(), mv.getColumna(), mv.getTurno(), this.tablero);
		} catch (MovimientoInvalido movimientoInvalido) {
			movimientoInvalido.printStackTrace();
		}
		undoStack.push(mv);                    //insertar en la pila
		this.turno = reglas.siguienteTurno(this.turno);//cambiar turno

		if (Ficha.VACIA != ganador) { // HAY GANADOR
			this.terminada = true;
		} else { //NO HAY GANADOR
			this.terminada = reglas.tablas(this.tablero);
		}


	}

 	}
	public void deshacerMovimiento(Movimiento mv){ 
		boolean hayMas = false;
		hayMas=!undoStack.isEmpty();
		try {
			if(hayMas){
					mv= undoStack.pop();
					mv.undo(this.tablero);
					this.turno=reglas.siguienteTurno(this.turno);
					hayMas=!undoStack.isEmpty();

			}
		} catch (MovimientoInvalido e) {

		}
	}
	public void reset(ReglasJuego reglas){ 
		this.tablero=reglas.iniciaTablero();
		this.reglas=reglas;
		this.turno  = reglas.jugadorInicial();
		this.terminada  = false;
		reglas.ganador = Ficha.VACIA;
		this.undoStack = new Stack<Movimiento>();
	}
}
		
