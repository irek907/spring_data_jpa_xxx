package com.fkb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fkb.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserName(@Param("username")String userName);
}
