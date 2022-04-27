package tn.dari.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.dari.entities.Furniture;
import tn.dari.services.FurnitureService;


import java.util.List;

@RestController
public class FurnitureController {

    @Autowired
    private FurnitureService furnitureservice;

    @PostMapping("/addFurniture")
    public Furniture addFurniture(@RequestBody Furniture furniture) {
        return furnitureservice.saveFurniture(furniture);
    }

    @PostMapping("/addFurnitures")
    public List<Furniture> addFurnitures(@RequestBody List<Furniture> furnitures) {
        return furnitureservice.saveFurnitures(furnitures);
    }

    @GetMapping("/furnitures")
    public List<Furniture> findAllFurnitures() {
        return furnitureservice.getFurnitures();
    }

    @GetMapping("/furnitureById/{id}")
    public Furniture findFurnitureById(@PathVariable Long id) {
        return furnitureservice.getFurnitureById(id);
    }

    @GetMapping("/furniture/{name}")
    public Furniture findFurnitureByName(@PathVariable String name) {
        return furnitureservice.getFurnitureByName(name);
    }

    @PutMapping("/update")
    public Furniture updateFurniture(@RequestBody Furniture furniture) {
        return furnitureservice.updateFurniture(furniture);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFurniture(@PathVariable Long id) {
        return furnitureservice.deleteFurniture(id);
    }


}