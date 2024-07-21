package com.infosys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Train {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINSEQUENCE")
    //@SequenceGenerator(name="TRAINSEQUENCE", sequenceName = "TRAINSEQUENCE", allocationSize=1)
	private Integer id;
	private String train_name;
	private String arrival_time;
	private String departure_time;
	private double fare;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	
	
}
