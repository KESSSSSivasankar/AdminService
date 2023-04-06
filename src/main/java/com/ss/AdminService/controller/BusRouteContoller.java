package com.ss.AdminService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ss.AdminService.entity.BusRoute;
import com.ss.AdminService.exceptions.RouteNotFoundException;
import com.ss.AdminService.service.BusRouteService;

@RestController
public class BusRouteContoller {
	
	
	@Autowired  
	BusRouteService busRouteService;
	
	
	@GetMapping("/busroutes")  
	private ResponseEntity<List<BusRoute>> getAllBusRoutes() throws RouteNotFoundException 
	{  
	return new ResponseEntity<>(busRouteService.fetchBusRouteList(), 
			   HttpStatus.OK);
	}  
	
	@GetMapping("/busroutes/{busroutesid}")  
	private ResponseEntity<BusRoute> getBusroutesId(@PathVariable("busroutesid") long busroutesid) throws RouteNotFoundException  
	{  
	return new ResponseEntity<>(busRouteService.fetchBusRoute(busroutesid), 
			   HttpStatus.OK);
	}  
	
	@GetMapping("/busroutes/{busroutesource}/{busroutedest}")  
	private ResponseEntity<BusRoute> getBusroutesId(@PathVariable("busroutesource") String busroutesource, @PathVariable("busroutedest") String busroutedest) throws RouteNotFoundException  
	{  
	return new ResponseEntity<>(busRouteService.fetchBusRoutes(busroutesource, busroutedest), 
			   HttpStatus.OK);
	} 
	
	@DeleteMapping("/busroutes/{busroutesid}")  
	private ResponseEntity<String> deleteBook(@PathVariable("busroutesid") long busroutesid)  throws RouteNotFoundException 
	{  
		try{
			busRouteService.deleteBusRouteById(busroutesid);  
			return ResponseEntity.ok("Entity deleted");      
		   }
		   catch (EmptyResultDataAccessException e){
		      return ResponseEntity.notFound().build();
		  } 
		
		
	}
	
	@PostMapping("/busroutes")  
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<String> saveBook(@RequestBody BusRoute busroute)   
	{  
		busRouteService.saveBusRoute(busroute) ;
		return new ResponseEntity<>("Bus Route updated success", 
				   HttpStatus.OK);  
	
	}  
	
	@PutMapping("/busroutes/{busroutesid}")  
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<String> update(@RequestBody BusRoute busroute,@PathVariable("busroutesid") long busroutesid) throws RouteNotFoundException  
	{  
		busRouteService.updateBusRoute(busroute, busroutesid);  
		return new ResponseEntity<>("Bus Route updated success", 
				   HttpStatus.OK);   
	}  

}
