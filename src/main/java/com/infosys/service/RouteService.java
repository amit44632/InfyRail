package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Route;
import com.infosys.entity.Train;
import com.infosys.repository.RouteRepo;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepo routeRepo;

	public Route saveRoutes(Route rt) {
		// TODO Auto-generated method stub
		return routeRepo.save(rt);
	}

	public List<Route> getRouteDetailsById(Integer id) {
		// TODO Auto-generated method stub
		return routeRepo.findByRouteId(id);
	}

}
