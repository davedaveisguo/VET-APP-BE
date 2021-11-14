package com.repository;

import com.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    User findUserById(String id);

    Optional<User> findByUsername(String userName);
    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String userName);

    Boolean existsByEmail(String email);
}
