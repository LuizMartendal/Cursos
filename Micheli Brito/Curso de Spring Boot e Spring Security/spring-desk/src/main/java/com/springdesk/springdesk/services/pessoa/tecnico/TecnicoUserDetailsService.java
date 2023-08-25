package com.springdesk.springdesk.services.pessoa.tecnico;

import com.springdesk.springdesk.models.pessoa.TecnicoModel;
import com.springdesk.springdesk.repositories.TecnicoRepository;
import com.springdesk.springdesk.security.TecnicoUserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TecnicoUserDetailsService implements UserDetailsService {

    @Autowired
    TecnicoRepository tecnicoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TecnicoModel tecnico = this.tecnicoRepository.findByEmail(email)
                .orElseThrow( () -> new RuntimeException("Usuário não encontrado com o seguinte email: " + email));
        return new TecnicoUserDetailsImpl(tecnico);
    }
}
