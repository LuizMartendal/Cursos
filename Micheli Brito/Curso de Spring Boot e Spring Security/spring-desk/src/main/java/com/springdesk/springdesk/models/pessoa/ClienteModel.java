package com.springdesk.springdesk.models.pessoa;

import com.springdesk.springdesk.models.ChamadoModel;
import com.springdesk.springdesk.models.PessoaModelImpl;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class ClienteModel extends PessoaModelImpl implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cliente")
    private List<ChamadoModel> chamados;
}
