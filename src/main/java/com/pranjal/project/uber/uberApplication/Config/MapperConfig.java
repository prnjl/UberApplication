package com.pranjal.project.uber.uberApplication.Config;



import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import org.locationtech.jts.geom.PrecisionModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pranjal.project.uber.uberApplication.Utils.GeomartyUtil;
import com.pranjal.project.uber.uberApplication.dto.PointDto;

@Configuration
public class MapperConfig {

	@Bean
	ModelMapper getmodelMapper() {
		
		ModelMapper mapper= new ModelMapper();
		//mapper.typeMap(PointDto.class, Point.class).setConverter(converter->{
	        mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
	            PointDto source = context.getSource();
	            
	            return GeomartyUtil.createPoint(source);
	        });
	        
	        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
	            Point source = context.getSource();
	            
	           double coordinates[] = {
	        		   source.getX(), source.getY()
	           };
	           return new PointDto(coordinates);
	        });

		
	        return mapper;
	
		}
}
