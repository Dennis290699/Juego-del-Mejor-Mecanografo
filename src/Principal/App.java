package Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Jugador;
import State.Configuracion;
import State.Juego;

public class App {
	private static Configuracion configuracion = new Configuracion();
	private static Juego juego;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		List<Jugador> jugadores = null;
		String categoriaSeleccionada = null;
		int cantidadPalabras = 0;
		int tiempoLimite = 0;

		while (!salir) {
			mostrarMenu();
			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer de entrada

			switch (opcion) {
			case 1:
				// Iniciar el juego
				if (juego == null) {
					System.out.println("Debe configurar el juego antes de iniciarlo.");
				} else {
					boolean continuar = true;
					while (continuar) {
						juego.iniciar();
						System.out.print("¿Desea jugar otra ronda? (s/n): ");
						char respuesta = scanner.next().charAt(0);
						scanner.nextLine(); // Limpiar el buffer de entrada
						if (respuesta == 'n' || respuesta == 'N') {
							continuar = false;
						}
					}
					juego.determinarGanador();
				}
				break;
			case 2:
				// Ver reglas del juego
				mostrarReglas();
				break;
			case 3:
				// Configurar el juego
				jugadores = configuracion.configurarJugadores();
				categoriaSeleccionada = configuracion.seleccionarCategoria();
				cantidadPalabras = configuracion.seleccionarNivelDificultad();
				tiempoLimite = configuracion.configurarTiempoLimite(cantidadPalabras);

				List<List<String>> palabrasPorJugador = new ArrayList<>();
				for (Jugador jugador : jugadores) {
					List<String> palabras = configuracion.obtenerPalabrasJugador(cantidadPalabras,
							categoriaSeleccionada, jugador.getNombre());
					palabrasPorJugador.add(palabras);
					System.out.println("Palabras seleccionadas para " + jugador.getNombre() + "guardadas con exito!");
				}

				juego = new Juego(jugadores, palabrasPorJugador, tiempoLimite);
				System.out.println("\nConfiguración del juego completada con éxito.\n");
				break;
			case 4:
				// Salir del programa
				salir = true;
				System.out.println("Gracias por jugar. ¡Hasta la próxima!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, intente de nuevo.");
				break;
			}
		}
		scanner.close();
	}

	private static void mostrarMenu() {
		System.out.println("\n==============================");
		System.out.println("    JUEGO DEL MEJOR MECANÓGRAFO");
		System.out.println("==============================");
		System.out.println("1. Iniciar Juego");
		System.out.println("2. Ver Reglas");
		System.out.println("3. Configurar Juego");
		System.out.println("4. Salir");
		System.out.println("==============================");
	}

	private static void mostrarReglas() {
		System.out.println("\n--- Reglas del Juego ---");
		System.out.println("1. Cada jugador debe escribir una secuencia de palabras correctamente.");
		System.out.println("2. Cada turno tiene un límite de tres fallos.");
		System.out.println("3. El jugador debe completar la secuencia sin cometer errores para sumar puntos.");
		System.out.println("4. Después de tres fallos, el turno termina.");
		System.out.println("5. El siguiente jugador debe presionar 'Enter' para iniciar su turno.");
		System.out.println("6. Al final, el jugador con más aciertos será declarado el ganador.");
		System.out.println("-------------------------\n");
	}
}// FINAL CLASS
