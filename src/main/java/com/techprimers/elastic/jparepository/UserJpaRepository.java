package com.techprimers.elastic.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.elastic.model.Users;

public interface UserJpaRepository extends JpaRepository<Users, Long> {

}
