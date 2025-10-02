package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		//Establecemos la conexion a la bd
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
		
		//Creamos el administrador de entidades
		EntityManager manager = factory.createEntityManager();
		
		try {
			Usuario usuario = new Usuario();
			usuario.setNombres("Niko");
			usuario.setApellido("Flores");
			usuario.setCuenta("nk01@gmail.com");
			usuario.setClave("456789");
			usuario.setFechaNac(LocalDate.of(1990, 9, 1));
			
			//Iniciamos transaccion
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			System.out.println("Registro exitoso");
			
			
		} catch (Exception e) {
			System.out.println("Hubo un error en la transaccion");
			System.out.println("Error: " + e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
	}

}
