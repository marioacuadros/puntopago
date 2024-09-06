package com.company.puntopago.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name="tipos_documento")
public class TipoDocumento implements Serializable{
    @Serial
    private static final long serialVersionUID = 7285794836806750952L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumento;
    private String tipoDocumento;
}
