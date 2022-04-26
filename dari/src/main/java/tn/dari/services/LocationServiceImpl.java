package tn.dari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.dari.repository.LocationRepository;
import tn.dari.entity.Location;

import java.util.List;


@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    public LocationRepository locationRepository;


    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> addLocations(List<Location> location) {
        return (List<Location>) locationRepository.saveAll(location);
    }

    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }




   /* public ResponseEntity<String> deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return "Reclamation removed !! " + id;
    }*/

    public Location updateLocation(Location location) {
        Location existingLocation = locationRepository.findById(location.getId()).orElse(null);
        existingLocation.setTitre(location.getTitre());
        existingLocation.setLieu(location.getLieu());
        existingLocation.setDescription(location.getDescription());
        existingLocation.setDated(location.getDated());
        existingLocation.setDatef(location.getDatef());
        existingLocation.setPrix(location.getPrix());
        return locationRepository.save(existingLocation);
    }

    public ResponseEntity<String> deleteLocation(Long id) {
        try {
            locationRepository.deleteById(id);
            return new ResponseEntity<String>( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>( HttpStatus.CONFLICT);
        }

    }

}