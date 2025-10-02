/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author SUITE
 */
@Entity
@Table(name="tb_categorias")
public class Categoria {
    
    @Id
    @Column(name="idcategoria")
    private int id;
    
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
}
