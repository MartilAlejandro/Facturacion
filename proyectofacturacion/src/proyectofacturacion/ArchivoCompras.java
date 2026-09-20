/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofacturacion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author marti
 */
public class ArchivoCompras {

    // Método para guardar una compra en el archivo
    public static void guardarCompra(Compra compra) {

        try {

            FileWriter archivo = new FileWriter("compras.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);

            escribir.println(
                    compra.codigoCompra + "," +
                    compra.codigoProveedor + "," +
                    compra.codigoProducto + "," +
                    compra.cantidad + "," +
                    compra.precio + "," +
                    compra.total
            );

            escribir.close();
            archivo.close();

        } catch (IOException e) {

            System.out.println("Error al guardar la compra.");
        }
    }

    // Método para cargar las compras guardadas en el archivo
    public static int cargarCompras(Compra[] compras) {

        try {

            File archivo = new File("compras.txt");

            if (!archivo.exists()) {
                return 0;
            }

            Scanner leer = new Scanner(archivo);

            int posicion = 0;

            while (leer.hasNextLine() && posicion < compras.length) {

                String linea = leer.nextLine();

                String[] datos = linea.split(",");

                String codigoCompra = datos[0];
                String codigoProveedor = datos[1];

                int codigoProducto =
                        Integer.parseInt(datos[2]);

                int cantidad =
                        Integer.parseInt(datos[3]);

                double precio =
                        Double.parseDouble(datos[4]);

                compras[posicion] = new Compra(
                        codigoCompra,
                        codigoProveedor,
                        codigoProducto,
                        cantidad,
                        precio
                );

                posicion++;
            }

            leer.close();

            return posicion;

        } catch (Exception e) {

            System.out.println("Error al cargar las compras.");
            return 0;
        }
    }

    // Método para guardar nuevamente todas las compras
    public static void guardarTodas(
            Compra[] compras,
            int cantidadCompras) {

        try {

            FileWriter archivo =
                    new FileWriter("compras.txt", false);

            PrintWriter escribir =
                    new PrintWriter(archivo);

            for (int i = 0; i < cantidadCompras; i++) {

                escribir.println(
                        compras[i].codigoCompra + "," +
                        compras[i].codigoProveedor + "," +
                        compras[i].codigoProducto + "," +
                        compras[i].cantidad + "," +
                        compras[i].precio + "," +
                        compras[i].total
                );
            }

            escribir.close();
            archivo.close();

        } catch (IOException e) {

            System.out.println("Error al guardar todas las compras.");
        }
    }
}
