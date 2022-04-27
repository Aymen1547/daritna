package tn.dari.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.Model.Achat;
import tn.dari.Repository.AchatRepository;

@Service
public class AchatService {
    @Autowired
    AchatRepository achatRepository;

////////////////////CRUD:    
    public Achat addAchat(Achat achat){
        achatRepository.save(achat);
        return achat;
    }

    public void deletAchat (long id, long userId){
        achatRepository.deleteById(id,userId);
    }

    public List<Achat> retreiveAllAchat(long userId){
        return achatRepository.findAll();
    }

    public Achat retreiveAchat(long id, long userId){
        return achatRepository.find(id, userId);
    }

    public Achat updateAchat(Achat achat, long id, long userId){
        Achat oldAchat=achatRepository.find(id, userId);

        oldAchat.setStatus(achat.isStatus());
        oldAchat.setCreationDate(achat.getCreationDate());
        oldAchat.setUpdateDate(achat.getUpdateDate());
        oldAchat.setCity(achat.getCity());
        oldAchat.setState(achat.getState());
        oldAchat.setPrice(achat.getPrice());
        oldAchat.setSurface(achat.getSurface());
        oldAchat.setType(achat.getType());
        oldAchat.setNbrRooms(achat.getNbrRooms());
        oldAchat.setNbrBathrooms(achat.getNbrBathrooms());
        oldAchat.setJardin(achat.isJardin());
        oldAchat.setGarage(achat.isGarage());
        oldAchat.setParking(achat.isParking());
        oldAchat.setImage(achat.getImage());
        oldAchat.setVideo(achat.getVideo());
        oldAchat.setDescription(achat.getDescription());
        oldAchat.setNbrLikes(achat.getNbrLikes());
        oldAchat.setNbrDisLikes(achat.getNbrDisLikes());

        achatRepository.save(oldAchat);
        return oldAchat;
    }


////////////////////Recherche par prix:
		
public List<Achat> findByPriceMinMaxPriceAsc(float pricemin,float pricemax) {
    return achatRepository.findByPriceMinMaxPriceAsc(pricemin, pricemax);
}

public List<Achat> findByPriceMinMaxPriceDesc(float pricemin,float pricemax) {
    return achatRepository.findByPriceMinMaxPriceDesc(pricemin, pricemax);
}

public List<Achat> findByPriceMinMaxSurfaceAsc(float pricemin,float pricemax) {
    return achatRepository.findByPriceMinMaxSurfaceAsc(pricemin, pricemax);
}

public List<Achat> findByPriceMinMaxSurfaceDesc(float pricemin,float pricemax) {
    return achatRepository.findByPriceMinMaxSurfaceDesc(pricemin, pricemax);
}

public List<Achat> findByPriceAndStatusTrue(float price) {
    return achatRepository.findByPriceAndStatusTrue(price);
}

////////////////////Recherche par Surface: 
public List<Achat> findBySurfaceAndStatusTrue(float surface) {
    return achatRepository.findBySurfaceAndStatusTrue(surface);
}

public List<Achat> findBySurfaceAndStatusTrueOrderByPriceAsc(float surface) {
    return achatRepository.findBySurfaceAndStatusTrueOrderByPriceAsc(surface);
}

public List<Achat> findBySurfaceAndStatusTrueOrderByPriceDesc(float surface) {
    return achatRepository.findBySurfaceAndStatusTrueOrderByPriceDesc(surface);
}

////////////////////Recherche par City: 
public List<Achat> findByCityAndStatusTrue(String city) {
    return achatRepository.findByCityAndStatusTrue(city);
}

public List<Achat> findByCityAndStatusTrueOrderByPriceAsc(String city) {
    return achatRepository.findByCityAndStatusTrueOrderByPriceAsc(city);
}

public List<Achat> findByCityAndStatusTrueOrderByPriceDesc(String city) {
    return achatRepository.findByCityAndStatusTrueOrderByPriceDesc(city);
}

////////////////////Recherche par State:
public List<Achat> findByStateAndStatusTrue(String state) {
    return achatRepository.findByStateAndStatusTrue(state);
}
public List<Achat> findByStateAndStatusTrueOrderByPriceAsc(String state) {
    return achatRepository.findByStateAndStatusTrueOrderByPriceAsc(state);
}

public List<Achat> findByStateAndStatusTrueOrderByPriceDesc(String state) {
    return achatRepository.findByStateAndStatusTrueOrderByPriceDesc(state);
}

////////////////////Recherche par NbrRooms:
public List<Achat> findByNbrRoomsAndStatusTrue(int nbrRooms) {
    return achatRepository.findByNbrRoomsAndStatusTrue(nbrRooms);
}

public List<Achat> findByNbrRoomsAndStatusTrueOrderByPriceAsc(int nbrRooms) {
    return achatRepository.findByNbrRoomsAndStatusTrueOrderByPriceAsc(nbrRooms);
}

public List<Achat> findByNbrRoomsAndStatusTrueOrderByPriceDesc(int nbrRooms) {
    return achatRepository.findByNbrRoomsAndStatusTrueOrderByPriceDesc(nbrRooms);
}

public List<Achat> findByNbrRoomsAndNbrBathroomsAndStatusTrue(int nbrRooms,int nbrBathrooms) {
    return achatRepository.findByNbrRoomsAndNbrBathroomsAndStatusTrue(nbrRooms,nbrBathrooms);
}

////////////////////Recherche par Options:   
public List<Achat> findByJardinTrueAndStatusTrue(){
    return achatRepository.findByJardinTrueAndStatusTrue();
}
public List<Achat> findByGarageTrueAndStatusTrue(){
    return achatRepository.findByGarageTrueAndStatusTrue();
}
public List<Achat> findByParkingTrueAndStatusTrue(){
    return achatRepository.findByParkingTrueAndStatusTrue();
}

public List<Achat> findByStatusTrueOrderByNbrLikesAsc(){
    return achatRepository.findByStatusTrueOrderByNbrLikesAsc();
}
public List<Achat> findByStatusTrueOrderByNbrLikesDesc(){
    return achatRepository.findByStatusTrueOrderByNbrLikesDesc();
}


////////////////////Fonction Avancées:

        //Estimation de prix par City
		public double EstimatedPriceByCity(String city) {
			List<Achat> liste = achatRepository.findByCityAndStatusTrue(city);
			double moyenne = 0;
			double price = 0;
			int lstSize = liste.size();
			for (int i = 0; i < lstSize; i++) {
				price = price + liste.get(i).getPrice();
			}

			moyenne = price / lstSize;
			return moyenne;
		}       

        //Estimation de prix par State
		public double EstimatedPriceByState(String state) {
			List<Achat> liste = achatRepository.findByStateAndStatusTrue(state);
			double moyenne = 0;
			double price = 0;
			int lstSize = liste.size();
			for (int i = 0; i < lstSize; i++) {
				price = price + liste.get(i).getPrice();
			}

			moyenne = price / lstSize;
			return moyenne;
		}

        //Estimation de surface par City
		public double EstimatedSurfaceByCity(String state) {
			List<Achat> liste = achatRepository.findByCityAndStatusTrue(state);
			double surfMoyenne = 0;
			double surface = 0;
			int lstSize = liste.size();
			for (int i = 0; i < lstSize; i++) {
				surface = surface + liste.get(i).getSurface();
			}

			surfMoyenne = surface / lstSize;
			return surfMoyenne;
		}

        //Estimation de surface par
		public double EstimatedSurfaceByState(String state) {
			List<Achat> liste = achatRepository.findByStateAndStatusTrue(state);
			double surfMoyenne = 0;
			double surface = 0;
			int lstSize = liste.size();
			for (int i = 0; i < lstSize; i++) {
				surface = surface + liste.get(i).getSurface();
			}

			surfMoyenne = surface / lstSize;
			return surfMoyenne;
		}

        //Estimation de prix par metre^2 par state
		public double PricePerMeterState(String state) {
			return EstimatedPriceByState(state) / EstimatedSurfaceByState(state);
		}

        //Estimation de prix par metre^2 par city
		public double PricePerMeterCity(String city) {
			return EstimatedPriceByCity(city) / EstimatedSurfaceByCity(city);
		}

        //Dernier biens vendus:
        public List<Achat> SoldLately(String periode ){
            List<Achat> liste = achatRepository.findAll();
            List<Achat> finalList=new ArrayList<Achat>();

            int lstSize = liste.size();
            int k=0;  //finalList index

            Date creationD;
            Date updateD;
            LocalDateTime presentD= LocalDateTime.now();  //retrive the present DateTime
            Date presentDate = Date.from(presentD.atZone(ZoneId.systemDefault()).toInstant());  // convert the present DateTime to instant than to date so we can use ".getTime"
            long duration;
            
            switch(periode){

                case "last week":
    		    	for (int i = 0; i < lstSize; i++) {
                        boolean status= liste.get(i).isStatus();  //status: sold(0) or available(1)
	        			creationD = liste.get(i).getCreationDate();
                        updateD = liste.get(i).getUpdateDate();

                        if (status==false && updateD.equals(creationD)){  //item sold and never updated
                            duration=presentDate.getTime()-creationD.getTime();  //getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GTM (Unix time)
                            if ( (duration/(8640*10^7)) <= 7){  //duration inferior to 7 days -> week
                                finalList.set(k, liste.get(i));  //save it into the finalList
                                k=k+1;
                            } 
                        }
                        else if (status==false && updateD.after(creationD)){  //item sold but was updated 
                            duration=presentDate.getTime()-updateD.getTime();  //consider updateDate and not creationDate
                            if ((duration/(8640*10^7))<=7){
                                finalList.set(k, liste.get(i));
                                k=k+1;
                            } 
                        }
	    		    }
                    break;

                case "last month":
    		    	for (int i = 0; i < lstSize; i++) {
                        boolean status= liste.get(i).isStatus();
	        			creationD = liste.get(i).getCreationDate();
                        updateD = liste.get(i).getUpdateDate();
                        if (status==false && updateD.equals(creationD)){
                            duration=presentDate.getTime()-creationD.getTime();
                            if ((duration/(8640*10^7))<=30){
                                finalList.set(k, liste.get(i));
                                k=k+1;
                            } 
                        }
                        else if (status==false && updateD.after(creationD)){
                            duration=presentDate.getTime()-updateD.getTime();
                            if ((duration/(8640*10^7))<=30){
                                finalList.set(k, liste.get(i));
                                k=k+1;
                            } 
                        }
	    		    }
                    break; 
                
                    case "last year":
    		    	for (int i = 0; i < lstSize; i++) {
                        boolean status= liste.get(i).isStatus();
	        			creationD = liste.get(i).getCreationDate();
                        updateD = liste.get(i).getUpdateDate();
                        if (status==false && updateD.equals(creationD)){
                            duration=presentDate.getTime()-creationD.getTime();
                            if ((duration/(8640*10^7))<=365){
                                finalList.set(k, liste.get(i));
                                k=k+1;
                            } 
                        }
                        else if (status==false && updateD.after(creationD)){
                            duration=presentDate.getTime()-updateD.getTime();
                            if ((duration/(8640*10^7))<=365){
                                finalList.set(k, liste.get(i));
                                k=k+1;
                            } 
                        }
	    		    }
                    break;    
            }

            return finalList;
        }







}
