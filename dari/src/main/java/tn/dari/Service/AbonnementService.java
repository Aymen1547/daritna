package tn.dari.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import tn.dari.Model.Abonnement;
import tn.dari.Model.User;
import tn.dari.Repository.AbonnementRepository;
import tn.dari.Repository.UserRepository;
import tn.dari.Utility.EmailService;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbonnementService implements IAbonnementService{
	@Autowired
	AbonnementRepository abonnementRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailService emailService;

	@Override
	@Transactional
	public Abonnement add(Abonnement abonnement) {
		User user = userRepository.findById(abonnement.getUser().getId()).get();
		emailService.send(user.getEmail(), "Abonnement done.", emailService.buildEmail(user.getUsername(),
				"Thank you ....", ""));
		return abonnementRepository.save(abonnement);
	}

	@Override
	public Abonnement update(Abonnement abonnement) {
		return abonnementRepository.save(abonnement);
	}

	@Override
	public void delete(Abonnement abonnement) {
		abonnementRepository.delete(abonnement);
	}

	@Override
	public List<Abonnement> retrieveAll() {
		return (List<Abonnement>) abonnementRepository.findAll();
	}
	
}
