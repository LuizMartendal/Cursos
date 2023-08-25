package com.springdesk.springdesk.services.pessoa.tecnico;

import com.springdesk.springdesk.models.pessoa.TecnicoModel;
import com.springdesk.springdesk.repositories.TecnicoRepository;
import com.springdesk.springdesk.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TecnicoService extends ServiceImpl<TecnicoModel> {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public JpaRepository<TecnicoModel, UUID> getRepository() {
        return this.tecnicoRepository;
    }
}
