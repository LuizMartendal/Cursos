package com.springdesk.springdesk.controllers.pessoa;

import com.springdesk.springdesk.controllers.ControllerImpl;
import com.springdesk.springdesk.models.pessoa.ClienteModel;
import com.springdesk.springdesk.services.Service;
import com.springdesk.springdesk.services.pessoa.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends ControllerImpl<ClienteModel> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public Service<ClienteModel> getService() {
        return this.clienteService;
    }

}
