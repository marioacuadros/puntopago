package com.company.puntopago.controller;


import com.company.puntopago.model.Operador;
import com.company.puntopago.response.OperadorResponseRest;
import com.company.puntopago.services.IOperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class OperadorController {
    @Autowired
    private IOperadorService service;

    @GetMapping("/operadores")
    public ResponseEntity<OperadorResponseRest> listarOperadores(){
        ResponseEntity<OperadorResponseRest> response = service.search();
        return response;
    }

    @GetMapping("/operadores/{id}")
    public ResponseEntity<OperadorResponseRest> buscarPorId(@PathVariable Long id){
        ResponseEntity<OperadorResponseRest> response = service.searchById(id);
        return response;
    }

    @PostMapping("operadores")
    public ResponseEntity<OperadorResponseRest> GuardarOperador(@RequestBody Operador operador){
        ResponseEntity<OperadorResponseRest> response = service.save(operador);
        return response;
    }
    @PutMapping("operadores/{id}")
    public ResponseEntity<OperadorResponseRest> ActualizarOperador(@RequestBody Operador operador, @PathVariable Long id){
        ResponseEntity<OperadorResponseRest> response = service.update(operador, id);
        return response;
    }
    @DeleteMapping("/operadores/{id}")
    public ResponseEntity<OperadorResponseRest> eliminarOperador(@PathVariable Long id){
        ResponseEntity<OperadorResponseRest> response = service.delete(id);
        return response;
    }

}
