package com.company.puntopago.dao;

import com.company.puntopago.model.Vendedor;
import org.springframework.data.repository.CrudRepository;

public interface IVendedorDao extends CrudRepository<Vendedor, Long> {
}
