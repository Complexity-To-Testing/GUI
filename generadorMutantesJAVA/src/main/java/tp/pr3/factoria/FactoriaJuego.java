package tp.pr3.factoria;


import java.util.Scanner;

import tp.pr1.logica.Ficha;
import tp.pr2.movimiento.Movimiento;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.jugador.Jugador;


	public interface FactoriaJuego{
		public abstract ReglasJuego creaReglas();
		public abstract Movimiento creaMovimiento(int fila, int col, Ficha color);
		public abstract Jugador creaJugadorAleatoria();
		public abstract Jugador creaJugadorHumano(Scanner sc);
		public abstract ReglasJuego creaReglas(int x, int y);
	}

	

