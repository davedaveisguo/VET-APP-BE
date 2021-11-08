package com.repository;

import com.model.Request;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RequestDao extends PagingAndSortingRepository<Request, Long> {

}

