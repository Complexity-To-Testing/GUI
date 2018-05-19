import tp.pr1.logica.Partida;
import tp.pr1.logica.TipoJuego;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.factoria.FactoriaJuego;
import tp.pr3.factoria.FactoriaJuegoGravity;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestGR {
	private static Scanner in = new Scanner(System.in);
	static FactoriaJuego factoria;
	static ReglasJuego reglas;
	static Partida p ;
	static TipoJuego tj;

	@org.junit.Test
	public void tesGravity() {

		factoria  = new FactoriaJuegoGravity();
		tj=TipoJuego.GR;
		reglas = factoria.creaReglas(10,10);

		p = new Partida(reglas);

		p.ejecutaMovimiento(factoria.creaMovimiento(2,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(10,9,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(3,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(10,8,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(4,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(10,7,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(5,1,p.getTurno()));

		assertEquals(p.getGanador(), p.getGanador());
	}
}
