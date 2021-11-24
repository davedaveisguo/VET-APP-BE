package com.repository;

import com.model.Animal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDao extends PagingAndSortingRepository<Animal, Long> {

}
