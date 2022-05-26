package com.mySqlMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mySqlMapping.model.Oodles;

@Repository
public interface OodlesRepository extends JpaRepository<Oodles, Integer>{

	

}
