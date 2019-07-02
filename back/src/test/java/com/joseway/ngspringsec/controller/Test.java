package com.joseway.ngspringsec.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.joseway.ngspringsec.model.Projet;
import com.joseway.ngspringsec.services.ProjetService;

class Test {

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@InjectMocks
	private ProjetControllerApi controller;
	
	@Mock
	private ProjetService service;
	
	
	@org.junit.jupiter.api.Test
	void testFindById() {
		Projet p1 = new Projet(1L, "friterie", "baraque", 10000, 0, "image");
		when(service.findById(p1.getId())).thenReturn(p1);
		
		Projet expected = controller.findById(p1.getId());
		
		assertThat(expected).isNotNull();
		assertThat(p1).isEqualTo(expected);
		assertThat(p1.getId()).isEqualTo(expected.getId());
	}
	
	
	
	
	@org.junit.jupiter.api.Test
	void test() {	
	}
	
	
	
	
	@org.junit.jupiter.api.Test							
	void testFindAll() {
		List<Projet> projets = new ArrayList<Projet>();
			Projet p1 = new Projet (1L, "friterie", "baraque", 10000, 0, "image1");
			Projet p2 = new Projet (2L, "brasserie", "artisanale", 5000, 0, "image2");
			projets.add(p1);
			projets.add(p2);
			when(service.findAll()).thenReturn(projets);
			List<Projet> expected= controller.findAll();
			
			assertThat(expected).isNotNull();
			assertThat(expected.size()).isEqualTo(2);
			assertThat(expected).contains(p2);	
	}

	
	
	
	
	@org.junit.jupiter.api.Test	
	void testSave() {
		Projet p = new Projet(1L, "friterie", "baraque", 10000, 0, "image");	
		when(service.save(p)).thenReturn(p);
		
		Projet expected = controller.save(p);			 
		
		assertThat(expected).isNotNull();
		assertThat(p).isEqualTo(expected);
	}
	
	
	
	
	@org.junit.jupiter.api.Test	
	void testDelete() {
		Projet p1 = new Projet(1L, "friterie", "baraque", 10000, 0, "image");	
		when(service.deleteById(p1.getId())).thenReturn(p1);
		
		Projet expected = controller.deleteProjet(p1.getId());			 
		
		assertThat(expected).isNotNull();
		assertThat(p1).isEqualTo(expected);
		assertThat(p1.getId()).isEqualTo(expected.getId());
	}
	
	
}
