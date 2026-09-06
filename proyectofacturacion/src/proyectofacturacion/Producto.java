/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;

/**
 *
 * @author rasta
 */
public class Producto {
    //Variables - Atributos
    public String nombre; 
    public int codigo;
    public char categoria;
    public boolean impuesto;
    
    private double precio;
    private int cantidad;
    private double peso;
    
    // Constructor
    public Producto(){
        this.nombre = "Chicharron";
        this.precio = 20;
        this.cantidad = 3;
        this.codigo = 345879;
        this.categoria = 'L';
        if (categoria == 'I') {
    this.impuesto = true;
} else {
    this.impuesto = false;
}
        this.peso = 1;
    }// fin constructor 1 
    
    public Producto (String nombre,double precio, int cantidad, int codigo, char categoria, double peso){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.categoria = categoria;
        if (categoria == 'I') {
        this.impuesto = true;
        } else {
        this.impuesto = false;
        }
        this.peso = peso;
        }//fin constructor 2 
    
    //Funciones - Metodos
    
    public void setPrecio(double precio) {
    if (precio >= 0) {
        this.precio = precio;
    } else {
        System.out.println("Error: el precio no puede ser negativo.");
    }
}// fin de set precio

public double getPrecio() {
    return this.precio;
}// fin de getprecio

public void setCantidad(int cantidad) {
    if (cantidad >= 0) {
        this.cantidad = cantidad;
    } else {
        System.out.println("Error: la cantidad no puede ser negativa.");
    }
}/// fin de setCantidad

public int getCantidad() {
    return this.cantidad;
}// fin getCantidad

public void setPeso(double peso) {
    if (peso >= 0) {
        this.peso = peso;
    } else {
        System.out.println("Error: el peso no puede ser negativo.");
    }
}// fin de set peso

public double getPeso() {
    return this.peso;
}// fin de get peso 

    
}// Fin class producto
