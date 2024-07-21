package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.TrainDTO;
import com.infosys.entity.Route;
import com.infosys.entity.Train;
import com.infosys.service.RouteService;
import com.infosys.service.TrainService;

@RestController
@RequestMapping("/train")
public class TrainController {
	
	@Autowired
	TrainService  trainService;
	
	@Autowired
	RouteService routeService;
	
	@PostMapping
	public Train saveTrainDetails(@RequestBody TrainDTO train)
	{
		
		System.out.println("train----"+train.getArrival_time());
		System.out.println("train----"+train.getTrain_name());
		Train tr = new Train();
		tr.setId(train.getId());
		tr.setTrain_name(train.getTrain_name());
		tr.setArrival_time(train.getArrival_time());
		tr.setDeparture_time(train.getDeparture_time());
		tr.setFare(train.getFare());
		Train t = trainService.saveTrain(tr);
		return t;
		
	}
	
	@GetMapping()
	public List<Train> getTrainById(@RequestParam String source,@RequestParam String destination)
	{
		List<Train> tr = trainService.getTrainDetailsById(source,destination);
		
		return tr;
	}
	@PutMapping()
	public Train updateTrain(@RequestBody TrainDTO train)
	{
		Train t = new Train();
		
		t.setId(train.getId());
		t.setTrain_name(train.getTrain_name());
		t.setArrival_time(train.getArrival_time());
		t.setDeparture_time(train.getDeparture_time());
		t.setFare(train.getFare());
		
		Train tr = trainService.saveTrain(t);
		if(tr != null)
		{
			return tr;
		}
		return new Train();
	}
	

}
