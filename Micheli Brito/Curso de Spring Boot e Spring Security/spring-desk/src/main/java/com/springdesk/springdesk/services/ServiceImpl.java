package com.springdesk.springdesk.services;

import com.springdesk.springdesk.exceptions.RecordNotFoundException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@MappedSuperclass
public abstract class ServiceImpl<T> implements Service<T> {

    public abstract JpaRepository<T, UUID> getRepository();

    @Override
    public T create(T object) {
        return this.getRepository().save(object);
    }

    @Override
    public T update(T object, UUID id) {
        return this.getRepository().findById(id)
                .map(entity -> {
                    BeanUtils.copyProperties(object, entity);
                    return this.getRepository().save(entity);
                }).orElseThrow(() -> new RecordNotFoundException("Objeto com o id: " + id + " não foi encontrado!"));
    }

    @Override
    public T findById(UUID id) {
        return this.getRepository().findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Objeto com o id: " + id + " não foi encontrado!"));
    }

    @Override
    public List<T> findAll() {
        List<T> entity = this.getRepository().findAll();
        if (entity.isEmpty()) {
            throw new RecordNotFoundException("Nenhum registro encontrado");
        }
        return entity;
    }

    @Override
    public void delete(UUID id) {
        T entity = this.findById(id);
        if (entity == null) {
            throw new RecordNotFoundException("Objeto com o id: " + id + " não foi encontrado!");
        }
        this.getRepository().delete(entity);
    }
}
