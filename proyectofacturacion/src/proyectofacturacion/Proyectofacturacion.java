/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofacturacion;

import java.util.Scanner;


/**
 *
 * @author marti
 */


public class Proyectofacturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
   Scanner Entrada = new Scanner(System.in);
   Producto[] productos = new Producto[10];
   
      int cantidadProductos = 0;
      int Menu =0;
      int Smenu =0;
     
      

      
      
      //Titulos del sistema 
      System.out.println("                      ======================");
      System.out.println("                      Sistema de facturacion");
      System.out.println("                      ======================");

    
    
      do{
      //Menu Principal del sistema de facturacion 
      System.out.println("=========================================");
      System.out.println("Menu principal del sistema de facturacion");
      System.out.println("1.Facturacion");
      System.out.println("2.Inventarios");
      System.out.println("3.Productos");
      System.out.println("4.Clientes");
      System.out.println("5.Proveedores");
      System.out.println("6.Compras");
      System.out.println("7.Reportes");
      System.out.println("8.Usuario");
      System.out.println("9.Configuracion");
      System.out.println("0.Salir");
      System.out.println("=========================================");
      Menu = Entrada.nextInt();
    
      switch(Menu){
        case 1:
       do{
      //Sub Menu Principal del sistema de facturacion 
      System.out.println("=========================================");
      System.out.println("          Menu de facturacion");
      System.out.println("1.Nueva Factura");
      System.out.println("2.Buscar Factura");
      System.out.println("3.Anular factura");
      System.out.println("4.Facturas del dia");
      System.out.println("5.Facturas por fecha");
      System.out.println("6.Devoluciones");
      System.out.println("7.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
        switch(Smenu){
        case 1:
        System.out.println("Nueva Factura");
        break;
        case 2:
        System.out.println("Buscar factura");
        break;
        case 3:
        System.out.println("Anular factura");
        break;
        case 4:
        System.out.println("facturas del dia");
        break;
         case 5:
        System.out.println("facturas por fechas");
        break;
        case 6:
        System.out.println("devoluciones");
        break;
        case 7:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=7 );
        break;

        case 2:
       do{
      //Sub Menu Principal del Inventario
      System.out.println("=========================================");
      System.out.println("           Menu de Inventarios");
      System.out.println("1.Ver Inventario");
      System.out.println("2.Entrada de Producto");
      System.out.println("3.Salida de producto");
      System.out.println("4.Ajustar existencia");
      System.out.println("5.Productos con bajo Stock");
      System.out.println("6.Historial de movimientos");
      System.out.println("7.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
        System.out.println("inventario");
        break;
        case 2:
        System.out.println("entrada de producto");
        break;
        case 3:
        System.out.println("salida de producto");
        break;
        case 4:
        System.out.println("ajustar existencia");
        break;
         case 5:
        System.out.println("productos con bajo stock");
        break;
        case 6:
        System.out.println("historial de movimientos");
        break;
        case 7:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=7 );
        break;

         case 3:
       do{
      //Sub Menu Principal de Productos
      System.out.println("=========================================");
      System.out.println("             Menu de Producto");
      System.out.println("1.Registrar Productos");
      System.out.println("2.Buscar Productos");
      System.out.println("3.Modificar Productos");
      System.out.println("4.Eliminar Productos");
      System.out.println("5.Lista de Productos");
      System.out.println("6.Categorias de producto");
      System.out.println("7.Precio");
      System.out.println("8.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:

    if (cantidadProductos >= 10) {

        System.out.println("No se pueden registrar más de 10 productos.");

    } else {

        System.out.println("REGISTRAR PRODUCTO");

        System.out.print("Ingrese código: ");
        String codigo = Entrada.next();

        System.out.print("Ingrese nombre: ");
        String nombre = Entrada.next();

        System.out.print("Ingrese categoría: ");
        String categoria = Entrada.next();

        System.out.print("Ingrese precio: ");
        double precio = Entrada.nextDouble();

        System.out.print("Ingrese existencia: ");
        int existencia = Entrada.nextInt();

         productos[cantidadProductos] =
                new Producto(codigo, nombre, categoria, precio, existencia);



        cantidadProductos++;

        System.out.println("Producto registrado correctamente.");
    }

    break;
       case 2:

    System.out.println("BUSCAR PRODUCTO");

    System.out.print("Ingrese el código del producto: ");
    String codigoBuscar = Entrada.next();

    boolean encontrado = false;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].codigo.equals(codigoBuscar)) {

            System.out.println("Producto encontrado");
            System.out.println("Código: " + productos[i].codigo);
            System.out.println("Nombre: " + productos[i].nombre);
            System.out.println("Categoría: " + productos[i].categoria);
            System.out.println("Precio: " + productos[i].precio);
            System.out.println("Existencia: " + productos[i].existencia);

            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Producto no encontrado.");
    }

    break;
       case 3:

    System.out.println("MODIFICAR PRODUCTO");

    System.out.print("Ingrese el código del producto: ");
    String codigoModificar = Entrada.next();

    boolean encontradoModificar = false;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].codigo.equals(codigoModificar)) {

            System.out.println("Producto encontrado.");
            System.out.println("Datos actuales:");
            System.out.println("Código: " + productos[i].codigo);
            System.out.println("Nombre: " + productos[i].nombre);
            System.out.println("Categoría: " + productos[i].categoria);
            System.out.println("Precio: " + productos[i].precio);
            System.out.println("Existencia: " + productos[i].existencia);

            System.out.println("--------------------------------");

            System.out.print("Ingrese nuevo nombre: ");
            productos[i].nombre = Entrada.next();

            System.out.print("Ingrese nueva categoría: ");
            productos[i].categoria = Entrada.next();

            System.out.print("Ingrese nuevo precio: ");
            productos[i].precio = Entrada.nextDouble();

            System.out.print("Ingrese nueva existencia: ");
            productos[i].existencia = Entrada.nextInt();

            System.out.println("Producto modificado correctamente.");

            encontradoModificar = true;
            break;
        }
    }

    if (!encontradoModificar) {
        System.out.println("Producto no encontrado.");
    }

    break;
        case 4:

    System.out.println("ELIMINAR PRODUCTO");

    System.out.print("Ingrese el código del producto: ");
    String codigoEliminar = Entrada.next();

    boolean encontradoEliminar = false;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].codigo.equals(codigoEliminar)) {

            System.out.println("Producto encontrado.");
            System.out.println("Código: " + productos[i].codigo);
            System.out.println("Nombre: " + productos[i].nombre);
            System.out.println("Categoría: " + productos[i].categoria);
            System.out.println("Precio: " + productos[i].precio);
            System.out.println("Existencia: " + productos[i].existencia);

            System.out.print("¿Está seguro de eliminarlo? (1=Sí / 2=No): ");
            int confirmar = Entrada.nextInt();

            if (confirmar == 1) {

                // Mover los productos siguientes una posición hacia atrás
                for (int j = i; j < cantidadProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }

                // Limpiar la última posición
                productos[cantidadProductos - 1] = null;

                cantidadProductos--;

                System.out.println("Producto eliminado correctamente.");

            } else {

                System.out.println("Eliminación cancelada.");
            }

            encontradoEliminar = true;
            break;
        }
    }

    if (!encontradoEliminar) {
        System.out.println("Producto no encontrado.");
    }

    break;
        case 5:

    System.out.println("LISTA DE PRODUCTOS");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        for (int i = 0; i < cantidadProductos; i++) {

            System.out.println("--------------------------------");
            System.out.println("Producto #" + (i + 1));
            System.out.println("Código: " + productos[i].codigo);
            System.out.println("Nombre: " + productos[i].nombre);
            System.out.println("Categoría: " + productos[i].categoria);
            System.out.println("Precio: " + productos[i].precio);
            System.out.println("Existencia: " + productos[i].existencia);
        }

        System.out.println("--------------------------------");
    }

    break;
        case 6:

    System.out.println("CATEGORIAS DE PRODUCTOS");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        System.out.println("Categorías registradas:");

        for (int i = 0; i < cantidadProductos; i++) {

            boolean repetida = false;

            for (int j = 0; j < i; j++) {

                if (productos[i].categoria.equalsIgnoreCase(productos[j].categoria)) {
                    repetida = true;
                    break;
                }
            }

            if (!repetida) {
                System.out.println("- " + productos[i].categoria);
            }
        }
    }

    break;
        case 7:

    System.out.println("CONSULTAR PRECIO");

    System.out.print("Ingrese el código del producto: ");
    String codigoPrecio = Entrada.next();

    boolean encontradoPrecio = false;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].codigo.equals(codigoPrecio)) {

            System.out.println("Producto encontrado.");
            System.out.println("Código: " + productos[i].codigo);
            System.out.println("Nombre: " + productos[i].nombre);
            System.out.println("Precio: " + productos[i].precio);

            encontradoPrecio = true;
            break;
        }
    }

    if (!encontradoPrecio) {
        System.out.println("Producto no encontrado.");
    }

    break;
        case 8:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=8 );
        break;

        case 4:
       do{
      //Sub Menu Principal de Clientes
      System.out.println("=========================================");
      System.out.println("             Menu de Cliente");
      System.out.println("1.Registrar cliente");
      System.out.println("2.Buscar cliente");
      System.out.println("3.Modificar cliente");
      System.out.println("4.Eliminar cliente");
      System.out.println("5.Listar clientes");
      System.out.println("6.Historial de compras");
      System.out.println("7.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
        System.out.println("Clientes");
        break;
        case 2:
        System.out.println("Registrar Cliente");
        break;
        case 3:
        System.out.println("Buscar Cliente");
        break;
        case 4:
        System.out.println("Modificar cliente");
        break;
         case 5:
        System.out.println("Lista de clientes");
        break;
        case 6:
        System.out.println("Historial de compras");
        break;
        case 7:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=7 );
        break;

         case 5:
       do{
      //Sub Menu Principal de Proveedores
      System.out.println("=========================================");
      System.out.println("            Menu de Proveedores");
      System.out.println("1.Registrar Proveedor");
      System.out.println("2.Buscar Proveedor");
      System.out.println("3.Modificar Proveedor");
      System.out.println("4.Eliminar Proveedor");
      System.out.println("5.Lista de Proveedores");
      System.out.println("6.Historial de compras");
      System.out.println("7.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
        System.out.println("registrar Proveedores");
        break;
        case 2:
        System.out.println("Buscar Proveedor");
        break;
        case 3:
        System.out.println("Modificar Proveedor");
        break;
        case 4:
        System.out.println("Eliminar proveedores");
        break;
         case 5:
        System.out.println("Lista de Proveedores");
        break;
        case 6:
        System.out.println("Historial de compras");
        break;
        case 7:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=7 );
        break;


         case 6:
       do{
      //Sub Menu Principal de compras
      System.out.println("=========================================");
      System.out.println("            Menu de compras");
      System.out.println("1.Registrar Compras");
      System.out.println("2.Buscar compras");
      System.out.println("3.ver compras realizadas");
      System.out.println("4.anular compra");
      System.out.println("5.consultar detalle de compras");
      System.out.println("6.Historial de compras");
      System.out.println("7.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
        System.out.println("registrar compras");
        break;
        case 2:
        System.out.println("Buscar compras");
        break;
        case 3:
        System.out.println("ver compras realizadas");
        break;
        case 4:
        System.out.println("anular compra");
        break;
         case 5:
        System.out.println("consultar detalle de compras");
        break;
        case 6:
        System.out.println("Historial de compras");
        break;
        case 7:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=7 );
        break;

         case 7:
       do{
      //Sub Menu Principal de reportes
      System.out.println("=========================================");
      System.out.println("            Menu de reportes");
      System.out.println("1.Reportes de venta");
      System.out.println("2.reportes de producto");
      System.out.println("3.reporte de clientes");
      System.out.println("4.reporte de inventario");
      System.out.println("5.reporte de compras");
      System.out.println("6.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
        System.out.println("Reportes de venta");
        break;
        case 2:
        System.out.println("reportes de producto");
        break;
        case 3:
        System.out.println("reporte de clientes");
        break;
        case 4:
        System.out.println("reporte de inventario");
        break;
         case 5:
        System.out.println("reporte de compras");
        break;
        case 6:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=6);
        break;

         case 8:
       do{
      //Sub Menu Principal de usuario
      System.out.println("=========================================");
      System.out.println("            Menu de Proveedores");
      System.out.println("1.Registrar usuario");
      System.out.println("2.Buscar usuario");
      System.out.println("3.Modificar usuario");
      System.out.println("4.Eliminar usuario");
      System.out.println("5.Lista de usuarios");
      System.out.println("6.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
        System.out.println("registrar usuario");
        break;
        case 2:
        System.out.println("Buscar usuario");
        break;
        case 3:
        System.out.println("Modificar usuario");
        break;
        case 4:
        System.out.println("Eliminar usuario");
        break;
         case 5:
        System.out.println("Lista de usuario");
        break;
        case 6:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=6 );
        break;

         case 9:
       do{
      //Sub Menu Principal de configuracion
      System.out.println("=========================================");
      System.out.println("            Menu de Proveedores");
      System.out.println("1.Datos de la empresa");
      System.out.println("2.Configurar impuesto");
      System.out.println("3.configurar descuento");
      System.out.println("4.configurar sistema");
      System.out.println("5.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
        System.out.println("datos de la empresa");
        break;
        case 2:
        System.out.println("configurar impuesto");
        break;
        case 3:
        System.out.println("configurar descuento");
        break;
        case 4:
        System.out.println("configurar sistema");
        break;
         case 5:
        System.out.println("Regresar al menu principal");
        break;
        default:
        System.out.println("opcion invalida");
        break;
        }//fin del submenu
        }while(Smenu !=5 );
        break;
        
        case 0:
        System.out.println("saliendo del sistema");
        break;
        default:
        System.out.println("opcion invalida");
        break;

      }//fin del menu

      
        

      }while(Menu !=0);

            
  }//fin main

}//fin class

