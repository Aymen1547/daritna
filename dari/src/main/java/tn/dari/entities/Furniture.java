package tn.dari.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "furniture")
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String picture;
    private String description;
    private LocalDate postdate;

    public Furniture() {

    }

    public Furniture(Long id, String name, double price, String picture, String description, LocalDate postdate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.postdate = postdate;
    }

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPostdate() {
        return postdate;
    }

    public void setPostdate(LocalDate postdate) {
        this.postdate = postdate;
    }
}
