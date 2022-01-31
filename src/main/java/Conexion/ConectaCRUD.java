package Conexion;

// ---  VIDEO 66 ---

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConectaCRUD
 */
@WebServlet("/ConectaCRUD")
public class ConectaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectaCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// Comentamos la linea 36 y copiamos el código de conexión a BD de la clase pruebasJDBC
		// Agregamos el driver, creamos el response, y cargamos el driver.
		// Creamos la conexión a la BD
		
		String jdbcURL = "jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
		String usuario ="root";
		String clave = "968574";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.print("Nombre de la base de datos: "+jdbcURL+"<br>");
			
			Class.forName(driver);
			
			Connection miConexion = DriverManager.getConnection(jdbcURL, usuario, clave);
			
			out.print("Conectado");
			
			miConexion.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
