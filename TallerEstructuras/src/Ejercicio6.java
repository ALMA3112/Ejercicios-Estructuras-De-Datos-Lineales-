import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Ejer6 {
	
	public static void ejecutar() {
	crearListaDeProductos();
    Stack<Producto> pilaProductos = agruparPorCodigo(listaDeProductos);
    
    double valorTotal = mostrarArticulosEnPila(pilaProductos);
    System.out.println("Valor total de los artículos: $" + valorTotal);
    
    double valorTotalRecursivo = mostrarTotalRecursivo(pilaProductos, 0);
    System.out.println("Valor total (recursivo): $" + valorTotalRecursivo);
}
	
	public static void crearListaDeProductos() {
		ArrayList<Producto> listaDeProductos = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) { //10 productos
            int numeroPedido = i + 1000; 
            Date fecha = new Date();
            int codigo = (rand.nextInt(100)); 
            int cantidad = rand.nextInt(10) + 1; 
            double precio = rand.nextDouble() * 100;

            // Crear un nuevo producto y agregarlo a la lista
            Producto producto = new Producto(numeroPedido, fecha, codigo, cantidad, precio);
            listaDeProductos.add(producto);
        }
        // Mostrar 
        for (Producto producto : listaDeProductos) {
            System.out.println(producto);
        }
    }

	public static Stack<Producto> agruparPorCodigo(ArrayList<Producto> listaDeProductos) {
    Stack<Producto> pilaProductos = new Stack<>();

    while (!listaDeProductos.isEmpty()) {
        Producto productoActual = listaDeProductos.get(0); // Obtenemos el primer producto
        int codigo = productoActual.getCodigoProducto();
        int cantidadTotal = productoActual.getCantidadPedida();
        double precio = productoActual.getPrecio(); // Precio del primer producto con este código

        // Recorremos el resto de la lista buscando productos con el mismo código
        for (int i = 1; i < listaDeProductos.size(); i++) {
            Producto producto = listaDeProductos.get(i);
            if (producto.getCodigoProducto() == codigo) {
                // Sumamos la cantidad de los productos con el mismo código
                cantidadTotal += producto.getCantidadPedida();
                // Eliminamos el producto que ya se sumó
                listaDeProductos.remove(i);
                i--; // Ajustamos el índice después de remover
            }
        }

        // Creamos un nuevo producto con la cantidad total y lo agregamos a la pila
        Producto productoAgrupado = new Producto(productoActual.getNumeroPedido(), productoActual.getFecha(), codigo, cantidadTotal, precio);
        pilaProductos.push(productoAgrupado);
        listaDeProductos.remove(0); // Removemos el primer producto que ya fue procesado
    }

    return pilaProductos;
}

	public static double mostrarArticulosEnPila(Stack<Producto> pilaProductos) {
    double valorTotal = 0;

    // Recorrer la pila de productos
    for (Producto producto : pilaProductos) {
        int cantidad = producto.getCantidadPedida();
        double precio = producto.getPrecio();
        double valorArticulo = cantidad * precio;

        // Mostrar la cantidad pedida y el valor (cantidad * precio)
        System.out.println("Código Producto: " + producto.getCodigoProducto() + 
                           ", Cantidad Pedida: " + cantidad + 
                           ", Valor Total: $" + valorArticulo);

        // Acumular el valor total de todos los artículos
        valorTotal += valorArticulo;
    }

    return valorTotal;
}

	public static double mostrarTotalRecursivo(Stack<Producto> pilaProductos, int index) {
    if (index >= pilaProductos.size()) {
        return 0; // Caso base: si hemos recorrido toda la pila, retornamos 0
    }

    Producto producto = pilaProductos.get(index);
    double valorArticulo = producto.getCantidadPedida() * producto.getPrecio();

    // Llamada recursiva sumando el valor del artículo actual al de los siguientes
    return valorArticulo + mostrarTotalRecursivo(pilaProductos, index + 1);
}

	
	
}
