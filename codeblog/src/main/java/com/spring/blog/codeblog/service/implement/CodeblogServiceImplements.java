package com.spring.blog.codeblog.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.codeblog.model.Post;
import com.spring.blog.codeblog.repository.CodeblogRepository;
import com.spring.blog.codeblog.service.CodeBlogService;

@Service
public class CodeblogServiceImplements implements CodeBlogService{

	@Autowired
	CodeblogRepository codeblogRepository;
	
	
	@Override
	public List<Post> findAll() {//retorna uma lista de Post
		return codeblogRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return codeblogRepository.save(post);
	}

}
