package com.techprimers.elastic.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techprimers.elastic.jparepository.UserJpaRepository;
import com.techprimers.elastic.model.Users;
import com.techprimers.elastic.repository.UsersRepository;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;
    
    @Autowired
    UserJpaRepository userJpaRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);
        System.out.println("Loading Data ...");
        
        List<Users> userData = getData();
        userJpaRepository.save(userData); // Save in H2 DB
        
        List<Users> usersList = userJpaRepository.findAll(); // Get from H2 DB
        usersRepository.save(usersList); // Loads into ElasticSearch repository
        
        System.out.println("Loading Completed !");

    }

    private List<Users> getData() {
        List<Users> users = new ArrayList<>();
        users.add(new Users("Ajay",123L, "Accounting", 12000L));
        users.add(new Users("Jaga",1234L, "Finance", 22000L));
        users.add(new Users("Thiru",1235L, "Accounting", 12000L));
        users.add(new Users("Balu",1236L, "Tech", 21000L));
        users.add(new Users("Techie",1237L, "Accounting", 13000L));
        users.add(new Users("Tiku",1238L, "Tech", 15000L));
        return users;
    }
}
