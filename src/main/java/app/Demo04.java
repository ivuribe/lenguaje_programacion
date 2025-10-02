package app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		// Establecemos la conexion a la bd
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");

		// Creamos el administrador de entidades
		EntityManager manager = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese el Codigo de usuario: ");
		Integer codUsuario = sc.nextInt();
		
		sc.nextLine();

		Usuario usuario = manager.find(Usuario.class, codUsuario);

		if (usuario != null) {
			System.out.println("Usuario encontrado");

			System.out.println("Ingrese nuevo nombre");
			String nuevoNombre = sc.nextLine();

			System.out.println("Ingrese nuevo apellido");
			String nuevoApellido = sc.nextLine();

			System.out.println("Ingrese nuevo clave");
			String nuevoClave = sc.nextLine();

			try {
				manager.getTransaction().begin();

				usuario.setNombres(nuevoNombre);
				usuario.setApellido(nuevoApellido);
				usuario.setClave(nuevoClave);
				manager.merge(usuario);

				manager.getTransaction().commit();

				System.out.println("Datos actulizados exitosamente! ");

			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			} 

		} else {
			System.out.println("Usuario no encontrado");
		}
		sc.close();
		manager.close();
		factory.close();

	}

}
