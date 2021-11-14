package com.repository;

import com.model.Report;
import com.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportDao extends PagingAndSortingRepository<Report, Long> {

}
