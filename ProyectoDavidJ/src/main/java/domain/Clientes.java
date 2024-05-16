package domain;

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
@Table(name = "Clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_cliente;
	@Column
	private String nombre;
	@Column
	private String apellido;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	@Column
	private String direccion;
	@Column
	private Integer telefono;
	@Column
	private String correo;
	
	//Cliente - Cuentas relacion (1-n)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Cuentas> cuentas;
	

	public Clientes(String nombre, String apellido, Date fecha_nacimiento, String direccion,
			Integer telefono, String corre, List<Cuentas> cuentas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = corre;
		this.cuentas = cuentas;
	}
	
	
	public Clientes() {
	
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
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

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String corre) {
		this.correo = corre;
	}

	public List<Cuentas> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuentas> cuentas) {
		this.cuentas = cuentas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
