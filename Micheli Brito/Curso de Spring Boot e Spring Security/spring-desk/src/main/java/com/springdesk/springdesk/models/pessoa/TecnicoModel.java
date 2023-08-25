package com.springdesk.springdesk.models.pessoa;

import com.springdesk.springdesk.models.ChamadoModel;
import com.springdesk.springdesk.models.PessoaModelImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "tecnico")
public class TecnicoModel extends PessoaModelImpl implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tecnico")
    private List<ChamadoModel> chamados = new ArrayList<>();
}
