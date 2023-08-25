package com.springdesk.springdesk.dtos;

import com.springdesk.springdesk.enums.Perfil;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
public class PessoaDto {

    @NotNull
    @UniqueElements
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private Perfil perfil;
}
