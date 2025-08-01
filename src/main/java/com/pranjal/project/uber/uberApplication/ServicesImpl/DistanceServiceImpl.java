package com.pranjal.project.uber.uberApplication.ServicesImpl;

import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import com.pranjal.project.uber.uberApplication.Services.DistanceService;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
public class DistanceServiceImpl implements DistanceService {


    private static final String BASE_OSRM_API = "http://router.project-osrm.org/route/v1/driving/13.388860,52.517037;13.397634,52.529407";


    //OSRM -> free  3rd party API to calculate distance between 2 point on earth  note-> road distance

    @Override
    public double calculateDistance(Point source, Point destination) {
        // TODO Auto-generated method stub

        try {

            String url = source.getX() + "," + source.getY() + ";" + destination.getY() + "," + destination.getY();

            OSRMResponseDto responseDto = RestClient
                    .builder()
                    .baseUrl(BASE_OSRM_API)
                    .build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .body(OSRMResponseDto.class);
            return responseDto.getRoutes().get(0).getDistance() / 1000.0;
            ///1000.0  -> will convert distance to Km.

        } catch (Exception e) {
            throw new RuntimeException("error getting data from OSRM api" + e.getMessage());
        }

    }


    @Data
    class OSRMResponseDto {
        private List<OSRMRouts> routes;
    }

    @Data
    class OSRMRouts {
        private Double distance;
    }

}
