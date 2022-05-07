package tn.dari.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import tn.dari.Model.BankCredit;

import java.util.List;



@Repository
public interface BankCreditRepository extends JpaRepository<BankCredit, Long> {

    @Query("SELECT distinct nameBank FROM BankCredit ")
    List<String> getAllBankByNames();

    @Query("SELECT sum(p.interestRate) FROM BankCredit p INNER JOIN SimulationDeCredit cs ON(p.nameBank=cs.nomBank)where p.nameBank=:name ")
    Double getAllBankByInteret(String name);

    @Query("SELECT nameBank from BankCredit where nameBank=:nom")
    String Recherchevaleur(String nom);


}
