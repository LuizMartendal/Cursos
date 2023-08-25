package com.springdesk.springdesk.security;

import com.springdesk.springdesk.models.pessoa.TecnicoModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class TecnicoUserDetailsImpl implements UserDetails {

    private TecnicoModel tecnico = new TecnicoModel();

    public TecnicoUserDetailsImpl(TecnicoModel tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.tecnico.getSenha();
    }

    @Override
    public String getUsername() {
        return this.tecnico.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
