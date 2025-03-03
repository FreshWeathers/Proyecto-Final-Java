import java.util.*;

public class Main {
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static ArrayList<Empleado> empleados = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("---- Menú Principal ----");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Empleado");
            System.out.println("3. Registrar Libro");
            System.out.println("4. Realizar Préstamo");
            System.out.println("5. Finalizar Préstamo");
            System.out.println("6. Generar Reporte");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    registrarEmpleado();
                    break;
                case 3:
                    registrarLibro();
                    break;
                case 4:
                    registrarPrestamo();
                    break;
                case 5:
                    finalizarPrestamo();
                    break;
                case 6:
                    generarReporte();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void registrarCliente() {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo del cliente: ");
        String correo = scanner.nextLine();
        System.out.print("Teléfono del cliente: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, correo, telefono);
        clientes.add(cliente);
    }

    public static void registrarEmpleado() {
        System.out.print("ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo del empleado: ");
        String correo = scanner.nextLine();
        System.out.print("Teléfono del empleado: ");
        String telefono = scanner.nextLine();
        System.out.print("Cargo del empleado: ");
        String cargo = scanner.nextLine();

        Empleado empleado = new Empleado(id, nombre, correo, telefono, cargo);
        empleados.add(empleado);
    }

    public static void registrarLibro() {
        System.out.print("ID del libro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Género del libro: ");
        String genero = scanner.nextLine();
        System.out.print("Cantidad total de ejemplares: ");
        int cantidadTotal = scanner.nextInt();
        System.out.print("Cantidad disponible de ejemplares: ");
        int cantidadDisponible = scanner.nextInt();

        Libro libro = new Libro(id, titulo, autor, anio, genero, cantidadTotal, cantidadDisponible);
        libros.add(libro);
    }

    // Método para registrar préstamos
    public static void registrarPrestamo() {
        // Implementación de préstamo
        System.out.println("Registrar préstamo...");
    }

    // Método para finalizar préstamos
    public static void finalizarPrestamo() {
        // Implementación de finalizar préstamo
        System.out.println("Finalizar préstamo...");
    }

    // Método para generar reporte
    public static void generarReporte() {
        // Implementación de reporte
        System.out.println("Generando reporte...");
    }
}

// Clase Cliente
class Cliente {
    int id;
    String nombre;
    String correo;
    String telefono;

    public Cliente(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Métodos relacionados con Cliente (si es necesario)
}

// Clase Empleado
class Empleado {
    int id;
    String nombre;
    String correo;
    String telefono;
    String cargo;

    public Empleado(int id, String nombre, String correo, String telefono, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    // Métodos para registrar préstamos, finalizar préstamos, generar reportes...
}

// Clase Libro
class Libro {
    int id;
    String titulo;
    String autor;
    int anio;
    String genero;
    int cantidadTotal;
    int cantidadDisponible;

    public Libro(int id, String titulo, String autor, int anio, String genero, int cantidadTotal, int cantidadDisponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Métodos relacionados con Libro (si es necesario)
}

// Clase Prestamo
class Prestamo {
    // Atributos y métodos del préstamo
}
