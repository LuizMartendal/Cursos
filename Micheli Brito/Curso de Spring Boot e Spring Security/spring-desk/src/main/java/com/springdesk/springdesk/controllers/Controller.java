package com.springdesk.springdesk.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface Controller<T> {

    ResponseEntity<T> findById(UUID id);

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> create(T object);

    ResponseEntity<T> update(T object, UUID id);

    ResponseEntity delete(UUID id);
}
