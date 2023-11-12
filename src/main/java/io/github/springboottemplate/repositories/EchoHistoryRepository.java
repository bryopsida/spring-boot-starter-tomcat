/* (C) 2023 */
package io.github.bryopsida.repositories;

import io.github.bryopsida.entities.EchoHistory;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchoHistoryRepository
    extends CrudRepository<EchoHistory, UUID> {}
