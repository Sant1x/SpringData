package com.example.demo.dao;

import com.example.demo.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PostRepository extends CrudRepository<Post, Long> {
}
