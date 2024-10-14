import java.util.Scanner;

public class ConectaCuatro {
    private int jugadorActual; //jugador en un int ya que puede ser jugador1 o jugador 2
    private char[][] tablero; //arreglo de arreglos para crear tablero

    public ConectaCuatro() { // constructor de clase
        tablero = new char[7][6]; //tablero de 7 filas y 6 columnas
        iniciarJuego(); // método iniciar el juego
    }

    public void iniciarJuego() { // método para iniciar el juego
        for (int i = 0; i < 7; i++) { 
            for (int j = 0; j < 6; j++) { //for para recorrer el tablero y poner un . para dar a entender que es un cuadro vacio
                tablero[i][j] = '.'; // espacio vacío en el tablero para que se note donde no hay fichas
            }
        }
        jugadorActual = 1; // el jugador 1 es el que comienza jugando
    }

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

    public boolean hacerMovimiento(int columna) { // método para realizar una jugada en el turno correspondiente
        columna -= 1; //  la columna para que sea de 1-6 para el usuario
        
        if (columna < 0 || columna >= 6) { /* si el usuario escoje una columna que no existe (debajo de 0 o arriba de 6), se 
            pide que digite otra*/ 
            System.out.println("La columna digitada no existe, elija otra entre 1 y 6");
            return false; // false porque no puede hacer el movimiento 
        }
         for (int fila = 6; fila >= 0; fila--) { //for para ver cuál es la fila de más abajo sin llenar y la ficha va ahi 
            if (tablero[fila][columna] == '.') { //si esa columna y fila está vacia entonces se puede poner la ficha del jugador
                tablero[fila][columna] = (jugadorActual == 1) ? 'X' : 'O'; //ya sea la ficha x || o
                return true; // se usan operadores ternarios para hacer menos lineas de codigo
            }
        }

        System.out.println("Esa columna ya está llena, por favor elija otra");
        return false;
    }

    public boolean esJuegoTerminado() { // verifica que el juego terminó y devuelve si hay un ganador o ha sido un empate
        return esGanador() || esEmpate(); // el empate solo sucede si ninguno de los dos jugadores gana, no pueden ganar lso dos
    }

    public boolean esGanador() { /* verifica si hay un ganador, esto cuando 4 fichas del mismo tipo se juntan/ Verifica filas, 
        columnas y diagonales*/
        for (int i = 0; i < 7; i++){ // para verificar fichas en la posicion horizontsl, vertical y diagonal
            for (int j = 0; j < 6; j++) {
                char ficha = tablero[i][j];
                if (ficha == '.') continue;  // si no hay nada, se sigue

                //verificar ficha juntas horizontalmente
                if (j + 3 < 6 && ficha == tablero[i][j + 1] && ficha == tablero[i][j + 2] && ficha == tablero[i][j + 3]) {
                    return true;
                }
                
                //verifica fichas juntas verticalmente
                if (i + 3 < 7 && ficha == tablero[i + 1][j] && ficha == tablero[i + 2][j] && ficha == tablero[i + 3][j]) {
                    return true;
                }
                
                // verificar cuatro fichas juntas en diagonal derecha
                if (i + 3 < 7 && j + 3 < 6 && ficha == tablero[i + 1][j + 1] && ficha == tablero[i + 2][j + 2] && ficha == tablero[i + 3][j + 3]) {
                    return true;
                }
                
                // vreificar cuatro fichas juntas en diagonla izquierda
                if (i + 3 < 7 && j - 3 >= 0 && ficha == tablero[i + 1][j - 1] && ficha == tablero[i + 2][j - 2] && ficha == tablero[i + 3][j - 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean esEmpate() { //metodo que verifica si hay empate
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) { //recorre el array 
                if (tablero[i][j] == '.') {
                    return false; // si aún queda un espacio vacío, no hay empate ya que hay posibilidad de ganar
                }
            }
        }
        return true; // si ya no quedan espacios vacíos, y nongún jugador ha ganado, es un empate
    }
    
    public void cambiarJugador() { //método que cambia el turno de los jugadores
        jugadorActual = (jugadorActual == 1) ? 2 : 1; // si el jugador actual es 1, se cambia a jugador 2 y viceversa
    }
}