package com.ss.AdminService.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.AdminService.entity.BusRoute;

@Repository
public interface BusRouteRepository extends CrudRepository<BusRoute, Long> {

}

