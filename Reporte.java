public class Reporte {
    private int cantidadLibros;
    private int cantidadUsuarios;
    private int cantidadPrestamosActivos;

    // Constructor
    public Reporte(int cantidadLibros, int cantidadUsuarios, int cantidadPrestamosActivos) {
        this.cantidadLibros = cantidadLibros;
        this.cantidadUsuarios = cantidadUsuarios;
        this.cantidadPrestamosActivos = cantidadPrestamosActivos;
    }

    // Métodos
    public void generarReporteGeneral() {
        System.out.println("Reporte General: Libros: " + cantidadLibros + ", Usuarios: " + cantidadUsuarios + ", Préstamos Activos: " + cantidadPrestamosActivos);
    }

    public void generarReportePrestamos() {
        System.out.println("Reporte de Préstamos Activos: " + cantidadPrestamosActivos);
    }

    // Getters y Setters
    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    // Otros getters y setters...
}
