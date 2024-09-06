package com.company.puntopago.response;

import com.company.puntopago.model.Vendedor;
import lombok.Data;

import java.util.List;
@Data
public class VendedorResponse {
    private List<Vendedor> vendedor;
}
