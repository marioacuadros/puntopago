package com.company.puntopago.response;

import com.company.puntopago.model.Venta;
import lombok.Data;

import java.util.List;

@Data
public class VentaResponse {
    private List<Venta> venta;
}
