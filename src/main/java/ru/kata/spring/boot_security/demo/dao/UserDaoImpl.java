package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllPeople() {
        return entityManager.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    @Override
    public User personById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User save(User user) {
      return entityManager.merge(user);
    }

    @Override
    public User update(User user) {

        return entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(personById(id));
    }

    @Query("Select u from User u left join fetch u.roles where u.login=:username")
    @Override
    public User getUserByLogin(String username) {
        TypedQuery<User> q = (entityManager.createQuery("select u from User u " +
                "join fetch u.roles where u.login = :login",User.class));
        q.setParameter("login",username);
        return q.getResultList().stream().findFirst().orElse(null);
    }
}
