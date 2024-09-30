package State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorPalabras {
	private static final List<String> TECNOLOGIA = List.of("programacion", "java", "teclado", "computadora", "juego",
			"monitor", "raton", "pantalla", "codigo", "algoritmo", "desarrollo");

	private static final List<String> NATURALEZA = List.of("arbol", "montana", "rio", "mar", "bosque", "flor", "nube",
			"lluvia", "sol", "tierra", "lago");

	private static final List<String> DEPORTES = List.of("futbol", "baloncesto", "tenis", "natacion", "atletismo",
			"voleibol", "gimnasia", "karate", "boxeo", "patinaje", "ciclismo");

	public static List<String> obtenerPalabrasAleatorias(String categoria, int cantidad) {
		List<String> palabrasFuente = switch (categoria) {
		case "tecnologia" -> TECNOLOGIA;
		case "naturaleza" -> NATURALEZA;
		case "deportes" -> DEPORTES;
		default -> TECNOLOGIA; // Por defecto tecnología
		};

		List<String> palabrasSeleccionadas = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < cantidad; i++) {
			int indiceAleatorio = random.nextInt(palabrasFuente.size());
			palabrasSeleccionadas.add(palabrasFuente.get(indiceAleatorio));
		}

		return palabrasSeleccionadas;
	}
}// FINAL CLASS
