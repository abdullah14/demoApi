package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.bean.Content;
import com.example.demo.api.dao.NotesDAO;
import com.example.demo.api.service.NotesService;

@RestController
@RequestMapping(path="/notes")
public class ApiController {

	@Autowired
	NotesService notesService ; 
	@GetMapping("/contents")
	public List<Content> getNotesContent(@RequestBody Content content){
		System.out.println("content :: "+content.getContent());
		System.out.println("content :: "+content.getAuthor());
		System.out.println("content :: "+content.getTitle());
		return notesService.getNotesContents();
	}
}
