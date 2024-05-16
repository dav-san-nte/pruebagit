package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Transacciones;
import repos.TransaccionesRepository;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Transactional
public class TransaccionesService implements CommandLineRunner {

    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Override
    public void run(String... args) throws Exception {
        Transacciones transaccion1 = new Transacciones("Depósito", new BigDecimal("1000.00"), new Date(), "Depósito inicial", new BigDecimal("1000.00"));
        Transacciones transaccion2 = new Transacciones("Retiro", new BigDecimal("200.00"), new Date(), "Retiro de efectivo", new BigDecimal("800.00"));

        // Guardar las transacciones en la base de datos
        transaccionesRepository.save(transaccion1);
        transaccionesRepository.save(transaccion2);
    }
}
