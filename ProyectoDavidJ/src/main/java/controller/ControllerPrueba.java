package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Api

//Visualizar el tipo de informacion de inserta y devuelve

@RestController
@RequestMapping("/Prueba")
public class ControllerPrueba {

	
	//Estos son de prueba para ver si funciona todo correctamente 
    @GetMapping("/pru")
    public String pru() {
        return "Hola, Funciona correctamente";
    }
    
    
    @GetMapping("/pcasas")
    public String pcasas() {
        return "Hola, que tal soinfnkoafnkoa alk la ckd,a cllc akd c kc d clkd k";
    }
    
    
    
    
    
}
