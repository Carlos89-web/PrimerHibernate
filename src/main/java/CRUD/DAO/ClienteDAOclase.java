package CRUD.DAO;

//--- VIDEO 69, 71, 73, 74, 75 ---

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import CRUD.Controlador.entity.Cliente;

// Para que toda la clase sea registrada en spring como un bean, usamos repository

@Repository
public class ClienteDAOclase implements ClienteDAO {
	
	// Aqui realizamos todo el trabajo, primero creamos el SessionFactory, al que llamamos igual que
	// como viene especificado en el archivo xml de configuraci�n. Hacemos la inyecci�n de dependencias
	// con la annotation Autowired
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// Hay una annotation de spring "m�gica" que nos permite simplificar c�digo, ya que nos evita
	// crear el commit, rollback, etc... que es @Transactional

	@Transactional
	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		
		// Obtenemos la sesi�n
		
		Session miSession = sessionFactory.getCurrentSession();
		
		// Creamos la consulta o query de objetos de tipo cliente, le pasamos como argumentos el nombre
		// de la tabla y la clase entidad
		
		Query<Cliente> miQuery = miSession.createQuery("from Cliente", Cliente.class);
		
		//Ejecutamos la query y devolvemos resultados
		
		List<Cliente> clientes = miQuery.getResultList();
		
		return clientes;
	}
	
	// Video 71: Creamos m�todo para insertar clientes en la tabla de la BD

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		// TODO Auto-generated method stub
		
		// Obtenemos la sesi�n
		
		Session miSession = sessionFactory.getCurrentSession();
		
		// Insertamos el cliente
		
		//miSession.save(elCliente);
		
		// Video 74: Usamos otro m�todo
		
		miSession.saveOrUpdate(elCliente);
		
	}
	
	// Video 73: M�todo para proporcionar el cliente seg�n el id que se le pida

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		// TODO Auto-generated method stub
		
		// Obtener la sesi�n
		
		Session miSession = sessionFactory.getCurrentSession(); 
		
		// Obtener la informaci�n del cliente seleccionado
		
		Cliente elCliente = miSession.get(Cliente.class, id);
		
		return elCliente;
	}

	// Video 75: M�todo para eliminar el cliente
	
	@Transactional
	@Override
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		
		// Obtener la sesi�n
		
		Session miSession = sessionFactory.getCurrentSession(); 
				
		// Borrar el cliente de la BD utilizando como criterio su id correspondiente
		
		Query consulta = miSession.createQuery("delete from Cliente where id=:IdDelCliente");
		
		// Establecemos el par�metro a borrar
		
		consulta.setParameter("IdDelCliente", id);
		
		consulta.executeUpdate();
		
	}

}














