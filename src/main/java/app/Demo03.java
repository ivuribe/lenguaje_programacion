package app;

//import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		//Establecemos la conexion a la bd
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
		
		//Creamos el administrador de entidades
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Ingrese el Codigo de usuario: ");
			Integer codUsuario = sc.nextInt();
			
			Usuario usuario = manager.find(Usuario.class, codUsuario);
			
			StringBuilder sb = new StringBuilder();
			sb.append("Los datos son: \n");
			sb.append("Nombres : "+ usuario.getNombres()+"\n");
			sb.append("Apellidos : "+ usuario.getApellido()+"\n");
			sb.append("Cuenta : "+ usuario.getCuenta()+"\n");
			sb.append("Clave : "+ usuario.getClave()+"\n");
			System.out.println(sb);
			
			
		} catch (Exception e) {
			System.out.println("Hubo un error en la transaccion");
			System.out.println("Error: " + e.getMessage());
			System.out.println("Usuario no encontrado");
		} finally {
			sc.close();
			manager.close();
			factory.close();
		}
	}

}
