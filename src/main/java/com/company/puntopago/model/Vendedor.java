package com.company.puntopago.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name="vendedores")
public class Vendedor implements Serializable {
    @Serial
    private static final long serialVersionUID = 6819565186854241157L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendedor;
    private String numDocumento;
    private String nombre;
    private String telefono;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoDocumento tipoDocumento;
}
