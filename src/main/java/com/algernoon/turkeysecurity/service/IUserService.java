package com.algernoon.turkeysecurity.service;

import java.util.List;

import com.algernoon.turkeysecurity.entity.UserEntity;

public interface IUserService {

	List<UserEntity> findAll();

	UserEntity saveUser(UserEntity user);

	UserEntity updateUser(UserEntity user);

	void deleteUser(Integer id);

	UserEntity findById(Integer id);
	
}
