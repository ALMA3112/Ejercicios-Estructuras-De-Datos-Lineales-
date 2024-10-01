import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class PuertoMaritimo {
    private List<Stack<Contenedor>> filas;
    private static final int NUM_FILAS = 9;
    private static final int CONTENEDORES_POR_FILA = 7;
    private static final int MAX_ALTURA = 8;
    private Random random;

    public PuertoMaritimo() {
        filas = new ArrayList<>(NUM_FILAS);
        for (int i = 0; i < NUM_FILAS; i++) {
            filas.add(new Stack<>());
        }
        random = new Random();
    }

    public void almacenarContenedor(Contenedor contenedor) {
        // Seleccionar una fila aleatoria
        int filaAleatoria = random.nextInt(NUM_FILAS);
        Stack<Contenedor> fila = filas.get(filaAleatoria);

        // Si la fila tiene espacio, añadir el contenedor
        if (fila.size() < MAX_ALTURA) {
            fila.push(contenedor);
            // Calculamos la columna y la posición
            int columna = fila.size(); // Columna es el tamaño actual de la fila (número de contenedores)
            int posicion = (filaAleatoria + 1); // La fila es 1-indexed
            System.out.println("Contenedor almacenado: " + contenedor.getCodigo() + 
                               " en Fila: " + (filaAleatoria + 1) + 
                               ", Columna: " + columna + 
                               ", Altura: " + (fila.size()));
        } else {
            System.out.println("No hay espacio disponible en la fila " + (filaAleatoria + 1));
        }
    }

    public Contenedor buscarContenedor(String codigo) {
        for (int i = 0; i < filas.size(); i++) {
            Stack<Contenedor> fila = filas.get(i);
            for (int j = 0; j < fila.size(); j++) {
                Contenedor contenedor = fila.get(j);
                if (contenedor.getCodigo().equals(codigo)) {
                    // La posición se considera como el índice + 1 para ser 1-indexed
                    System.out.println("Contenedor encontrado: " + contenedor.getCodigo() +
                                       " en Fila: " + (i + 1) + 
                                       ", Columna: " + (j + 1) + 
                                       ", Altura: " + (fila.size() - j));
                    return contenedor;
                }
            }
        }
        System.out.println("Contenedor no encontrado.");
        return null;
    }

    public static class Contenedor {
        private String codigo;

        public Contenedor(String codigo) {
            this.codigo = codigo;
        }

        public String getCodigo() {
            return codigo;
        }
    }

    public static void main(String[] args) {
        PuertoMaritimo puerto = new PuertoMaritimo();
        // Ejemplo de uso
        puerto.almacenarContenedor(new Contenedor("A1234"));
        puerto.almacenarContenedor(new Contenedor("B5678"));
        puerto.almacenarContenedor(new Contenedor("C9012"));
        puerto.buscarContenedor("B5678");
    }
}
