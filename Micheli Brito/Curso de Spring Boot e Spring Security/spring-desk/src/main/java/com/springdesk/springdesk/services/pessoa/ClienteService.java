package com.springdesk.springdesk.services.pessoa;

import com.springdesk.springdesk.models.pessoa.ClienteModel;
import com.springdesk.springdesk.repositories.ClienteRepository;
import com.springdesk.springdesk.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService extends ServiceImpl<ClienteModel> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public JpaRepository<ClienteModel, UUID> getRepository() {
        return this.clienteRepository;
    }
}
