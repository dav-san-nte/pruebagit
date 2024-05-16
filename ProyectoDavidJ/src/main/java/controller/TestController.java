package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import repos.EmpleadosRepository;

@RestController
public class TestController {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @GetMapping("/test")
    public String test() {
        empleadosRepository.testMethod();
        return "Mensaje de prueba enviado al repositorio de Empleados.";
    }
}
