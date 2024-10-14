import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        /*Crear una instancia de la clase Empleado
        Empleado empleado1 = new Empleado(1, "Juan Pérez", 3000.50);
        
        // Invocar el método mostrarDetalles
        empleado1.mostrarDetalles();
    }*/
    
    Empleado[] empleados = new Empleado[5];
        Scanner scanner = new Scanner(System.in);
        
        // Recopilar datos de los empleados
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Empleado " + (i + 1) + ":");
            
            System.out.print("ID Empleado: ");
            int id_empleado = scanner.nextInt();
            
            System.out.print("Nombre: ");
            scanner.nextLine(); // Consumir la nueva línea
            String nombre = scanner.nextLine();
            
            System.out.print("Salario: ");
            double salario = scanner.nextDouble();
            
            // Crear un nuevo objeto Empleado y agregarlo al arreglo
            empleados[i] = new Empleado(id_empleado, nombre, salario);
        }
        
        // Mostrar los detalles de todos los empleados
        System.out.println("\nInformación de los empleados:");
        for (Empleado emp : empleados) {
            emp.mostrarDetalles();
            System.out.println();
        }
        
        scanner.close();
    }
}
    

