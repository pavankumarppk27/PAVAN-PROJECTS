package com.ats.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

	public boolean existsByPassword(String password);
	public boolean existsByEmail(String email);
	public UserEntity findByPassword(String password);
	public UserEntity findByEmail(String email);
	
	
}
