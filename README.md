# Juego del Mejor Mecanógrafo

## Descripción

"Juego del Mejor Mecanógrafo" es un juego diseñado para poner a prueba las habilidades de mecanografía de los jugadores, combinando rapidez y precisión. Los jugadores deben teclear una secuencia de palabras correctamente dentro de un tiempo límite, y la competición se puede realizar entre dos o más participantes, con la posibilidad de organizar torneos.

El proyecto está implementado en **Java**, utilizando **Eclipse IDE** para la programación. 

## Características del Juego

- **Jugadores múltiples:** Permite configurar y jugar entre dos o más jugadores.
- **Palabras personalizables:** Cada jugador puede optar por usar palabras generadas automáticamente o ingresar sus propias palabras.
- **Niveles de dificultad:** Los jugadores pueden seleccionar el nivel de dificultad desde el arranque del juego (Fácil, Medio, Difícil).
- **Configuración de tiempo límite:** Ajuste dinámico del tiempo límite, ya sea manualmente o por defecto, según el nivel de dificultad.
- **Validación de palabras:** No se permiten palabras vacías ni duplicadas.
- **Menú principal interactivo y estético:** Un menú principal claro e interactivo facilita la navegación entre opciones como iniciar el juego, configurar el juego, o ver las reglas.

## Cómo Jugar

1. **Configuración del Juego**:
   - Se solicita el número de jugadores y los nombres de cada uno.
   - Los jugadores seleccionan una categoría de palabras (Tecnología, Naturaleza, Deportes).
   - Se elige un nivel de dificultad (Fácil, Medio, Difícil).
   - Se ajusta el tiempo límite para cada turno, de manera manual o automática según el nivel de dificultad.

2. **Palabras para los Jugadores**:
   - Cada jugador elige si desea usar palabras generadas automáticamente o ingresar sus propias palabras.
   - Las palabras ingresadas deben ser únicas y no estar vacías.

3. **Juego por Turnos**:
   - Cada jugador tiene un turno para completar una secuencia de palabras dentro del tiempo límite.
   - Los jugadores tienen tres intentos de fallo por turno. Cuando un jugador agota sus intentos, se notifica al siguiente jugador para que presione 'Enter' y continúe.

4. **Ganador**:
   - Al finalizar todos los turnos, el jugador con mayor número de aciertos es declarado el ganador. Se generan reportes para determinar al ganador y los lugares de segundo y tercer lugar.

## Instalación

Para ejecutar el proyecto, sigue estos pasos:

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/Dennis290699/Juego-del-Mejor-Mecanografo.git
   ```
2. **Abre el proyecto en Eclipse**.

3. **Ejecuta el archivo `Main.java`** para iniciar el juego.

## Uso

El juego está diseñado para ser intuitivo y sencillo. Los jugadores configuran el juego al inicio, seleccionan sus preferencias y juegan por turnos siguiendo las instrucciones en pantalla. Un menú principal interactivo les permitirá navegar entre las opciones.

## Estructura del Código

- **Main.java**: Contiene el punto de entrada del programa, mostrando un menú principal interactivo para iniciar o configurar el juego.
- **Configuracion.java**: Se encarga de configurar todos los elementos iniciales del juego, como jugadores, palabras, nivel de dificultad y tiempo límite.
- **Juego.java**: Maneja la lógica del juego, incluyendo el flujo por turnos, la validación de palabras, y la determinación del ganador.
- **Jugador.java**: Clase para representar a cada jugador, con atributos como nombre y puntuación.
- **GeneradorPalabras.java**: Clase para generar palabras aleatorias basadas en la categoría seleccionada.

## Requisitos

- **Java JDK 8** o superior.
- **Eclipse IDE** o cualquier otro IDE que soporte Java.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el juego, puedes hacer un **fork** del repositorio y enviar un **pull request** con tus cambios.

1. Realiza un fork del proyecto.
2. Crea una rama con tus mejoras:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Haz commit de tus cambios:
   ```bash
   git commit -m 'Añadida nueva funcionalidad'
   ```
4. Haz push de la rama:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un pull request. 😀