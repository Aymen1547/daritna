package tn.dari.services;

import org.springframework.http.ResponseEntity;
import tn.dari.entity.Location;
import java.util.List;

public interface LocationService  {
    Location addLocation(Location location);
    List<Location> addLocations(List<Location> location);
    List<Location> getLocations();
    Location updateLocation(Location location);

}

