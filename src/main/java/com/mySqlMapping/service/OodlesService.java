package com.mySqlMapping.service;

import org.springframework.stereotype.Service;

import com.mySqlMapping.model.Oodles;
import com.mySqlMapping.model.OodlesEmployee;

@Service
public interface OodlesService {
	
	Object saveOodles(Oodles oodles);
	

}
