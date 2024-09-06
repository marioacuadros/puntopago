package com.company.puntopago.response;

import com.company.puntopago.model.Operador;
import lombok.Data;

import java.util.List;
@Data
public class OperadorResponse {
    private List<Operador> operador;
}
