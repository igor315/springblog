package com.spring.blog.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.codeblog.model.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long> {

}
