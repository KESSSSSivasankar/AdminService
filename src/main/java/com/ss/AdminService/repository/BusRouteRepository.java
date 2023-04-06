package com.ss.AdminService.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.AdminService.entity.BusRoute;

@Repository
public interface BusRouteRepository extends CrudRepository<BusRoute, Long> {
	
	BusRoute findByBusSourceAndBusDestination(String busSource, String busDestination);

}

