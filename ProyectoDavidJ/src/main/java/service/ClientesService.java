package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Clientes;
import repos.ClientesRepository;

@Service
@Transactional
public class ClientesService implements CommandLineRunner {

	@Autowired
	private ClientesRepository clientesrepository;

	//que actúa como una capa intermedia entre el controlador y el repositorio en una arquitectura típica de Spring MVC.
	
	
	//encapsula la lógica relacionada con la manipulación de datos de clientes y proporciona métodos 
	//para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos a través del repositorio ClientesRepository.
	
	  
	
	public ClientesService(ClientesRepository clientesRepository) {
	        this.clientesrepository = clientesRepository;
	    }

	    public List<Clientes> getAllClientes() {
	        return clientesrepository.findAll();
	    }

	    public Clientes getClienteById(Long id) {
	        return clientesrepository.findById(id).orElse(null);
	    }

	    public Clientes addCliente(Clientes cliente) {
	        return clientesrepository.save(cliente);
	    }

	    public Clientes updateCliente(Long id, Clientes cliente) {
	        cliente.setId_cliente(id); // Aseguramos que el ID sea el correcto
	        return clientesrepository.save(cliente);
	    }

	    public void deleteCliente(Long id) {
	    	clientesrepository.deleteById(id);
	    }
	
	

	@Override
	public void run(String... args) throws Exception {

	
		//Insertamos datos predeterminados para cuando se inicie la aplicacion se inserten directamente en la base de datos
	
		System.out.print("Insertando datos");

		Clientes cliente = new Clientes();

		cliente.setNombre("Pepe");
		cliente.setApellido("Ferguson");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaNacimiento = dateFormat.parse("2012-12-12");

		cliente.setFecha_nacimiento(fechaNacimiento); // Establecer la fecha de nacimiento como la fecha actual
		cliente.setDireccion("Calle Principal 123");
		cliente.setTelefono(123456789);
		cliente.setCorreo("pepe@example.com");

		// Guardar el cliente en la base de datos
		clientesrepository.save(cliente);
		System.out.println("Datos insertados correctamente.");
		
		
		
	 // Insertar segundo cliente
	    Clientes cliente2 = new Clientes();
	    cliente2.setNombre("Ana");
	    cliente2.setApellido("Martínez");
	    Date fechaNacimiento2 = dateFormat.parse("1990-05-25");
	    cliente2.setFecha_nacimiento(fechaNacimiento2);
	    cliente2.setDireccion("Avenida Central 456");
	    cliente2.setTelefono(987654321);
	    cliente2.setCorreo("ana@example.com");
	    
	    clientesrepository.save(cliente2);
	    System.out.println("Datos insertados correctamente.");

	

		
	}

}
