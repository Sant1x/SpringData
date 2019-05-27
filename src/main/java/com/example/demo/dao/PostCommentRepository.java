package com.example.demo.dao;

import com.example.demo.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
interface PostCommentRepository extends JpaRepository<PostComment,Long> {
}
