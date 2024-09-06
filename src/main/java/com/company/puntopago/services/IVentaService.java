package com.company.puntopago.services;


import com.company.puntopago.model.Venta;
import com.company.puntopago.response.VentaResponseRest;
import org.springframework.http.ResponseEntity;

public interface IVentaService {
    public ResponseEntity<VentaResponseRest> search();
    public ResponseEntity<VentaResponseRest> searchById(Long id);
    public ResponseEntity<VentaResponseRest> save(Venta venta, Long idOperador, Long idVendedor);
    public ResponseEntity<VentaResponseRest> update(Venta venta, Long id);
    public ResponseEntity<VentaResponseRest> delete(Long id);
}
