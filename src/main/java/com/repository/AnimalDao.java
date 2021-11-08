package com.repository;

import com.model.Animal;
import com.model.Prescribe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnimalDao extends PagingAndSortingRepository<Animal, Long> {

}
