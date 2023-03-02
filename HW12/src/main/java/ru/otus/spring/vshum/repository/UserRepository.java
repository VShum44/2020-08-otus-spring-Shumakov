package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.vshum.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);
}
