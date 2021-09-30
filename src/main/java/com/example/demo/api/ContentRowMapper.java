package com.example.demo.api;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.api.bean.Content;

public class ContentRowMapper implements RowMapper<Content>{

	@Override
	public Content mapRow(ResultSet arg0, int arg1) throws SQLException {
		Content content = new Content();
		//content.setAuthor(arg0.getString("author"));
		content.setContent(arg0.getString("content"));
		content.setTitle(arg0.getString("title"));
		return content;
	}

}
