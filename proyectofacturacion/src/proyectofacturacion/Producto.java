package proyectofacturacion;

/**
 *
 * @author rasta
 */
public class Producto {

    // Variables - Atributos
    private String nombreProd;
    private int codigo;
    private char categoria;
    boolean impuesto;
    private double precio;
    private int cantidad;
    private double peso;

    // Constructor
    public Producto() {
        this("Chicharron", 20, 3, 345879, 'L', 1);
    }

    public Producto(String nombreProd, double precio, int cantidad, int codigo, char categoria, double peso) {
        this.nombreProd = nombreProd;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.categoria = categoria;
        this.impuesto = categoria == 'I';
        this.peso = peso;
    }

    public void mostrarProducto() {
        System.out.println("=================================");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombreProd);
        System.out.println("Categoría: " + categoria);
        System.out.println("Precio: L. " + precio);
        System.out.println("Existencia: " + cantidad);
        System.out.println("=================================");
    }

    // Funciones - Metodos
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: el precio no puede ser negativo.");
        }
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("Error: la cantidad no puede ser negativa.");
        }
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setPeso(double peso) {
        if (peso >= 0) {
            this.peso = peso;
        } else {
            System.out.println("Error: el peso no puede ser negativo.");
        }
    }

    public double getPeso() {
        return this.peso;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
        this.impuesto = categoria == 'I';
    }

    public boolean isImpuesto() {
        return impuesto;
    }
}

