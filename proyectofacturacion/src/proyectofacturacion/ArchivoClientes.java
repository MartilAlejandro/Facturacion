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

public class ArchivoClientes {

    // Metodo para guardar un cliente
    public static void guardarCliente(Cliente cliente) {

        try {

            FileWriter archivo = new FileWriter("clientes.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);

            escribir.println(
                cliente.memberID + "," +
                cliente.nombreCliente + "," +
                cliente.getmemberType() + "," +
                cliente.RTN + "," +
                cliente.getEdad()
            );

            escribir.close();
            archivo.close();

        } catch (IOException e) {

            System.out.println("Error al guardar el cliente.");

        }
    }


    // Metodo para cargar los clientes
    public static int cargarClientes(Cliente[] clientes) {

        try {

            java.io.File archivo = new java.io.File("clientes.txt");

            if (!archivo.exists()) {

                return 0;
            }

            java.util.Scanner leer = new java.util.Scanner(archivo);

            int posicion = 0;

            while (leer.hasNextLine() && posicion < clientes.length) {

                String linea = leer.nextLine();

                String[] datos = linea.split(",");

                String memberID = datos[0];
                String nombreCliente = datos[1];
                char memberType = datos[2].charAt(0);
                String RTN = datos[3];
                int Edad = Integer.parseInt(datos[4]);

                clientes[posicion] = new Cliente(nombreCliente,memberID,memberType,RTN,Edad);

                posicion++;
            }

            leer.close();

            return posicion;

        } catch (Exception e) {

            System.out.println("Error al cargar los clientes.");

            return 0;
        }
    }


    // Metodo para guardar todos los clientes
    public static void guardarTodos(Cliente[] clientes, int cantidadClientes) {

        try {

            FileWriter archivo = new FileWriter("clientes.txt", false);
            PrintWriter escribir = new PrintWriter(archivo);

            for (int i = 0; i < cantidadClientes; i++) {

                escribir.println(
                    clientes[i].memberID + "," +
                    clientes[i].nombreCliente + "," +
                    clientes[i].getmemberType() + "," +
                    clientes[i].RTN + "," +
                    clientes[i].getEdad()
                );
            }

            escribir.close();
            archivo.close();

        } catch (IOException e) {

            System.out.println("Error al guardar los clientes.");

        }
    }
}