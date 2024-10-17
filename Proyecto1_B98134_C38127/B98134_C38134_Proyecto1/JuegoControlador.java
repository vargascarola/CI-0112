import java.util.Scanner;
/**
 * Clase que controla la selección y ejecución de los juegos TicTacToe y Conecta Cuatro.
 */
public class JuegoControlador {
    private TicTacToe ticTacToe; ///< atributo objeto de la clase TicTacToe
    private ConectaCuatro connectFour; ///< atrib objeto de la clase ConectaCuatro
    private Object juegoActual; ///< objeto que referencia a TicTacToe o ConectaCuatro, según lo que se seleccione

    /**
     * Constructor de la clase JuegoControlador. Inicializa los objetos TicTacToe y ConectaCuatro.
     */
    public JuegoControlador() {
        ticTacToe = new TicTacToe(); 
        connectFour = new ConectaCuatro(); 
    }
    
    /**
     * Método principal que inicia la ejecución del programa.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {  
        JuegoControlador controlador = new JuegoControlador(); 
        controlador.procesarEntradaUsuario(); ///< llama metodo procesarEntradaUsuario
    }

    /**
     * Muestra el menú para que el usuario seleccione el juego que desee.
     */
    public void mostrarMenu() {
        System.out.println("Hola, bienvenido. Seleccione un juego:"); 
        System.out.println("1. TicTacToe"); ///< opción 1 para TicTacToe
        System.out.println("2. Cuatro en Línea"); ///< opción 2 para Conecta Cuatro
    }

    /**
     * Permite al usuario seleccionar el juego que quiera.
     */
    public void seleccionarJuego() {
        Scanner scanner = new Scanner(System.in); ///< entrada del usuario
        mostrarMenu(); ///< se llama al método mostrarMenu para desplegar las opciones
        int opcion = scanner.nextInt(); ///< leer entrada usuaria
        
        switch (opcion) {
            case 1: ///< si elige la opción 1 se abre el tictactoe
                juegoActual = ticTacToe; 
                System.out.println("Ha seleccionado el juego TicTacToe."); 
                break;
            case 2: ///< si elige la opción 2 se abre Conecta Cuatro
                juegoActual = connectFour; 
                System.out.println("Ha seleccionado el juego Conecta Cuatro."); 
                break;
            default: ///< si se elige una opción no válida
                System.out.println("Opción no válida. Seleccione otra vez por favor."); 
                seleccionarJuego(); ///< se vuelve a llamar al método para que el usuario seleccione nuevamente una opcion válida
                break;
        }
    }

    /**
     * Identifica el juego que se eligió y lo inicia.
     */
    public void jugar() {
        if (juegoActual instanceof TicTacToe) { ///< si juegoActual es una instancia de TicTacToe
            jugarTicTacToe(); ///< se llama al método para jugar TicTacToe
        } else if (juegoActual instanceof ConectaCuatro) { ///< si juegoActual es una instancia de ConectaCuatro
            jugarConectaCuatro(); ///< llamar al método para jugar Conecta Cuatro
        }
    }

    /**
     * Ejecuta el ciclo del juego TicTacToe.
     */
    public void jugarTicTacToe() {
        Scanner scanner = new Scanner(System.in); ///< leer la entrada del usuario
        while (!ticTacToe.esJuegoTerminado()) { ///< mientras el juego no haya terminado (no hay ganador ni empate)
            ticTacToe.mostrarTablero(); ///< sigue mostrando el tablero
            System.out.println("Jugador " + ticTacToe.getJugadorActual() + ", ingrese fila y columna (0-2):");
            // pide al jugador actual que ingrese la fila y columna para hacer un movimiento
            int fila = scanner.nextInt(); 
            int columna = scanner.nextInt(); 
            
            if (ticTacToe.hacerMovimiento(fila, columna)) { ///< si es un movimiento válido
                if (ticTacToe.esGanador()) { ///< verifica si el jugador ha ganado
                    ticTacToe.mostrarTablero(); ///< muestra el tablero final
                    System.out.println("Jugador " + ticTacToe.getJugadorActual() + " ha ganado. ¡Felicidades!"); 
                    break; 
                } else if (ticTacToe.esEmpate()) { ///< verifica si es un empate
                    ticTacToe.mostrarTablero(); ///< muestra el tablero final
                    System.out.println("Ha sido un empate."); 
                    break; 
                }
                ticTacToe.cambiarJugador(); ///< cambia el turno al otro jugador
            } else { 
                // en caso de que el movimiento sea inválido
                System.out.println("Movimiento inválido, por favor intente de nuevo."); 
            }
        }
    }

    /**
     * Ejecuta el ciclo del juego Conecta Cuatro.
     */
    public void jugarConectaCuatro() {
        Scanner scanner = new Scanner(System.in); ///< para leer la entrada del usuario
        while (!connectFour.esJuegoTerminado()) { ///< mientras el juego no haya terminado (no hay ganador ni empate)
            connectFour.mostrarTablero(); ///< muestra el tablero 
            System.out.println("Jugador " + (connectFour.getJugadorActual()) + ", elija una columna (1-6):");
            // pide al jugador actual que elija una columna para hacer un movimiento
            int columna = scanner.nextInt(); ///< leer columna ingresada por persona usuaria
            
            if (connectFour.hacerMovimiento(columna)) { ///< si es un movimiento válido
                if (connectFour.esGanador()) {  ///< revisa si el jugador ha ganado
                    connectFour.mostrarTablero(); ///< muestra el tablero final
                    System.out.println("Jugador " + connectFour.getJugadorActual() + " ha ganado- ¡Felicidades!"); 
                    break; 
                
                } else if (connectFour.esEmpate()) { ///< verifica si hay un empate
                    connectFour.mostrarTablero(); ///< muestra el tablero final
                    System.out.println("¡Es un empate!"); 
                    break;
                }
                connectFour.cambiarJugador(); ///< cambia el turno al otro jugador
            } else { 
                // si el movimiento es inválido se pide otro intento
                System.out.println("Movimiento inválido, intente de nuevo.");
            }
        }
    }

    /**
     * Procesa las entradas de la persona usuaria y gestiona la selección del juego.
     */
    public void procesarEntradaUsuario() { 
        seleccionarJuego(); ///< llama al método para seleccionar el juego
        jugar(); ///< llama al método para iniciar el juego
    }

}