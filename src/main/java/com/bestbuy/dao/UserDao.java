package com.bestbuy.dao;

import java.util.List;

import com.bestbuy.model.Role;
import com.bestbuy.model.User;

public interface UserDao {
	List<User> getUsers();
	User getUser(Integer id);
	Boolean add(User user);
	Boolean update(User user);
	Boolean delete(Integer id);
	
	Boolean ifAnyUserHasThisRole(Role role);
	Boolean exists(User user);
	Boolean ifUserNameIsTakenAlready(String username);
	Boolean ifUserNameIsOnlyTakenByOrItsNew(User user);
}
