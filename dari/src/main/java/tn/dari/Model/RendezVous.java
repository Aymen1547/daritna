package tn.dari.Model;

import java.io.Serializable;

import java.util.Date;


import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "RendezVous")
public class RendezVous implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContrat")
	private int id;
	
	@FutureOrPresent(message = "La date du rendez-vous doit être supperieur a celle d'aujourd'hui ")
	@Temporal (TemporalType.DATE)
	@Column(name="Date",nullable =false)
	private Date date;
	
	@Min(0)
	@Max(24)
	@Column(name="heur",nullable =false)
	private int heur;
	
	@Enumerated(EnumType.STRING)
	private EnumeratedRegion region;
	
	@Size(min = 10,message = "La longueur du lieu du rendez-vous doit etre supperieur a 10 caracteres")
	@Size(max = 255,message = "La longueur du lieu du rendez-vous ne doit pas depasser 255 caracteres")
	@Column(name="lieu",nullable =false)
	private String lieu;
	
	@Enumerated(EnumType.STRING)
	private EnumeratedEtat etat;
	
	@OneToOne
	private Annonce annonce;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHeur() {
		return heur;
	}

	public void setHeur(int heur) {
		this.heur = heur;
	}

	public EnumeratedRegion getRegion() {
		return region;
	}

	public void setRegion(EnumeratedRegion region) {
		this.region = region;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public EnumeratedEtat getEtat() {
		return etat;
	}

	public void setEtat(EnumeratedEtat etat) {
		this.etat = etat;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public User getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(User demandeur) {
		this.demandeur = demandeur;
	}

	@OneToOne
	private User demandeur;

	
	
	
	
	
	

}
