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
   
      
      int cantidadCompras = 0;
      int cantidadProveedores = 0;
      int cantidadClientes = 0;
      int cantidadProductos = 0;
      int Menu =0;
      int Smenu =0;
      
     Compra[] compras = new Compra[10];
     cantidadCompras = ArchivoCompras.cargarCompras(compras);
      
     Proveedor[] proveedores = new Proveedor[10];
     cantidadProveedores = ArchivoProveedores.cargarProveedores(proveedores);
      
     Cliente[] clientes = new Cliente[10];
     cantidadClientes = ArchivoClientes.cargarClientes(clientes);
     
     Producto[] productos = new Producto[10];
     cantidadProductos = ArchivoProductos.cargarProductos(productos);
   

      
      
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
      System.out.println("8.Configuracion");
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

    System.out.println("=========================================");
    System.out.println("             VER INVENTARIO");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        for (int i = 0; i < cantidadProductos; i++) {

            System.out.println("Producto #" + (i + 1));
            System.out.println("Codigo: "
                    + productos[i].getCodigo());
            System.out.println("Nombre: "
                    + productos[i].getNombreProd());
            System.out.println("Categoria: "
                    + productos[i].getCategoria());
            System.out.println("Precio: L. "
                    + productos[i].getPrecio());
            System.out.println("Existencia: "
                    + productos[i].getCantidad());
            System.out.println("Peso: "
                    + productos[i].getPeso());

            System.out.println("-----------------------------------------");
        }

        System.out.println("Total de productos: "
                + cantidadProductos);
    }

    System.out.println("=========================================");

    break;
        case 2:

    System.out.println("=========================================");
    System.out.println("          ENTRADA DE PRODUCTO");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

        break;
    }

    System.out.print("Ingrese el codigo del producto: ");
    int codigoEntrada = Entrada.nextInt();

    int indiceEntrada = -1;

    // Buscar el producto
    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].getCodigo() == codigoEntrada) {

            indiceEntrada = i;

            break;
        }
    }

    // Verificar si existe
    if (indiceEntrada == -1) {

        System.out.println("Producto no encontrado.");

        break;
    }

    System.out.print("Ingrese la cantidad que desea agregar: ");
    int cantidadEntrada = Entrada.nextInt();

    // Validar cantidad
    if (cantidadEntrada <= 0) {

        System.out.println("La cantidad debe ser mayor que 0.");

        break;
    }

    // Obtener existencia actual
    int existenciaActual =
            productos[indiceEntrada].getCantidad();

    // Aumentar existencia
    productos[indiceEntrada].setCantidad(
            existenciaActual + cantidadEntrada
    );

    // Guardar cambios
    ArchivoProductos.guardarTodos(
            productos,
            cantidadProductos
    );

    System.out.println("=========================================");
    System.out.println("Entrada registrada correctamente.");
    System.out.println("Producto: "
            + productos[indiceEntrada].getNombreProd());
    System.out.println("Cantidad agregada: "
            + cantidadEntrada);
    System.out.println("Nueva existencia: "
            + productos[indiceEntrada].getCantidad());
    System.out.println("=========================================");

    break;
    
        case 3:

    System.out.println("=========================================");
    System.out.println("           SALIDA DE PRODUCTO");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

        break;
    }

    System.out.print("Ingrese el codigo del producto: ");
    int codigoSalida = Entrada.nextInt();

    int indiceSalida = -1;

    // Buscar el producto
    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].getCodigo() == codigoSalida) {

            indiceSalida = i;

            break;
        }
    }

    // Verificar si existe
    if (indiceSalida == -1) {

        System.out.println("Producto no encontrado.");

        break;
    }

    System.out.println("Producto: "
            + productos[indiceSalida].getNombreProd());

    System.out.println("Existencia actual: "
            + productos[indiceSalida].getCantidad());

    System.out.print("Ingrese la cantidad que desea retirar: ");
    int cantidadSalida = Entrada.nextInt();

    // Validar cantidad
    if (cantidadSalida <= 0) {

        System.out.println("La cantidad debe ser mayor que 0.");

        break;
    }

    // Verificar existencia suficiente
    if (cantidadSalida > productos[indiceSalida].getCantidad()) {

        System.out.println("No hay suficiente existencia.");

        break;
    }

    // Restar existencia
    int existenciaActual1 =productos[indiceSalida].getCantidad();

    productos[indiceSalida].setCantidad(existenciaActual1 - cantidadSalida);

    // Guardar cambios
    ArchivoProductos.guardarTodos(
            productos,
            cantidadProductos
    );

    System.out.println("=========================================");
    System.out.println("Salida registrada correctamente.");
    System.out.println("Producto: "
            + productos[indiceSalida].getNombreProd());
    System.out.println("Cantidad retirada: "
            + cantidadSalida);
    System.out.println("Nueva existencia: "
            + productos[indiceSalida].getCantidad());
    System.out.println("=========================================");

    break;
    
        case 4:

    System.out.println("=========================================");
    System.out.println("           AJUSTAR EXISTENCIA");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

        break;
    }

    System.out.print("Ingrese el codigo del producto: ");
    int codigoAjustar = Entrada.nextInt();

    int indiceAjustar = -1;

    // Buscar el producto
    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].getCodigo() == codigoAjustar) {

            indiceAjustar = i;

            break;
        }
    }

    // Verificar si existe
    if (indiceAjustar == -1) {

        System.out.println("Producto no encontrado.");

        break;
    }

    System.out.println("Producto: "
            + productos[indiceAjustar].getNombreProd());

    System.out.println("Existencia actual: "
            + productos[indiceAjustar].getCantidad());

    System.out.print("Ingrese la nueva existencia: ");
    int nuevaExistencia = Entrada.nextInt();

    // Validar existencia
    if (nuevaExistencia < 0) {

        System.out.println("La existencia no puede ser negativa.");

        break;
    }

    // Ajustar existencia
    productos[indiceAjustar].setCantidad(nuevaExistencia);

    // Guardar cambios
    ArchivoProductos.guardarTodos(
            productos,
            cantidadProductos
    );

    System.out.println("=========================================");
    System.out.println("Existencia ajustada correctamente.");
    System.out.println("Producto: "
            + productos[indiceAjustar].getNombreProd());
    System.out.println("Nueva existencia: "
            + productos[indiceAjustar].getCantidad());
    System.out.println("=========================================");

    break;
    
        case 5:

    System.out.println("=========================================");
    System.out.println("        PRODUCTOS CON BAJO STOCK");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

        break;
    }

    boolean hayBajoStock = false;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].getCantidad() <= 5) {

            System.out.println("Codigo: "
                    + productos[i].getCodigo());
            System.out.println("Nombre: "
                    + productos[i].getNombreProd());
            System.out.println("Categoria: "
                    + productos[i].getCategoria());
            System.out.println("Precio: L. "
                    + productos[i].getPrecio());
            System.out.println("Existencia: "
                    + productos[i].getCantidad());

            System.out.println("-----------------------------------------");

            hayBajoStock = true;
        }
    }

    if (!hayBajoStock) {

        System.out.println("No hay productos con bajo stock.");
    }

    System.out.println("=========================================");

    break;
    
        case 6:

    System.out.println("=========================================");
    System.out.println("       HISTORIAL DE MOVIMIENTOS");
    System.out.println("=========================================");

    if (cantidadCompras == 0) {

        System.out.println("No hay movimientos registrados.");

        break;
    }

    for (int i = 0; i < cantidadCompras; i++) {

        System.out.println("Movimiento #" + (i + 1));

        System.out.println("Tipo: Entrada");
        System.out.println("Codigo de compra: "
                + compras[i].codigoCompra);
        System.out.println("Codigo de proveedor: "
                + compras[i].codigoProveedor);
        System.out.println("Codigo de producto: "
                + compras[i].codigoProducto);
        System.out.println("Cantidad: "
                + compras[i].cantidad);
        System.out.println("Precio: L. "
                + compras[i].precio);
        System.out.println("Total: L. "
                + compras[i].total);

        System.out.println("-----------------------------------------");
    }

    System.out.println("Total de movimientos: "
            + cantidadCompras);

    System.out.println("=========================================");

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
        do {
        // Sub Menu Principal de Productos
        System.out.println("=========================================");
        System.out.println("             MENU DE PRODUCTOS");
        System.out.println("=========================================");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Buscar Producto");
        System.out.println("3. Modificar Producto");
        System.out.println("4. Eliminar Producto");
        System.out.println("5. Lista de Productos");
        System.out.println("6. Buscar por Categoria");
        System.out.println("7. Consultar Precio");
        System.out.println("8. Regresar al Menu Principal");
        System.out.println("=========================================");

        Smenu = Entrada.nextInt();

        System.out.println("=========================================");

        switch (Smenu) {

           
    case 1:

    if (cantidadProductos < 10) {

        System.out.println("          REGISTRAR PRODUCTO");
        System.out.println("=========================================");

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProd = Entrada.next();

        System.out.print("Ingrese el precio: ");
        double precio = Entrada.nextDouble();

        System.out.print("Ingrese la cantidad Existencia: ");
        int cantidad = Entrada.nextInt();

        System.out.print("Ingrese el codigo: ");
        int codigo = Entrada.nextInt();

        System.out.print("Ingrese la categoria (I/E): ");
        char categoria = Entrada.next().charAt(0);

        System.out.print("Ingrese el peso: ");
        double peso = Entrada.nextDouble();

        productos[cantidadProductos] = new Producto( nombreProd,precio,cantidad,codigo,categoria,peso);
        
        ArchivoProductos.guardarProducto(productos[cantidadProductos]);

        cantidadProductos++;

        System.out.println("=========================================");
        System.out.println("Producto registrado correctamente.");
        System.out.println("=========================================");

    } else {

        System.out.println("=========================================");
        System.out.println("Ya se registraron los 10 productos.");
        System.out.println("No se pueden registrar mas productos.");
        System.out.println("=========================================");
    }

    break;


            

    case 2:

    System.out.println("            BUSCAR PRODUCTO");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        System.out.print("Ingrese el codigo del producto: ");
        int codigoBuscar = Entrada.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getCodigo() == codigoBuscar) {

                System.out.println("=========================================");
                System.out.println("          PRODUCTO ENCONTRADO");
                System.out.println("=========================================");

                productos[i].mostrarProducto();

                System.out.println("Peso: " + productos[i].getPeso());

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Producto no encontrado.");

        }
    }

    break;
    
    case 3:

    System.out.println("          MODIFICAR PRODUCTO");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        System.out.print("Ingrese el codigo del producto: ");
        int codigoModificar = Entrada.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getCodigo() == codigoModificar) {

                System.out.println("Producto encontrado.");
                System.out.println("=========================================");

                System.out.print("Ingrese el nuevo nombre: ");
                productos[i].setNombreProd(Entrada.next());

                System.out.print("Ingrese el nuevo precio: ");
                productos[i].setPrecio(Entrada.nextDouble());

                System.out.print("Ingrese la nueva cantidad: ");
                productos[i].setCantidad(Entrada.nextInt());

                System.out.print("Ingrese la nueva categoria: ");
                productos[i].setCategoria(Entrada.next().charAt(0));

                System.out.print("Ingrese el nuevo peso: ");
                productos[i].setPeso(Entrada.nextDouble());
                
                ArchivoProductos.guardarTodos(productos, cantidadProductos);

                System.out.println("=========================================");
                System.out.println("Producto modificado correctamente.");
                System.out.println("=========================================");

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Producto no encontrado.");

        }
    }

    break;

            case 4:

    System.out.println("           ELIMINAR PRODUCTO");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        System.out.print("Ingrese el codigo del producto: ");
        int codigoEliminar = Entrada.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getCodigo() == codigoEliminar) {

                // Mover los productos hacia la izquierda
                for (int j = i; j < cantidadProductos - 1; j++) {

                    productos[j] = productos[j + 1];
                }

                // Dejar vacia la ultima posicion
                productos[cantidadProductos - 1] = null;

                cantidadProductos--;
                
                ArchivoProductos.guardarTodos(productos, cantidadProductos);

                encontrado = true;

                System.out.println("=========================================");
                System.out.println("Producto eliminado correctamente.");
                System.out.println("=========================================");

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Producto no encontrado.");

        }
    }

    break;

            case 5:

    System.out.println("           LISTA DE PRODUCTOS");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        for (int i = 0; i < cantidadProductos; i++) {

            System.out.println("Producto #" + (i + 1));

            productos[i].mostrarProducto();

            System.out.println("Peso: " + productos[i].getPeso());
            System.out.println();
        }
    }

    break;

            case 6:

    System.out.println("        BUSCAR POR CATEGORIA");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        System.out.print("Ingrese la categoria: ");
        char categoriaBuscar = Entrada.next().charAt(0);

        boolean encontrado = false;

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getCategoria() == categoriaBuscar) {

                productos[i].mostrarProducto();

                System.out.println("Peso: " + productos[i].getPeso());

                encontrado = true;
            }
        }

        if (!encontrado) {

            System.out.println("No hay productos en esa categoria.");

        }
    }

    break;

           case 7:

    System.out.println("           CONSULTAR PRECIO");
    System.out.println("=========================================");

    if (cantidadProductos == 0) {

        System.out.println("No hay productos registrados.");

    } else {

        System.out.print("Ingrese el codigo del producto: ");
        int codigoBuscar = Entrada.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getCodigo() == codigoBuscar) {

                System.out.println("=========================================");
                System.out.println("Producto: " + productos[i].getNombreProd());
                System.out.println("Precio: L. " + productos[i].getPrecio());
                System.out.println("=========================================");

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Producto no encontrado.");

        }
    }

    break;

            case 8:
                System.out.println("Regresando al Menu Principal...");
                break;

            default:
                System.out.println("Opcion no valida");
        }

    } while (Smenu != 8);

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
      System.out.println("6.Historial de clientes");
      System.out.println("7.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
            
            case 1:

    if (cantidadClientes < 10) {

        System.out.println("          REGISTRAR CLIENTE");
        System.out.println("=========================================");

        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = Entrada.next();

        System.out.print("Ingrese el Member ID: ");
        String memberID = Entrada.next();

        System.out.print("Ingrese el tipo de miembro (P/B): ");
        char memberType = Entrada.next().charAt(0);

        System.out.print("Ingrese el RTN: ");
        String RTN = Entrada.next();

        System.out.print("Ingrese la edad: ");
        int Edad = Entrada.nextInt();

        clientes[cantidadClientes] = new Cliente(nombreCliente,memberID,memberType,RTN,Edad);
        
        ArchivoClientes.guardarCliente(clientes[cantidadClientes]);

        cantidadClientes++;

        System.out.println("=========================================");
        System.out.println("Cliente registrado correctamente.");
        System.out.println("=========================================");

    } else {

        System.out.println("=========================================");
        System.out.println("Ya se registraron los 10 clientes.");
        System.out.println("=========================================");
    }

    break;
        
        case 2:

    System.out.println("           BUSCAR CLIENTE");
    System.out.println("=========================================");

    if (cantidadClientes == 0) {

        System.out.println("No hay clientes registrados.");

    } else {

        System.out.print("Ingrese el Member ID del cliente: ");
        String memberIDBuscar = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadClientes; i++) {

            if (clientes[i].memberID.equals(memberIDBuscar)) {

                System.out.println("=========================================");
                System.out.println("          CLIENTE ENCONTRADO");
                System.out.println("=========================================");

                System.out.println("Nombre: " + clientes[i].nombreCliente);
                System.out.println("Member ID: " + clientes[i].memberID);
                System.out.println("Tipo de miembro: " + clientes[i].getmemberType());
                System.out.println("RTN: " + clientes[i].RTN);
                System.out.println("Edad: " + clientes[i].getEdad());

                System.out.println("=========================================");

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Cliente no encontrado.");

        }
    }

    break;
    
        case 3:

    System.out.println("         MODIFICAR CLIENTE");
    System.out.println("=========================================");

    if (cantidadClientes == 0) {

        System.out.println("No hay clientes registrados.");

    } else {

        System.out.print("Ingrese el Member ID del cliente: ");
        String memberIDModificar = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadClientes; i++) {

            if (clientes[i].memberID.equals(memberIDModificar)) {

                System.out.println("=========================================");
                System.out.println("Cliente encontrado.");
                System.out.println("=========================================");

                System.out.print("Ingrese el nuevo nombre: ");
                clientes[i].nombreCliente = Entrada.next();

                System.out.print("Ingrese el nuevo tipo de miembro (P/B): ");
                char memberType = Entrada.next().charAt(0);
                clientes[i].setmemberType(memberType);

                System.out.print("Ingrese el nuevo RTN: ");
                clientes[i].RTN = Entrada.next();

                System.out.print("Ingrese la nueva edad: ");
                int Edad = Entrada.nextInt();
                clientes[i].setEdad(Edad);
                
                ArchivoClientes.guardarTodos(clientes, cantidadClientes);

                System.out.println("=========================================");
                System.out.println("Cliente modificado correctamente.");
                System.out.println("=========================================");

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Cliente no encontrado.");

        }
    }

    break;
    
        
       case 4:

    System.out.println("          ELIMINAR CLIENTE");
    System.out.println("=========================================");

    if (cantidadClientes == 0) {

        System.out.println("No hay clientes registrados.");

    } else {

        System.out.print("Ingrese el Member ID del cliente: ");
        String memberIDEliminar = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadClientes; i++) {

            if (clientes[i].memberID.equals(memberIDEliminar)) {

                // Mover los clientes hacia la izquierda
                for (int j = i; j < cantidadClientes - 1; j++) {

                    clientes[j] = clientes[j + 1];
                }

                // Dejar vacia la ultima posicion
                clientes[cantidadClientes - 1] = null;

                cantidadClientes--;
                
                ArchivoClientes.guardarTodos(clientes, cantidadClientes);

                encontrado = true;

                System.out.println("=========================================");
                System.out.println("Cliente eliminado correctamente.");
                System.out.println("=========================================");

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Cliente no encontrado.");

        }
    }

    break;
    
         case 5:

    System.out.println("           LISTA DE CLIENTES");
    System.out.println("=========================================");

    if (cantidadClientes == 0) {

        System.out.println("No hay clientes registrados.");

    } else {

        for (int i = 0; i < cantidadClientes; i++) {

            System.out.println("Cliente #" + (i + 1));
            System.out.println("Nombre: " + clientes[i].nombreCliente);
            System.out.println("Member ID: " + clientes[i].memberID);
            System.out.println("Tipo de miembro: " + clientes[i].getmemberType());
            System.out.println("RTN: " + clientes[i].RTN);
            System.out.println("Edad: " + clientes[i].getEdad());

            System.out.println("=========================================");
        }
    }

    break;
        case 6:

    System.out.println("        HISTORIAL DE COMPRAS");
    System.out.println("=========================================");

    if (cantidadClientes == 0) {

        System.out.println("No hay clientes registrados.");

    } else {

        System.out.print("Ingrese el Member ID del cliente: ");
        String memberIDHistorial = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadClientes; i++) {

            if (clientes[i].memberID.equals(memberIDHistorial)) {

                System.out.println("=========================================");
                System.out.println("Cliente: " + clientes[i].nombreCliente);
                System.out.println("Member ID: " + clientes[i].memberID);
                System.out.println("=========================================");

                System.out.println("Historial de compras");
                System.out.println("-----------------------------------------");
                System.out.println("No hay compras registradas.");
                System.out.println("=========================================");

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Cliente no encontrado.");

        }
    }

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
      System.out.println("6.Historial de Proveedores");
      System.out.println("7.Regresar al menu principal");
      System.out.println("=========================================");
      Smenu = Entrada.nextInt();
      System.out.println("=========================================");
      
        switch(Smenu){
        case 1:
            
    if (cantidadProveedores < 10) {

        System.out.println("         REGISTRAR PROVEEDOR");
        System.out.println("=========================================");

        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = Entrada.next();

        System.out.print("Ingrese el codigo del proveedor: ");
        String codigoProveedor = Entrada.next();

        System.out.print("Ingrese el RTN: ");
        String RTN = Entrada.next();

        System.out.print("Ingrese el telefono: ");
        String telefono = Entrada.next();

        System.out.print("Ingrese el producto que suministra: ");
        String producto = Entrada.next();

        proveedores[cantidadProveedores] = new Proveedor(nombreProveedor,codigoProveedor,RTN,telefono,producto);
        
        ArchivoProveedores.guardarProveedor(proveedores[cantidadProveedores]);

        cantidadProveedores++;

        System.out.println("=========================================");
        System.out.println("Proveedor registrado correctamente.");
        System.out.println("=========================================");

    } else {

        System.out.println("=========================================");
        System.out.println("Ya se registraron los 10 proveedores.");
        System.out.println("=========================================");
    }

    break;
    
        case 2:

    System.out.println("          BUSCAR PROVEEDOR");
    System.out.println("=========================================");

    if (cantidadProveedores == 0) {

        System.out.println("No hay proveedores registrados.");

    } else {

        System.out.print("Ingrese el codigo del proveedor: ");
        String codigoBuscar = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProveedores; i++) {

            if (proveedores[i].codigoProveedor.equals(codigoBuscar)) {

                System.out.println("=========================================");
                System.out.println("        PROVEEDOR ENCONTRADO");
                System.out.println("=========================================");

                proveedores[i].mostrarProveedor();

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Proveedor no encontrado.");

        }
    }

    break;
    
        case 3:

    System.out.println("         MODIFICAR PROVEEDOR");
    System.out.println("=========================================");

    if (cantidadProveedores == 0) {

        System.out.println("No hay proveedores registrados.");

    } else {

        System.out.print("Ingrese el codigo del proveedor: ");
        String codigoModificar = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProveedores; i++) {

            if (proveedores[i].codigoProveedor.equals(codigoModificar)) {

                System.out.println("=========================================");
                System.out.println("Proveedor encontrado.");
                System.out.println("=========================================");

                System.out.print("Ingrese el nuevo nombre: ");
                proveedores[i].nombreProveedor = Entrada.next();

                System.out.print("Ingrese el nuevo RTN: ");
                proveedores[i].RTN = Entrada.next();

                System.out.print("Ingrese el nuevo telefono: ");
                proveedores[i].telefono = Entrada.next();

                System.out.print("Ingrese el nuevo producto: ");
                proveedores[i].producto = Entrada.next();
                
                ArchivoProveedores.guardarTodos(proveedores, cantidadProveedores);

                System.out.println("=========================================");
                System.out.println("Proveedor modificado correctamente.");
                System.out.println("=========================================");

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Proveedor no encontrado.");

        }
    }

    break;
    
        case 4:

    System.out.println("          ELIMINAR PROVEEDOR");
    System.out.println("=========================================");

    if (cantidadProveedores == 0) {

        System.out.println("No hay proveedores registrados.");

    } else {

        System.out.print("Ingrese el codigo del proveedor: ");
        String codigoEliminar = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProveedores; i++) {

            if (proveedores[i].codigoProveedor.equals(codigoEliminar)) {

                // Mover los proveedores hacia la izquierda
                for (int j = i; j < cantidadProveedores - 1; j++) {

                    proveedores[j] = proveedores[j + 1];
                }

                // Dejar vacia la ultima posicion
                proveedores[cantidadProveedores - 1] = null;

                cantidadProveedores--;
                
                ArchivoProveedores.guardarTodos(proveedores, cantidadProveedores);

                encontrado = true;

                System.out.println("=========================================");
                System.out.println("Proveedor eliminado correctamente.");
                System.out.println("=========================================");

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Proveedor no encontrado.");

        }
    }

    break;
    
        case 5:

    System.out.println("          LISTA DE PROVEEDORES");
    System.out.println("=========================================");

    if (cantidadProveedores == 0) {

        System.out.println("No hay proveedores registrados.");

    } else {

        for (int i = 0; i < cantidadProveedores; i++) {

            System.out.println("Proveedor #" + (i + 1));

            proveedores[i].mostrarProveedor();

            System.out.println();
        }
    }

    break;
    
        case 6:

    System.out.println("        HISTORIAL DE PROVEEDORES");
    System.out.println("=========================================");

    if (cantidadProveedores == 0) {

        System.out.println("No hay proveedores registrados.");

    } else {

        System.out.print("Ingrese el codigo del proveedor: ");
        String codigoHistorial = Entrada.next();

        boolean encontrado = false;

        for (int i = 0; i < cantidadProveedores; i++) {

            if (proveedores[i].codigoProveedor.equals(codigoHistorial)) {

                System.out.println("=========================================");
                System.out.println("Proveedor: " + proveedores[i].nombreProveedor);
                System.out.println("Codigo: " + proveedores[i].codigoProveedor);
                System.out.println("Producto: " + proveedores[i].producto);
                System.out.println("=========================================");

                System.out.println("Historial de compras");
                System.out.println("-----------------------------------------");
                System.out.println("No hay compras registradas.");
                System.out.println("=========================================");

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println("Proveedor no encontrado.");

        }
    }

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

    if (cantidadCompras >= 10) {
        System.out.println("No se pueden registrar mas compras.");
        break;
    }

    System.out.println("=========================================");
    System.out.println("          REGISTRAR COMPRA");
    System.out.println("=========================================");

    System.out.print("Ingrese codigo de compra: ");
    String codigoCompra = Entrada.next();

    // Buscar proveedor
    System.out.print("Ingrese codigo del proveedor: ");
    String codigoProveedor = Entrada.next();

    int indiceProveedor = -1;

    for (int i = 0; i < cantidadProveedores; i++) {

        if (proveedores[i].codigoProveedor.equals(codigoProveedor)) {
            indiceProveedor = i;
            break;
        }
    }

    if (indiceProveedor == -1) {
        System.out.println("Proveedor no encontrado.");
        break;
    }

    // Buscar producto
    System.out.print("Ingrese codigo del producto: ");
    int codigoProducto = Entrada.nextInt();

    int indiceProducto = -1;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].getCodigo() == codigoProducto) {
            indiceProducto = i;
            break;
        }
    }

    if (indiceProducto == -1) {
        System.out.println("Producto no encontrado.");
        break;
    }

    // Cantidad comprada
    System.out.print("Ingrese cantidad comprada: ");
    int cantidad = Entrada.nextInt();

    if (cantidad <= 0) {
        System.out.println("La cantidad debe ser mayor que 0.");
        break;
    }

    // Precio de compra
    System.out.print("Ingrese precio de compra: L. ");
    double precio = Entrada.nextDouble();

    if (precio < 0) {
        System.out.println("El precio no puede ser negativo.");
        break;
    }

    // Registrar la compra
    compras[cantidadCompras] = new Compra(codigoCompra,codigoProveedor,codigoProducto,cantidad,precio);
    
    ArchivoCompras.guardarCompra(compras[cantidadCompras]);

    // Aumentar existencia del producto
    int existenciaActual = productos[indiceProducto].getCantidad();

    productos[indiceProducto].setCantidad(existenciaActual + cantidad);

    cantidadCompras++;

    // Guardar cambios del inventario
    ArchivoProductos.guardarTodos(productos, cantidadProductos);

    System.out.println("=========================================");
    System.out.println("Compra registrada correctamente.");
    System.out.println("Proveedor: " +
                       proveedores[indiceProveedor].nombreProveedor);
    System.out.println("Producto: " +
                       productos[indiceProducto].getNombreProd());
    System.out.println("Cantidad comprada: " + cantidad);
    System.out.println("Nueva existencia: " +
                       productos[indiceProducto].getCantidad());
    System.out.println("=========================================");

    break;
    
        case 2:

    System.out.println("=========================================");
    System.out.println("            BUSCAR COMPRA");
    System.out.println("=========================================");

    if (cantidadCompras == 0) {
        System.out.println("No hay compras registradas.");
        break;
    }

    System.out.print("Ingrese el codigo de la compra: ");
    String codigoBuscar = Entrada.next();

    boolean encontrada = false;

    for (int i = 0; i < cantidadCompras; i++) {

        if (compras[i].codigoCompra.equals(codigoBuscar)) {

            System.out.println("=========================================");
            System.out.println("Compra encontrada");
            System.out.println("=========================================");

            compras[i].mostrarCompra();

            encontrada = true;
            break;
        }
    }

    if (!encontrada) {
        System.out.println("No se encontro ninguna compra con ese codigo.");
    }

    break;
    
        case 3:

    System.out.println("=========================================");
    System.out.println("         COMPRAS REALIZADAS");
    System.out.println("=========================================");

    if (cantidadCompras == 0) {
        System.out.println("No hay compras registradas.");
        break;
    }

    for (int i = 0; i < cantidadCompras; i++) {

        System.out.println("Compra #" + (i + 1));

        compras[i].mostrarCompra();

    }

    break;
    case 4:

    System.out.println("=========================================");
    System.out.println("             ANULAR COMPRA");
    System.out.println("=========================================");

    // Verificar si existen compras
    if (cantidadCompras == 0) {
        System.out.println("No hay compras registradas.");
        break;
    }

    // Pedir codigo de la compra
    System.out.print("Ingrese el codigo de la compra que desea anular: ");
    String codigoAnular = Entrada.next();

    int indiceCompra = -1;

    // Buscar la compra
    for (int i = 0; i < cantidadCompras; i++) {

        if (compras[i].codigoCompra.equals(codigoAnular)) {
            indiceCompra = i;
            break;
        }
    }

    // Verificar si se encontro la compra
    if (indiceCompra == -1) {
        System.out.println("Compra no encontrada.");
        break;
    }

    // Buscar el producto relacionado con la compra
    int indiceProductoCompra = -1;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].getCodigo() == compras[indiceCompra].codigoProducto) {
            indiceProductoCompra = i;
            break;
        }
    }

    // Verificar si existe el producto
    if (indiceProductoCompra == -1) {
        System.out.println("El producto de la compra no existe.");
        break;
    }

    // Obtener la existencia actual del producto
    int existenciaAnular =
            productos[indiceProductoCompra].getCantidad();

    // Obtener la cantidad que se compro
    int cantidadComprada =
            compras[indiceCompra].cantidad;

    // Verificar que haya suficiente existencia
    if (existenciaAnular < cantidadComprada) {

        System.out.println("No se puede anular la compra.");
        System.out.println(
                "La existencia actual es menor que la cantidad comprada."
        );

        break;
    }

    // Restar la cantidad de la compra
    productos[indiceProductoCompra].setCantidad(
            existenciaAnular - cantidadComprada
    );

    // Eliminar la compra del arreglo
    for (int i = indiceCompra; i < cantidadCompras - 1; i++) {

        compras[i] = compras[i + 1];
    }

    // Limpiar la ultima posicion
    compras[cantidadCompras - 1] = null;

    // Disminuir la cantidad de compras
    cantidadCompras--;
    
   ArchivoCompras.guardarTodas(compras, cantidadCompras);

    // Guardar el inventario actualizado
    ArchivoProductos.guardarTodos(
            productos,
            cantidadProductos
    );

    System.out.println("=========================================");
    System.out.println("Compra anulada correctamente.");
    System.out.println("Codigo de compra: " + codigoAnular);
    System.out.println("Producto: "
            + productos[indiceProductoCompra].getNombreProd());
    System.out.println("Cantidad anulada: "
            + cantidadComprada);
    System.out.println("Nueva existencia: "
            + productos[indiceProductoCompra].getCantidad());
    System.out.println("=========================================");

    break;
    
    case 5:

    System.out.println("=========================================");
    System.out.println("       DETALLE DE LA COMPRA");
    System.out.println("=========================================");

    if (cantidadCompras == 0) {
        System.out.println("No hay compras registradas.");
        break;
    }

    System.out.print("Ingrese el codigo de la compra: ");
    String codigoDetalle = Entrada.next();

    int indiceDetalle = -1;

    // Buscar la compra
    for (int i = 0; i < cantidadCompras; i++) {

        if (compras[i].codigoCompra.equals(codigoDetalle)) {
            indiceDetalle = i;
            break;
        }
    }

    // Verificar si existe
    if (indiceDetalle == -1) {

        System.out.println("Compra no encontrada.");

        break;
    }

    // Mostrar los datos de la compra
    compras[indiceDetalle].mostrarCompra();

    // Buscar el proveedor
    int indiceProveedorDetalle = -1;

    for (int i = 0; i < cantidadProveedores; i++) {

        if (proveedores[i].codigoProveedor.equals(
                compras[indiceDetalle].codigoProveedor)) {

            indiceProveedorDetalle = i;
            break;
        }
    }

    // Mostrar proveedor
    if (indiceProveedorDetalle != -1) {

        System.out.println("Proveedor: "
                + proveedores[indiceProveedorDetalle].nombreProveedor);
    }

    // Buscar el producto
    int indiceProductoDetalle = -1;

    for (int i = 0; i < cantidadProductos; i++) {

        if (productos[i].getCodigo()
                == compras[indiceDetalle].codigoProducto) {

            indiceProductoDetalle = i;
            break;
        }
    }

    // Mostrar producto
    if (indiceProductoDetalle != -1) {

        System.out.println("Producto: "
                + productos[indiceProductoDetalle].getNombreProd());
    }

    System.out.println("=========================================");

    break;
        case 6:

    System.out.println("=========================================");
    System.out.println("          HISTORIAL DE COMPRAS");
    System.out.println("=========================================");

    if (cantidadCompras == 0) {
        System.out.println("No hay compras registradas.");
        break;
    }

    for (int i = 0; i < cantidadCompras; i++) {

        System.out.println("Compra #" + (i + 1));

        compras[i].mostrarCompra();

    }

    System.out.println("Total de compras realizadas: "
            + cantidadCompras);

    System.out.println("=========================================");

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
      //Sub Menu Principal de configuracion
      System.out.println("=========================================");
      System.out.println("            Menu de Configuracion");
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