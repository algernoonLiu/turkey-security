package com.algernoon.turkeysecurity.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.algernoon.turkeysecurity.entity.UserEntity;
import com.algernoon.turkeysecurity.repository.UserRepository;
import com.algernoon.turkeysecurity.service.IUserService;

@Service
@Transactional
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Cacheable(key = "#id")
	@Override
	public UserEntity findById(Integer id) {
		return userRepository.findOne(id);
	}
	
	@Cacheable
	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@CachePut(key = "#user.id", value = "#user")
	@Override
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}

	@CachePut(key = "#user.id", value = "#user")
	@Override
	public UserEntity updateUser(UserEntity user) {
		return userRepository.save(user);
	}

	@CacheEvict(key = "#id")
	@Override
	public void deleteUser(Integer id) {
		userRepository.delete(id);;
	}

}
