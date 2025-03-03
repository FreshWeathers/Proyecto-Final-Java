import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Cliente cliente;
    private Libro libro;

    public Prestamo(int idPrestamo, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Cliente cliente, Libro libro) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.cliente = cliente;
        this.libro = libro;
    }

    // Métodos

    public void registrarPrestamo() {
        System.out.println("Préstamo registrado para el cliente con ID: " + cliente.getIdUsuario() + " con el libro: " + libro.getTitulo());
        System.out.println("Fecha de préstamo: " + fechaPrestamo);
        System.out.println("Fecha de devolución: " + fechaDevolucion);
    }

    public void finalizarPrestamo() {
        System.out.println("Préstamo finalizado para el libro: " + libro.getTitulo());
    }

    // Getters y setters si los necesitas
}
