package tn.dari.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import tn.dari.Model.Abonnement;
import tn.dari.Service.AbonnementService;
import tn.dari.Utility.FileUpload;

@RestController
@RequestMapping("/abonnement")
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin("http://localhost:4200/")
public class AbonnementController {
	@Autowired
	AbonnementService abonnementService;

	@PostMapping("/add")
	public ResponseEntity<Abonnement> add(@RequestPart Abonnement abonnement, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		abonnement.setImage(fileName);
		String uploadDir = "invitation-photos/" + abonnement.getId();
		FileUpload.saveFile(uploadDir, fileName, multipartFile);
		Abonnement abonnementSaved = abonnementService.add(abonnement);
		
		if (abonnementSaved != null)
			return new ResponseEntity<>(abonnementSaved, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update")
	public ResponseEntity<Abonnement> update(@RequestPart Abonnement abonnement, @RequestParam("image") MultipartFile multipartFile) throws IOException{
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		abonnement.setImage(fileName);
		String uploadDir = "invitation-photos/" + abonnement.getId();
		FileUpload.saveFile(uploadDir, fileName, multipartFile);
		Abonnement abonnementUpdated = abonnementService.update(abonnement);
		
		if (abonnementUpdated != null) {
			return new ResponseEntity<>(abonnementUpdated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Abonnement abonnement) {
		abonnementService.delete(abonnement);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/retrieveAll")
	public ResponseEntity<List<Abonnement>> retrieveAll() {
		List<Abonnement> abonnementRetreived = abonnementService.retrieveAll();
		return new ResponseEntity<>(abonnementRetreived, HttpStatus.OK);
		
	}
}
	
