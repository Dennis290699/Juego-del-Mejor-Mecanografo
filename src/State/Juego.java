package State;

import java.util.List;
import java.util.Scanner;

import Model.Jugador;

public class Juego {
	private List<Jugador> jugadores;
	private List<List<String>> palabrasPorJugador;
	private int tiempoLimite;

	public Juego(List<Jugador> jugadores, List<List<String>> palabrasPorJugador, int tiempoLimite) {
		this.jugadores = jugadores;
		this.palabrasPorJugador = palabrasPorJugador;
		this.tiempoLimite = tiempoLimite;
	}

	public void iniciar() {
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < jugadores.size(); i++) {
			Jugador jugador = jugadores.get(i);
			List<String> palabras = palabrasPorJugador.get(i);
			int fallos = 0;

			System.out.println("\nEs el turno del jugador: " + jugador.getNombre() + ". Presiona Enter para comenzar.");
			scanner.nextLine();

			for (String palabra : palabras) {
				if (fallos >= 3) {
					System.out.println("Has alcanzado el límite de 3 fallos. Turno terminado.");
					break;
				}

				System.out.println("Escribe la palabra: " + palabra);
				long tiempoInicio = System.currentTimeMillis();
				String entrada = scanner.nextLine();
				long tiempoFin = System.currentTimeMillis();

				if (entrada.equals(palabra) && (tiempoFin - tiempoInicio) / 1000 <= tiempoLimite) {
					jugador.incrementarAciertos();
					System.out.println("¡Correcto!");
				} else {
					fallos++;
					jugador.incrementarFallos();
					System.out.println("Incorrecto. Intentos restantes: " + (3 - fallos));
				}
			}

			if (i < jugadores.size() - 1) {
				System.out.println("\nTurno del siguiente jugador. Presiona Enter para continuar.");
				scanner.nextLine();
			}
		}
	}

	public void determinarGanador() {
		Jugador ganador = jugadores.get(0);

		for (Jugador jugador : jugadores) {
			System.out.println("Jugador: " + jugador.getNombre() + ", Aciertos: " + jugador.getAciertos() + ", Fallos: "
					+ jugador.getFallos());
			if (jugador.getAciertos() > ganador.getAciertos()) {
				ganador = jugador;
			}
		}

		System.out.println("\nEl ganador es: " + ganador.getNombre() + " con " + ganador.getAciertos() + " aciertos.");
	}
}// FINAL CLASS
