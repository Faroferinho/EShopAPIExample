package org.example.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CRUDController<Media, MediaDTO> {
    ResponseEntity<Media> create(MediaDTO dto);

    ResponseEntity<List<Media>> findAll();

    ResponseEntity<Optional<Media>> findById(Long id);

    ResponseEntity<Void> deleteById(Long id);
}
