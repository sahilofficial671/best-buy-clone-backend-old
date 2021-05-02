package com.bestbuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestbuy.dao.UserDao;
import com.bestbuy.model.Role;
import com.bestbuy.model.User;
import com.bestbuy.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public Boolean add(User user) {
		return userDao.add(user);
	}

	@Override
	public Boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public Boolean delete(Integer id) {
		return userDao.delete(id);
	}

	@Override
	public Boolean ifAnyUserHasThisRole(Role role) {
		return userDao.ifAnyUserHasThisRole(role);
	}

	@Override
	public Boolean exists(User user) {
		return userDao.exists(user);
	}

}
