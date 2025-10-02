package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		// Establecemos la conexion a la bd
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");

		// Creamos el administrador de entidades
		EntityManager manager = factory.createEntityManager();

		//Cosultas JPQL para traer todos los usuarios
		String jpql = "SELECT u from Usuario u";
		List<Usuario> lstUsuario = manager.createQuery(jpql, Usuario.class).getResultList();
		
		//Mostrar la informacion
		System.out.println("Listado de Usuarios: ");
		System.out.println("****************************************************");
		for (Usuario u : lstUsuario) {
			System.out.println("Codigo.......: " + u.getCodUsuario());
			System.out.println("Nombre.......: " + u.getNombres() + " " + u.getApellido());
			System.out.println("Tipo.........: " + u.getIdTipo());
			System.out.println("****************************************************");
		}
		
		manager.close();
		factory.close();

	}

}
