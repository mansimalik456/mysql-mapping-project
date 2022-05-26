package com.mySqlMapping.serviceImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mySqlMapping.model.EmployeeRole;
import com.mySqlMapping.model.Oodles;
import com.mySqlMapping.model.OodlesEmployee;
import com.mySqlMapping.repository.EmployeeRoleRepository;
import com.mySqlMapping.repository.OodlesEmployeeRepository;
import com.mySqlMapping.repository.OodlesRepository;
import com.mySqlMapping.service.OodlesService;

@Service
public class OodlesServiceImp implements OodlesService {
	
	@Autowired
	public OodlesRepository oodlesRepository;
	
	@Autowired
	public OodlesEmployeeRepository oodlesEmployeeRepository;
	
	@Autowired 
	public EmployeeRoleRepository employeeRoleRepository;

	@Override
	public Object saveOodles(Oodles oodles) {
		Oodles oodlesData = new Oodles();
		oodlesData.setWorkingFields(oodles.getWorkingFields());
		oodlesData.setId(oodles.getId());
		List<OodlesEmployee> empList = oodles.getEmpList().stream().map(data->{
			data.setOodles(oodlesData);
			return data;
		}).collect(Collectors.toList());
		oodlesData.setEmpList(empList);
		
		return oodlesRepository.save(oodlesData);
		
	}

}
