package com.repository;

import com.model.Comment;
import com.model.Prescribe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentDao extends PagingAndSortingRepository<Comment, Long> {

}
