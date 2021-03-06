package com.spring.blog.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.blog.codeblog.model.Post;
import com.spring.blog.codeblog.service.CodeBlogService;

@Controller
public class CodeblogController {

	@Autowired
	CodeBlogService codeBlogService;
	
	/*método que mostra os posts na tela*/
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeBlogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	/*método que retorna os detalhes especificos de um determinado post pelo "ID"*/
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeBlogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	/*método para criar um novo POST*/ /**/
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm () {
		return "postForm";
	}
	
	/*Método para criar um salvar POS*/
	@RequestMapping(value = "/newppost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		codeBlogService.save(post);
		return "redirect;/posts";
	}
	
}
