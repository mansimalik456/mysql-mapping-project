package com.mySqlMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mySqlMapping.model.OodlesEmployee;

@Repository
public interface OodlesEmployeeRepository extends JpaRepository<OodlesEmployee , Integer> {

}
