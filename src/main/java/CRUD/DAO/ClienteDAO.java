package CRUD.DAO;

import java.util.List;

import CRUD.Controlador.entity.Cliente;

// --- VIDEO 69, 71, 73, 75 ---

public interface ClienteDAO {

	// Declaramos el método que me va a devolver los clientes.
	// Al crear esta interfaz, me va a permitir hacer una inyección de dependencias allí donde lo 
	// necesite del objeto ClienteDAO
	
	public List<Cliente> getClientes();
	
	// Video 71: Creamos método para insertar clientes en la tabla de la BD

	public void insertarCliente(Cliente elCliente);
	
	// Video 73

	public Cliente getCliente(int id);
	
	// Video 75

	public void eliminarCliente(int id);

}
