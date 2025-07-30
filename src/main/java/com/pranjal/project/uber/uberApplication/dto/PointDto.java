package com.pranjal.project.uber.uberApplication.dto;

import org.locationtech.jts.geom.Coordinate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class PointDto {
	
	
	private double[] coordinates;
	
	private String type="Point";

	public PointDto(double[] coordinates) {
		
		this.coordinates = coordinates;
		
	}

	

	
	
	

	

}
