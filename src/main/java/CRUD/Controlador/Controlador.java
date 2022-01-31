package CRUD.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CRUD.Controlador.entity.Cliente;
import CRUD.DAO.ClienteDAO;

// --- Video 67, 71, 73, 75 ---

// Le decimos que será la clase controlador con la annotation @Controller.
// Registramos las url, que es la tabla "cliente" de la BD, a través de @RequestMapping

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	// Creamos de forma encapsulada de tipo ClienteDAO al que llamamos clienteDAO
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	// Creamos un método que nos va a devovler el JSP, que recibe por parámetro el Model
	// al que llamamos modelo, retornamos el nombre de nuestro JSP

	@RequestMapping("/lista")
	public String listaClients (Model modelo) {
		
		// Creamos una inyección desde la clase ClienteDAO hasta el controlador.
		// Este método debe obtener los clientes desde el DAO
		
		List<Cliente> losClientes = clienteDAO.getClientes();
		
		// Agregar los clientes al model "modelo"
		
		modelo.addAttribute("clientes", losClientes);
		
		return "lista-clientes";
		
	}
	
	// Creamos un mapeo al formulario "formularioCliente" de la carpeta view
	
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model modelo) {
		
		// Bind de datos cliente para crear clientes totalmente nuevos
		
		Cliente elCliente = new Cliente();
		
		// Pasamos como parámetro el nombre del atributo y lo agregamos
		
		modelo.addAttribute("cliente", elCliente);
		
		return "formularioCliente";
		
	}
	
	// Creamos un método que conecte el botón insertar con la base de datos y agregue al cliente 
	// a la tabla. Por parámetro, debemos pasarle el modelattribute, al que dimos nombre en el 
	// formulario "formularioCliente", y a continuación, un objeto de tipo Cliente. Y por último,
	// redireccionamos a clientes/lista
	
	@PostMapping("/insertarCliente")
	public String insertarCliente (@ModelAttribute("cliente") Cliente elCliente) {
		
		// Insertamos el cliente en la BD
		
		clienteDAO.insertarCliente(elCliente);
		
		return "redirect:/cliente/lista";
		
	}
	
	// Video 73: Este método hará 3 tareas
	
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int Id, Model modelo) {
		
		// Primero, obtiene el cliente: Creamos un objeto de tipo Cliente,
		
		Cliente elCliente = clienteDAO.getCliente(Id);
		
		// Segundo, establece el cliente como atributon del modelo
		
		modelo.addAttribute("cliente", elCliente);
		
		// Tercero, enviar al formulario
		
		return "formularioCliente";
		
	}
	
	// Video 75: Creamos un mapeo hacia el link del botón eliminar. Model no lo necesitamos
	// porque no necesitamos información del objeto cliente, solo el id. 
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int Id) {
		
		// Primero, obtiene el cliente que queremos eliminar
		
		clienteDAO.eliminarCliente(Id);
		
		// Segundo, redireccionar a la lista de clientes
		
		return "redirect:/cliente/lista";
		
	}

}









