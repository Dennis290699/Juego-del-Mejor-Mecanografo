package Model;

public class Jugador {
	private String nombre;
	private int aciertos;
	private int fallos;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.aciertos = 0;
		this.fallos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAciertos() {
		return aciertos;
	}

	public int getFallos() {
		return fallos;
	}

	public void incrementarAciertos() {
		aciertos++;
	}

	public void incrementarFallos() {
		fallos++;
	}

	public void reiniciarPuntuacion() {
		aciertos = 0;
		fallos = 0;
	}
}// FINAL CLASS
