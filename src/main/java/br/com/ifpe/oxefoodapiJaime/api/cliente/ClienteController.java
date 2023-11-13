package br.com.ifpe.oxefoodapiJaime.api.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapiJaime.modelo.cliente.Cliente;
import br.com.ifpe.oxefoodapiJaime.modelo.cliente.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {


    

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       clienteService.delete(id);
       return ResponseEntity.ok().build();
   }


   @Autowired
   private ClienteService clienteService;

   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
       
   }
   
   @GetMapping
    public List<Cliente> findAll() {
  
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {

        return clienteService.findById(id);
        
    }

    



       
   }



