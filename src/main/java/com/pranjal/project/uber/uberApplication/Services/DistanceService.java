package com.pranjal.project.uber.uberApplication.Services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {

	
	double calculateDistance(Point src,Point dest);
	
}
