package com.springdesk.springdesk.services.chamado;

import com.springdesk.springdesk.models.ChamadoModel;
import com.springdesk.springdesk.repositories.ChamadoRepository;
import com.springdesk.springdesk.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChamadoService extends ServiceImpl<ChamadoModel> {

    @Autowired
    ChamadoRepository chamadoRepository;

    @Override
    public JpaRepository<ChamadoModel, UUID> getRepository() {
        return this.chamadoRepository;
    }
}
