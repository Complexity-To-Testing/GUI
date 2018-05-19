package tp.pr1.main; //Cristhian y Fabian
import tp.pr1.logica.Partida;
import tp.pr1.logica.TipoJuego;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.factoria.FactoriaJuego;
import tp.pr3.factoria.FactoriaJuegoComplica;
import tp.pr3.factoria.FactoriaJuegoConecta4;
import tp.pr3.factoria.FactoriaJuegoGravity;

import java.util.Scanner;


public class Main {
	private static Scanner in = new Scanner(System.in);
		static FactoriaJuego factoria;
		static ReglasJuego reglas;
		static Partida p ;
		static TipoJuego tj;
		
	public static void main(String[] args){


		//jugarC4();
		//InterfazConsola("CONECTA 4");

		/*
		jugarCO();
		InterfazConsola("COMPLICA");
		*/

		jugarGR(10,10);
		//InterfazConsola("GRAVITY");

		
	}

	private static void jugarC4 () {
		
		factoria  = new FactoriaJuegoConecta4(); 		
		tj=TipoJuego.C4;							
		reglas = factoria.creaReglas();
		
	}
	private static void jugarCO () {

		factoria  = new FactoriaJuegoComplica(); 	
		tj=TipoJuego.CO;
		reglas = factoria.creaReglas();
	}
	private static void jugarGR(int x, int y) {
		if (x == 0 && y == 0) {
			factoria = new FactoriaJuegoGravity();
			tj = TipoJuego.GR;
			reglas = factoria.creaReglas();
		} else {
			factoria = new FactoriaJuegoGravity();
			tj = TipoJuego.GR;
			int col = y;
			int fila = x;
			reglas = factoria.creaReglas(fila, col);
		}
	}
}
