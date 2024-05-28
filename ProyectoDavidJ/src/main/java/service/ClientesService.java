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
	
	//servicio de autenticación
	public Clientes authenticate(String nombre, Integer pin) {
        return clientesrepository.findByNombreAndPin(nombre, pin);
    }
	

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

	
		 insertarDatosPredeterminados();

		
	}
	
	
	  private void insertarDatosPredeterminados() throws Exception {
	        System.out.println("Insertando datos predeterminados");

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	        if (clientesrepository.findByNombreAndPin("Pepe", 1234) == null) {
	            Clientes cliente1 = new Clientes();
	            cliente1.setNombre("Pepe");
	            cliente1.setApellido("Ferguson");
	            cliente1.setFecha_nacimiento(dateFormat.parse("2012-12-12"));
	            cliente1.setDireccion("Calle Principal 123");
	            cliente1.setTelefono(123456789);
	            cliente1.setCorreo("pepe@example.com");
	            cliente1.setPin(1234);
	            clientesrepository.save(cliente1);
	            System.out.println("Datos del cliente Pepe insertados correctamente.");
	        }

	        if (clientesrepository.findByNombreAndPin("Ana", 5432) == null) {
	            Clientes cliente2 = new Clientes();
	            cliente2.setNombre("Ana");
	            cliente2.setApellido("Martínez");
	            cliente2.setFecha_nacimiento(dateFormat.parse("1990-05-25"));
	            cliente2.setDireccion("Avenida Central 456");
	            cliente2.setTelefono(987654321);
	            cliente2.setCorreo("ana@example.com");
	            cliente2.setPin(5432);
	            clientesrepository.save(cliente2);
	            System.out.println("Datos del cliente Ana insertados correctamente.");
	        }
	        
	        if (clientesrepository.findByNombreAndPin("Carlos", 6789) == null) {
	            Clientes cliente3 = new Clientes();
	            cliente3.setNombre("Carlos");
	            cliente3.setApellido("Lopez");
	            cliente3.setFecha_nacimiento(dateFormat.parse("1985-03-15"));
	            cliente3.setDireccion("Calle Secundaria 789");
	            cliente3.setTelefono(112233445);
	            cliente3.setCorreo("carlos@example.com");
	            cliente3.setPin(6789);
	            clientesrepository.save(cliente3);
	            System.out.println("Datos del cliente Carlos insertados correctamente.");
	        }
	        
	        
	        
	        
	
	
	
	
	  }
}
