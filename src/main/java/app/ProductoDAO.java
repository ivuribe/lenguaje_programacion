/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Producto;

/**
 *
 * @author SUITE
 */
public class ProductoDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
    
    public boolean registrar(Producto producto){
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        } finally{
            em.close();
        }
    }
    
    public List<Producto> listar(){
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public Producto buscar(String id){
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }
}
