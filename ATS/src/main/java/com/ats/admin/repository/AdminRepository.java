package com.ats.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.user.entity.UserEntity;

public interface AdminRepository extends JpaRepository<UserEntity,Long>{
	
	@Query("from UserEntity where role=:role and status=:status ")
	public List<UserEntity> findAllAgencyAccounts(String role,String status);
	
	

}
