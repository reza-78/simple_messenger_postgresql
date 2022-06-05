package ir.postgresql.simple_messenger_postgresql.repository;

import ir.postgresql.simple_messenger_postgresql.model.Group;
import ir.postgresql.simple_messenger_postgresql.model.Message;
import ir.postgresql.simple_messenger_postgresql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByGroupAndSender(Group group, User sender);
}
