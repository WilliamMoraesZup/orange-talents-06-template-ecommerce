package com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UsersService implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;
    private String query;

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        query = "select u from Usuario u where u.login = :username";

        System.out.println(username);
        List<?> objects = manager.createQuery(query)
                .setParameter("username", username).getResultList();
        System.out.println(objects);

        Assert.isTrue(objects.size() <= 1, "[BUG]");

        if (objects.isEmpty()) {
            throw new UsernameNotFoundException(
                    "Não foi possivel encontrar o usuario");

        }
        return userDetailsMapper.map(objects.get(0));


    }
}
