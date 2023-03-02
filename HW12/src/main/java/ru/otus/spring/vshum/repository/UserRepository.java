package ru.otus.spring.vshum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.vshum.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}
