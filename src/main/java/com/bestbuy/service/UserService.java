package com.bestbuy.service;

import java.util.List;

import com.bestbuy.model.User;

public interface UserService {
	List<User> getUsers();
	User getUser(Integer id);
	Boolean add(User user);
	Boolean update(User user);
	Boolean delete(Integer id);
}
