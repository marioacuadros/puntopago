package com.company.puntopago.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name="operadores")
public class Operador implements Serializable {
    @Serial
    private static final long serialVersionUID = 5650299312021273925L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperador;
    private String operador;
}
