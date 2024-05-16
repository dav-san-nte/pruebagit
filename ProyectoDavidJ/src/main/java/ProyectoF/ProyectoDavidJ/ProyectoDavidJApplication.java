package ProyectoF.ProyectoDavidJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"config"})    //Para que escane la clase config 
public class ProyectoDavidJApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDavidJApplication.class, args);
	}

}
