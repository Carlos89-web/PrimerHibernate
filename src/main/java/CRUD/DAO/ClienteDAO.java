package CRUD.DAO;

import java.util.List;

import CRUD.Controlador.entity.Cliente;

// --- VIDEO 69, 71, 73, 75 ---

public interface ClienteDAO {

	// Declaramos el m�todo que me va a devolver los clientes.
	// Al crear esta interfaz, me va a permitir hacer una inyecci�n de dependencias all� donde lo 
	// necesite del objeto ClienteDAO
	
	public List<Cliente> getClientes();
	
	// Video 71: Creamos m�todo para insertar clientes en la tabla de la BD

	public void insertarCliente(Cliente elCliente);
	
	// Video 73

	public Cliente getCliente(int id);
	
	// Video 75

	public void eliminarCliente(int id);

}
