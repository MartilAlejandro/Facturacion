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
public class ArchivoProveedores {

    // Metodo para guardar un proveedor
    public static void guardarProveedor(Proveedor proveedor) {

        try {

            FileWriter archivo = new FileWriter("proveedores.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);

            escribir.println(
                proveedor.codigoProveedor + "," +
                proveedor.nombreProveedor + "," +
                proveedor.RTN + "," +
                proveedor.telefono + "," +
                proveedor.producto
            );

            escribir.close();
            archivo.close();

        } catch (IOException e) {

            System.out.println("Error al guardar el proveedor.");

        }
    }


    // Metodo para cargar los proveedores
    public static int cargarProveedores(Proveedor[] proveedores) {

        try {

            java.io.File archivo = new java.io.File("proveedores.txt");

            if (!archivo.exists()) {

                return 0;
            }

            java.util.Scanner leer = new java.util.Scanner(archivo);

            int posicion = 0;

            while (leer.hasNextLine() && posicion < proveedores.length) {

                String linea = leer.nextLine();

                String[] datos = linea.split(",");

                String codigoProveedor = datos[0];
                String nombreProveedor = datos[1];
                String RTN = datos[2];
                String telefono = datos[3];
                String producto = datos[4];

                proveedores[posicion] = new Proveedor(
                        nombreProveedor,
                        codigoProveedor,
                        RTN,
                        telefono,
                        producto
                );

                posicion++;
            }

            leer.close();

            return posicion;

        } catch (Exception e) {

            System.out.println("Error al cargar los proveedores.");

            return 0;
        }
    }


    // Metodo para guardar todos los proveedores
    public static void guardarTodos(Proveedor[] proveedores, int cantidadProveedores) {

        try {

            FileWriter archivo = new FileWriter("proveedores.txt", false);
            PrintWriter escribir = new PrintWriter(archivo);

            for (int i = 0; i < cantidadProveedores; i++) {

                escribir.println(
                    proveedores[i].codigoProveedor + "," +
                    proveedores[i].nombreProveedor + "," +
                    proveedores[i].RTN + "," +
                    proveedores[i].telefono + "," +
                    proveedores[i].producto
                );
            }

            escribir.close();
            archivo.close();

        } catch (IOException e) {

            System.out.println("Error al guardar los proveedores.");

        }
    }
}
