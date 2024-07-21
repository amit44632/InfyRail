package com.infosys.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.RouteDTO;
import com.infosys.entity.Route;
import com.infosys.entity.Train;
import com.infosys.exception.InfyRailException;
import com.infosys.repository.TrainRepo;
import com.infosys.service.RouteService;
import com.infosys.service.TrainService;

@RestController
@RequestMapping("/routes")
@PropertySource(value = { "classpath:ValidationMessage.properties" })
public class AdminController {

	@Autowired
	private TrainService trainService;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private TrainRepo trainRepo;
	
	@Autowired
	private Environment environment;
	
	@GetMapping()
	public List<Train> getName()
	{
		List<Train> trains = trainService.getAllTrainDetails();
		return trains;
	}
	
	@PostMapping()
	public ResponseEntity<Integer> saveRoutes(@Valid @RequestBody RouteDTO route) throws InfyRailException
	{
		if(route.getDestination() !=null && route.getSource() !=null)
		{
			Route rt = new Route();
			rt.setSource(route.getSource());
			rt.setDestination(route.getDestination());
			rt.setTrainlist(route.getTrainlist());
			
		Route rout=routeService.saveRoutes(rt);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(rout.getId()); 
		}
		else
		{
			throw new InfyRailException(environment.getProperty("general.exception"));
		//	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
		}
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Route> getDetailsByID(@PathVariable Integer id)
	{
		List<Route> rt = routeService.getRouteDetailsById(id);
		if(rt.size() > 0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(rt.get(0));	
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Route());
		}
		
	}
	@PutMapping("{id}")
	public Route updateRoute(@PathVariable Integer id,@RequestBody RouteDTO rt)
	{
		
		List<Route> exsitting_route = routeService.getRouteDetailsById(id);
		if(exsitting_route.size() > 0)
		{
			Route route = exsitting_route.get(0);
			
			route.setId(id);
			route.setSource(rt.getSource());
			route.setDestination(rt.getDestination());
			if(rt.getTrainlist() !=null && !rt.getTrainlist().equals(""))
			{
				String tr_list = route.getTrainlist() + ","+ rt.getTrainlist();
				route.setTrainlist(tr_list);
			}
			Route r = routeService.saveRoutes(route);
			return r;
		}
		
		
		
		
		return new Route();
	}
	@DeleteMapping("/{route_id}/{train_id}")
	public Route deleteTrain(@PathVariable Integer route_id,@PathVariable Integer train_id)
	{
		List<Route> rt = routeService.getRouteDetailsById(route_id);
		if(rt.size() > 0)
		{
			String trainlist = rt.get(0).getTrainlist();
		//	String[] trainlist_arr = trainlist.split(",");
			//String trainlist_str = "";
			String str = trainlist.replaceAll(","+train_id+"","");
			str = str.replaceAll(""+train_id+",","");
			Route r = rt.get(0);
			r.setTrainlist(str);
			r.setId(route_id);
			Route r1 = routeService.saveRoutes(r);
			
			trainRepo.deleteById(train_id); 
			return r1;
		}
		return new Route();
	}
}
