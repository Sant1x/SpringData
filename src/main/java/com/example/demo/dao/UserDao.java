package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    @Query(
            value = "SELECT u FROM User u WHERE u.id = ?1"
           )
    User findUserBySipmleId(Long id);

    User findUserByName(String name);

    @Query(
            value = "SELECT u FROM User u WHERE u.id > ?1"
    )
    List<User> findAllUsersWhereIdBetterThen(Long id);
}
