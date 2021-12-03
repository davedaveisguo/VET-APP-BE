package com.repository;

import com.model.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDao extends PagingAndSortingRepository<Animal, Integer> {

}
