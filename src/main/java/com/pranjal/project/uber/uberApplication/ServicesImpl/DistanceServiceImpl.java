package com.pranjal.project.uber.uberApplication.ServicesImpl;

import com.pranjal.project.uber.uberApplication.Services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class DistanceServiceImpl implements DistanceService {


    private static final String BASE_OSRM_API = "https://router.project-osrm.org/route/v1/driving/13.388860,52.517037;13.397634,52.529407";


    //OSRM -> free  3rd party API to calculate distance between 2 point on earth  note-> road distance

    @Override
    public double calculateDistance(Point source, Point destination) {
        // TODO Auto-generated method stub

       /* try {

            String url = source.getX() + "," + source.getY() + ";" + destination.getX() + "," + destination.getY();

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
*/


        try {

            // Construct the OSRM API endpoint
            String coordinates = source.getX() + "," + source.getY() + ";" + destination.getX() + "," + destination.getY();
            String url = "https://router.project-osrm.org/route/v1/driving/" + coordinates;

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<OSRMResponseDto> response = restTemplate.getForEntity(url, OSRMResponseDto.class);

            // Extract and return the distance in kilometers
            return response.getBody().getRoutes().get(0).getDistance() / 1000.0;


        } catch (Exception e) {
            throw new RuntimeException("error getting data from OSRM api" + e.getMessage());

        }
    }



    @Data
    static class   OSRMResponseDto {
        private List<OSRMRouts> routes;
    }


    @Data
    static class OSRMRouts {
        private Double distance;
    }

}
