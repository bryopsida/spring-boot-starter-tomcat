/* (C) 2023 */
package io.github.springboottemplate.services;

import io.github.springboottemplate.entities.EchoHistory;
import io.github.springboottemplate.repositories.EchoHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class EchoService {

    private final EchoHistoryRepository repository;

    public EchoService(EchoHistoryRepository repo) {
        this.repository = repo;
    }

    public Iterable<EchoHistory> list() {
        return repository.findAll();
    }

    public EchoHistory recordHistory(EchoHistory history) {
        return repository.save(history);
    }
}
