import java.util.Stack;

public class Ejercicio1 {
	
	public static Stack<Integer> pila = new Stack <>();
	public static Stack<Integer> pilaAux = new Stack <>();
	
	public static void main(String[] args) {
		
		int dato = 900;
		for (int i=0; i<10;i++) {
			
			pila.push(dato);
			dato -=50;
		}
		
		System.out.println(pila.toString());
		int primero = pila.pop();
		
		while(!pila.isEmpty()) {
			pilaAux.push(pila.pop());
		}
		
		int ultimo = pilaAux.pop();
		
		System.out.println(pilaAux);
		System.out.println(pila.toString());
		
		pila.push(primero);
		while(!pilaAux.isEmpty()) {
			pila.push(pilaAux.pop());
		}
		pila.push(ultimo);
		System.out.println(pila.toString());

	}
	
}
