/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofacturacion;

import java.util.ArrayList;
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
        Scanner Entrada = new Scanner(System.in);

        int cantidadCompras = 0;
        int cantidadFacturas = 0;
        int cantidadProveedores = 0;
        int cantidadClientes = 0;
        int cantidadProductos = 0;
        int Menu = 0;
        int Smenu = 0;

        Compra[] compras = new Compra[10];
        cantidadCompras = ArchivoCompras.cargarCompras(compras);

        Proveedor[] proveedores = new Proveedor[10];
        cantidadProveedores = ArchivoProveedores.cargarProveedores(proveedores);

        Cliente[] clientes = new Cliente[10];
        cantidadClientes = ArchivoClientes.cargarClientes(clientes);

        Producto[] productos = new Producto[10];
        cantidadProductos = ArchivoProductos.cargarProductos(productos);

        Factura[] facturas = new Factura[10];

        System.out.println("                      ======================");
        System.out.println("                      Sistema de facturacion");
        System.out.println("                      ======================");

        do {
            System.out.println("=========================================");
            System.out.println("Menu principal del sistema de facturacion");
            System.out.println("1.Facturacion");
            System.out.println("2.Inventarios");
            System.out.println("3.Productos");
            System.out.println("4.Clientes");
            System.out.println("5.Proveedores");
            System.out.println("6.Compras");
            System.out.println("7.Reportes");
            System.out.println("0.Salir");
            System.out.println("=========================================");
            Menu = Entrada.nextInt();

            switch (Menu) {
                case 1:
                    do {
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

                        switch (Smenu) {
                            case 1:
                                System.out.println("           NUEVA FACTURA");
                                System.out.println("=========================================");

                                if (cantidadClientes == 0) {
                                    System.out.println("No hay clientes registrados. Registre uno primero.");
                                } else {
                                    System.out.print("Ingrese el Member ID del cliente: ");
                                    String memberIDFactura = Entrada.next();

                                    Cliente clienteFactura = null;
                                    for (int i = 0; i < cantidadClientes; i++) {
                                        if (clientes[i].memberID.equals(memberIDFactura)) {
                                            clienteFactura = clientes[i];
                                            break;
                                        }
                                    }

                                    if (clienteFactura == null) {
                                        System.out.println("Cliente no encontrado.");
                                    } else {
                                        System.out.println("Cliente encontrado: " + clienteFactura.nombreCliente);

                                        ArrayList<Producto> productosFactura = new ArrayList<>();
                                        String respuesta;

                                        do {
                                            System.out.print("Ingrese el codigo del producto: ");
                                            int codigoFactura = Entrada.nextInt();

                                            Producto productoEncontrado = null;
                                            for (int j = 0; j < cantidadProductos; j++) {
                                                if (productos[j].getCodigo() == codigoFactura) {
                                                    productoEncontrado = productos[j];
                                                    break;
                                                }
                                            }

                                            if (productoEncontrado == null) {
                                                System.out.println("Producto no encontrado.");
                                            } else {
                                                System.out.print("Ingrese la cantidad a comprar: ");
                                                int cantidadComprada = Entrada.nextInt();

                                                Producto lineaFactura = new Producto(
                                                        productoEncontrado.getNombreProd(),
                                                        productoEncontrado.getPrecio(),
                                                        cantidadComprada,
                                                        productoEncontrado.getCodigo(),
                                                        productoEncontrado.getCategoria(),
                                                        productoEncontrado.getPeso()
                                                );

                                                productosFactura.add(lineaFactura);
                                                System.out.println("Producto agregado a la factura.");
                                            }

                                            System.out.print("Desea agregar otro producto? (s/n): ");
                                            respuesta = Entrada.next();
                                        } while (respuesta.equalsIgnoreCase("s"));

                                        System.out.println("Productos en la factura: " + productosFactura.size());
                                        System.out.print("Fecha (dd/mm/aaaa): ");
                                        String fechaFactura = Entrada.next();

                                        System.out.print("Hora: ");
                                        String horaFactura = Entrada.next();

                                        System.out.print("Metodo de pago (E = Efectivo, T = Tarjeta): ");
                                        char metodoPagoFactura = Entrada.next().charAt(0);

                                        System.out.print("Efectivo recibido: ");
                                        double efectivoFactura = Entrada.nextDouble();

                                        String numeroFacturaNueva = "F" + String.format("%03d", cantidadFacturas + 1);

                                        Factura facturaNueva = new Factura(
                                                numeroFacturaNueva,
                                                fechaFactura,
                                                horaFactura,
                                                metodoPagoFactura,
                                                clienteFactura,
                                                productosFactura,
                                                efectivoFactura
                                        );

                                        facturaNueva.calcularTotales();
                                        facturas[cantidadFacturas] = facturaNueva;
                                        cantidadFacturas++;

                                        System.out.println("=========================================");
                                        System.out.println("           RECIBO DE FACTURA");
                                        System.out.println("=========================================");
                                        System.out.println("Factura: " + facturaNueva.numeroFactura);
                                        System.out.println("Cliente: " + clienteFactura.nombreCliente);
                                        System.out.println("Cantidad de productos: " + facturaNueva.getTotalProductos());
                                        System.out.println("Subtotal: L. " + facturaNueva.getSubtotal());
                                        System.out.println("Impuesto: L. " + facturaNueva.getImpuesto());
                                        System.out.println("Total a pagar: L. " + facturaNueva.getTotalPagar());
                                        System.out.println("Efectivo recibido: L. " + facturaNueva.getefectivoRecibido());
                                        System.out.println("Cambio: L. " + facturaNueva.getCambio());
                                        System.out.println("=========================================");
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("           BUSCAR FACTURA");
                                System.out.println("=========================================");

                                if (cantidadFacturas == 0) {
                                    System.out.println("No hay facturas registradas.");
                                } else {
                                    System.out.print("Ingrese el numero de factura: ");
                                    String numeroBuscar = Entrada.next();

                                    boolean encontrada = false;
                                    for (int i = 0; i < cantidadFacturas; i++) {
                                        if (facturas[i].numeroFactura.equals(numeroBuscar)) {
                                            System.out.println("=========================================");
                                            System.out.println("Factura: " + facturas[i].numeroFactura);
                                            System.out.println("Fecha: " + facturas[i].fecha + "  Hora: " + facturas[i].hora);
                                            System.out.println("Cliente: " + facturas[i].cliente.nombreCliente);
                                            System.out.println("Cantidad de productos: " + facturas[i].getTotalProductos());
                                            System.out.println("Subtotal: L. " + facturas[i].getSubtotal());
                                            System.out.println("Impuesto: L. " + facturas[i].getImpuesto());
                                            System.out.println("Total a pagar: L. " + facturas[i].getTotalPagar());
                                            System.out.println("Cambio: L. " + facturas[i].getCambio());
                                            System.out.println("=========================================");
                                            encontrada = true;
                                            break;
                                        }
                                    }

                                    if (!encontrada) {
                                        System.out.println("Factura no encontrada.");
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("          ANULAR FACTURA");
                                System.out.println("=========================================");

                                if (cantidadFacturas == 0) {
                                    System.out.println("No hay facturas registradas.");
                                } else {
                                    System.out.print("Ingrese el numero de factura a anular: ");
                                    String numeroAnular = Entrada.next();

                                    boolean encontrada = false;
                                    for (int i = 0; i < cantidadFacturas; i++) {
                                        if (facturas[i].numeroFactura.equals(numeroAnular)) {
                                            for (int j = i; j < cantidadFacturas - 1; j++) {
                                                facturas[j] = facturas[j + 1];
                                            }
                                            facturas[cantidadFacturas - 1] = null;
                                            cantidadFacturas--;
                                            encontrada = true;
                                            System.out.println("=========================================");
                                            System.out.println("Factura anulada correctamente.");
                                            System.out.println("=========================================");
                                            break;
                                        }
                                    }

                                    if (!encontrada) {
                                        System.out.println("Factura no encontrada.");
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("         FACTURAS DEL DIA");
                                System.out.println("=========================================");

                                if (cantidadFacturas == 0) {
                                    System.out.println("No hay facturas registradas.");
                                } else {
                                    for (int i = 0; i < cantidadFacturas; i++) {
                                        System.out.println("Factura: " + facturas[i].numeroFactura);
                                        System.out.println("Cliente: " + facturas[i].cliente.nombreCliente);
                                        System.out.println("Total a pagar: L. " + facturas[i].getTotalPagar());
                                        System.out.println("-----------------------------------------");
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("        FACTURAS POR FECHA");
                                System.out.println("=========================================");

                                if (cantidadFacturas == 0) {
                                    System.out.println("No hay facturas registradas.");
                                } else {
                                    System.out.print("Ingrese la fecha a buscar (dd/mm/aaaa): ");
                                    String fechaBuscar = Entrada.next();

                                    boolean encontrada = false;
                                    for (int i = 0; i < cantidadFacturas; i++) {
                                        if (facturas[i].fecha.equals(fechaBuscar)) {
                                            System.out.println("Factura: " + facturas[i].numeroFactura);
                                            System.out.println("Cliente: " + facturas[i].cliente.nombreCliente);
                                            System.out.println("Total a pagar: L. " + facturas[i].getTotalPagar());
                                            System.out.println("-----------------------------------------");
                                            encontrada = true;
                                        }
                                    }

                                    if (!encontrada) {
                                        System.out.println("No hay facturas en esa fecha.");
                                    }
                                }
                                break;

                            case 6:
                                System.out.println("           DEVOLUCIONES");
                                System.out.println("=========================================");

                                if (cantidadFacturas == 0) {
                                    System.out.println("No hay facturas registradas.");
                                } else {
                                    System.out.print("Ingrese el numero de factura a devolver: ");
                                    String numeroDevolucion = Entrada.next();

                                    boolean encontrada = false;
                                    for (int i = 0; i < cantidadFacturas; i++) {
                                        if (facturas[i].numeroFactura.equals(numeroDevolucion)) {
                                            System.out.println("=========================================");
                                            System.out.println("Devolucion registrada para la factura " + facturas[i].numeroFactura);
                                            System.out.println("Monto a devolver: L. " + facturas[i].getTotalPagar());
                                            System.out.println("=========================================");
                                            encontrada = true;
                                            break;
                                        }
                                    }

                                    if (!encontrada) {
                                        System.out.println("Factura no encontrada.");
                                    }
                                }
                                break;

                            case 7:
                                System.out.println("Regresar al menu principal");
                                break;
                            default:
                                System.out.println("opcion invalida");
                                break;
                        }
                    } while (Smenu != 7);
                    break;
                // ====================================================================
                // OPCION 2: MENU DE INVENTARIOS
                // Permite ver el inventario, dar entradas/salidas, ajustar existencias,
                // ver productos con bajo stock y ver el historial de movimientos.
                // ====================================================================
                case 2:
                    do {
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

                        switch (Smenu) {
                            // ---- 2.1 VER INVENTARIO: muestra todos los productos con sus datos ----
                            case 1:

                                System.out.println("=========================================");
                                System.out.println("             VER INVENTARIO");
                                System.out.println("=========================================");

                                // Si no hay productos, avisa; si hay, los recorre y los imprime
                                if (cantidadProductos == 0) {

                                    System.out.println("No hay productos registrados.");

                                } else {

                                    // Recorre el arreglo desde la posicion 0 hasta el ultimo producto registrado
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
                            // ---- 2.2 ENTRADA DE PRODUCTO: suma unidades a la existencia de un producto ----
                            case 2:

                                System.out.println("=========================================");
                                System.out.println("          ENTRADA DE PRODUCTO");
                                System.out.println("=========================================");

                                // Si no hay productos no se puede hacer una entrada
                                if (cantidadProductos == 0) {

                                    System.out.println("No hay productos registrados.");

                                    break;
                                }

                                System.out.print("Ingrese el codigo del producto: ");
                                int codigoEntrada = Entrada.nextInt();

                                int indiceEntrada = -1; // -1 significa "no encontrado"

                                // Buscar el producto
                                for (int i = 0; i < cantidadProductos; i++) {

                                    if (productos[i].getCodigo() == codigoEntrada) {

                                        indiceEntrada = i; // Guarda la posicion donde se encontro

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
                                int existenciaActual
                                        = productos[indiceEntrada].getCantidad();

                                // Aumentar existencia
                                productos[indiceEntrada].setCantidad(
                                        existenciaActual + cantidadEntrada
                                );

                                // Guardar cambios en el archivo de productos
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

                            // ---- 2.3 SALIDA DE PRODUCTO: resta unidades a la existencia de un producto ----
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

                                // Verificar existencia suficiente (no se puede retirar mas de lo que hay)
                                if (cantidadSalida > productos[indiceSalida].getCantidad()) {

                                    System.out.println("No hay suficiente existencia.");

                                    break;
                                }

                                // Restar existencia
                                int existenciaActual1 = productos[indiceSalida].getCantidad();

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

                            // ---- 2.4 AJUSTAR EXISTENCIA: reemplaza la existencia por un valor nuevo ----
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

                                // Validar existencia (no puede ser negativa)
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

                            // ---- 2.5 PRODUCTOS CON BAJO STOCK: lista los que tienen 5 unidades o menos ----
                            case 5:

                                System.out.println("=========================================");
                                System.out.println("        PRODUCTOS CON BAJO STOCK");
                                System.out.println("=========================================");

                                if (cantidadProductos == 0) {

                                    System.out.println("No hay productos registrados.");

                                    break;
                                }

                                boolean hayBajoStock = false; // Bandera: indica si se encontro al menos uno

                                for (int i = 0; i < cantidadProductos; i++) {

                                    // Se considera "bajo stock" cuando la existencia es 5 o menos
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

                            // ---- 2.6 HISTORIAL DE MOVIMIENTOS: usa las compras como "entradas" de inventario ----
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
                    } while (Smenu != 7);
                    break;

                // ====================================================================
                // OPCION 3: MENU DE PRODUCTOS
                // CRUD de productos: registrar, buscar, modificar, eliminar, listar,
                // buscar por categoria y consultar precio.
                // ====================================================================
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

                            // ---- 3.1 REGISTRAR PRODUCTO: pide los datos y crea un nuevo Producto ----
                            case 1:

                                // Solo se puede registrar si el arreglo aun tiene espacio (maximo 10)
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
                                    char categoria = Entrada.next().charAt(0); // Toma solo la primera letra

                                    System.out.print("Ingrese el peso: ");
                                    double peso = Entrada.nextDouble();

                                    // Crea el objeto Producto y lo guarda en la siguiente posicion libre del arreglo
                                    productos[cantidadProductos] = new Producto(nombreProd, precio, cantidad, codigo, categoria, peso);

                                    // Guarda (agrega) el nuevo producto en el archivo
                                    ArchivoProductos.guardarProducto(productos[cantidadProductos]);

                                    cantidadProductos++; // Ahora hay un producto mas

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

                            // ---- 3.2 BUSCAR PRODUCTO: lo busca por codigo y muestra sus datos ----
                            case 2:

                                System.out.println("            BUSCAR PRODUCTO");
                                System.out.println("=========================================");

                                if (cantidadProductos == 0) {

                                    System.out.println("No hay productos registrados.");

                                } else {

                                    System.out.print("Ingrese el codigo del producto: ");
                                    int codigoBuscar = Entrada.nextInt();

                                    boolean encontrado = false; // Bandera de busqueda

                                    for (int i = 0; i < cantidadProductos; i++) {

                                        if (productos[i].getCodigo() == codigoBuscar) {

                                            System.out.println("=========================================");
                                            System.out.println("          PRODUCTO ENCONTRADO");
                                            System.out.println("=========================================");

                                            productos[i].mostrarProducto(); // Metodo de la clase Producto que imprime sus datos

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

                            // ---- 3.3 MODIFICAR PRODUCTO: busca por codigo y reemplaza sus datos ----
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

                                            // Pide los nuevos datos y los asigna con los metodos "set"
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

                                            // Reescribe todo el archivo con los datos actualizados
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

                            // ---- 3.4 ELIMINAR PRODUCTO: lo quita del arreglo y del archivo ----
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

                                            // Mover los productos hacia la izquierda (tapa el hueco que deja el eliminado)
                                            for (int j = i; j < cantidadProductos - 1; j++) {

                                                productos[j] = productos[j + 1];
                                            }

                                            // Dejar vacia la ultima posicion
                                            productos[cantidadProductos - 1] = null;

                                            cantidadProductos--; // Hay un producto menos

                                            // Reescribe el archivo sin el producto eliminado
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

                            // ---- 3.5 LISTA DE PRODUCTOS: muestra todos los productos registrados ----
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

                            // ---- 3.6 BUSCAR POR CATEGORIA: muestra todos los productos de una categoria (I/E) ----
                            case 6:

                                System.out.println("        BUSCAR POR CATEGORIA");
                                System.out.println("=========================================");

                                if (cantidadProductos == 0) {

                                    System.out.println("No hay productos registrados.");

                                } else {

                                    System.out.print("Ingrese la categoria: ");
                                    char categoriaBuscar = Entrada.next().charAt(0);

                                    boolean encontrado = false;

                                    // No usa break: debe mostrar TODOS los productos de esa categoria
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

                            // ---- 3.7 CONSULTAR PRECIO: muestra solo el nombre y precio de un producto ----
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

                    } while (Smenu != 8); // El submenu de productos termina con la opcion 8

                    break;

                // ====================================================================
                // OPCION 4: MENU DE CLIENTES
                // CRUD de clientes: registrar, buscar, modificar, eliminar, listar
                // e historial de compras (por ahora sin datos reales).
                // ====================================================================
                case 4:
                    do {
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

                        switch (Smenu) {

                            // ---- 4.1 REGISTRAR CLIENTE ----
                            case 1:

                                // Solo si hay espacio en el arreglo (maximo 10 clientes)
                                if (cantidadClientes < 10) {

                                    System.out.println("          REGISTRAR CLIENTE");
                                    System.out.println("=========================================");

                                    System.out.print("Ingrese el nombre del cliente: ");
                                    String nombreCliente = Entrada.next();

                                    System.out.print("Ingrese el Member ID: ");
                                    String memberID = Entrada.next(); // Identificador unico del cliente

                                    System.out.print("Ingrese el tipo de miembro (P/B): ");
                                    char memberType = Entrada.next().charAt(0);

                                    System.out.print("Ingrese el RTN: "); // RTN: Registro Tributario Nacional (Honduras)
                                    String RTN = Entrada.next();

                                    System.out.print("Ingrese la edad: ");
                                    int Edad = Entrada.nextInt();

                                    // Crea el cliente y lo guarda en la siguiente posicion libre
                                    clientes[cantidadClientes] = new Cliente(nombreCliente, memberID, memberType, RTN, Edad);

                                    // Lo agrega al archivo de clientes
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

                            // ---- 4.2 BUSCAR CLIENTE: por Member ID ----
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

                                        // equals se usa para comparar textos (String)
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

                            // ---- 4.3 MODIFICAR CLIENTE: cambia nombre, tipo de miembro, RTN y edad ----
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

                                            // Reescribe el archivo completo con los cambios
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

                            // ---- 4.4 ELIMINAR CLIENTE ----
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

                                            // Actualiza el archivo sin el cliente eliminado
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

                            // ---- 4.5 LISTAR CLIENTES: muestra todos los clientes ----
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
                            // ---- 4.6 HISTORIAL DE COMPRAS DEL CLIENTE: aun es un mensaje fijo (sin facturas) ----
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
                                            System.out.println("No hay compras registradas."); // Pendiente: enlazar con facturas
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
                    } while (Smenu != 7);
                    break;

                // ====================================================================
                // OPCION 5: MENU DE PROVEEDORES
                // CRUD de proveedores: registrar, buscar, modificar, eliminar, listar
                // e historial (por ahora sin datos reales).
                // ====================================================================
                case 5:
                    do {
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

                        switch (Smenu) {
                            // ---- 5.1 REGISTRAR PROVEEDOR ----
                            case 1:

                                // Solo si hay espacio (maximo 10 proveedores)
                                if (cantidadProveedores < 10) {

                                    System.out.println("         REGISTRAR PROVEEDOR");
                                    System.out.println("=========================================");

                                    System.out.print("Ingrese el nombre del proveedor: ");
                                    String nombreProveedor = Entrada.next();

                                    System.out.print("Ingrese el codigo del proveedor: ");
                                    String codigoProveedor = Entrada.next(); // Identificador unico del proveedor

                                    System.out.print("Ingrese el RTN: ");
                                    String RTN = Entrada.next();

                                    System.out.print("Ingrese el telefono: ");
                                    String telefono = Entrada.next();

                                    System.out.print("Ingrese el producto que suministra: ");
                                    String producto = Entrada.next();

                                    // Crea el proveedor y lo guarda en el arreglo
                                    proveedores[cantidadProveedores] = new Proveedor(nombreProveedor, codigoProveedor, RTN, telefono, producto);

                                    // Lo agrega al archivo de proveedores
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

                            // ---- 5.2 BUSCAR PROVEEDOR: por codigo ----
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

                                            proveedores[i].mostrarProveedor(); // Imprime los datos del proveedor

                                            encontrado = true;

                                            break;
                                        }
                                    }

                                    if (!encontrado) {

                                        System.out.println("Proveedor no encontrado.");

                                    }
                                }

                                break;

                            // ---- 5.3 MODIFICAR PROVEEDOR: cambia nombre, RTN, telefono y producto ----
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

                                            // Reescribe el archivo con los datos actualizados
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

                            // ---- 5.4 ELIMINAR PROVEEDOR ----
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

                                            // Actualiza el archivo sin el proveedor eliminado
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

                            // ---- 5.5 LISTA DE PROVEEDORES ----
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

                            // ---- 5.6 HISTORIAL DE PROVEEDOR: aun es un mensaje fijo (sin compras enlazadas) ----
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
                                            System.out.println("No hay compras registradas."); // Pendiente: filtrar compras del proveedor
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
                    } while (Smenu != 7);
                    break;

                // ====================================================================
                // OPCION 6: MENU DE COMPRAS
                // Registra compras a proveedores (aumentando la existencia del producto),
                // las busca, las lista, las anula (restando la existencia) y muestra detalles.
                // ====================================================================
                case 6:
                    do {
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

                        switch (Smenu) {
                            // ---- 6.1 REGISTRAR COMPRA: valida proveedor y producto, guarda la compra y suma al inventario ----
                            case 1:

                                // Limite de 10 compras en el arreglo
                                if (cantidadCompras >= 10) {
                                    System.out.println("No se pueden registrar mas compras.");
                                    break;
                                }

                                System.out.println("=========================================");
                                System.out.println("          REGISTRAR COMPRA");
                                System.out.println("=========================================");

                                System.out.print("Ingrese codigo de compra: ");
                                String codigoCompra = Entrada.next();

                                // Buscar proveedor (la compra debe pertenecer a un proveedor existente)
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

                                // Buscar producto (debe existir en el inventario)
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

                                // Registrar la compra (el total se calcula dentro de la clase Compra)
                                compras[cantidadCompras] = new Compra(codigoCompra, codigoProveedor, codigoProducto, cantidad, precio);

                                // Guarda la compra en el archivo de compras
                                ArchivoCompras.guardarCompra(compras[cantidadCompras]);

                                // Aumentar existencia del producto (la mercaderia comprada entra al inventario)
                                int existenciaActual = productos[indiceProducto].getCantidad();

                                productos[indiceProducto].setCantidad(existenciaActual + cantidad);

                                cantidadCompras++;

                                // Guardar cambios del inventario
                                ArchivoProductos.guardarTodos(productos, cantidadProductos);

                                System.out.println("=========================================");
                                System.out.println("Compra registrada correctamente.");
                                System.out.println("Proveedor: "
                                        + proveedores[indiceProveedor].nombreProveedor);
                                System.out.println("Producto: "
                                        + productos[indiceProducto].getNombreProd());
                                System.out.println("Cantidad comprada: " + cantidad);
                                System.out.println("Nueva existencia: "
                                        + productos[indiceProducto].getCantidad());
                                System.out.println("=========================================");

                                break;

                            // ---- 6.2 BUSCAR COMPRA: por codigo de compra ----
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

                                        compras[i].mostrarCompra(); // Imprime los datos de la compra

                                        encontrada = true;
                                        break;
                                    }
                                }

                                if (!encontrada) {
                                    System.out.println("No se encontro ninguna compra con ese codigo.");
                                }

                                break;

                            // ---- 6.3 VER COMPRAS REALIZADAS: lista todas las compras ----
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
                            // ---- 6.4 ANULAR COMPRA: elimina la compra y descuenta lo comprado del inventario ----
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
                                int existenciaAnular
                                        = productos[indiceProductoCompra].getCantidad();

                                // Obtener la cantidad que se compro
                                int cantidadComprada
                                        = compras[indiceCompra].cantidad;

                                // Verificar que haya suficiente existencia
                                // (si ya se vendio/retiro parte de lo comprado, no se puede anular)
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

                                // Eliminar la compra del arreglo (mueve las siguientes una posicion a la izquierda)
                                for (int i = indiceCompra; i < cantidadCompras - 1; i++) {

                                    compras[i] = compras[i + 1];
                                }

                                // Limpiar la ultima posicion
                                compras[cantidadCompras - 1] = null;

                                // Disminuir la cantidad de compras
                                cantidadCompras--;

                                // Reescribe el archivo de compras sin la compra anulada
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

                            // ---- 6.5 DETALLE DE COMPRA: muestra la compra junto con el nombre del proveedor y del producto ----
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

                                // Buscar el proveedor de esa compra
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

                                // Buscar el producto de esa compra
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
                            // ---- 6.6 HISTORIAL DE COMPRAS: lista todas las compras y su total ----
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
                    } while (Smenu != 7);
                    break;

                // ====================================================================
                // OPCION 7: MENU DE REPORTES (aun sin implementar, solo imprime texto)
                // ====================================================================
                                // ====================================================================
                // OPCION 7: MENU DE REPORTES
                // Permite consultar informacion general de ventas, productos,
                // clientes, inventario y compras.
                // ====================================================================
                case 7:
                    
                    do {
                        // Sub Menu Principal de reportes
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

                        switch (Smenu) {

                            // ---- 7.1 REPORTE DE VENTAS ----
                            case 1:

                                System.out.println("=========================================");
                                System.out.println("            REPORTE DE VENTAS");
                                System.out.println("=========================================");

                                // Verificar si existen facturas
                                if (cantidadFacturas == 0) {

                                    System.out.println("No hay facturas registradas.");

                                } else {

                                    double totalVentas = 0;

                                    // Recorrer todas las facturas
                                    for (int i = 0; i < cantidadFacturas; i++) {

                                        System.out.println("Factura #" + (i + 1));
                                        System.out.println("Numero de factura: "
                                                + facturas[i].numeroFactura);
                                        System.out.println("Fecha: "
                                                + facturas[i].fecha);
                                        System.out.println("Cliente: "
                                                + facturas[i].cliente.nombreCliente);
                                        System.out.println("Total: L. "
                                                + facturas[i].getTotalPagar());

                                        // Sumar el total de cada factura
                                        totalVentas = totalVentas
                                                + facturas[i].getTotalPagar();

                                        System.out.println("-----------------------------------------");
                                    }

                                    // Mostrar resumen de ventas
                                    System.out.println("Cantidad de facturas: "
                                            + cantidadFacturas);
                                    System.out.println("Total de ventas: L. "
                                            + totalVentas);
                                }

                                System.out.println("=========================================");

                                break;


                            // ---- 7.2 REPORTE DE PRODUCTOS ----
                            case 2:

                                System.out.println("=========================================");
                                System.out.println("          REPORTE DE PRODUCTOS");
                                System.out.println("=========================================");

                                // Verificar si existen productos
                                if (cantidadProductos == 0) {

                                    System.out.println("No hay productos registrados.");

                                } else {

                                    // Recorrer todos los productos
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


                            // ---- 7.3 REPORTE DE CLIENTES ----
                            case 3:

                                System.out.println("=========================================");
                                System.out.println("            REPORTE DE CLIENTES");
                                System.out.println("=========================================");

                                // Verificar si existen clientes
                                if (cantidadClientes == 0) {

                                    System.out.println("No hay clientes registrados.");

                                } else {

                                    // Recorrer todos los clientes
                                    for (int i = 0; i < cantidadClientes; i++) {

                                        System.out.println("Cliente #" + (i + 1));
                                        System.out.println("Nombre: "
                                                + clientes[i].nombreCliente);
                                        System.out.println("Member ID: "
                                                + clientes[i].memberID);
                                        System.out.println("Tipo de miembro: "
                                                + clientes[i].getmemberType());
                                        System.out.println("RTN: "
                                                + clientes[i].RTN);
                                        System.out.println("Edad: "
                                                + clientes[i].getEdad());

                                        System.out.println("-----------------------------------------");
                                    }

                                    System.out.println("Total de clientes: "
                                            + cantidadClientes);
                                }

                                System.out.println("=========================================");

                                break;


                            // ---- 7.4 REPORTE DE INVENTARIO ----
                            case 4:

                                System.out.println("=========================================");
                                System.out.println("          REPORTE DE INVENTARIO");
                                System.out.println("=========================================");

                                // Verificar si existen productos
                                if (cantidadProductos == 0) {

                                    System.out.println("No hay productos registrados.");

                                } else {

                                    int totalExistencias = 0;

                                    // Recorrer los productos para sumar las existencias
                                    for (int i = 0; i < cantidadProductos; i++) {

                                        totalExistencias = totalExistencias
                                                + productos[i].getCantidad();
                                    }

                                    System.out.println("Cantidad de productos: "
                                            + cantidadProductos);

                                    System.out.println("Total de unidades en inventario: "
                                            + totalExistencias);

                                    System.out.println("-----------------------------------------");

                                    // Mostrar el detalle del inventario
                                    for (int i = 0; i < cantidadProductos; i++) {

                                        System.out.println("Codigo: "
                                                + productos[i].getCodigo());
                                        System.out.println("Producto: "
                                                + productos[i].getNombreProd());
                                        System.out.println("Existencia: "
                                                + productos[i].getCantidad());

                                        System.out.println("-----------------------------------------");
                                    }
                                }

                                System.out.println("=========================================");

                                break;


                            // ---- 7.5 REPORTE DE COMPRAS ----
                            case 5:

                                System.out.println("=========================================");
                                System.out.println("            REPORTE DE COMPRAS");
                                System.out.println("=========================================");

                                // Verificar si existen compras
                                if (cantidadCompras == 0) {

                                    System.out.println("No hay compras registradas.");

                                } else {

                                    double totalCompras = 0;

                                    // Recorrer todas las compras
                                    for (int i = 0; i < cantidadCompras; i++) {

                                        System.out.println("Compra #" + (i + 1));
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

                                        // Sumar el total de cada compra
                                        totalCompras = totalCompras
                                                + compras[i].total;

                                        System.out.println("-----------------------------------------");
                                    }

                                    // Mostrar resumen de compras
                                    System.out.println("Cantidad de compras: "
                                            + cantidadCompras);
                                    System.out.println("Total de compras: L. "
                                            + totalCompras);
                                }

                                System.out.println("=========================================");

                                break;


                            // ---- 7.6 REGRESAR AL MENU PRINCIPAL ----
                            case 6:

                                System.out.println("Regresar al menu principal");

                                break;


                            // ---- OPCION NO VALIDA ----
                            default:

                                System.out.println("opcion invalida");

                                break;
                        }//fin del submenu

                    } while (Smenu != 6); // Repite hasta seleccionar regresar

                    break;


            }//fin del menu

        } while (Menu != 0); // Repite el menu principal hasta que el usuario elija 0

    }//fin main

}//fin class
