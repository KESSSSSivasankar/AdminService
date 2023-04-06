package com.ss.AdminService.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.AdminService.entity.BusRoute;
import com.ss.AdminService.exceptions.RouteNotFoundException;
import com.ss.AdminService.repository.BusRouteRepository;

import jakarta.transaction.Transactional;

@Service
public class BusRouteServiceImpl implements BusRouteService {

	@Autowired
	BusRouteRepository busRouteRepository;
	
	@Override
	@Transactional
	public BusRoute saveBusRoute(BusRoute route) {
		// TODO Auto-generated method stub
		return busRouteRepository.save(route);
	}

	@Override
	public List<BusRoute> fetchBusRouteList() throws RouteNotFoundException{
		return (List<BusRoute>)
				busRouteRepository.findAll();
	}

	@Override
	@Transactional
	public BusRoute updateBusRoute(BusRoute route, Long routeId) throws RouteNotFoundException{
		BusRoute depDB
        = busRouteRepository.findById(routeId)
              .get();

    if (Objects.nonNull(route.getBusSource())
        && !"".equalsIgnoreCase(
        		route.getBusSource())) {
        depDB.setBusSource(
        		route.getBusSource());
    }
    
    if (Objects.nonNull(route.getBusDestination())
            && !"".equalsIgnoreCase(
            		route.getBusDestination())) {
            depDB.setBusDestination(
            		route.getBusDestination());
     }
    
    if (Objects.nonNull(route.getBusprice())
            && !"".equalsIgnoreCase(
            		route.getBusprice())) {
            depDB.setBusprice(
            		route.getBusprice());
     }

    
    return busRouteRepository.save(depDB);

	}

	@Override
	@Transactional
	public void deleteBusRouteById(Long routeId) throws RouteNotFoundException{
		busRouteRepository.deleteById(routeId);
		
	}

	@Override
	public BusRoute fetchBusRoute(Long routeId) throws RouteNotFoundException{
		// TODO Auto-generated method stub
		return busRouteRepository.findById(routeId)
	              .get();
	}

	@Override
	public BusRoute fetchBusRoutes(String busSrc, String busDest) throws RouteNotFoundException {

		return  busRouteRepository.findByBusSourceAndBusDestination(busSrc,busDest);
	}

}
