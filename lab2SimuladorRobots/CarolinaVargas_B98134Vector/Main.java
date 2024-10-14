import java.util.Scanner; 

public class Main
{
     public static void main (String [] args){
         int [] vector1 = {1,2,3,4,5,6,7};
         Vector vector = new Vector(vector1);
         vector.printVector(); 
         
         vector.randomize();
         System.out.println("\n");
         vector.printVector();
         vector.sortArray();
         System.out.println("\n");
         vector.printVector();
         
         Scanner scanner = new Scanner (System.in);
         System.out.println("\n");
         System.out.println("¿Cuál valor desea buscar?");
         int numeroBusqueda = scanner.nextInt();
         vector.busquedaSecuencial(numeroBusqueda);
         System.out.println("\n");
         vector.paresImpares();
         vector.resta();
        }
}


/* un metodo que recorra el arreglo y int posiciónMneor y un int valorMenor, donde se guarden las posiciones del menor numero.
   entonces si el valor de la posicion cero es menor al de la posicion 2, se guarda en posicion menor la posicion del menor y el valor 
   del menor cambia por el valor de esa posición 
   v= [5, 25, 3, 17, 1] caundo se llega al final del arreglo, v [4] = v[0] y luego v[0]= valorMenor
   se hace con dos for anidados uno i y otro j y cuando i empieza en 0, j empieza en 1, uno que guarda
   se llama ordenamiento de selección. 
   los punteros (for) empiezan en la posición 0 del array, pero el puntero j es el que se mueve en las posiciones de 0 hasta 
   el final del arreglo comparando, cuando se llega al final de arreglo el for i empieza en la posición 1, porque en la 0 ya se 
   guardó el menor. Ahora el for i empieza en la posición 1, y el j se mueve de la 1 hasta el final del arreglo y deja en la 
   posición 1 el menor valor desde la posición 1  hasta el último. Ahora el for i empieza en la posición 2, y el for j recorre 
   desde la posición 2 hasta el final y guarda en la posición 2 el valor menor desde la posicion 2 hasta el final y así sucesivamente*/
 
