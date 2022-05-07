package tn.dari.Service;

import tn.dari.Model.BankCredit;
import tn.dari.Model.SimulationDeCredit;


import java.util.List;

public interface bankService {

    List<BankCredit> retrieveAllBank();

    BankCredit addBank (BankCredit s);

    BankCredit updateBank (BankCredit s);

    BankCredit retrieveBank (Long id);

    void removeBank (Long id);

    List<String> getAllBankByNames();

    Double getAllBankByInteret(String name);

    String RechercheBank(String name);


    double calcul ( SimulationDeCredit cs);

}
