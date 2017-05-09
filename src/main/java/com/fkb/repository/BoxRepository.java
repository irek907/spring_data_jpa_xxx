package com.fkb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fkb.domain.Box;

public interface BoxRepository extends JpaRepository<Box, Long> {


	public Box findBySn(@Param("sn") String sn);

}
