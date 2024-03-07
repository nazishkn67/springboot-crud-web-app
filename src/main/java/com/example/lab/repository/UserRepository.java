package com.example.lab.repository;

import com.example.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u WHERE " +
            "u.firstName LIKE CONCAT('%', :query, '%')" +
            "Or  u.lastName LIKE CONCAT('%', :query, '%')" +
            "Or u.emailAddress LIKE CONCAT('%', :query, '%')")
    List<User> searchUser(String query);
}
