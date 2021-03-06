package com.example.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.dto.Article;
import com.example.spring.util.Util;

@Controller
public class UsrArticleController {
	private int articleLastId;
	private List<Article> articles;
	
	public UsrArticleController() {
		// 멤버변수 초기화
		articleLastId = 0;
		articles = new ArrayList<>();
		
		// 게시물 2개 생성
		articles.add(new Article(++articleLastId, "2020-12-12 12:12:12", "2020-12-12 12:12:12", "제목1", "내용1"));
		articles.add(new Article(++articleLastId, "2020-12-12 12:12:12", "2020-12-12 12:12:12", "제목2", "내용2"));
	}
	
	@RequestMapping("usr/article/detail")
	@ResponseBody
	public Article ShowDetail(int id) {
		return articles.get(id - 1);
	}
	
	@RequestMapping("usr/article/list")
	@ResponseBody
	public List<Article> Showlist() {
		return articles;
	}
	
	@RequestMapping("usr/article/doAdd")
	@ResponseBody
	public Map<String, Object> doAdd(String title, String body) {
		String regDate = Util.getNowDateStr();
		String updateDate = regDate;
		
		articles.add(new Article(++articleLastId, regDate, updateDate, title, body));
		
		Map<String, Object> rs = new HashMap<>();
		rs.put("resultCode", "S-1");
		rs.put("msg", "성공하였습니다.");
		rs.put("id", articleLastId);
		
		return rs;
	}
	

	@RequestMapping("usr/article/doDelete")
	@ResponseBody
	public Map<String, Object> doDelete(int id) {
		boolean deleteArticlsRs = deleteArticle(id);
		
		Map<String, Object> rs = new HashMap<>();
		
		if (deleteArticlsRs) {
			rs.put("resultCode", "S-1");
			rs.put("msg", "성공하였습니다.");
		}
		else {
			rs.put("resultCode", "F-1");
			rs.put("msg", "해당 게시물은 존재하지 않습니다.");
		}
		
		rs.put("id", id);
		
		return rs;
	}
	
	private boolean deleteArticle(int id) {
		for ( Article article : articles) {
			if ( article.getId() == id) {
				articles.remove(article);
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping("usr/article/doModify")
	@ResponseBody
	public Map<String, Object> doModify(int id, String title, String body) {
		Article selArticle = null;
		
		for ( Article article : articles ) {
			if ( article.getId() == id) {
				selArticle = article;
				break;
			}
		}
		
		Map<String, Object> rs = new HashMap<>();
		
		if (selArticle == null) {
			rs.put("resultCode", "F-1");
			rs.put("msg", String.format("%d번 게시물은 존재하지 않습니다.", id));
			return rs;
		}
		
		selArticle.setUpdateDate(Util.getNowDateStr());
		selArticle.setTitle(title);
		selArticle.setBody(body);
		
		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물이 수정되었습니다.", id));
		rs.put("id", id);
		
		return rs;
		
		
	}		
}
