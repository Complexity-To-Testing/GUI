import tp.pr1.logica.Partida;
import tp.pr1.logica.TipoJuego;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.factoria.FactoriaJuego;
import tp.pr3.factoria.FactoriaJuegoComplica;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestCO {
	private static Scanner in = new Scanner(System.in);
	static FactoriaJuego factoria;
	static ReglasJuego reglas;
	static Partida p ;
	static TipoJuego tj;


	@org.junit.Test
	public void tesCO() {

		factoria  = new FactoriaJuegoComplica();
		tj=TipoJuego.CO;
		reglas = factoria.creaReglas();

		p = new Partida(reglas);

		// Movimientos
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,2,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,2,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,2,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));

		assertEquals(p.getGanador(),p.getGanador());

	}
}
