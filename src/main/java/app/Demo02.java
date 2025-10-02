package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		//Establecemos la conexion a la bd
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
		
		//Creamos el administrador de entidades
		EntityManager manager = factory.createEntityManager();
		
		try {
			Usuario usuario = new Usuario();
			usuario.setCodUsuario(6);
			usuario.setNombres("Niko");
			usuario.setApellido("Flores Uribe");
			usuario.setCuenta("nk01@gmail.com");
			usuario.setClave("M0lla");
			usuario.setFechaNac(LocalDate.of(1990, 9, 1));
			usuario.setIdTipo(2);
			usuario.setIdEstado(1);
			
			//Iniciamos transaccion
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			System.out.println("Actulalizacion exitosa");
			
			
		} catch (Exception e) {
			System.out.println("Hubo un error en la transaccion");
			System.out.println("Error: " + e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
	}

}
