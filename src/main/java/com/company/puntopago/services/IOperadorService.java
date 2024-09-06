package com.company.puntopago.services;

import com.company.puntopago.model.Operador;
import com.company.puntopago.response.OperadorResponseRest;
import org.springframework.http.ResponseEntity;

public interface IOperadorService {
    public ResponseEntity<OperadorResponseRest> search();
    public ResponseEntity<OperadorResponseRest> searchById(Long id);
    public ResponseEntity<OperadorResponseRest> save(Operador operador);
    public ResponseEntity<OperadorResponseRest> update(Operador operador, Long id);
    public ResponseEntity<OperadorResponseRest> delete(Long id);
}
