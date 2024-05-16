package service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Cuentas;
import repos.CuentasRepository;

@Service
@Transactional
public class CuentasService implements CommandLineRunner{
	@Autowired
	private CuentasRepository cuentasrepository;

	
	
	
	@Override
	public void run(String... args) throws Exception {

		
		System.out.print("Insertando datos");
		
		Cuentas cuenta = new Cuentas();
		
		 // Establecer los valores de los atributos
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldo(new BigDecimal("1000.00"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaApertura = dateFormat.parse("2022-01-01");
        cuenta.setFechaApertura(fechaApertura);
        cuenta.setEstadoCuenta("Activa");

        // No necesitamos establecer transacciones y beneficiarios en este ejemplo

        // Guardar la cuenta en la base de datos
        cuentasrepository.save(cuenta);

        System.out.println("Datos de cuentas insertados correctamente.");
		
		
		
	}
	
	
	
	
	
	
}
