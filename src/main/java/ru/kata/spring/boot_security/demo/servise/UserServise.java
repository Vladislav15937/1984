package ru.kata.spring.boot_security.demo.servise;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserServise extends UserDetailsService {


    List<User> getAllPeople();


    User personById(Long id);


    User save(User user);

    User update(User user);

    void delete(Long id);

    User getUserByLogin(String username);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
