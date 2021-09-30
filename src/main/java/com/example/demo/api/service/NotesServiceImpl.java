package com.example.demo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.bean.Content;
import com.example.demo.api.dao.NotesDAO;

@Service
public class NotesServiceImpl implements NotesService {
	
	@Autowired
	NotesDAO notesDAO;
	public List<Content> getNotesContents(){
		
		return notesDAO.getNotesContents();
	}
}
