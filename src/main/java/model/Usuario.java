package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "tb_usuarios")
@DynamicInsert
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usua")
	private Integer codUsuario;

	@Column(name = "nom_usua")
	private String nombres;

	@Column(name = "ape_usua")
	private String apellido;

	@Column(name = "usr_usua")
	private String cuenta;

	@Column(name = "cla_usua")
	private String clave;

	@Column(name = "fna_usua")
	private LocalDate fechaNac;

        //Original para el ejercicio del T1
        /*
	@Column(name = "idtipo")
	private Integer idTipo;
        */
        
        //Mejorado para el ejercicio del T2
        @ManyToOne
        @JoinColumn(name = "idtipo")
        private Tipo tipo;
        
	@Column(name = "est_usua")
	private Integer idEstado;

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
        //getIdTipo y setIdTipo según el ejercicio del T1
	public Integer getIdTipo() {
		//return idTipo;
                return tipo.getId();
	}

	public void setIdTipo(Integer idTipo) {
		//this.idTipo = idTipo;
                this.tipo.setId(idTipo); 
	}
        
        //Mejorado para trabajar con la Clase Tipo según el ejercicio del T2
        public Tipo getTipo(){
            return tipo;
        }
        
        public void setTipo(Tipo tipo){
            this.tipo = tipo;
        }

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	

}
