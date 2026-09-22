/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;
import java.util.ArrayList;

/**
 *
 * @author rasta
 */
public class Factura{
    //Variables - atributos
    public String numeroFactura;
    public String fecha;
    public String hora;
    public Cliente cliente;
    public ArrayList<Producto> productos;
        
    private char metodoPago;
    private int totalProductos;
    private double subtotal;
    private double descuento;
    private double impuesto;
    private double totalPagar;
    private double efectivoRecibido;
    private double cambio;
    /**
     * 9/18 para cliente use el new como hicimos en introPOO con Javier en Persona pq no lo use como variable si no q lo jale de la otra clase,
     * Para el arrayList hice como en arreglos dinamicos para crear el arraylist vacio que jale los productos con el .add
     */
    // Constructor1
    public Factura(){
    this.numeroFactura = "Factura #1";
    this.fecha = "19/09/2026";
    this.hora = "2:30 PM";
    this.cliente = new Cliente();
    this.productos = new ArrayList<Producto>();
    this.metodoPago = 'E';
    this.totalProductos = 0;
    this.subtotal = 0;
    this.descuento = 0;
    this.impuesto = 0;
    this.totalPagar = 0;
    this.efectivoRecibido = 0;
    this.cambio = 0;
        
    }//Fin constructor1
        
    // COnstructor 2
    public Factura(String numeroFactura, String fecha, String hora, char metodoPago, Cliente cliente, ArrayList<Producto> productos, double efectivoRecibido) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.hora = hora;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
        this.productos = productos;
        this.efectivoRecibido = efectivoRecibido;
        

        
    }// Fin constructo2

    // funcinoes/metodos
    
    public void setefectivoRecibido(double efectivoRecibido){
        if (efectivoRecibido >= 0){
            this.efectivoRecibido = efectivoRecibido;
            } else {
            System.out.println("Error: el efectivo no puede ser negativo");
        }//fin else
            
    }//fin setEfect
public double getefectivoRecibido(){
    return this.efectivoRecibido;
}//fin getEfe

 public void setmetodoPago(char metodoPago){
        if (metodoPago == 'E'|| metodoPago == 'T'){
            this.metodoPago = metodoPago;
    } else {
            System.out.println("Solo aceptamos Efectivo o Tarjeta");
            } 
    }// fin setmetodoPago
    public char getmetodoPago(){
        return this.metodoPago;
    }//fin getmetodoPago
    
    public int getTotalProductos() {
        return this.totalProductos;
    }//fin getTotalProductos

    public double getSubtotal() {
        return this.subtotal;
    }//fin getSubtotal

    public double getImpuesto() {
        return this.impuesto;
    }//fin getImpuesto

    public double getTotalPagar() {
        return this.totalPagar;
    }//fin getTotalPagar

    public double getCambio() {
        return this.cambio;
    }//fin getCambio
    
    public void calcularTotales(){
        this.totalProductos = 0;
        this.subtotal = 0;
        this.impuesto = 0;
        
        for (int i = 0; i < this.productos.size(); i++){
            Producto p = this.productos.get(i);
            double totalLinea = p.getPrecio() * p.getCantidad();
            
            this.totalProductos += p.getCantidad();
            this.subtotal += totalLinea;
            
            if(p.impuesto == true){
                this.impuesto += totalLinea * 0.15;
            }//fin if
        }//fin For
        
        this.totalPagar = this.subtotal + this.impuesto - this.descuento;
       if (this.metodoPago == 'T') {
    this.cambio = 0; // con tarjeta se cobra el total exacto, no hay cambio
} else {
    this.cambio = this.efectivoRecibido - this.totalPagar;
}
    }// Fin calcularTotales

}// Fin class Factura
