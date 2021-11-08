package com.repository;

import com.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

    User findUserById(String id);
}
