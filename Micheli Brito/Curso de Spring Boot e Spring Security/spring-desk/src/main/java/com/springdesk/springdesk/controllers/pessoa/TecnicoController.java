package com.springdesk.springdesk.controllers.pessoa;

import com.springdesk.springdesk.controllers.ControllerImpl;
import com.springdesk.springdesk.models.pessoa.TecnicoModel;
import com.springdesk.springdesk.services.Service;
import com.springdesk.springdesk.services.pessoa.tecnico.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController extends ControllerImpl<TecnicoModel> {

    @Autowired
    private TecnicoService tecnicoService;

    @Override
    public Service<TecnicoModel> getService() {
        return this.tecnicoService;
    }
}
