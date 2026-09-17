/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;

/**
 *
 * @author marti
 */
public class Producto {

    String codigo;
    String nombre;
    String categoria;
    double precio;
    int existencia;

    public Producto(String codigo, String nombre, String categoria,
                     double precio, int existencia) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.existencia = existencia;
    }

    public void mostrarProducto() {

        System.out.println("=================================");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Precio: L. " + precio);
        System.out.println("Existencia: " + existencia);
        System.out.println("=================================");
    }
}