package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Empleados; // Asegúrate de importar la clase correcta

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
    // Aquí puedes agregar métodos personalizados de repositorio si los necesitas
	
	  Logger logger = LoggerFactory.getLogger(EmpleadosRepository.class);

	    default void testMethod() {
	        logger.info("Mensaje de prueba desde el repositorio de Empleados.");
	    }
	
}
