package com.infosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Train;
import com.infosys.repository.TrainRepo;


@Service
public class TrainService {
	
	@Autowired
	private TrainRepo trainRepo;
	
	public List<Train> getAllTrainDetails() {
		// TODO Auto-generated method stub
		return (List<Train>) trainRepo.findAll();
	}

	public Train saveTrain(Train tr) {
		// TODO Auto-generated method stub
		Train trainobj = trainRepo.save(tr);
		return trainobj;
	}

	public List<Train> getTrainDetailsById(Integer id) {
		// TODO Auto-generated method stub
		return (List<Train>) trainRepo.getTrainDetailsById(id);
	}

	public List<Train> getTrainDetailsById(String source, String destination) {
		// TODO Auto-generated method stub
		return (List<Train>) trainRepo.getTrainDetailsById(source,destination);
	}


}
