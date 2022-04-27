package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.Model.Achat;
import tn.dari.Service.AchatService;

@RestController
@RequestMapping ("/Achat")
public class AchatController {
    @Autowired
    AchatService achatService;

////////////////////CRUD:    
    @PostMapping("/addAchat")
    @ResponseBody
    public Achat add(@RequestBody Achat a){
        return achatService.addAchat(a);
    }

    @DeleteMapping("/deletAchat/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") long id, @PathVariable("userid") long userId){
        achatService.deletAchat(id, userId);

    }

    @GetMapping("/retriveAllAchat")
    @ResponseBody
    public List <Achat> findAll (@PathVariable("userid") long userId){
        List<Achat> list= achatService.retreiveAllAchat(userId);
        return list;
    }

    @GetMapping("/retriveAchat/{id}")
    @ResponseBody
    public Achat find (@PathVariable("id") long id,@PathVariable("userid") long userId){
        return achatService.retreiveAchat(id, userId);
    }

    @PutMapping("/updateAchat/{id}")
    @ResponseBody
    public Achat update(@RequestBody Achat a, @PathVariable("id") long id,@PathVariable("userid") long userId){
        return achatService.updateAchat(a, id, userId);
    }

////////////////////Recherche par prix:
    @GetMapping("/searchAchat/price/priceAsc/{priceMin}/{priceMax}")
	@ResponseBody 
    public List<Achat> findPriceMinMaxPriceAsc(@PathVariable("priceMin") float pricemin,@PathVariable("priceMax") float pricemax) {
        return achatService.findByPriceMinMaxPriceAsc(pricemin, pricemax);
    }
    
    @GetMapping("/searchAchat/price/priceDesc/{priceMin}/{priceMax}")
	@ResponseBody
    public List<Achat> findPriceMinMaxPriceDesc(@PathVariable("priceMin") float pricemin,@PathVariable("priceMax") float pricemax) {
        return achatService.findByPriceMinMaxPriceDesc(pricemin, pricemax);
    }
    
    @GetMapping("/searchAchat/price/surfaceAsc/{priceMin}/{priceMax}")
	@ResponseBody
    public List<Achat> findPriceMinMaxSurfaceAsc(@PathVariable("priceMin") float pricemin,@PathVariable("priceMax") float pricemax) {
        return achatService.findByPriceMinMaxSurfaceAsc(pricemin, pricemax);
    }
    
    @GetMapping("/searchAchat/price/surfaceDesc/{priceMin}/{priceMax}")
	@ResponseBody
    public List<Achat> findPriceMinMaxSurfaceDesc(@PathVariable("priceMin") float pricemin,@PathVariable("priceMax") float pricemax) {
        return achatService.findByPriceMinMaxSurfaceDesc(pricemin, pricemax);
    }
    
    @GetMapping("/searchAchat/price/{price}")
	@ResponseBody
    public List<Achat> findPriceAndStatusTrue(@PathVariable("price") float price) {
        return achatService.findByPriceAndStatusTrue(price);
    }   


////////////////////Recherche par Surface: 
    @GetMapping("/searchAchat/Surface/{surface}")
    @ResponseBody
    public List<Achat> findSurfaceAndStatusTrue(@PathVariable("surface")float surface) {
        return achatService.findBySurfaceAndStatusTrue(surface);
    }
    
    @GetMapping("/searchAchat/Surface/PriceAsc/{surface}")
    @ResponseBody
    public List<Achat> findSurfaceAndStatusTrueOrderByPriceAsc(@PathVariable("surface") float surface) {
        return achatService.findBySurfaceAndStatusTrueOrderByPriceAsc(surface);
    }
    
    @GetMapping("/searchAchat/Surface/PriceDesc/{surface}")
    @ResponseBody
    public List<Achat> findSurfaceAndStatusTrueOrderByPriceDesc(@PathVariable("surface") float surface) {
        return achatService.findBySurfaceAndStatusTrueOrderByPriceDesc(surface);
    }

////////////////////Recherche par City:     
    @GetMapping("/searchAchat/City/{city}")
	@ResponseBody
    public List<Achat> findCityAndStatusTrue(@PathVariable("city") String city) {
        return achatService.findByCityAndStatusTrue(city);
    }
    
    @GetMapping("/searchAchat/City/PriceAsc/{city}")
	@ResponseBody
    public List<Achat> findCityAndStatusTrueOrderByPriceAsc(@PathVariable("city") String city) {
        return achatService.findByCityAndStatusTrueOrderByPriceAsc(city);
    }
    
    @GetMapping("/searchAchat/City/PriceDesc/{city}")
	@ResponseBody
    public List<Achat> findCityAndStatusTrueOrderByPriceDesc(@PathVariable("city") String city) {
        return achatService.findByCityAndStatusTrueOrderByPriceDesc(city);
    }


////////////////////Recherche par State:
    @GetMapping("/searchAchat/State/{state}")
    @ResponseBody
    public List<Achat> findStateAndStatusTrue(@PathVariable("state") String state) {
        return achatService.findByStateAndStatusTrue(state);
    }

    @GetMapping("/searchAchat/State/PriceAsc/{state}")
    @ResponseBody
    public List<Achat> findStateAndStatusTrueOrderByPriceAsc(@PathVariable("state") String state) {
        return achatService.findByStateAndStatusTrueOrderByPriceAsc(state);
    }
    
    @GetMapping("/searchAchat/State/PriceDesc/{state}")
    @ResponseBody
    public List<Achat> findStateAndStatusTrueOrderByPriceDesc(@PathVariable("state") String state) {
        return achatService.findByStateAndStatusTrueOrderByPriceDesc(state);
    }


////////////////////Recherche par NbrRooms:
    @GetMapping("/searchAchat/NbrRooms/{nbrRooms}")
	@ResponseBody
    public List<Achat> findNbrRoomsAndStatusTrue(@PathVariable("nbrRooms") int nbrRooms) {
        return achatService.findByNbrRoomsAndStatusTrue(nbrRooms);
    }
    
    @GetMapping("/searchAchat/NbrRooms/PriceAsc/{nbrRooms}")
	@ResponseBody
    public List<Achat> findNbrRoomsAndStatusTrueOrderByPriceAsc(@PathVariable("nbrRooms") int nbrRooms) {
        return achatService.findByNbrRoomsAndStatusTrueOrderByPriceAsc(nbrRooms);
    }
    
    @GetMapping("/searchAchat/NbrRooms/PriceDesc/{nbrRooms}")
	@ResponseBody
    public List<Achat> findNbrRoomsAndStatusTrueOrderByPriceDesc(@PathVariable("nbrRooms") int nbrRooms) {
        return achatService.findByNbrRoomsAndStatusTrueOrderByPriceDesc(nbrRooms);
    }
    
    @GetMapping("/searchAchat/NbrRooms/nbrBathrooms/{nbrRooms}/{nbrBathrooms}")
	@ResponseBody
    public List<Achat> findNbrRoomsAndNbrBathroomsAndStatusTrue(@PathVariable("nbrRooms") int nbrRooms,@PathVariable("nbrBathrooms") int nbrBathrooms) {
        return achatService.findByNbrRoomsAndNbrBathroomsAndStatusTrue(nbrRooms,nbrBathrooms);
    }


////////////////////Recherche par Options:  
    
    @GetMapping("/searchAchat/options/Jardins")
    @ResponseBody    
    public List<Achat> findByJardinTrueAndStatusTrue(){
        return achatService.findByJardinTrueAndStatusTrue();
    }

    @GetMapping("/searchAchat/options/Garage")
    @ResponseBody 
    public List<Achat> findGarageTrueAndStatusTrue(){
        return achatService.findByGarageTrueAndStatusTrue();
    }

    @GetMapping("/searchAchat/options/Parking")
    @ResponseBody 
    public List<Achat> findParkingTrueAndStatusTrue(){
        return achatService.findByParkingTrueAndStatusTrue();
    }
    
    @GetMapping("/searchAchat/options/NbrLikesAsc")
    @ResponseBody 
    public List<Achat> findStatusTrueOrderByNbrLikesAsc(){
        return achatService.findByStatusTrueOrderByNbrLikesAsc();
    }

    @GetMapping("/searchAchat/options/NbrLikesDesc")
    @ResponseBody 
    public List<Achat> findStatusTrueOrderByNbrLikesDesc(){
        return achatService.findByStatusTrueOrderByNbrLikesDesc();
    }


////////////////////Fonction Avancées:

    //Estimation de prix par City
    @GetMapping("/estimation/pricePerCity/{city}")
    @ResponseBody
    public double EstimatedPriceCity(@PathVariable("city") String city) {
        return achatService.EstimatedPriceByCity(city);
    }

    @GetMapping("/estimation/pricePerState/{state}")
    @ResponseBody
    public double EstimatedPriceState(@PathVariable("state") String state) {
        return achatService.EstimatedPriceByState(state);
    }

    @GetMapping("/estimation/pricePerMeterPerState/{state}")
    @ResponseBody
    public double PricePerMeterPerState(@PathVariable("state") String state){
        return achatService.PricePerMeterState(state);
    }


    @GetMapping("/estimation/pricePerMeterPerCity/{city}")
    @ResponseBody
    public double PricePerMeterPerCity(@PathVariable("city") String city) {
        return achatService.PricePerMeterCity(city);
    }

    @GetMapping("/searchAchat/soldLately/{periode}")
    @ResponseBody
    public List<Achat> SoldLately(@PathVariable("periode") String periode ){
        return achatService.SoldLately(periode);
    }


}
