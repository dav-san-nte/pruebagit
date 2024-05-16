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
@Table(name = "Cuentas")
public class Cuentas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cuenta;

	@Column
	private String tipoCuenta;

	@Column(precision = 15, scale = 2)
	private BigDecimal saldo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaApertura")
	private Date fechaApertura;

	@Column
	private String estadoCuenta;

	// Cuentas - Transacciones relacion (1-n)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Transacciones> transacciones;

	// Cuentas - Beneficiarios relacion (1-n)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Beneficiarios> beneficiarios;
	
	

	public Cuentas(String tipoCuenta, BigDecimal saldo, Date fechaApertura, String estadoCuenta,
			List<Transacciones> transacciones, List<Beneficiarios> beneficiarios) {
		super();
		
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
		this.estadoCuenta = estadoCuenta;
		this.transacciones = transacciones;
		this.beneficiarios = beneficiarios;
	}
	
	
	public Cuentas() {
		
	}
	

	public long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public List<Transacciones> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	public List<Beneficiarios> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiarios> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	
	
	
	

}
