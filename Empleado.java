import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    private String nombre;
    private String password;
    private String correo;
    private String telefono;

    public Empleado(String nombre, String password, String correo, String telefono) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean iniciarSesion(String password) {
        return this.password.equals(password);
    }

    public void registrarLibro(ArrayList<Libro> libros, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.next();
        System.out.print("Ingrese la cantidad total de copias: ");
        int cantidadTotal = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Libro nuevoLibro = new Libro(titulo, autor, anio, genero, cantidadTotal);
        libros.add(nuevoLibro);
        System.out.println("Libro '" + titulo + "' registrado exitosamente.");
    }

    public void modificarLibro(ArrayList<Libro> libros, Scanner scanner) {
        System.out.print("Ingrese el título del libro a modificar: ");
        String titulo = scanner.nextLine();
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                System.out.print("Nuevo título: ");
                libro.setTitulo(scanner.nextLine());
                System.out.print("Nuevo autor: ");
                libro.setAutor(scanner.nextLine());
                System.out.print("Nuevo año de publicación: ");
                libro.setAnioPublicacion(scanner.nextInt());
                System.out.print("Nuevo género: ");
                libro.setGenero(scanner.next());
                System.out.print("Nueva cantidad total: ");
                libro.setCantidadTotal(scanner.nextInt());
                scanner.nextLine(); // Consumir el salto de línea
                System.out.println("Libro modificado exitosamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void eliminarLibro(ArrayList<Libro> libros, Scanner scanner) {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equals(titulo)) {
                libros.remove(i);
                System.out.println("Libro '" + titulo + "' eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void consultarDisponibilidad(ArrayList<Libro> libros) {
        System.out.println("Libros disponibles:");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo() + " - Disponibles: " + libro.getCantidadDisponible());
        }
    }

    public void registrarUsuario(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la contraseña del nuevo cliente: ");
        String password = scanner.nextLine();
        System.out.print("Ingrese el correo del nuevo cliente: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el teléfono del nuevo cliente: ");
        String telefono = scanner.nextLine();
        Cliente nuevoCliente = new Cliente(nombre, password, correo, telefono);
        clientes.add(nuevoCliente);
        System.out.println("Cliente '" + nombre + "' registrado exitosamente.");
    }

    public void consultarUsuarios(ArrayList<Cliente> clientes) {
        System.out.println("Clientes registrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        }
    }

    public void registrarPrestamo(ArrayList<Prestamo> prestamos, ArrayList<Cliente> clientes, ArrayList<Libro> libros, Scanner scanner) {
        // Implementar la lógica de registro de préstamo
        System.out.println("Registrando préstamo...");
    }

    public void generarReporte(ArrayList<Libro> libros, ArrayList<Cliente> clientes, ArrayList<Prestamo> prestamos) {
        // Implementar la lógica para generar reportes
        System.out.println("Generando reporte...");
    }

    public void bloquearCliente(Cliente cliente) {
        cliente.bloquear();
        System.out.println("Cliente " + cliente.getNombre() + " bloqueado.");
    }
}
