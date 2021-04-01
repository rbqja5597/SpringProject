package com.example.spring.dto;

public class Article {
	private int id;
	private String updateDate;
	private String regDate;
	private String title;
	private String body;

	public Article(int id, String regDate, String updateDate, String title, String body) {
		this.id = id;
		this.updateDate = updateDate;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
	
	

	@Override
	public String toString() {
		return "Article [id=" + id + ", updateDate=" + updateDate + ", regDate=" + regDate + ", title=" + title
				+ ", body=" + body + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	

}