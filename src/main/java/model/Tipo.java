/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author SUITE
 */

@Entity
@Table(name="tb_tipos")
@Data //autogenera los getters y setters, esta anotacion pertenece a Lombok
public class Tipo {
    
    @Id
    @Column(name = "idtipo")
    private int id;
    
    @Column(name = "descripcion", length = 15)
    private String descripcion;
    
    //Forma tradicional de getters y setters si no se usa Lombok
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
}
