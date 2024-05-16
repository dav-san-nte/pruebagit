package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Cuentas; // Asegúrate de importar la clase correcta

@Repository
public interface CuentasRepository extends JpaRepository<Cuentas, Long> {
    // Aquí puedes agregar métodos personalizados de repositorio si los necesitas
	
}

