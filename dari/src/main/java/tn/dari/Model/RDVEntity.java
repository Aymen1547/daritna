package tn.dari.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "RDV")
public class RDVEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public long id_rdv;
	
	@Column(name="sujet")
	public String title;
	
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateRDV")
	private Date dateRDV;
	@Column(name="Visibility")
	private int Visibility;
	@Column(name="state")
	private String state;
	@Column(name="Heure")
	private int Heure;
	@Column(name="Attendance")
	private String Attendance;

	@OneToOne
	@JoinColumn(name="T_RDV")
	private ClientEntity client;
	
	@OneToOne
	@JoinColumn(name="T_RDV_FeedBack")
	private RDVFeedbackEntity RDVF;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Date getDateAppointement() {
		return dateRDV;
	}
	public void setDateAppointement(Date dateAppointement) {
		this.dateRDV = dateAppointement;
	}
	public long getId_rdv() {
		return id_rdv;
	}
	public void setId_rdv(long id_rdv) {
		this.id_rdv = id_rdv;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getVisibility() {
		return Visibility;
	}
	public void setVisibility(int visibility) {
		Visibility = visibility;
	}
	public int getHeure() {
		return Heure;
	}
	public void setHeure(int heure) {
		Heure = heure;
	}
	public String getAttendance() {
		return Attendance;
	}
	public void setAttendance(String attendance) {
		Attendance = attendance;
	}
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	public RDVFeedbackEntity getRDVF() {
		return RDVF;
	}
	public void setRDVF(RDVFeedbackEntity rDVF) {
		RDVF = rDVF;
	}
	
	
}
