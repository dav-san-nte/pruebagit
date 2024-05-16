package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Beneficiarios")
public class Beneficiarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idbeneficiarios;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private Integer numerocuenta;
	@Column
	private String banco;
	
	
	public Beneficiarios(String nombre, String apellido, Integer numerocuenta, String banco) {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.numerocuenta = numerocuenta;
		this.banco = banco;
	}
	
	public Beneficiarios() {
	
	}
	

	public long getIdbeneficiarios() {
		return idbeneficiarios;
	}

	public void setIdbeneficiarios(long idbeneficiarios) {
		this.idbeneficiarios = idbeneficiarios;
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

	public Integer getNumerocuenta() {
		return numerocuenta;
	}

	public void setNumerocuenta(Integer numerocuenta) {
		this.numerocuenta = numerocuenta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}


}
