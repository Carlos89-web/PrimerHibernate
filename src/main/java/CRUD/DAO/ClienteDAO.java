package CRUD.DAO;

import java.util.List;

import CRUD.Controlador.entity.Cliente;

public interface ClienteDAO {

	// Declaramos el método que me va a devolver los clientes.
	// Al crear esta interfaz, me va a permitir hacer una inyección de dependencias allí donde lo 
	// necesite del objeto ClienteDAO
	
	public List<Cliente> getClientes();
	
	// Creamos método para insertar clientes en la tabla de la BD

	public void insertarCliente(Cliente elCliente);

	public Cliente getCliente(int id);

	public void eliminarCliente(int id);

}
