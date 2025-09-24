import java.util.ArrayList;

public class Inventario {
    //Atributos
    private String nombreTienda;
    public ArrayList<Productos>inventario;

    //Constructor

    public Inventario(String nombreTienda, ArrayList<Productos> inventario) {
        this.nombreTienda = nombreTienda;
        this.inventario = inventario;
    }

    //Metodos basicos

    //Agregar un producto - 0(1)
    public void agregarProducto(Productos producto) {
        inventario.add(producto);
    }
    //Eliminar un producto - 0(n)
    public void eliminarProducto(String codigoProducto) {
        boolean eliminado = false;
        int i = 0;
        while (i < inventario.size() && !eliminado) {
            if (inventario.get(i).getCodProducto().equals(codigoProducto)) {
                inventario.remove(i);
                eliminado = true;
                System.out.println("El producto " + codigoProducto + " se eliminado.");
            }else {
                i++;
            }
        }
        if (!eliminado) {
            System.out.println("El producto " + codigoProducto + " no existe.");
        }
    }
    // Actualizar Producto - O(n)
    public void modificarProducto(String codigoProducto, Productos producto) {
        boolean modificado = false;
        int i = 0;

        while (i < inventario.size() && !modificado) {
            if (inventario.get(i).getCodProducto().equals(codigoProducto)) {
                inventario.set(i, producto);
                modificado = true;
                System.out.println("El producto " + codigoProducto + " se modificó.");
            } else {
                i++;
            }
        }

        if (!modificado) {
            System.out.println("El producto " + codigoProducto + " no existe.");
        }
    }
    //Buscar producto - 0(n)
    public static String buscarProducto (String codigoProducto, ArrayList<Productos> inventario) {
        boolean buscado = false;
        int i = 0;
        while (i < inventario.size() && !buscado) {
            if (inventario.get(i).getCodProducto().equals(codigoProducto)) {
                buscado = true;
                Productos producto = inventario.get(i);
                return producto.toString();
            }
        }
        return "No se encontró el producto " + codigoProducto;
    }

}
