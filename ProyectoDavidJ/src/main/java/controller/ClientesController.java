package controller;


import domain.Clientes;
import service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Esta clase es un controlador de Spring MVC que gestiona las solicitudes relacionadas con los clientes de una aplicación
//En resumen, este controlador proporciona puntos finales RESTful para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad de Cliente de la aplicación.
//Métodos de solicitud HTTP:

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	@Autowired
    private ClientesService clientesService;

    
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping //Este método maneja las solicitudes GET a la ruta /clientes y devuelve una lista de todos los clientes en la base de datos.
    public List<Clientes> getAllClientes() {
        return clientesService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Clientes getClienteById(@PathVariable Long id) {
        return clientesService.getClienteById(id);
    }

    @PostMapping
    public Clientes addCliente(@RequestBody Clientes cliente) {
        return clientesService.addCliente(cliente);
    }

    @PutMapping("/{id}")
    public Clientes updateCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        return clientesService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clientesService.deleteCliente(id);
    }
    
    
    //Swagger es un conjunto de herramientas de código abierto que se utiliza para diseñar, crear, documentar y consumir servicios web RESTful.
    
}
