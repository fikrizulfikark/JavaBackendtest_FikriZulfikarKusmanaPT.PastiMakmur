package com.testbeackenddeveloper.fikrizulfikarkusmana.repository;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
