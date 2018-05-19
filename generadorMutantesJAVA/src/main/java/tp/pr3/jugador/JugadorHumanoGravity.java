package tp.pr3.jugador;

import java.util.Scanner;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Tablero;
public class JugadorHumanoGravity extends Jugador{
	private Scanner sc;
	public JugadorHumanoGravity(Scanner sc) { this.sc=sc;}
	protected void obtenFilaColumna(Tablero tab, Ficha color) {
		System.out.print("introduce la columna: ");
		int col = sc.nextInt();
		System.out.print("introduce la fila: ");
		int fila = sc.nextInt();
		sc.nextLine(); // Quitamos el INTRO
		this.fila = fila-1;
		this.columna= col-1;
	}
}
