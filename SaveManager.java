import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class SaveManager {

    // Método para guardar el estado de los objetos (clientes, libros, prestamos, empleados)
    public void guardarEstado(GestionClientes gestionClientes, List<Libro> libros, List<Prestamo> prestamos, List<Empleado> empleados) {
        try {
            // Crear el archivo donde se guardarán los datos
            FileOutputStream fileOut = new FileOutputStream("estado.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Guardar los objetos en el archivo
            out.writeObject(new Object[]{gestionClientes, libros, prestamos, empleados});

            // Cerrar los streams
            out.close();
            fileOut.close();

            System.out.println("Estado guardado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el estado.");
        }
    }

    // Método para cargar el estado desde el archivo
    public Object[] cargarEstado() {
        Object[] datos = new Object[4];

        try {
            // Intentar leer el archivo de estado
            FileInputStream fileIn = new FileInputStream("estado.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Leer los objetos guardados
            datos = (Object[]) in.readObject();

            // Cerrar los streams
            in.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            // Si el archivo no se encuentra, inicializar las listas vacías
            System.out.println("Archivo estado.dat no encontrado. Se creará un archivo nuevo.");
            datos[1] = new ArrayList<Libro>();     // Lista de libros vacía
            datos[2] = new ArrayList<Prestamo>();  // Lista de préstamos vacía
            datos[3] = new ArrayList<Empleado>();  // Lista de empleados vacía

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar el estado.");
        }

        return datos;
    }
}
