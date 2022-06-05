package ir.postgresql.simple_messenger_postgresql.repository;

import ir.postgresql.simple_messenger_postgresql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
