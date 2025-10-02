/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Proveedor;

/**
 *
 * @author SUITE
 */
public class ProveedorDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
    
    public void registrar(Proveedor proveedor){
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
    
    public List<Proveedor> listar(){
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public Proveedor buscar(int id){
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }
}
