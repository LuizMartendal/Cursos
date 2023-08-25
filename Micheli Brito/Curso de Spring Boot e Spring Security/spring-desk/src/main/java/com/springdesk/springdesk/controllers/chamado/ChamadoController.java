package com.springdesk.springdesk.controllers.chamado;

import com.springdesk.springdesk.controllers.ControllerImpl;
import com.springdesk.springdesk.models.ChamadoModel;
import com.springdesk.springdesk.services.Service;
import com.springdesk.springdesk.services.chamado.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamados")
public class ChamadoController extends ControllerImpl<ChamadoModel> {

    @Autowired
    private ChamadoService chamadoService;

    @Override
    public Service<ChamadoModel> getService() {
        return chamadoService;
    }
}
