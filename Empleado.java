public class Empleado extends Usuario {
    private String puesto;

    public Empleado(String nombre, String direccion, String telefono, String puesto) {
        super(nombre, direccion, telefono); // Llamada al constructor de Usuario
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    // Métodos específicos para el empleado
    public void registrarPrestamo() {
        // Implementación del registro de préstamo
    }

    public void finalizarPrestamo() {
        // Implementación para finalizar un préstamo
    }

    public void generarReporte() {
        // Implementación para generar reporte
    }
}
