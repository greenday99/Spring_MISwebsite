package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.login.Account;
import com.practice.webapp.entity.news.Bulletin;

public interface LoginDAO {
	public boolean checkLogin(Account login);
	public List<Bulletin> getHomeNews();
	
}
