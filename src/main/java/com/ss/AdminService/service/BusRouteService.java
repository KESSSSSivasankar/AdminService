package com.ss.AdminService.service;

import java.util.List;

import com.ss.AdminService.entity.BusRoute;
import com.ss.AdminService.exceptions.RouteNotFoundException;

public interface BusRouteService {

	
    // Save operation
	BusRoute saveBusRoute(BusRoute route);
 
    // Read operation
    List<BusRoute> fetchBusRouteList() throws RouteNotFoundException;
    
    // Read operation
    BusRoute fetchBusRoute(Long routeId) throws RouteNotFoundException;
    
 // Read operation
    BusRoute fetchBusRoutes(String busSrc, String busDest) throws RouteNotFoundException;
 
    // Update operation
    BusRoute updateBusRoute(BusRoute route,
                                Long routeId) throws RouteNotFoundException;
 
    // Delete operation
    void deleteBusRouteById(Long routeId) throws RouteNotFoundException;
}
