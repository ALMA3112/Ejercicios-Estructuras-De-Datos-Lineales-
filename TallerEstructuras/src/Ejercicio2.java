import java.util.Stack;


public class Ejercicio2 {

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        
   
        int dato = 200;
		for (int i=0; i<10;i++) {
			
			pila.push(dato);
			dato +=50;
		}
		
		int dato_insetado = 240;

        System.out.println("Pila antes de insertar: " + pila);
        insertarDato(pila, dato_insetado);
        System.out.println("Pila después de insertar: " + pila);
    }

    public static void insertarDato(Stack<Integer> pila, int dato) {
       
        if (pila.isEmpty() || dato >= pila.peek()) {
            pila.push(dato);
            return;
        }
        
        int tope = pila.pop();
        insertarDato(pila, dato);
        pila.push(tope);
    }
}
