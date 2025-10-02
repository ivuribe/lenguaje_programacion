package app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

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

			StringBuilder sb = new StringBuilder();
			sb.append("Los datos son: \n");
			sb.append("Nombres : "+ usuario.getNombres()+"\n");
			sb.append("Apellidos : "+ usuario.getApellido()+"\n");
			sb.append("Cuenta : "+ usuario.getCuenta()+"\n");
			sb.append("Clave : "+ usuario.getClave()+"\n");
			System.out.println(sb);

			try {
				manager.getTransaction().begin();

				manager.remove(usuario);

				manager.getTransaction().commit();

				System.out.println("Datos eliminado exitosamente! ");

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
