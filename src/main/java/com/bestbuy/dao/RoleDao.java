package com.bestbuy.dao;

import java.util.List;

import com.bestbuy.model.Role;

public interface RoleDao {
	List<Role> getRoles();
	Role getRole(Integer id);
	Boolean add(Role role);
	Boolean update(Role role);
	Boolean delete(Integer id);
	
	Boolean exists(Integer id);
}
