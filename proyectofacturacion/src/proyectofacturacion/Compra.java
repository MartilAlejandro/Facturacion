/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;

/**
 *
 * @author marti
 */
public class Compra {

    public String codigoCompra;
    public String codigoProveedor;
    public int codigoProducto;
    public int cantidad;
    public double precio;
    public double total;

    public Compra(String codigoCompra, String codigoProveedor,int codigoProducto, int cantidad, double precio) {

        this.codigoCompra = codigoCompra;
        this.codigoProveedor = codigoProveedor;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = cantidad * precio;
    }

    public void mostrarCompra() {
        System.out.println("=================================");
        System.out.println("Codigo de compra: " + codigoCompra);
        System.out.println("Codigo proveedor: " + codigoProveedor);
        System.out.println("Codigo producto: " + codigoProducto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio de compra: L. " + precio);
        System.out.println("Total: L. " + total);
        System.out.println("=================================");
    }
}
