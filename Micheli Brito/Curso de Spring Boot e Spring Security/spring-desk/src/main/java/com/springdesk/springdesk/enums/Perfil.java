package com.springdesk.springdesk.enums;

import lombok.Getter;
import lombok.Setter;

public enum Perfil {

    ADMIN("Administrador"),
    TECNICO("Técnico"),
    CLIENTE("Cliente");

    private String perfil;

    private Perfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
