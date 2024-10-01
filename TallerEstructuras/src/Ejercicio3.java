import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Ejercicio3 {

    // Función recursiva para agregar novillos al establo #1
    public static void agregarNovillosEstablo1(List<Integer> establo1, int minNovillos) {
        if (establo1.size() >= minNovillos) {
            return;
        } else {
            Random random = new Random();
            int pesoNovillo = 150 + random.nextInt(351); // Generar peso aleatorio entre 150 y 500
            establo1.add(pesoNovillo);
            agregarNovillosEstablo1(establo1, minNovillos);
        }
    }

    // Función para separar los novillos en establos #2 y #3 usando pilas (Stack)
    public static void separarNovillos(List<Integer> establo1, Stack<Integer> establo2, Stack<Integer> establo3) {
        for (int novillo : establo1) {
            if (novillo >= 200 && novillo <= 350) {
                establo2.push(novillo); // Añadir novillo a la pila del establo #2
            } else if (novillo >= 351 && novillo <= 450) {
                establo3.push(novillo); // Añadir novillo a la pila del establo #3
            }
        }
    }

    // Función para calcular el promedio de peso de los novillos en un establo
    public static double promedioPeso(List<Integer> establo) {
        if (establo.size() == 0) {
            return 0;
        }
        int suma = 0;
        for (int novillo : establo) {
            suma += novillo;
        }
        return (double) suma / establo.size();
    }

    public static double promedioPeso(Stack<Integer> establo) {
        if (establo.size() == 0) {
            return 0;
        }
        int suma = 0;
        for (int novillo : establo) {
            suma += novillo;
        }
        return (double) suma / establo.size();
    }

    public static void main(String[] args) {
        // 1. Guardar el rebaño en el establo #1
        List<Integer> establo1 = new ArrayList<>();
        agregarNovillosEstablo1(establo1, 40); // Añadir al menos 40 novillos al establo #1

        // Mostrar el rebaño inicial
        System.out.println("Rebaño en el establo #1: " + establo1);
        System.out.println("Total de novillos en el establo #1: " + establo1.size());
        System.out.printf("Promedio de peso en el establo #1: %.2f kilos\n", promedioPeso(establo1));

        // 2. Separar los novillos en los establos #2 y #3
        Stack<Integer> establo2 = new Stack<>();
        Stack<Integer> establo3 = new Stack<>();
        separarNovillos(establo1, establo2, establo3);

        // 3. Mostrar la información de salida
        System.out.println("\nTotal de novillos en el establo #2: " + establo2.size());
        System.out.printf("Promedio de peso en el establo #2: %.2f kilos\n", promedioPeso(establo2));

        System.out.println("\nTotal de novillos en el establo #3: " + establo3.size());
        System.out.printf("Promedio de peso en el establo #3: %.2f kilos\n", promedioPeso(establo3));
    }
}
