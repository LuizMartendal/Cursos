package com.springdesk.springdesk.dtos;

import com.springdesk.springdesk.enums.Prioridade;
import com.springdesk.springdesk.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ChamadoDto {

    @NotNull
    private String titulo;

    @NotNull
    private LocalDate dataFechamento;

    @NotNull
    private Prioridade prioridade;

    @NotNull
    private Status status;

    @NotNull
    private String observacao;
}
