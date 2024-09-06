package com.company.puntopago.controller;

import com.company.puntopago.response.OperadorResponseRest;
import com.company.puntopago.response.VendedorResponseRest;
import com.company.puntopago.services.IOperadorService;
import com.company.puntopago.services.IVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VendedorController {
    @Autowired
    private IVendedorService service;
    @GetMapping("/vendedores")
    public ResponseEntity<VendedorResponseRest> listarVendedores(){
        ResponseEntity<VendedorResponseRest> response = service.search();
        return response;
    }
}
