import java.util.Date;

public class Prestamo {
    private Cliente cliente;
    private Libro libro;
    private Date fecha; // Add this field

    // Constructor
    public Prestamo(Cliente cliente, Libro libro) {
        this.cliente = cliente;
        this.libro = libro;
        this.fecha = new Date(); // Initialize fecha with the current date
    }

    // Getter for fecha
    public Date getFecha() {
        return fecha;
    }

    // other fields and methods
}