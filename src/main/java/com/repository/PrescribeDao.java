package com.repository;

import com.model.Prescribe;
import com.model.Report;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrescribeDao extends PagingAndSortingRepository<Prescribe, Long> {

}
