package com.springdesk.springdesk.repositories;

import com.springdesk.springdesk.models.pessoa.TecnicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TecnicoRepository extends JpaRepository<TecnicoModel, UUID> {

    Optional<TecnicoModel> findByEmail(String email);
}
