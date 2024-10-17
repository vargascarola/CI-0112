import java.util.Scanner;

/**
 * Clase ConectaCuatro.
 * Esta clase representa el juego "Cuatro en Línea".
 */
public class ConectaCuatro {
    private int jugadorActual; ///< jugador en un int ya que puede ser jugador1 o jugador 2
    private char[][] tablero; ///< arreglo de arreglos para crear tablero

    /**
     * Constructor de la clase ConectaCuatro.
     * Inicializa el tablero y llama al método iniciarJuego().
     */
    public ConectaCuatro() { 
        tablero = new char[7][6]; //tablero de 7 filas y 6 columnas
        iniciarJuego(); // método iniciar el juego
    }

    /**
     * Método get para obtener el jugador actual.
     * @return jugadorActual El jugador actual (1 o 2).
     */
    public int getJugadorActual(){ 
        return jugadorActual;
    }

    /**
     * Método para iniciar el juego.
     * Llena el tablero con puntos para representar espacios vacíos y asigna el turno al jugador 1.
     */
    public void iniciarJuego() { 
        for (int i = 0; i < 7; i++) { 
            for (int j = 0; j < 6; j++) { //for para recorrer el tablero y poner un . para dar a entender que es un cuadro vacío
                tablero[i][j] = '.'; // espacio vacío en el tablero para que se note donde no hay fichas
            }
        }
        jugadorActual = 1; // el jugador 1 es el que comienza jugando
    }

    /**
     * Muestra el tablero en la consola.
     */
    public void mostrarTablero() {
        System.out.println("  1 2 3 4 5 6"); //mostrar los números de las columnas
        for (int i = 0; i < 7; i++) {
            System.out.print((i + 1) + " "); //muestra los números de las filas para mejor guía
            for (int j = 0; j < 6; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Método para realizar una jugada en la columna correspondiente.
     * @param columna La columna en la que se quiere hacer el movimiento.
     * @return true si el movimiento es válido, false si la columna no es válida o está llena.
     */
    public boolean hacerMovimiento(int columna) { 
        columna -= 1; // la columna para que sea de 1-6 para el usuario

        if (columna < 0 || columna >= 6) { /* si el usuario escoge una columna que no existe (debajo de 0 o arriba de 6), se 
            pide que digite otra*/ 
            System.out.println("La columna digitada no existe, elija otra entre 1 y 6");
            return false; // false porque no puede hacer el movimiento 
        }
        for (int fila = 6; fila >= 0; fila--) { //for para ver cuál es la fila de más abajo sin llenar y la ficha va ahí 
            if (tablero[fila][columna] == '.') { //si esa columna y fila está vacía entonces se puede poner la ficha del jugador
                tablero[fila][columna] = (jugadorActual == 1) ? 'X' : 'O'; //ya sea la ficha x || o
                return true; // se usan operadores ternarios para hacer menos líneas de código
            }
        }

        System.out.println("Esa columna ya está llena, por favor elija otra");
        return false;
    }

    /**
     * Verifica si el juego ha terminado, ya sea porque hay un ganador o porque hay un empate.
     * @return true si el juego ha terminado, false en caso contrario.
     */
    public boolean esJuegoTerminado() { 
        return esGanador() || esEmpate(); // el empate solo sucede si ninguno de los dos jugadores gana
    }

    /**
     * Verifica si hay un ganador.
     * @return true si hay un ganador, false en caso contrario.
     */
    public boolean esGanador() { /* verifica si hay un ganador, esto sucede cuando 4 fichas del mismo tipo se juntan. Verifica filas, 
        columnas y diagonales */
        for (int i = 0; i < 7; i++){ // para verificar fichas en la posición horizontal, vertical y diagonal
            for (int j = 0; j < 6; j++) {
                char ficha = tablero[i][j];
                if (ficha == '.') continue;  // si no hay nada, se sigue

                // verificar fichas juntas horizontalmente
                if (j + 3 < 6 && ficha == tablero[i][j + 1] && ficha == tablero[i][j + 2] && ficha == tablero[i][j + 3]) {
                    return true;
                }

                // verificar fichas juntas verticalmente
                if (i + 3 < 7 && ficha == tablero[i + 1][j] && ficha == tablero[i + 2][j] && ficha == tablero[i + 3][j]) {
                    return true;
                }

                // verificar cuatro fichas juntas en diagonal derecha
                if (i + 3 < 7 && j + 3 < 6 && ficha == tablero[i + 1][j + 1] && ficha == tablero[i + 2][j + 2] && ficha == tablero[i + 3][j + 3]) {
                    return true;
                }

                // verificar cuatro fichas juntas en diagonal izquierda
                if (i + 3 < 7 && j - 3 >= 0 && ficha == tablero[i + 1][j - 1] && ficha == tablero[i + 2][j - 2] && ficha == tablero[i + 3][j - 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifica si el juego ha terminado en empate.
     * @return true si es empate, false si aún hay espacios vacíos.
     */
    public boolean esEmpate() { // método que verifica si hay empate
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) { // recorre el array
                if (tablero[i][j] == '.') {
                    return false; // si aún queda un espacio vacío, no hay empate ya que hay posibilidad de ganar
                }
            }
        }
        return true; // si ya no quedan espacios vacíos y ningún jugador ha ganado, es un empate
    }

    /**
     * Método que cambia el turno de los jugadores.
     */
    public void cambiarJugador() { 
        jugadorActual = (jugadorActual == 1) ? 2 : 1; // si el jugador actual es 1, se cambia a jugador 2 y viceversa
    }
}