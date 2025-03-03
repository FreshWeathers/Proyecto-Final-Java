class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private int cantidadTotal;
    private int cantidadDisponible;

    public Libro(int idLibro, String titulo, String autor, int anio, String genero, int cantidadTotal, int cantidadDisponible) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTitulo() {
        return titulo;
    }

    // Métodos adicionales si es necesario...
}
