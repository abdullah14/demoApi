package com.example.demo.api.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.demo.api.ContentRowMapper;
import com.example.demo.api.bean.Content;

@Component
public class NotesDAOImpl implements NotesDAO{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Content> getNotesContents(){
		List<Content> contentList = new ArrayList<>();
		//List<String> contents = jdbcTemplate.query("select content from notes",String.class);
		Set<Integer> ids = new HashSet<>();
		ids.add(1);
		ids.add(2);
		String sql = "select * from notes where id in (:id1)";
		MapSqlParameterSource paramSoure = new MapSqlParameterSource();
		paramSoure.addValue("id1",ids);
        List<Content> contents = jdbcTemplate.query(sql,paramSoure,new ContentRowMapper());
        
        //List rows = jdbcTemplate.queryForList(sql);
        
/*        for(Object row: rows ) {
        	
        	Content content = new Content();
        	
        }*/
		contentList.addAll(contents);
		return contents;
	}

}
