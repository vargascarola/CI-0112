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
    }
}