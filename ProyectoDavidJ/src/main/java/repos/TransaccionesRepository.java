package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Transacciones; // Asegúrate de importar la clase correcta

@Repository
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {
    // Aquí puedes agregar métodos personalizados de repositorio si los necesitas
}
