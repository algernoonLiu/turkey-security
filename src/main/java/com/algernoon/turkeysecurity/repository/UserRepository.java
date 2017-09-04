package com.algernoon.turkeysecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algernoon.turkeysecurity.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
