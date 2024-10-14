
public class Empleado
{
    int id_empleado;
    String nombre;
    double salario;
    
    // Constructor de la clase
    public Empleado(int id_empleado, String nombre, double salario) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.salario = salario;
    }
    
    // Método para mostrar los detalles del empleado
    public void mostrarDetalles() {
        System.out.println("ID Empleado: " + id_empleado);
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
    }
}

