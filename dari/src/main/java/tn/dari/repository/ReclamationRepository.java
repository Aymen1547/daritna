package tn.dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entity.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}
