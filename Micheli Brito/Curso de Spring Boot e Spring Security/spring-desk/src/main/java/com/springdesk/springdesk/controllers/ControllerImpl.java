package com.springdesk.springdesk.controllers;

import com.springdesk.springdesk.services.Service;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class ControllerImpl<T> implements Controller<T> {

    public abstract Service<T> getService();

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.getService().findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.getService().findAll());
    }

    @Override
    @PostMapping
    public ResponseEntity<T> create(@RequestBody @Valid T object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.getService().create(object));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody @Valid T object, @PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.getService().update(object,id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.getService().delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
