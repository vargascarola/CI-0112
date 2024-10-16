/**
 * Clase TicTacToe representa el juego de Tic Tac Toe.
 * Atributos:
 *  - tablero: un arreglo 2D de caracteres que representa el estado actual del tablero.
 *  - jugadorActual: un carácter que puede ser 'X' o 'O', representando al jugador actual.
 */
public class TicTacToe {
    private char[][] tablero;
    private char jugadorActual;

    /**
     * Constructor de la clase TicTacToe.
     * Inicializa el juego llamando al método iniciarJuego().
     */
    public TicTacToe() {
        iniciarJuego();
    }

    /**
     * Método que inicializa el tablero y establece el jugador inicial.
     * El tablero se llena con caracteres '-' para representar espacios vacíos,
     * y el jugador inicial se establece como 'X'.
     */
    public void iniciarJuego() {
        tablero = new char[][]{
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };
        jugadorActual = 'X';  // Jugador inicial
    }

    /**
     * Método que realiza un movimiento en el tablero.
     * @param fila: entero que indica la fila (0, 1, 2).
     * @param columna: entero que indica la columna (0, 1, 2).
     * @return boolean: true si el movimiento es válido y se ha realizado, false si es inválido.
     * 
     * Verifica si la posición está dentro de los límites y si está disponible ('-'). 
     * Si es válido, coloca el símbolo del jugador actual en la posición indicada.
     */
    public boolean hacerMovimiento(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
            if (tablero[fila][columna] == '-') {
                tablero[fila][columna] = jugadorActual;
                return true;
            } else {
                return false;  // La posición ya está ocupada
            }
        } else {
            return false;  // Movimiento fuera de los límites
        }
    }

    /**
     * Método que muestra el estado actual del tablero.
     * Imprime el tablero en la consola, mostrando las posiciones ocupadas por 'X', 'O' o vacías ('-').
     */
    public void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Método que verifica si el juego ha terminado.
     * @return boolean: true si hay un ganador o si es un empate, false en caso contrario.
     * 
     * Llama a esGanador() para verificar si alguien ha ganado o esEmpate() para comprobar si el tablero está lleno sin ganador.
     */
    public boolean esJuegoTerminado() {
        return esGanador() || esEmpate();
    }

    /**
     * Método que verifica si el jugador actual ha ganado.
     * @return boolean: true si el jugador actual ha logrado 3 en línea, false si no.
     * 
     * Revisa las filas, columnas y diagonales para determinar si hay 3 símbolos iguales del jugador actual.
     */
    public boolean esGanador() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true;
            }
        }
        // Comprobar columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                return true;
            }
        }
        // Comprobar diagonales
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true;
        }
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true;
        }
        return false;
    }

    /**
     * Método que verifica si el juego ha terminado en empate.
     * @return boolean: true si todas las posiciones del tablero están llenas sin ganador, false en caso contrario.
     * 
     * Recorre el tablero para verificar si hay alguna posición vacía ('-'). Si no hay posiciones vacías y no hay ganador, es empate.
     */
    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Método que cambia el turno del jugador actual.
     * Alterna entre el jugador 'X' y el jugador 'O'.
     */
    public void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    /**
     * Método que devuelve el jugador actual.
     * @return char: El jugador actual ('X' o 'O').
     */
    public char getJugadorActual() {
        return jugadorActual;
    }
}
