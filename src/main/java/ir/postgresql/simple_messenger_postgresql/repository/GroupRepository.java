package ir.postgresql.simple_messenger_postgresql.repository;

import ir.postgresql.simple_messenger_postgresql.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
