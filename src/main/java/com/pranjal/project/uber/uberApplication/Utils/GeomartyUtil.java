package com.pranjal.project.uber.uberApplication.Utils;

import com.pranjal.project.uber.uberApplication.dto.PointDto;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

public class GeomartyUtil {

	public static Point createPoint(PointDto pointDto) {

		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326); // SRID

		double[] coords = pointDto.getCoordinates();

		Coordinate coordinate = new Coordinate(coords[0], coords[1]);
		return geometryFactory.createPoint(coordinate);

	}
}
