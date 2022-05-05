package tn.dari.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "RDVFeedback")
public class RDVFeedbackEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_rdv_feedback")
	public long id;
	
	@Column(name="descRDV")
	public String descRDV;
	
	@OneToOne(mappedBy="RDVF")
	private RDVEntity rdv;
	
	@Column(name="Likes")
	private boolean Likes;
	
	public String getDescriptionFeedBack() {
		return descRDV;
	}
	public void setDescriptionFeedBack(String descriptionFeedBack) {
		descRDV = descriptionFeedBack;
	}
	
	public boolean isLikes() {
		return Likes;
	}
	public void setLikes(boolean likes) {
		Likes = likes;
	}
}
