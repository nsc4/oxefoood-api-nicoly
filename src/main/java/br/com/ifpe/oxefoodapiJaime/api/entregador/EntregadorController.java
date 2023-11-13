
package br.com.ifpe.oxefoodapiJaime.api.entregador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapiJaime.modelo.entregador.Entregador;
import br.com.ifpe.oxefoodapiJaime.modelo.entregador.EntregadorService;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {

   @Autowired
   private EntregadorService entregadorService;

   @PostMapping
   public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {

       Entregador entregador = entregadorService.save(request.build());
       return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
       
   }
   @GetMapping
    public List<Entregador> findAll() {
  
        return entregadorService.findAll();
    }

    @GetMapping("/{id}")
    public Entregador findById(@PathVariable Long id) {

        return entregadorService.findById(id);
    }
    //
     @PutMapping("/{id}")
   public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

       entregadorService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       entregadorService.delete(id);
       return ResponseEntity.ok().build();
   }

}