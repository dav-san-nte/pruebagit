package domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "Empleados")
public class Empleados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idempleado;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String cargo;
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaApertura")
	private Date fechacontrato;

	@Column(precision = 15, scale = 2)
	private BigDecimal salario;

	@Column
	private String departamento;

	@Column
	private String correoElectronico;

	@Column
	private Integer telefono;
	
	
	//Empledos - Transacciones relacion (1-n)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Transacciones> transacciones;


	public Empleados(String nombre, String apellido, String cargo, Date fechacontrato,
			BigDecimal salario, String departamento, String correoElectronico, Integer telefono,
			List<Transacciones> transacciones) {
		super();
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechacontrato = fechacontrato;
		this.salario = salario;
		this.departamento = departamento;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.transacciones = transacciones;
	}

	
	public Empleados() {
		
	}
	

	public long getIdempleado() {
		return idempleado;
	}


	public void setIdempleado(long idempleado) {
		this.idempleado = idempleado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Date getFechacontrato() {
		return fechacontrato;
	}


	public void setFechacontrato(Date fechacontrato) {
		this.fechacontrato = fechacontrato;
	}


	public BigDecimal getSalario() {
		return salario;
	}


	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public List<Transacciones> getTransacciones() {
		return transacciones;
	}


	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}
    
	
	

}
