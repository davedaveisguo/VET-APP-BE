package com.repository;

import com.model.Report;
import com.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReportDao extends PagingAndSortingRepository<Report, Long> {

}
