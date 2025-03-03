import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {  // Hace serializable la clase cliente para implementar un archivo de datos
    private static final long serialVersionUID = 1L; // Agregar un identificador de versión

    public String getPassword() {
        return password;
    }

    private String nombre;
    private String password;
    private String correo;
    private String telefono;
    private boolean bloqueado;
    private ArrayList<Libro> librosPrestados;

    public Cliente(String nombre, String password, String correo, String telefono) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.bloqueado = false;
        this.librosPrestados = new ArrayList<>();
    }

    public boolean iniciarSesion(String password) {
        return this.password.equals(password) && !bloqueado; // Verificar si no está bloqueado
    }

    public boolean isBloqueado() {
        return bloqueado;
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

    public void bloquear() {
        this.bloqueado = true;
    }

    public boolean puedePedirPrestamo() {
        return librosPrestados.size() < 2;  // Máximo 2 préstamos activos
    }

    public void agregarPrestamo(Libro libro) {
        if (puedePedirPrestamo()) {
            librosPrestados.add(libro);
            System.out.println("Libro '" + libro.getTitulo() + "' prestado a " + nombre);
        } else {
            System.out.println("No puedes pedir más préstamos, has alcanzado el límite de 2.");
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            librosPrestados.remove(libro);
            System.out.println("Libro '" + libro.getTitulo() + "' devuelto por " + nombre);
        } else {
            System.out.println("Este libro no está en tu lista de préstamos.");
        }
    }

    // Método para ver los libros prestados
    public void verLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println(nombre + " no tiene libros prestados.");
        } else {
            System.out.println("Libros prestados por " + nombre + ":");
            for (Libro libro : librosPrestados) {
                System.out.println("- " + libro.getTitulo());
            }
        }
    }

    // Método para obtener la cantidad de libros prestados
    public int cantidadLibrosPrestados() {
        return librosPrestados.size();
    }
}
