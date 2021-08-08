package com.spring.blog.codeblog.utils;

//Classe apenas para testar se os post está sendo salvo no banco de dados

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.blog.codeblog.model.Post;
import com.spring.blog.codeblog.repository.CodeblogRepository;

@Component
public class DummyData {

	@Autowired
	CodeblogRepository codeblogRepository;
	
	//@PostConstruct
	public void savePosts() {
		
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("Igor Santos");
		post1.setData(LocalDate.now());
		post1.setTitulo("Spring Boot");
		post1.setTexto("O Spring Boot facilita a criação de aplicativos autônomos baseados em primavera, baseados em primavera, que você pode \"apenas executar\".\r\n"
				+ "\r\n"
				+ "Temos uma visão opinativa da plataforma primavera e bibliotecas de terceiros para que você possa começar com o mínimo de barulho. A maioria dos aplicativos Spring Boot precisa de configuração de mola mínima.");
		
		Post post2 = new Post();
		post2.setAutor("Igor Santos");
		post2.setData(LocalDate.now());
		post2.setTitulo("Spring Data");
		post2.setTexto("A missão da Spring Data é fornecer um modelo de programação familiar e consistente baseado na Primavera para acesso a dados, mantendo os traços especiais do armazenamento de dados subjacente.\r\n"
				+ "\r\n"
				+ "Facilita o uso de tecnologias de acesso a dados, bancos de dados relacionais e não relacionais, estruturas de redução de mapas e serviços de dados baseados em nuvem. Este é um projeto guarda-chuva que contém muitos subprojetos que são específicos para um determinado banco de dados. Os projetos são desenvolvidos trabalhando em conjunto com muitas das empresas e desenvolvedores que estão por trás dessas tecnologias interessantes.");
		
		postList.add(post1);
		postList.add(post2);
		
		for (Post post : postList) {
			Post postSaved = codeblogRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}
	
}
