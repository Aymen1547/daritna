package tn.dari.Repository;

import tn.dari.Model.Achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatRepository extends JpaRepository <Achat, Long> {
////////////////////CRUD:
    @Modifying
    @Query("DELETE FROM Achat a WHERE a.id=:id AND a.userId=:userId")
    void deleteById(@Param("id")long id,@Param("userId")long userId);

    @Query("SELECT a FROM Achat a WHERE  a.userId=:userId")
    List <Achat> findAll(@Param("userId")long userId);

    @Query("SELECT a FROM Achat a WHERE a.id=:id AND a.userId=:userId")
    Achat find(@Param("id")long id,@Param("userId")long userId);

////////////////////Recherche par prix:

    @Query("Select a FROM Achat a WHERE a.price Between :priceMin and :priceMax AND a.status=true ORDER BY a.price ASC")
    public List<Achat> findByPriceMinMaxPriceAsc(@Param("priceMin") float priceMin,@Param("priceMax") float priceMax);

    @Query("Select a FROM Achat a WHERE a.price Between :priceMin and :priceMax AND a.status=true ORDER BY a.price DESC")
    public List<Achat> findByPriceMinMaxPriceDesc(@Param("priceMin") float priceMin,@Param("priceMax") float priceMax );

    @Query("Select a FROM Achat a WHERE a.price Between :priceMin and :priceMax AND a.status=true ORDER BY a.surface ASC")
    public List<Achat> findByPriceMinMaxSurfaceAsc(@Param("priceMin") float priceMin,@Param("priceMax") float priceMax);

    @Query("Select a FROM Achat a WHERE a.price Between :priceMin and :priceMax AND a.status=true ORDER BY a.surface DESC")
    public List<Achat> findByPriceMinMaxSurfaceDesc(@Param("priceMin") float priceMin,@Param("priceMax") float priceMax);


    List<Achat> findByPriceAndStatusTrue(float price);

////////////////////Recherche par Surface:   
    List<Achat> findBySurfaceAndStatusTrue(float surface);
	List<Achat> findBySurfaceAndStatusTrueOrderByPriceAsc(float surface);
	List<Achat> findBySurfaceAndStatusTrueOrderByPriceDesc(float surface);

////////////////////Recherche par City:     
    List<Achat> findByCityAndStatusTrue(String city);
    List<Achat> findByCityAndStatusTrueOrderByPriceAsc(String city);
    List<Achat> findByCityAndStatusTrueOrderByPriceDesc(String city);

////////////////////Recherche par State: 
    List<Achat> findByStateAndStatusTrue(String state);
    List<Achat> findByStateAndStatusTrueOrderByPriceAsc(String state);
    List<Achat> findByStateAndStatusTrueOrderByPriceDesc(String state );

////////////////////Recherche par NbrRooms:
    List<Achat> findByNbrRoomsAndStatusTrue(int nbrRooms);
    List<Achat> findByNbrRoomsAndStatusTrueOrderByPriceAsc(int nbrRooms);
    List<Achat> findByNbrRoomsAndStatusTrueOrderByPriceDesc(int nbrRooms);
	
    List<Achat> findByNbrRoomsAndNbrBathroomsAndStatusTrue(int nbrRooms,int nbrBathrooms);

////////////////////Recherche par Options:   
List<Achat> findByJardinTrueAndStatusTrue();
List<Achat> findByGarageTrueAndStatusTrue();
List<Achat> findByParkingTrueAndStatusTrue();

List<Achat> findByStatusTrueOrderByNbrLikesAsc();
List<Achat> findByStatusTrueOrderByNbrLikesDesc();

}
