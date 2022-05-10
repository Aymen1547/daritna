package tn.dari.Model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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

public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdReclamation;
    private String Contenu;
   // @Temporal(TemporalType.DATE)
    private Date date;
    private String Object;
    private String type;
    //@JsonBackReference
    @ManyToOne
    //@JoinColumn(nullable = false)
    private Location location;
}
