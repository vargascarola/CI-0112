import java.util.Random; 

public class Vector{
    
    private int [] vector;
    
    public Vector(int [] vector){ //constructor
        this.vector = vector;
        
    }
    
    //métod set
    public void setVector(int [] vector){
        this.vector = vector; 
    }
    
    public void printVector(){
        for (int i= 0; i < vector.length; i++){
            System.out.print (vector[i] + "  "); 
            
        }
    }
    
    public void randomize(){
        Random randomNums = new Random();
        for (int i=0; i < vector.length; i++){
        vector[i] = randomNums.nextInt(101);    
    }
    }
    
    public void sortArray (){
        for (int i=0; i < vector.length; i++){
            int posicionMenor = i; 
            int valorMenor = vector[i]; //guardar el valor menor 
            for(int j= i + 1; j < vector.length; j++){ //empieza en i+1 para que el j empiece uno a la derecha del i  
                if (vector [j] < valorMenor){ // se compara el j 
                    posicionMenor = j;//se actualiza la posición del menor
                    valorMenor = vector[j]; //se actualiza el valor menor 
                
                }
            }
                if (posicionMenor != i){ // if la posic del menor no es la actual, se cambia 
                // hacer el cambio de los valores con ayuda de la var. aux
                int aux = vector [i];
                vector[i] = vector[posicionMenor];
                vector[posicionMenor] = aux;
                /* hacer una variable auxiliar para poder cambiar las posiciones del i con el menor
                   int aux= v[posMen]
                   v[posmenor] = v[i]
                   v[i] = aux*/
        
    }
}   
}

public void busquedaSecuencial(int numeroBusqueda) {
        int indice = -1; // Inicialmente, el índice es -1 para indicar que no se encontró el número
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == numeroBusqueda) {
                indice = i; // Guarda el índice donde se encontró el número
                break; // Sale del ciclo una vez que encuentra el número
            }
        }

        // Imprimir resultado
        if (indice != -1) {
            System.out.println("El número " + numeroBusqueda + " está en la posición " + indice);
        } else {
            System.out.println("El número " + numeroBusqueda + " no se encuentra en el vector.");
        }
    }
    
public void paresImpares (){
    int pares=0;
    int impares=0; 
    for (int i = 0; i < vector.length; i++) {
        if(vector[i] % 2 == 0){ // verifica si el numero es par
            pares ++; // suma a la variable pares
    }else{
        impares ++; // si no es par, es impar. suma a la variable impares
    }
}
System.out.println("La cantidad de números pares es: " + pares + " y la cantidad de impares es: " + impares);
}

public int resta(){
    int numMayor = this.vector[0];
    int numMenor = this.vector[0];
    
    for (int i = 1; i < this.vector.length; i++) {
        if (this.vector[i]> numMayor) {
            numMayor= this.vector[i];
        }
        if (this.vector[i] < numMenor){
            numMenor = this.vector[i];
        }
}
int resta = numMayor - numMenor;
System.out.println("La resta del mayor número menos el menor es de: "+ resta);
return resta;
}
}








