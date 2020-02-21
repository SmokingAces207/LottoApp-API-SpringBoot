package com.josephocallaghan.lottoapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josephocallaghan.lottoapp.config.AjaxResponse;
import com.josephocallaghan.lottoapp.dto.TestDto;

@RequestMapping("/status")
@RestController
public class StatusRestController extends BaseRestController {

	@GetMapping("/{id}")
	public AjaxResponse getStatusById(@PathVariable("id") Integer id) {
		
		// Get Status by ID
		logger.debug("Test debug here");
		TestDto testDto = new TestDto("Testing", 1234);
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
		response.getData().put("testDo", testDto);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
}
