package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {

	public static void main(String[] args) {
		// Establecemos la conexion a la bd
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");

		// Creamos el administrador de entidades
		EntityManager manager = factory.createEntityManager();

		//Cosultas JPQL para traer todos los usuarios en base a un criterio de busqueda
		String jpql = "SELECT u from Usuario u WHERE u.idEstado = :estado";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("estado", 1);
		
		List<Usuario> lstUsuario = query.getResultList();
		
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
