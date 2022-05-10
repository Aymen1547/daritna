package tn.dari.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="SimulationDeCredit")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimulationDeCredit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="CSId")
    private Long CSId;
    private String nameCS;
    private String nomBank;
    private double mounthlyInCame;
    private long Duree;
    private double montantVoudre;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cs")
    private Set<BankCredit> bankCredits;





    //@ManyToOne
    //private User us;


}