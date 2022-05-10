package tn.dari.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.dari.Model.Location;
import tn.dari.Service.LocationServiceImpl;

import java.util.List;

@RestController

public class LocationController {

    @Autowired
    private LocationServiceImpl LocationService;

    @PostMapping("/addLocation")
        public @ResponseBody Location addLocation(@RequestBody Location location) throws Exception {
        return LocationService.addLocation(location);
    }

    /*@PostMapping("/addLocations")
    public List<Location> addLocations(@RequestBody List<Location> locations) {
        return LocationService.addLocations(locations);
    }*/

    @GetMapping("/Locations")
    public List<Location> findAllLocations() {
        return LocationService.getLocations();
    }

    @PutMapping("/updateLocation")
    public Location updateLocation(@RequestBody Location location) {
        return LocationService.updateLocation(location);
    }

    @DeleteMapping("/deleteLocation/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable long id){

        return LocationService.deleteLocation(id);
    }




}