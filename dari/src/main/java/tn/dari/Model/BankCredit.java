package tn.dari.Model;


import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name="Bank")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankCredit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="BankId")
    private Long bankId;
    @Column (name="nameBank")
    private String nameBank;
    @Column (name="interet")
    private double interestRate;


    @ManyToOne (cascade = CascadeType.ALL)
    //@JoinColumn (nullable=false)
    private SimulationDeCredit cs;



}
