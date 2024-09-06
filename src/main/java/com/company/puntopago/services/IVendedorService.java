package com.company.puntopago.services;

import com.company.puntopago.response.VendedorResponseRest;
import org.springframework.http.ResponseEntity;

public interface IVendedorService {
    public ResponseEntity<VendedorResponseRest> search();
}
