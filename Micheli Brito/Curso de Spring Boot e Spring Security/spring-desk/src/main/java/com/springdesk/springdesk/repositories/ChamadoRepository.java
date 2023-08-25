package com.springdesk.springdesk.repositories;

import com.springdesk.springdesk.models.ChamadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChamadoRepository extends JpaRepository<ChamadoModel, UUID> {
    @Query(value = "select * from chamado", nativeQuery = true)
    public List<ChamadoModel> findAllChamados();
}
