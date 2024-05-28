package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    // Aquí puedes agregar métodos personalizados de repositorio si los necesitas
	
	
	 Clientes findByNombreAndPin(String nombre, Integer pin);
	
	
}
