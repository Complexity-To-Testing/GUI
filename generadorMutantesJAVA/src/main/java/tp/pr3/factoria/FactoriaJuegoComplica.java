package tp.pr3.factoria;

import java.util.Scanner;

import tp.pr1.logica.Ficha;
import tp.pr2.movimiento.Movimiento;
import tp.pr2.movimiento.MovimientoComplica;
import tp.pr2.reglas.ReglasComplica;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.jugador.Jugador;
import tp.pr3.jugador.JugadorAleactorioComplica;
import tp.pr3.jugador.JugadorHumanoComplica;

public class FactoriaJuegoComplica implements FactoriaJuego{

	@Override
	public ReglasJuego creaReglas() {
		return new ReglasComplica();
	}

	@Override
	public Movimiento creaMovimiento(int fila, int col, Ficha color) {
		return new MovimientoComplica(col, color);
	}

	@Override
	public Jugador creaJugadorAleatoria() {
		return new JugadorAleactorioComplica();
	}

	@Override
	public Jugador creaJugadorHumano(Scanner sc) {
		return new JugadorHumanoComplica(sc);
	}

	@Override
	public ReglasJuego creaReglas(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
