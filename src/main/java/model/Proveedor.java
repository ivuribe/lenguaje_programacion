/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author SUITE
 */
@Entity
@Table(name = "tb_proveedor")
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproveedor;
    
    @Column(name = "nombre_rs", nullable=false, length = 45)
    private String nombre_rs;
    
    @Column(name = "telefono", length = 10)
    private String telefono;
    
    @Column(name = "email", length = 45)
    private String email;

    /**
     * @return the idproveedor
     */
    public int getIdproveedor() {
        return idproveedor;
    }

    /**
     * @param idproveedor the idproveedor to set
     */
    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    /**
     * @return the nombre_rs
     */
    public String getNombre_rs() {
        return nombre_rs;
    }

    /**
     * @param nombre_rs the nombre_rs to set
     */
    public void setNombre_rs(String nombre_rs) {
        this.nombre_rs = nombre_rs;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
