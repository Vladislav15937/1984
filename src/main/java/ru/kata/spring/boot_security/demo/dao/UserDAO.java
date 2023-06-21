package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllPeople();

    public User personById(Long id);

    public User save(User user);

    public User update(User user);

    public void delete(Long id);

    public User getUserByLogin(String username);

}
