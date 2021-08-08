package com.spring.blog.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.codeblog.model.Post;
import com.spring.blog.codeblog.service.CodeBlogService;

@Controller
public class CodeblogController {

	@Autowired
	CodeBlogService codeBlogService;
	
	@RequestMapping(value = "posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeBlogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
}
