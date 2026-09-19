/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author marti
 */
public class ArchivoProductos {

    // Metodo para guardar un producto
    public static void guardarProducto(Producto producto) {

        try {

            FileWriter archivo = new FileWriter("productos.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);

            escribir.println(
                producto.getCodigo() + "," +
                producto.getNombreProd() + "," +
                producto.getPrecio() + "," +
                producto.getCantidad() + "," +
                producto.getCategoria() + "," +
                producto.getPeso()
            );

            escribir.close();
            archivo.close();

        } catch (IOException e) {

            System.out.println("Error al guardar el producto.");

        }
    }


    // Metodo para cargar los productos
    public static int cargarProductos(Producto[] productos) {

        try {

            java.io.File archivo = new java.io.File("productos.txt");

            if (!archivo.exists()) {

                return 0;
            }

            java.util.Scanner leer = new java.util.Scanner(archivo);

            int posicion = 0;

            while (leer.hasNextLine() && posicion < productos.length) {

                String linea = leer.nextLine();

                String[] datos = linea.split(",");

                int codigo = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                int cantidad = Integer.parseInt(datos[3]);
                char categoria = datos[4].charAt(0);
                double peso = Double.parseDouble(datos[5]);

                productos[posicion] = new Producto(nombre,precio,cantidad,codigo,categoria,peso);

                posicion++;
            }

            leer.close();

            return posicion;

        } catch (Exception e) {

            System.out.println("Error al cargar los productos.");

            return 0;
        }
    }
    
    // Metodo para guardar todos los productos
public static void guardarTodos(Producto[] productos, int cantidadProductos) {

    try {

        FileWriter archivo = new FileWriter("productos.txt", false);
        PrintWriter escribir = new PrintWriter(archivo);

        for (int i = 0; i < cantidadProductos; i++) {

            escribir.println(
                productos[i].getCodigo() + "," +
                productos[i].getNombreProd() + "," +
                productos[i].getPrecio() + "," +
                productos[i].getCantidad() + "," +
                productos[i].getCategoria() + "," +
                productos[i].getPeso()
            );
        }

        escribir.close();
        archivo.close();

    } catch (IOException e) {

        System.out.println("Error al guardar los productos.");
    }
}
}
    

    

