import java.util.Random;
import java.util.Scanner;

public class JuegoBatalla {
    private Robot[] robots;
    private int cantidadRobots;
    private Random random = new Random(); // para generar números aleatorios

    // constructor que inicializa el array de robots
    public JuegoBatalla(int cantidadRobots) {
        this.cantidadRobots = cantidadRobots; //almacena la cantidad de robots que elija el usuario
        robots = new Robot[cantidadRobots]; // crea el array  on la cantidad de robots que haya elegido el usuario 
    }

    //método para iniciar la batalla
    public void iniciarBatalla() {
    Random random = new Random(); //generar números aleatorios para los ataque de robot
    int robotsVivos = cantidadRobots; //cantidad de robots que siguen vivos

    while (robotsVivos > 1) { //while haya mas de un robot con vida, se sigue con la batalla 
        for (int i = 0; i < robots.length; i++) { //for que recorre el arreglo desde 0 hasta el número de robo
            if (robots[i] != null && robots[i].estaVivo()) { /*se verifica si el robot de la posición i aún está vivo (no null)
                además de verificarlo con el método está vivo*/ 
                
                //elegir un robot aleatorio para atacar que no sea el mismo que va a atacar y además que esté vivo
                int objetivo;
                do {
                    objetivo = random.nextInt(robots.length); // agarra un índice aleatorio entre 0 y el número de robots ingresado
                } while (objetivo == i || robots[objetivo] == null || !robots[objetivo].estaVivo()); 
                // y este procedimiento se repite hasta que el objetivo no sea el mismo robot atacante y esté vivo

                //para que el robot del i ataque al otroRobot
                robots[i].atacar(robots[objetivo]);

                //si el robot objetivo queda sin vida, se quita un robot vivo
                if (!robots[objetivo].estaVivo()) {
                    robots[objetivo] = null; //la posición en el array donde estaba el que murió, ahora queda en null
                    robotsVivos--; //y el número de robots vivos se baja
                }

                // si solo queda un robot con vida, la pelea se acaba 
                if (robotsVivos == 1) {
                }
            }
        }
    }
    // mostrar el robot ganador si no se detuvo la simulación por poarte del usuario
      if (robotsVivos == 1) {
        mostrarGanador();
        }
    }

    // método para mostrar el ganador
    public void mostrarGanador() {
        for (Robot robot : robots) { //pasa rpetidamente por el arreglo  
            if (robot != null && robot.estaVivo()) { // para comprobar que  el robor no esté null o muerto
                System.out.println("¡El robot ganador es: " + robot.getNombre() + "!"); // imprime le nombre del único robot vivo
            }
        }
    }
    
    public void mostrarEstadoRobot() { // método para mostar el estado de los robots
        System.out.println("Estado actual de los robots:");
        for (Robot robot : robots) //pasar por el arreglo viendo el estado de cada uno de los robots 
            if (robot != null) { 
                System.out.println(robot.estadoRobot());
            }
        }

    public static void main(String[] args) { // main
        Scanner scanner = new Scanner(System.in); //scanner para poder preguntar al usaurio los datos 

        // pedir al usuario la cantidad de robots (máximo 10)
        System.out.println("Ingrese la cantidad de robots (máximo 10):");
        int cantidadRobots = scanner.nextInt();
        while (cantidadRobots > 10 || cantidadRobots < 2) { // verifica que la cantidad sea entre 2 y 10
            System.out.println("La cantidad de robots debe ser entre 2 y 10. Intente nuevamente:"); // si no, pide otra entrada
            cantidadRobots = scanner.nextInt();
        }

        // crear el juego con la cantidad de robots indicada por el usuario  
        JuegoBatalla juego = new JuegoBatalla(cantidadRobots);
        scanner.nextLine(); 

        // se pide al usuario los datos de cada robot
        for (int i = 0; i < cantidadRobots; i++) { 
            /*se va recorriendo los espacios del array para ir guardando los datos 
            ingresados por la persona usuaria*/
            System.out.println("Ingrese el nombre del robot " + (i + 1) + ":");
            String nombre = scanner.nextLine();

            //todos los robots comienzan con 100 puntos de vida, esoo no se le pide al usuario
            int puntosVida = 100;

            System.out.println("Ingrese el ataque del robot " + nombre + " (entre 10 y 20):");
            int ataque = scanner.nextInt(); // se pide al usuario la potencia de ataque, entre 10 y 20
            while (ataque < 10 || ataque > 20) { // si el ataque que ingresó el usuario es menor a 10 o mayor a 20, pide otro 
                System.out.println("El ataque debe estar entre 10 y 20. Intente nuevamente:");
                ataque = scanner.nextInt();
            }
            scanner.nextLine(); 

            // crear el robot y agregarlo al array
            juego.robots[i] = new Robot(nombre, puntosVida, ataque);
        }

        // iniciar la batalla
        juego.iniciarBatalla();
    }
}