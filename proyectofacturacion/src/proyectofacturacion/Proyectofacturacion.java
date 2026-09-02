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
        System.out.println("Producto");
        break;
        case 2:
        System.out.println("buscar producto");
        break;
        case 3:
        System.out.println("modificar producto");
        break;
        case 4:
        System.out.println("eliminar producto");
        break;
         case 5:
        System.out.println("Lista de producto");
        break;
        case 6:
        System.out.println("categoria de productos");
        break;
        case 7:
        System.out.println("Precio de productos");
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


        //me quede por aqui 

         case 6:
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

         case 7:
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

         case 8:
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

         case 9:
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

