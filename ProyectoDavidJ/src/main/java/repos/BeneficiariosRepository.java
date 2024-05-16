package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Beneficiarios; // Asegúrate de importar la clase correcta

@Repository
public interface BeneficiariosRepository extends JpaRepository<Beneficiarios, Long> {
    // Aquí puedes agregar métodos personalizados de repositorio si los necesitas
}
