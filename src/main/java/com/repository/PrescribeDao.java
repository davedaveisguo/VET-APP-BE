package com.repository;

import com.model.Prescribe;
import com.model.Report;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PrescribeDao extends PagingAndSortingRepository<Prescribe, Long> {

}
