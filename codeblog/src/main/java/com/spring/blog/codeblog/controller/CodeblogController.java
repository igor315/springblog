package com.spring.blog.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.codeblog.model.Post;
import com.spring.blog.codeblog.service.CodeBlogService;

@Controller
public class CodeblogController {

	@Autowired
	CodeBlogService codeBlogService;
	
	//método que mostra os posts na tela
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeBlogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	//método que retorna os detalhes especificos de um determinado post pelo "ID"
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeBlogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
}
