package tp.pr3.factoria;

import java.util.Scanner;

import tp.pr1.logica.Ficha;
import tp.pr2.movimiento.Movimiento;
import tp.pr2.movimiento.MovimientoGravity;
import tp.pr2.reglas.ReglasGravity;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.jugador.Jugador;
import tp.pr3.jugador.JugadorAleactorioGravity;
import tp.pr3.jugador.JugadorHumanoGravity;

public class FactoriaJuegoGravity implements FactoriaJuego {

	@Override
	public ReglasJuego creaReglas() {
		return new ReglasGravity();
	}
	@Override
	public Movimiento creaMovimiento(int fila, int col, Ficha color) {
		return new MovimientoGravity(fila, col, color);
	}

	@Override
	public Jugador creaJugadorAleatoria() {
		return new JugadorAleactorioGravity();
	}

	@Override
	public Jugador creaJugadorHumano(Scanner sc) {
		return new JugadorHumanoGravity(sc);	}


	@Override
	public ReglasJuego creaReglas(int x, int y) {
		
		return new ReglasGravity(x,y);
	}

}
