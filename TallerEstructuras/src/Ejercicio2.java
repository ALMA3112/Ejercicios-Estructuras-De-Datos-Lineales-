
import java.util.Stack;

public class Ejercicio2 {
    public static Stack<Integer> pila = new Stack();
    
    public static void llenarPila(){
        int dato=900;
        for(int i=0; i<10;i++){
            pila.push(dato);
            dato+=20;
        }
        System.out.println(pila.toString());
    }
    
    public static Stack<Integer> insertarDato(Stack<Integer> pila , int dato){
        if(pila.isEmpty()|| pila.peek()<dato){
            pila.push(dato);
        }
        else{
            int tope = pila.pop();
            insertarDato(pila, dato);
            pila.push(tope);
        }
        return pila;
    }
    
    public static void ejecutar(){
        System.out.println("Pila antes de insertar: ");
        llenarPila();
        int dato_insetado = 961;
        insertarDato(pila, dato_insetado);
        System.out.println("Pila despues de insertar: " + pila);
    }
}
