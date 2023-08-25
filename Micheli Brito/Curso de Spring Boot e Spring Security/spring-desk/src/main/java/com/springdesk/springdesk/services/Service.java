package com.springdesk.springdesk.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Service<T> {

    T create(T object);

    T update(T object, UUID id);

    T findById(UUID id);

    List<T> findAll();

    void delete(UUID id);
}
