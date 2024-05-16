package controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Aquí puedes personalizar la página de error como desees
        return "error"; // Suponiendo que tienes una vista llamada "error"
    }
}
