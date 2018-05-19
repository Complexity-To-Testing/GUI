package tp.pr3.jugador;

import java.util.Scanner;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;

public class JugadorHumanoComplica extends Jugador {

	private Scanner sc;
	
	public JugadorHumanoComplica(Scanner sc){
		this.sc=sc;
	}
	@Override
	protected void obtenFilaColumna(Tablero tab, Ficha color) {
		System.out.print("--Introduce la columna: ");
		int col = sc.nextInt();
		this.columna = col-1;
		sc.nextLine();	
	}
	
}
