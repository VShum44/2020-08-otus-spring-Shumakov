package ru.otus.spring.vshum.service.implementation;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.domain.User;
import ru.otus.spring.vshum.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new NoSuchElementException("Нет пользователя с login: " + username));
        //Временная заглушка
        List<SimpleGrantedAuthority> list = new ArrayList<>(List.of(new SimpleGrantedAuthority("ALL")));

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                list
        );
    }
}
