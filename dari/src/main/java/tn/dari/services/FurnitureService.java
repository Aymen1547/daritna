package tn.dari.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.dari.entities.CategoryFurniture;
import tn.dari.entities.Furniture;
import tn.dari.repositories.CategoryRepository;
import tn.dari.repositories.FurnitureRepository;

import java.util.List;

@Service

public class FurnitureService {

    @Autowired
    private FurnitureRepository furniturerepository;
    @Autowired
    CategoryRepository cateRepo;

    public Furniture saveFurniture(Furniture furniture) {
        return furniturerepository.save(furniture);
    }

    public List<Furniture> saveFurnitures(List<Furniture> furnitures) {
        return furniturerepository.saveAll(furnitures);
    }

    public List<Furniture> getFurnitures() {
        return furniturerepository.findAll();
    }

    public Furniture getFurnitureById(Long id) {
        return furniturerepository.findById(id).orElse(null);
    }

    public Furniture getFurnitureByName(String name) {
        return furniturerepository.findByName(name);
    }

    public String deleteFurniture(Long id) {
        furniturerepository.deleteById(id);
        return "furniture removed !! " + id;
    }

    public Furniture updateFurniture(Furniture furniture) {
        Furniture existingFurniture = furniturerepository.findById(furniture.getIdFur()).orElse(null);
        existingFurniture.setName(furniture.getName());
        existingFurniture.setPrice(furniture.getPrice());
        existingFurniture.setPicture(furniture.getPicture());
        existingFurniture.setDescription(furniture.getDescription());
        existingFurniture.setPostdate(furniture.getPostdate());
        return furniturerepository.save(existingFurniture);
    }


    public List<Furniture>getAllFurniture(){
        return furniturerepository.findAll();
    }
    public List<Furniture>getFurnitureByCategory(String furniture_id){
        return furniturerepository.getByCategoryId(furniture_id);
    }

    public List<CategoryFurniture>getAllCategory(){
        return cateRepo.findAll();
    }

    public Furniture getFurnitureById(long furnitureId) throws Exception {
        return furniturerepository.findById(furnitureId).orElseThrow(() ->new Exception("furniture is not found"));
    }

}
