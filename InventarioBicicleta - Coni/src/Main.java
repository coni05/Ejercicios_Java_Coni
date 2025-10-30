import model.Marca;
import repository.BicicletaRepository;
import repository.MarcaRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("!Bienvenido al Sistema de Inventario de Bicicletas¡");
        
        while (true) {
            mostrarMenuPrincipal();
            int opcion = leer("Seleccione una opción: ");
    
            switch (opcion) {
                case 1:
                    gestionarMarcas();
                    break;
                case 2:
                    gestionarBicicletas();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n========== MENÚ PRINCIPAL ========== \n");
        System.out.println("1. Gestionar Marcas \n");
        System.out.println("2. Gestionar Bicicletas \n");
        System.out.println("3. Salir \n");
        System.out.println("====================================");
    }
    private static void gestionarMarcas() {
        MarcaRepository repository = new MarcaRepository();
        while (true) {
            System.out.println("\n--- Gestión de Marcas --- \n");
            System.out.println("1. Registrar Marca\n");
            System.out.println("2. Buscar Marca por ID \n");
            System.out.println("3. Listar Todas las Marcas\n");
            System.out.println("4. Actualizar Marca\n");
            System.out.println("5. Eliminar Marca\n");
            System.out.println("6. Volver al Menú Principal \n");
            
            int opcion = leerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    registrarMarca(repository);
                break;
                case 2:
                    buscarMarcaPorId(repository);
                break;
                case 3:
                    listarMarcas(repository);
                break;
                case 4:
                    actualizarMarca(repository);
                break;
                case 5:
                    eliminarMarca(repository);
                break;
                case 6:
                    return;
                break;    
                default:
                    System.out.println("Opción inválida.");
            }    
        }  
    } 
    
    private static void insertarMarca(MarcaRepository repository) {
        System.out.print("Nombre de la marca: ");
        String nombre = scanner.nextLine();
        System.out.print("País de origen: ");
        String pais = scanner.nextLine();
        System.out.print("Descripción (opcional): ");
        String descripcion = scanner.nextLine();

        Marca marca = new Marca();
        marca.setNombre(nombre);
        marca.setPaisOrigen(pais);
        marca.setDescripcion(descripcion);

        repository.registrar(marca);
    }

    private static void consultar(MarcaRepository repository) {
        int id_marca = leerEntero("ID de la marca a buscar: ");
        Marca marca = repository.consultarMarcaPorId(id_marca);
        if (marca != null) {
            System.out.println("Marca encontrada:");
            System.out.println(marca);
        } else {
            System.out.println(" No se encontró ninguna marca con ese ID.");
        }
    }

    private static void listar(MarcaRepository repository) {
        List<Marca> marca = repository.listarMarca();
        if (marca.isEmpty()) {
            System.out.println("No hay marcas registradas.");
        } else {
            System.out.println("Lista de Marcas:");
            for (Marca m : marca) {
                System.out.println(m);
            }
        }
    }

    private static void actualizar(MarcaRepository repository) {
        int id_marca = leerEntero("ID de la marca a actualizar: ");
        Marca marca = repository.actualizarMarca();;
        if (marca == null) {
            System.out.println("No se encontró la marca con ID: " + id_marca);
            return;
        }

        System.out.println("Actualizando marca: " + marca.getNombre());
        System.out.print("Nuevo nombre (dejar vacío para mantener): ");
        String nombre = scanner.nextLine();
        if (!nombre.trim().isEmpty()) marca.setNombre(nombre);

        System.out.print("Nuevo país de origen (dejar vacío para mantener): ");
        String pais_origen = scanner.nextLine();
        if (!pais.trim().isEmpty()) marca.setPais_Origen(pais_origen);

        System.out.print("Nueva descripción (dejar vacío para mantener): ");
        String descripcion = scanner.nextLine();
        if (!descripcion.trim().isEmpty()) marca.setDescripcion(descripcion);

        repository.actualizarMarca(marca);
    }

    private static void eliminar(MarcaRepository repository) {
        int id_marca1 = leerEntero("ID de la marca a eliminar: ");
        try {
            repository.eliminarMarca(id_marca1);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        repository.eliminarMarcaMarca(id_marca1);
    }

    // === GESTIÓN DE BICICLETAS ===

    private static void gestionarBicicletas() {
        BicicletaRepository repository = new BicicletaRepository();
        while (true) {
            System.out.println("\n--- Gestión de Bicicletas ---");
            System.out.println("1. Registrar Bicicleta \n");
            System.out.println("2. Buscar Bicicleta por ID \n");
            System.out.println("3. Buscar Bicicleta por Modelo \n");
            System.out.println("4. Listar Todas las Bicicletas \n");
            System.out.println("5. Actualizar Bicicleta \n");
            System.out.println("6. Eliminar Bicicleta \n");
            System.out.println("7. Registrar Entrada de Mercancía \n");
            System.out.println("8. Registrar Salida de Mercancía (Venta)\n");
            System.out.println("9. Volver al Menú Principal\n");
            
            int opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarBicicleta(repository);
                break;
                case 2:
                    buscarBicicletaPorId(repository);
                    break;
                case 3:
                    buscarBicicletaPorModelo(repository);
                break;
                case 4:
                    listarBicicletas(repository);
                break;
                case 5:
                    actualizarBicicleta(repository);
                    break;
                case 6:
                    eliminarBicicleta(repository);
                    break;
                case 7:
                    registrarEntrada(repository);
                    break;
                case 8:
                    registrarSalida(repository);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }

    } 
    
     private static void registrar(BicicletaRepository repository) {
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Tipo (Montaña/Ruta/Urbana/Eléctrica/BMX/Híbrida): ");
        String tipo = scanner.nextLine();
        System.out.print("Talla: ");
        String talla = scanner.nextLine();
        System.out.print("Color: ");
        System.out.print("Descripción (opcional): ");
        String descripcion = scanner.nextLine();
        String color = scanner.nextLine();
        System.out.print("Precio: ");
        Double precio = scanner.nextDouble();
        System.out.print("Cantidad en stock: ");
        Long cantidad_stock = scanner.nextLong();
        System.out.print("Stock mínimo: ");
        Long stock_minimo = scanner.nextLong();
        System.out.print("ID de la marca: ");
        Long id_marca = scanner.nextLong();

        Bicicleta b = new Bicicleta();
        b.setModelo(modelo);
        b.setTipo(tipo);
        b.setTalla(talla);
        b.setColor(color);
        b.setDescripcion(descripcion);
        b.setPrecio(precio);
        b.setCantidad_Stock(cantidad_stock);
        b.setStock_Minimo(stock_minimo);
        b.setIdMarca(id_marca);

        repository.insertarBicicleta(b);
    }

    private static void consultar(BicicletaRepository repository) {
        int id_bicicleta = leerEntero("ID de la bicicleta a buscar: ");
        Bicicleta b = repository.consultarBicicletaPorId(id_bicicleta);
        if (b != null) {
            System.out.println("Bicicleta encontrada:");
            System.out.println(b);
        } else {
            System.out.println("No se encontró ninguna bicicleta con ese ID.");
        }
    }

    private static void listar(BicicletaRepository repository) {
        List<Bicicleta> bicicleta = repository.listarBicicletas();
        if (bicicleta.isEmpty()) {
            System.out.println("No hay bicicletas registradas.");
        } else {
            System.out.println("Lista de Bicicletas:");
            for (Bicicleta b : bicicleta) {
                System.out.println(b);
            }
        }
    }

    private static void actualizar(BicicletaRepository repository) {
        int bicicleta = leer("ID de la bicicleta a actualizar: ");
        Bicicleta  b = repository.actualizarBicicleta(bicicleta);
        if (b == null) {
            System.out.println("No se encontró la bicicleta con ID: " + bicicleta);
            return;
        }

        System.out.println("Actualizando bicicleta: " + b.getModelo());
        System.out.print("Nuevo modelo: ");
        String modelo = scanner.nextLine();
        if (!modelo.trim().isEmpty()) b.setModelo(modelo);

        System.out.print("Nuevo tipo: ");
        String tipo = scanner.nextLine();
        if (!tipo.trim().isEmpty()) b.setTipo(tipo);

        System.out.print("Nueva talla: ");
        String talla = scanner.nextLine();
        if (!talla.trim().isEmpty()) b.setTalla(talla);

        System.out.print("Nuevo color: ");
        String color = scanner.nextLine();
        if (!color.trim().isEmpty()) b.setColor(color);

        System.out.print("Nueva descripción: ");
        String descripcion = scanner.nextLine();
        if (!descripcion.trim().isEmpty()) b.setDescripcion(descripcion);

        System.out.print("Nuevo precio: ");
        Double precio = scanner.nextLong();
        if (!precio.trim().isEmpty()) b.setPrecio(precio);

        System.out.print("Nuevo cantidad en stock: ");
        Double cantidad_stock = scanner.nextLong();
        if (!cantidad_stock.trim().isEmpty()) b.setPrecio(cantidad_stock);

        System.out.print("Nuevo stock minimo: ");
        Double stock_minimo = scanner.nextLong();
        if (!stock_minimo.trim().isEmpty()) b.setPrecio(stock_minimo);

        System.out.print("Nuevo id de marca : ");
        Double id_marca = scanner.nextLong();
        if (!id_marca.trim().isEmpty()) b.setPrecio(id_marca);
        repository.actualizarBicicleta(b);

        repository.actualizarBicicleta(b);
    }

    private static void eliminar(BicicletaRepository repository) {
        int id_bicicleta1 = leerEntero("ID de la bicicleta a eliminar: ");
        try {
            repository.eliminarBicicleta(id_bicicleta1);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void Entrada(BicicletaRepository repository) {
        int id = leerEntero("ID de la bicicleta: ");
        int cantidad = leerEntero("Cantidad a ingresar: ");
        try {
            repository.registrarEntrada(id_Bicicleta3, cantidad);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void Salida(BicicletaRepository repository) {
        int id_bicicleta4 = leerEntero("ID de la bicicleta: ");
        int cantidad2 = leerEntero("Cantidad a salir: ");
        try {
            repo.registrarSalida(id_bicicleta4, cantidad2);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
