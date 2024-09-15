
public class Robot // Creación de clase 
{
    private String nombre; // atributos 
    private int puntosVida;
    private int ataque; 
    
    //métodos set y get 
    
    public void setNombre (String nombre){ 
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setPuntosVida (int puntosVida){
        this.puntosVida = puntosVida;
    }
    
    public int getPuntosVida(){
        return puntosVida;
    }
    
    public void setAtaque (int ataque){
        this.ataque = ataque;
    }
    
    public int getAtaque(){
        return ataque;
    }
    
    // constructor de clase
    
    public Robot(String nombre, int puntosVida, int ataque){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque; 
        
    }
    // métodos 
    public boolean estaVivo(){ //método para verificar si el robot está vivo
        if (puntosVida > 0){ // si tiene más de 0 puntos de vida, entonces se retorna un true (está vivo) 
            return true;
        }else{ // de lo contrario, entonces el robot no está vivo y retorna falso
            return false; 
        }
        }
        
     public void atacar(Robot otroRobot) {
        if (estaVivo()) {  // Si el robot a atacar está vivo, entonces puede dar el ataque
            System.out.println(nombre + " ha atacado a " + otroRobot.getNombre() + " con " + ataque + " puntos de daño.");
            otroRobot.puntosVida -= ataque; // Directamente reduce la vida del otro robot
            if (otroRobot.puntosVida < 0) { // Si la vida baja de cero, se ajusta a 0
                otroRobot.puntosVida = 0;
            }
            System.out.println(otroRobot.getNombre() + " ahora tiene " + otroRobot.getPuntosVida() + " puntos de vida.");
        }
    }
    
    public String estadoRobot(){ // devulve un estado actual de los robots; su nombre, puntos de vida y atque que recibió 
        return nombre + "Vida: " + puntosVida + "Daño recibido: " + ataque;
    }
    }