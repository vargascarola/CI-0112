Este proyecto implementa dos juegos de consola, TicTacToe y Conecta Cuatro. El programa permite al usuario seleccionar entre estos juegos, jugar contra otro jugador y determinar el ganador o si hay un empate.
Requisitos del Sistema
Se necesita el JDK instalado y una IDE para compilar y ejecutar el programa.

El proyecto se divide en 3 clases:

JuegoControlador:
Controlador que permite seleccionar y ejecutar uno de los dos juegos disponibles.
Gestiona la interacción con el usuario y el ciclo de juego.

TicTacToe:
Implementa el juego TicTacToe (Tres en Raya).
Soporta un tablero de 3x3 y la jugabilidad entre dos jugadores ('X' y 'O').
Incluye métodos para hacer movimientos, verificar si hay un ganador o empate, y cambiar de turno.

ConectaCuatro:
Implementa el juego Conecta Cuatro.
Soporta un tablero de 7 filas y 6 columnas donde los jugadores deben conectar 4 fichas en fila para ganar.
Contiene métodos para hacer movimientos, verificar el ganador, empate y cambiar de turno.

////////Cómo Ejecutar el Programa//////////
Compilar el archivo principal JuegoControlador.java junto con las clases TicTacToe.java y ConectaCuatro.java.
Al ejecutar JuegoControlador, se mostrará un menú en la consola donde el usuario puede seleccionar entre TicTacToe o Conecta Cuatro:
Opción 1: Jugar TicTacToe.
Opción 2: Jugar Conecta Cuatro.
Dependiendo del juego seleccionado, el usuario ingresará movimientos a través de la consola.

TicTacToe: El jugador ingresa las coordenadas (fila y columna) para colocar su ficha.

Conecta Cuatro: El jugador selecciona la columna donde desea dejar caer su ficha.
El programa determinará si hay un ganador, un empate, o si el juego debe continuar.


Ejemplo de Ejecución;
Hola, bienvenido. Seleccione un juego:
1. TicTacToe
2. Cuatro en Línea
El usuario selecciona el juego ingresando un número (1 o 2).
Durante el juego, se pedirá al usuario que ingrese las coordenadas o columnas donde desea hacer su movimiento.
El programa continuará hasta que haya un ganador o empate.
