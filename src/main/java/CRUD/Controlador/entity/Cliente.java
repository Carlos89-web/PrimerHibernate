package CRUD.Controlador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Indicamos a la clase que va a ser una entidad con @Entity y la tabla que va a mapear con @Table

@Entity
@Table(name="cliente")
public class Cliente {
	
	// Creamos tantos campos encapsulados como campos haya en la tabla de la BD, 4 en nuestro caso
	// Indicamos cual es el campo ID (@Id), cual es el campo que da entidad @GeneratedValue , es 
	// decir, el campo clave  y a que campo de la tabla corresponde cada variable (@Column) 
	// (Siempre deben coincidir el nombre de la variable con el nombre del titulo de la columna de 
	// la tabla de la BD)
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="email")
	private String email;
	
	// Creamos un constructor por defecto, getters y setters, y toString
	
	public Cliente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}
	
	

}
