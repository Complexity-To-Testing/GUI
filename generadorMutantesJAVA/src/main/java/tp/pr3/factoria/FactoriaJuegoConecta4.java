package tp.pr3.factoria;

import java.util.Scanner;

import tp.pr1.logica.Ficha;
import tp.pr2.movimiento.Movimiento;
import tp.pr2.movimiento.MovimientoConecta4;
import tp.pr2.reglas.ReglasConecta4;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.jugador.Jugador;
import tp.pr3.jugador.JugadorAleactorioConecta4;
import tp.pr3.jugador.JugadorHumanoConecta4;

public class FactoriaJuegoConecta4 implements FactoriaJuego{

	@Override
	public ReglasJuego creaReglas() {
		return new ReglasConecta4();
		
	}
	@Override
	public Movimiento creaMovimiento(int fila, int col, Ficha color) {
		return new MovimientoConecta4(col, color);
	}

	@Override
	public Jugador creaJugadorAleatoria() {
		return new JugadorAleactorioConecta4();
	}


	@Override
	public Jugador creaJugadorHumano(Scanner sc) {
		return new JugadorHumanoConecta4(sc);
	}

	@Override
	public ReglasJuego creaReglas(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}
