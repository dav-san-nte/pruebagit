package domain;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "Transacciones")
public class Transacciones {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idtransacciones;

	    @Column
	    private String tipoTransaccion;

	    @Column(precision = 15, scale = 2)
	    private BigDecimal monto;

	    @Temporal(TemporalType.DATE)
		@Column(name = "fechaHora")
	    private Date fechaHora;

	    @Column
	    private String descripcion;

	    @Column(precision = 15, scale = 2)
	    private BigDecimal saldoResultante;
	    
	    
	    
	    

		public Transacciones(String tipoTransaccion, BigDecimal monto, Date fechaHora,
				String descripcion, BigDecimal saldoResultante) {
			super();
			
			this.tipoTransaccion = tipoTransaccion;
			this.monto = monto;
			this.fechaHora = fechaHora;
			this.descripcion = descripcion;
			this.saldoResultante = saldoResultante;
		}
		
		
		public Transacciones() {
		
		}

		public Long getIdtransacciones() {
			return idtransacciones;
		}

		public void setIdtransacciones(Long idtransacciones) {
			this.idtransacciones = idtransacciones;
		}

		public String getTipoTransaccion() {
			return tipoTransaccion;
		}

		public void setTipoTransaccion(String tipoTransaccion) {
			this.tipoTransaccion = tipoTransaccion;
		}

		public BigDecimal getMonto() {
			return monto;
		}

		public void setMonto(BigDecimal monto) {
			this.monto = monto;
		}

		public Date getFechaHora() {
			return fechaHora;
		}

		public void setFechaHora(Date fechaHora) {
			this.fechaHora = fechaHora;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public BigDecimal getSaldoResultante() {
			return saldoResultante;
		}

		public void setSaldoResultante(BigDecimal saldoResultante) {
			this.saldoResultante = saldoResultante;
		}
	
	
	    
	    
	    
	    
}
