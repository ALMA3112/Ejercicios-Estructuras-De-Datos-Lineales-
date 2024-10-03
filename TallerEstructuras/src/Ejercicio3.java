import java.util.ArrayList;
import java.util.Stack;

public class Ejer3 {
    public static Stack<Integer> establo2 = new Stack<>();
    public static Stack<Integer> establo3 = new Stack<>();
    public static ArrayList<Integer> establo1 = new ArrayList<>();

    public static void ejecutar() {
        llenarLista();
        separarNovillos();
        System.out.println("Establo 1: " + establo1.toString());
        promedios();
    }

    public static void llenarLista() {
        for (int i = 0; i < 41; i++) {
            establo1.add((int) (Math.random() * (500 - 150 + 1)) + 150);
        }
        System.out.println(establo1.toString());
    }

    public static void separarNovillos() {
        int i = 0;
        while (i < establo1.size()) {
            int novillo = establo1.get(i);
            if (200 <= novillo && novillo <= 350) {
                establo2.add(novillo);
                establo1.remove(i); 
            } else if (351 <= novillo && novillo <= 450) {
                establo3.add(novillo);
                establo1.remove(i); 
            } else {
                i++; // Solo incrementar si no se eliminó un elemento
            }
        }
    }


    public static void promedios() {
        if (establo1.isEmpty()) {
            System.out.println("Establo 1: vacío");
        } else {
            double suma = 0;
            for (int peso : establo1) {
                suma += peso;
            }
            double promedioLista = suma / establo1.size();
            System.out.println("Promedio pesos establo 1: " + promedioLista);
            System.out.println("Número de animales: " + establo1.size());
        }


        if (establo2.isEmpty()) {
            System.out.println("Establo 2: vacío");
        } else {
            double suma = 0;
            int tam = establo2.size();
            while (!establo2.isEmpty()) {
                suma += establo2.pop(); 
            }
            double promedioEstablo2 = suma / tam;
            System.out.println("Promedio pesos establo 2: " + promedioEstablo2);
            System.out.println("Número de animales: " + tam);
        }


        if (establo3.isEmpty()) {
            System.out.println("Establo 3: vacío");
        } else {
            double suma = 0;
            int tam3 = establo3.size();
            while (!establo3.isEmpty()) {
                suma += establo3.pop(); 
            }
            double promedioEstablo3 = suma / tam3;
            System.out.println("Promedio pesos establo 3: " + promedioEstablo3);
            System.out.println("Número de animales: " + tam3);
        }
    }
}
