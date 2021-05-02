package com.bestbuy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestbuy.model.User;
import com.bestbuy.service.RoleService;
import com.bestbuy.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = userService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
		User user = userService.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user/submit")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user){
		if(! roleService.exists(user.getRoleId())) {
			return new ResponseEntity<String>("Role not found.", HttpStatus.NOT_FOUND);
		}
		if(userService.add(user)) {
			return new ResponseEntity<String>("User Added", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		if(! roleService.exists(user.getRoleId())) {
			return new ResponseEntity<String>("Role not found.", HttpStatus.NOT_FOUND);
		}
		if(userService.update(user)) {
			return new ResponseEntity<String>("User Updated", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") Integer id){
		if(userService.delete(id)) {
			return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
}
