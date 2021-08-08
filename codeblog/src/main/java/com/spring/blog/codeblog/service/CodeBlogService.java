package com.spring.blog.codeblog.service;

import java.util.List;

import com.spring.blog.codeblog.model.Post;

public interface CodeBlogService {

	List<Post> findAll();
	Post findById(Long id);
	Post save (Post psot);
}
