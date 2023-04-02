package com.ss.AdminService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RouteNotFoundException extends RuntimeException {
	
	public RouteNotFoundException(String exception) {
	    super(exception);
	  }

}
