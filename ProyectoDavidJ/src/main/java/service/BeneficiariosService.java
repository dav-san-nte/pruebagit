package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Beneficiarios;
import repos.BeneficiariosRepository;

@Service
@Transactional
public class BeneficiariosService implements CommandLineRunner {

    @Autowired
    private BeneficiariosRepository beneficiariosRepository;

    @Override
    public void run(String... args) throws Exception {
        Beneficiarios beneficiario1 = new Beneficiarios("Juan", "Perez", 123456789, "Banco A");
        Beneficiarios beneficiario2 = new Beneficiarios("Maria", "Lopez", 987654321, "Banco B");

        // Guardar los beneficiarios en la base de datos
        beneficiariosRepository.save(beneficiario1);
        beneficiariosRepository.save(beneficiario2);
    }
}
