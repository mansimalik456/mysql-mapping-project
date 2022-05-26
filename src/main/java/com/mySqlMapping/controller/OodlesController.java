package com.mySqlMapping.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mySqlMapping.model.Oodles;
import com.mySqlMapping.model.OodlesEmployee;
import com.mySqlMapping.response.Response;
import com.mySqlMapping.service.OodlesEmployeeService;
import com.mySqlMapping.service.OodlesService;
import com.mySqlMapping.web.MessageConstants;

@RestController
public class OodlesController {
	
    @Autowired
    private OodlesService oodlesService;
   
//	@ApiOperation(value = "This api is used to save oodles ")
//	@PostMapping(UrlConstants.CREATE_OODLES)
    
	@RequestMapping(value = "/saveoodles", method = RequestMethod.POST)
	public ResponseEntity<Object> saveOodles(@RequestBody Oodles oodles){
		Object savedOodles = oodlesService.saveOodles(oodles);
		if(Objects.nonNull(savedOodles)) {
			return Response.generateResponse(HttpStatus.CREATED, savedOodles, MessageConstants.SUCCESS, true);
		}
		 return Response.generateResponse(HttpStatus.EXPECTATION_FAILED, null, MessageConstants.FAILED, false);
	} 

}
