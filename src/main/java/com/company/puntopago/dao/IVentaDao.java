package com.company.puntopago.dao;

import com.company.puntopago.model.Venta;
import org.springframework.data.repository.CrudRepository;

public interface IVentaDao  extends CrudRepository<Venta, Long> {
}
