import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializamos el inventario
        Inventario inventario = new Inventario("PC-Component's", new ArrayList<>());

        // Productos iniciales
        inventario.agregarProducto(new Productos("P001", "Portátil Lenovo", 750.00, Categorias.PC, 10));
        inventario.agregarProducto(new Productos("P002", "Ratón Logitech", 25.99, Categorias.PC, 30));
        inventario.agregarProducto(new Productos("P003", "Teclado Mecánico", 55.00, Categorias.PC, 15));
        inventario.agregarProducto(new Productos("P004", "Smartphone Samsung", 899.00, Categorias.MOVIL, 8));
        inventario.agregarProducto(new Productos("P005", "Auriculares Sony", 120.50, Categorias.MOVIL, 20));
        inventario.agregarProducto(new Productos("P006", "Tablet iPad", 450.00, Categorias.TABLET, 12));
        inventario.agregarProducto(new Productos("P007", "Tablet Samsung", 399.00, Categorias.TABLET, 7));

        boolean repetir = true;

        while (repetir) {
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Nuevo Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Buscar Producto");
            System.out.println("5. Mostrar Inventario");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("--- Crear Producto ---");
                    System.out.print("Código del producto: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio del producto: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Categoría del producto (PC, MOVIL, TABLET): ");
                    String categoriaStr = sc.nextLine();
                    Categorias categoria = Categorias.valueOf(categoriaStr.toUpperCase());

                    System.out.print("Stock del producto: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    Productos nuevoProducto = new Productos(codigo, nombre, precio, categoria, stock);
                    inventario.agregarProducto(nuevoProducto);
                    break;

                case 2:
                    System.out.println("--- Modificar Producto ---");
                    System.out.print("Código del producto a actualizar: ");
                    String codUpdate = sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nombreNuevo = sc.nextLine();

                    System.out.print("Nuevo precio: ");
                    double precioNuevo = sc.nextDouble();

                    System.out.print("Nuevo stock: ");
                    int stockNuevo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nueva categoría (PC, MOVIL, TABLET): ");
                    String categoriaNueva = sc.nextLine();
                    Categorias catNueva = Categorias.valueOf(categoriaNueva.toUpperCase());

                    Productos productoModificado = new Productos(codUpdate, nombreNuevo, precioNuevo, catNueva, stockNuevo);
                    inventario.modificarProducto(codUpdate, productoModificado);
                    break;

                case 3:
                    System.out.println("--- Eliminar Producto ---");
                    System.out.print("Código del producto: ");
                    String codEliminar = sc.nextLine();
                    inventario.eliminarProducto(codEliminar);
                    break;

                case 4:
                    System.out.println("--- Buscar Producto ---");
                    System.out.print("Código del producto: ");
                    String codBuscar = sc.nextLine();
                    String resultado = Inventario.buscarProducto(codBuscar, new ArrayList<>(inventario.inventario));
                    System.out.println(resultado);
                    break;

                case 5:
                    System.out.println("--- Mostrar Inventario ---");
                    for (Productos p : inventario.inventario) {
                        System.out.println(p);
                    }
                    break;

                case 0:
                    repetir = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
