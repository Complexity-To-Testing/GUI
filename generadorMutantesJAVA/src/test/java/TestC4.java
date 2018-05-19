import tp.pr1.logica.Partida;
import tp.pr1.logica.TipoJuego;
import tp.pr2.reglas.ReglasJuego;
import tp.pr3.factoria.FactoriaJuego;
import tp.pr3.factoria.FactoriaJuegoConecta4;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestC4 {
	private static Scanner in = new Scanner(System.in);
	static FactoriaJuego factoria;
	static ReglasJuego reglas;
	static Partida p ;
	static TipoJuego tj;

	/* Test Conecta 4*/
	@org.junit.Test
	public void tesC4() {
		factoria  = new FactoriaJuegoConecta4();
		tj=TipoJuego.C4;
		reglas = factoria.creaReglas();
        p = new Partida(reglas);

        //c= new ControladorConsola(factoria,p, in,tj);
        //vc = new VistaConsola(p, "Conecta 4");
        //c.run();

		// Movimientos
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,2,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,2,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,2,p.getTurno()));
		p.ejecutaMovimiento(factoria.creaMovimiento(0,1,p.getTurno()));

		assertEquals(p.getGanador(), p.getGanador());
	}
}
