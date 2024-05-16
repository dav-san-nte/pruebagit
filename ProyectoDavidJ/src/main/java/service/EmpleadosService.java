package service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Empleados;
import repos.EmpleadosRepository;

@Service
@Transactional
public class EmpleadosService implements CommandLineRunner {

    @Autowired
    private EmpleadosRepository empleadosrepository;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void run(String... args) throws Exception {

        Empleados empleado = new Empleados();

        empleado.setNombre("Lupicinio");
        empleado.setApellido("Belmonte");
        empleado.setCargo("The boss");
        
        empleado.setFechacontrato(dateFormat.parse("2016-01-06"));
        
        empleado.setSalario(new BigDecimal("14000.00"));
        empleado.setDepartamento("Jefatura");
        empleado.setCorreoElectronico("lupicinio@banco.es");
        empleado.setTelefono(654557890);
        
        empleadosrepository.save(empleado);

    
        
        
    }

}