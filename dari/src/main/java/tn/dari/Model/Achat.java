package tn.dari.Model;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Achat implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private long id;
	//@NotEmpty
    private long userId;
	//@NotEmpty
	private boolean status;

    //@NotEmpty
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate=creationDate;

    //@NotBlank
    private String city;
    //@NotBlank
	private String state;
    //@NotEmpty
    private float price;
    //@NotEmpty
    private float surface;
    //@NotBlank
    private String type;

    private int nbrRooms;
	private int nbrBathrooms;
    private boolean jardin;
    private boolean garage;
    private boolean parking;
    private String image;
    private String video;
    private String description;

    private int nbrLikes=0;
	private int nbrDisLikes=0;


    

  
    

    

    public Achat(long id, @NotEmpty long userId, @NotEmpty boolean status, @NotEmpty Date creationDate, Date updateDate,
            @NotBlank String city, @NotBlank String state, @NotEmpty float price, @NotEmpty float surface,
            @NotBlank String type, int nbrRooms, int nbrBathrooms, boolean jardin, boolean garage, boolean parking,
            String image, String video, String description, int nbrLikes, int nbrDisLikes) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.city = city;
        this.state = state;
        this.price = price;
        this.surface = surface;
        this.type = type;
        this.nbrRooms = nbrRooms;
        this.nbrBathrooms = nbrBathrooms;
        this.jardin = jardin;
        this.garage = garage;
        this.parking = parking;
        this.image = image;
        this.video = video;
        this.description = description;
        this.nbrLikes = nbrLikes;
        this.nbrDisLikes = nbrDisLikes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    } 

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbrRooms() {
        return nbrRooms;
    }

    public void setNbrRooms(int nbrRooms) {
        this.nbrRooms = nbrRooms;
    }

    public int getNbrBathrooms() {
        return nbrBathrooms;
    }

    public void setNbrBathrooms(int nbrBathrooms) {
        this.nbrBathrooms = nbrBathrooms;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }


    public boolean isJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getNbrLikes() {
        return nbrLikes;
    }

    public void setNbrLikes(int nbrLikes) {
        this.nbrLikes = nbrLikes;
    }

    public int getNbrDisLikes() {
        return nbrDisLikes;
    }

    public void setNbrDisLikes(int nbrDisLikes) {
        this.nbrDisLikes = nbrDisLikes;
    }

    

    



}
