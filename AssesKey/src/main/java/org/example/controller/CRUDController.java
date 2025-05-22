package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

public interface CRUDController<Media, MediaDTO> {
    ResponseEntity<Media> create(MediaDTO dto);

    ResponseEntity<List<Media>> findAll(@RequestHeader(value = "Authorization") String token);

    ResponseEntity<Optional<Media>> findById(@RequestHeader(value = "Authorization") String token, Long id);

    ResponseEntity<Void> deleteById(@RequestHeader(value = "Authorization") String token, Long id);
}
