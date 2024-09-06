package com.company.puntopago.controller;

import com.company.puntopago.model.Venta;
import com.company.puntopago.response.VentaResponseRest;
import com.company.puntopago.services.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VentaController {
    @Autowired
    private IVentaService service;

    @GetMapping("/ventas")
    public ResponseEntity<VentaResponseRest> listarVentas(){
        ResponseEntity<VentaResponseRest> response = service.search();
        return response;
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<VentaResponseRest> buscarPorId(@PathVariable Long id){
        ResponseEntity<VentaResponseRest> response = service.searchById(id);
        return response;
    }
    @PostMapping("ventas")
    public ResponseEntity<VentaResponseRest> GuardarVenta(@RequestParam("celular") String celular,
                                                          @RequestParam("fecha") String fecha,
                                                          @RequestParam("valor") Long valor,
                                                          @RequestParam("idOperador") Long idOperador,
                                                          @RequestParam("idVendedor") Long idVendedor
                ){
        Venta venta = new Venta();
        venta.setCelular(celular);
        venta.setFecha(fecha);
        venta.setValor(valor);
        ResponseEntity<VentaResponseRest> response = service.save(venta, idOperador, idVendedor);
        return response;
    }

    @PutMapping("ventas/{id}")
    public ResponseEntity<VentaResponseRest> ActualizarVenta(@RequestBody Venta venta, @PathVariable Long id){
        ResponseEntity<VentaResponseRest> response = service.update(venta, id);
        return response;
    }

    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<VentaResponseRest> eliminarVenta(@PathVariable Long id){
        ResponseEntity<VentaResponseRest> response = service.delete(id);
        return response;
    }

}
