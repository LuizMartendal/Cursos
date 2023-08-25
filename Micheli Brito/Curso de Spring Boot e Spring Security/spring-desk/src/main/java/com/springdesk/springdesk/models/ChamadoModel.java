package com.springdesk.springdesk.models;

import com.springdesk.springdesk.enums.Prioridade;
import com.springdesk.springdesk.enums.Status;
import com.springdesk.springdesk.models.pessoa.ClienteModel;
import com.springdesk.springdesk.models.pessoa.TecnicoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "chamado")
public class ChamadoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(columnDefinition = "char(36)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column
    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column
    private String observacao;

    @ManyToOne()
    @JoinColumn(name = "id_cliente_fk", referencedColumnName = "id", columnDefinition = "char(36)")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_tecnico_fk", referencedColumnName = "id", columnDefinition = "char(36)")
    private TecnicoModel tecnico;
}
