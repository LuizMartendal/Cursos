package com.springdesk.springdesk.models;

import com.springdesk.springdesk.enums.Perfil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Types;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class PessoaModelImpl implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "char(36)")
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil;

    public PessoaModelImpl() { }

    public PessoaModelImpl(UUID id, String name, String email, String senha, Perfil perfil) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }
}
