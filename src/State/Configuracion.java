package State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Model.Jugador;

public class Configuracion {
	private Scanner scanner = new Scanner(System.in);

	public List<Jugador> configurarJugadores() {
		List<Jugador> jugadores = new ArrayList<>();
		System.out.print("Ingrese el número de jugadores: ");
		int numeroJugadores = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer de entrada

		for (int i = 1; i <= numeroJugadores; i++) {
			System.out.print("Ingrese el nombre del jugador " + i + ": ");
			String nombre = scanner.nextLine();
			jugadores.add(new Jugador(nombre));
		}

		return jugadores;
	}

	public String seleccionarCategoria() {
		System.out.println("Seleccione la categoría de palabras:");
		System.out.println("1. Tecnología");
		System.out.println("2. Naturaleza");
		System.out.println("3. Deportes");

		int opcion = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer de entrada

		switch (opcion) {
		case 1:
			return "tecnologia";
		case 2:
			return "naturaleza";
		case 3:
			return "deportes";
		default:
			System.out.println("Opción inválida, se seleccionará 'Tecnología' por defecto.");
			return "tecnologia";
		}
	}

	public int seleccionarNivelDificultad() {
		System.out.println("Seleccione el nivel de dificultad:");
		System.out.println("1. Fácil (3 palabras)");
		System.out.println("2. Medio (5 palabras)");
		System.out.println("3. Difícil (7 palabras)");

		int nivel = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer de entrada

		switch (nivel) {
		case 1:
			return 3;
		case 2:
			return 5;
		case 3:
			return 7;
		default:
			System.out.println("Opción inválida, se seleccionará 'Medio' por defecto.");
			return 5;
		}
	}

	public int configurarTiempoLimite(int nivelDificultad) {
		System.out.println("¿Desea establecer el tiempo límite manualmente? (s/n)");
		char respuesta = scanner.next().charAt(0);
		scanner.nextLine(); // Limpiar el buffer de entrada

		if (respuesta == 's' || respuesta == 'S') {
			System.out.print("Ingrese el tiempo límite para escribir cada secuencia (en segundos): ");
			return scanner.nextInt();
		} else {
			return calcularTiempoPorDefecto(nivelDificultad);
		}
	}

	private int calcularTiempoPorDefecto(int nivelDificultad) {
		switch (nivelDificultad) {
		case 3:
			return 30; // Fácil: 30 segundos
		case 5:
			return 20; // Medio: 20 segundos
		case 7:
			return 15; // Difícil: 15 segundos
		default:
			return 20; // Por defecto: nivel medio
		}
	}

	public List<String> obtenerPalabrasJugador(int cantidadPalabras, String categoriaSeleccionada,
			String nombreJugador) {
		System.out.println("Jugador: " + nombreJugador
				+ ", ¿desea usar palabras generadas automáticamente o ingresar sus propias palabras?");
		System.out.println("1. Generadas automáticamente");
		System.out.println("2. Ingresar mis propias palabras");
		int opcion = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer de entrada

		List<String> palabras = new ArrayList<>();
		if (opcion == 1) {
			palabras = GeneradorPalabras.obtenerPalabrasAleatorias(categoriaSeleccionada, cantidadPalabras);
		} else if (opcion == 2) {
			Set<String> palabrasIngresadas = new HashSet<>();
			System.out.println("Ingrese las palabras que desea usar (cada palabra debe ser única y no estar vacía):");
			while (palabrasIngresadas.size() < cantidadPalabras) {
				System.out.print("Palabra " + (palabrasIngresadas.size() + 1) + ": ");
				String palabra = scanner.nextLine().trim();

				if (palabra.isEmpty()) {
					System.out.println("La palabra no puede estar vacía. Por favor, intente de nuevo.");
				} else if (palabrasIngresadas.contains(palabra)) {
					System.out.println("La palabra ya ha sido ingresada. Por favor, ingrese una palabra diferente.");
				} else {
					palabrasIngresadas.add(palabra);
				}
			}
			palabras.addAll(palabrasIngresadas);
		} else {
			System.out.println("Opción inválida. Se generarán palabras automáticamente.");
			palabras = GeneradorPalabras.obtenerPalabrasAleatorias(categoriaSeleccionada, cantidadPalabras);
		}

		return palabras;
	}

}// FINAL CLASS
