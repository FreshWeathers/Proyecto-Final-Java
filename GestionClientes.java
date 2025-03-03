import java.io.*;
import java.util.ArrayList;

public class GestionClientes {
    private ArrayList<Cliente> clientes;

    public GestionClientes() {
        clientes = new ArrayList<>();
        cargarClientes(); // Carga los clientes al iniciar
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        guardarClientes(); // Guarda después de agregar un cliente
    }

    public Cliente buscarCliente(String nombre, String password) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getPassword().equals(password)) {
                return cliente;
            }
        }
        return null;
    }

    // Método para guardar la lista de clientes en un archivo
    private void guardarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de clientes desde un archivo
    @SuppressWarnings("unchecked")
    private void cargarClientes() {
        File file = new File("clientes.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                clientes = (ArrayList<Cliente>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}