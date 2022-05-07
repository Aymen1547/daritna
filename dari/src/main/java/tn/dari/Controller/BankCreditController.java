package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.dari.Model.BankCredit;
import tn.dari.Model.SimulationDeCredit;
import tn.dari.Service.BankServiceImpl;



@RestController
@RequestMapping("/api/BankCredit")
public class BankCreditController {
    @Autowired
    private BankServiceImpl ibankService;


    @GetMapping("/retrieveAllBank")
    public List<BankCredit> retrieveAllBank() {
        return ibankService.retrieveAllBank();
    }

    @GetMapping("/retrieveBank/{idBank}")
    public BankCredit retrieveSimulation(@PathVariable("idBank")Long id) {

        return ibankService.retrieveBank(id);
    }


    @PostMapping("/addBank")
    public BankCredit addBank(@RequestBody BankCredit s) {
        return ibankService.addBank(s);
    }


    @DeleteMapping("/removeBank/{idBank}")
    public void removeBank(@PathVariable("idBank") Long id) {
        ibankService.removeBank(id);
    }


    @PutMapping("/updateBank")
    public BankCredit updateBank(@RequestBody BankCredit s) {
        return ibankService.updateBank(s);
    }

   @PutMapping("/bank/{idBank}")
    public ResponseEntity<BankCredit> updatebanks(@PathVariable("idBank") Long BankId, @RequestBody BankCredit bankDetails){
        BankCredit bank = ibankService.retrieveBank(BankId);

        bank.setNameBank(bankDetails.getNameBank());
        bank.setInterestRate(bankDetails.getInterestRate());

        BankCredit updatedbank = ibankService.updateBank(bank);
        return ResponseEntity.ok(updatedbank);
    }


    @GetMapping("/getAllBankByNames")
    @ResponseBody
    public List<String> getAllBankByNames(){
        return ibankService.getAllBankByNames();
    }

    @GetMapping("/RechercheBank/{name}")
    @ResponseBody
    public String getAllBankByNames(@PathVariable("name") String name){
        return ibankService.RechercheBank(name);
    }


    @PostMapping(value = "calculate")
    @ResponseBody
    public double calcul ( @RequestBody SimulationDeCredit cs)
    {
        return ibankService.calcul(cs);
    }

}
