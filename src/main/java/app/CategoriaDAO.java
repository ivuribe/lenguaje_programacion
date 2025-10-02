/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Categoria;

/**
 *
 * @author SUITE
 */
public class CategoriaDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");
    
    public void registrar(Categoria categoria){
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
    
    public List<Categoria> listar(){
        EntityManager em = factory.createEntityManager();
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }
    
    public Categoria buscar(int id) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }
}