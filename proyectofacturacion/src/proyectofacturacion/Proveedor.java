/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;

/**
 *
 * @author marti
 */
public class Proveedor {

    // Datos del proveedor
    public String nombreProveedor;
    public String codigoProveedor;
    public String RTN;
    public String telefono;
    public String producto;

    // Constructor con datos predeterminados
    public Proveedor() {
        this.nombreProveedor = "Proveedor General";
        this.codigoProveedor = "001";
        this.RTN = "08011999123456";
        this.telefono = "9999-9999";
        this.producto = "Producto General";
    }

    // Constructor para registrar un proveedor con sus datos
    public Proveedor(String nombreProveedor, String codigoProveedor,String RTN, String telefono, String producto) {

        this.nombreProveedor = nombreProveedor;
        this.codigoProveedor = codigoProveedor;
        this.RTN = RTN;
        this.telefono = telefono;
        this.producto = producto;
    }

    // Método para mostrar los datos del proveedor
    public void mostrarProveedor() {

        System.out.println("=================================");
        System.out.println("Codigo: " + codigoProveedor);
        System.out.println("Nombre: " + nombreProveedor);
        System.out.println("RTN: " + RTN);
        System.out.println("Telefono: " + telefono);
        System.out.println("Producto: " + producto);
        System.out.println("=================================");
    }
}