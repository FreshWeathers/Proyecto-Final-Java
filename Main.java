import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear instancia de SaveManager
        SaveManager saveManager = new SaveManager();
        
        // Cargar datos desde el archivo
        Object[] datosCargados = saveManager.cargarEstado();
        GestionClientes gestionClientes = (GestionClientes) datosCargados[0];
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Verificar que los datos cargados sean del tipo esperado antes de hacer el cast
        if (datosCargados[1] instanceof List<?>) {
            List<?> tempLibros = (List<?>) datosCargados[1];
            if (!tempLibros.isEmpty() && tempLibros.get(0) instanceof Libro) {
                for (Object obj : tempLibros) {
                    if (obj instanceof Libro) {
                        libros.add((Libro) obj);
                    }
                }
            }
        }
        
        if (datosCargados[2] instanceof List<?>) {
            List<?> tempPrestamos = (List<?>) datosCargados[2];
            if (!tempPrestamos.isEmpty() && tempPrestamos.get(0) instanceof Prestamo) {
                for (Object obj : tempPrestamos) {
                    if (obj instanceof Prestamo) {
                        prestamos.add((Prestamo) obj);
                    }
                }
            }
        }

        if (datosCargados[3] instanceof List<?>) {
            List<?> tempEmpleados = (List<?>) datosCargados[3];
            if (!tempEmpleados.isEmpty() && tempEmpleados.get(0) instanceof Empleado) {
                for (Object obj : tempEmpleados) {
                    if (obj instanceof Empleado) {
                        empleados.add((Empleado) obj);
                    }
                }
            }
        }

        // Si no hay empleados registrados, agregar uno por defecto
        if (empleados.isEmpty()) {
            Empleado empleadoInicial = new Empleado("Juan", "clave123", "juan@example.com", "123456789");
            empleados.add(empleadoInicial);
        }

        // Menú de interacción
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar nuevo empleado");
            System.out.println("2. Iniciar sesión como empleado");
            System.out.println("3. Iniciar sesión como cliente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del nuevo empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la contraseña del nuevo empleado: ");
                    String password = scanner.nextLine();
                    System.out.print("Ingrese el correo del nuevo empleado: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del nuevo empleado: ");
                    String telefono = scanner.nextLine();
                    Empleado nuevoEmpleado = new Empleado(nombre, password, correo, telefono);
                    empleados.add(nuevoEmpleado);
                    System.out.println("Empleado " + nombre + " registrado exitosamente.");
                    
                    // Guardar cambios
                    saveManager.guardarEstado(gestionClientes, libros, prestamos, empleados);
                    break;

                case 2:
                    System.out.print("Ingrese contraseña de empleado: ");
                    String passwordEmpleado = scanner.nextLine();
                    boolean empleadoEncontrado = false;

                    for (Empleado empleado : empleados) {
                        if (empleado.iniciarSesion(passwordEmpleado)) {
                            empleadoEncontrado = true;
                            System.out.println(empleado.getNombre() + " ha iniciado sesión como empleado.");
                            // Menú de empleado
                            menuEmpleado(scanner, libros, prestamos, gestionClientes);
                            break;
                        }
                    }

                    if (!empleadoEncontrado) {
                        System.out.println("Contraseña incorrecta.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese su nombre de usuario: ");
                    String nombreClienteLogin = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String passwordClienteLogin = scanner.nextLine();
                
                    Cliente clienteEncontrado = gestionClientes.buscarCliente(nombreClienteLogin, passwordClienteLogin);
                    if (clienteEncontrado != null) {
                        System.out.println("Inicio de sesión exitoso. Bienvenido, " + clienteEncontrado.getNombre() + "!");
                        // Menú de cliente
                        menuCliente(scanner, clienteEncontrado, prestamos);
                    } else {
                        System.out.println("Nombre de usuario o contraseña incorrectos. Intente nuevamente.");
                    }
                    break;

                case 4:
                    System.out.println("Guardando estado y saliendo...");
                    saveManager.guardarEstado(gestionClientes, libros, prestamos, empleados);
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void menuEmpleado(Scanner scanner, ArrayList<Libro> libros, ArrayList<Prestamo> prestamos, GestionClientes gestionClientes) {
        while (true) {
            System.out.println("\n--- Menú Empleado ---");
            System.out.println("1. Ver libros");
            System.out.println("2. Registrar préstamo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcionEmpleado = scanner.nextInt();
            scanner.nextLine();

            switch (opcionEmpleado) {
                case 1:
                    System.out.println("Libros registrados:");
                    for (Libro libro : libros) {
                        System.out.println(libro.getTitulo() + " por " + libro.getAutor());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el cliente para registrar el préstamo: ");
                    String clienteNombre = scanner.nextLine();
                    Cliente cliente = gestionClientes.buscarClientePorNombre(clienteNombre);
                    if (cliente != null) {
                        System.out.print("Ingrese el título del libro: ");
                        String libroTitulo = scanner.nextLine();
                        Libro libro = buscarLibroPorTitulo(libros, libroTitulo);
                        if (libro != null) {
                            Prestamo nuevoPrestamo = new Prestamo(cliente, libro);
                            prestamos.add(nuevoPrestamo);
                            System.out.println("Préstamo registrado exitosamente.");
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    return; // Salir del menú de empleado

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void menuCliente(Scanner scanner, Cliente cliente, ArrayList<Prestamo> prestamos) {
        while (true) {
            System.out.println("\n--- Menú Cliente ---");
            System.out.println("1. Ver mis préstamos");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcionCliente = scanner.nextInt();
            scanner.nextLine();

            switch (opcionCliente) {
                case 1:
                    System.out.println("Mis préstamos:");
                    for (Prestamo prestamo : prestamos) {
                        if (prestamo.getCliente().equals(cliente)) {
                            System.out.println(prestamo.getLibro().getTitulo() + " - Fecha: " + prestamo.getFecha());
                        }
                    }
                    break;

                case 2:
                    return; // Salir del menú de cliente

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static Libro buscarLibroPorTitulo(ArrayList<Libro> libros, String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
