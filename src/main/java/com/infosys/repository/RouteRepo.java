package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Route;
import com.infosys.entity.Train;

@Repository
public interface RouteRepo extends JpaRepository<Route, Integer>{
	
	@Query(value = "select * from route c where c.id =?1", nativeQuery = true)
	List<Route> findByRouteId(Integer id);

	

}
