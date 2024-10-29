package com.dkcodie.ewallet.repository;

import com.dkcodie.ewallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findAllByEmailNot(String email);
}