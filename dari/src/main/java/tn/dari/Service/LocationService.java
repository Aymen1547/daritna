package tn.dari.Service;

import tn.dari.Model.Location;
import java.util.List;

public interface LocationService  {
    Location addLocation(Location location);
    List<Location> addLocations(List<Location> location);
    List<Location> getLocations();
    Location updateLocation(Location location);

}

