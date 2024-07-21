package com.infosys.dto;

import javax.validation.constraints.NotEmpty;

public class RouteDTO {

	
	private int id;
	
	@NotEmpty(message = "Source cannot be empty.")
	private String source;
	
	@NotEmpty(message = "Destination cannot be empty.")
	private String destination;
	
	@NotEmpty(message = "Train list should not be empty.")
	private String trainlist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTrainlist() {
		return trainlist;
	}
	public void setTrainlist(String trainlist) {
		this.trainlist = trainlist;
	}

	
	
}
