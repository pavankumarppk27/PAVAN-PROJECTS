package com.tagtransaction.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tagtransaction.tag.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

		public UserEntity findByEmail(String email);
	
	
}
 