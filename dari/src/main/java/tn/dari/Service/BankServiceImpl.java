package tn.dari.Service;

import java.rmi.ServerError;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.dari.Model.BankCredit;
import tn.dari.Model.SimulationDeCredit;
import tn.dari.Repository.BankCreditRepository;

@Service
public class BankServiceImpl implements bankService {

    @Autowired
    BankCreditRepository bankRepository;



    @Override
    public List<BankCredit> retrieveAllBank() {
        // TODO Auto-generated method stub
        return (List<BankCredit>) bankRepository.findAll();
    }

    @Override
    public BankCredit addBank(BankCredit s) {
        // TODO Auto-generated method stub
                return bankRepository.save(s);
    }

    @Override
    public BankCredit updateBank(BankCredit s) {
        // TODO Auto-generated method stub
        return bankRepository.save(s);
    }

    @Override
    public BankCredit retrieveBank(Long aLong) {
        // TODO Auto-generated method stub
        BankCredit o = bankRepository.findById(aLong).orElse(null);
        return o;
    }

    @Override
    public void removeBank(Long id) {
        // TODO Auto-generated method stub
        bankRepository.deleteById(id);
    }

    @Override
    public List<String> getAllBankByNames() {

        return bankRepository.getAllBankByNames();
    }


    @Override
    public Double getAllBankByInteret(String name){
        return bankRepository.getAllBankByInteret(name);
    }

   @Override
    public double calcul ( SimulationDeCredit cs)
    {
       if (getAllBankByInteret(cs.getNomBank())!= null&& getAllBankByInteret(cs.getNomBank())>0)
        {
            System.err.println(cs.getNomBank());
            Long duree= cs.getDuree();
            double interet=getAllBankByInteret(cs.getNomBank());
            System.err.println(interet);
            double montant= cs.getMontantVoudre();
            double t=(interet/12)/100;
            double s=1-Math.pow((1+t),-(duree));
            double m=montant*t/s;
            return m;
        }else {
            return 0;
       }
    }

    public String RechercheBank(String name) {

        return bankRepository.Recherchevaleur(name);
    }





}
