package com.talk2amareswaran.projects.hotelapp;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OAuthDAOService extends JpaRepository<UserEntity,Integer>{

	UserEntity findByEmail(String username);

	

	
}
