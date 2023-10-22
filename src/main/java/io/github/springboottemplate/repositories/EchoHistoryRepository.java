/* (C) 2023 */
package io.github.springboottemplate.repositories;

import io.github.springboottemplate.entities.EchoHistory;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchoHistoryRepository
    extends CrudRepository<EchoHistory, UUID> {}
