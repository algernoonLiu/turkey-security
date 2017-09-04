package com.algernoon.turkeysecurity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algernoon.turkeysecurity.entity.UserEntity;
import com.algernoon.turkeysecurity.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
	public UserEntity get(@PathVariable Integer id) {
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public List<UserEntity> list() {
		return userService.findAll();
	}

	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
	public ResponseEntity<?> add(@Valid UserEntity user) {
		UserEntity userEntity = userService.saveUser(user);
		return ResponseEntity.ok(userEntity);
	}
	
	@RequestMapping(value = "/api/user", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid UserEntity user) {
		UserEntity userEntity = userService.updateUser(user);
		return ResponseEntity.ok(userEntity);
	}
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("删除成功！");
	}
	
}
