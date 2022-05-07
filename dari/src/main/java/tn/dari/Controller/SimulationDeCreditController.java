package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.dari.Model.SimulationDeCredit;
import tn.dari.Service.SimulationDeCreditServiceImpl;


import java.util.List;


@RestController
@RequestMapping("/api/SimulationDeCredit")
public class SimulationDeCreditController {

    @Autowired
    private SimulationDeCreditServiceImpl  SimulationService;


    @GetMapping("/retrieveAllSimulation")
    public List<SimulationDeCredit> retrieveAllSimulation() {
        return SimulationService.retrieveAllSimulation();
    }

    @PostMapping("/addSimulation")
    public SimulationDeCredit addSimulation(@RequestBody SimulationDeCredit s) {
        return SimulationService.addSimulation(s);
    }


    @PutMapping("/updateSimulation")
    public SimulationDeCredit updateSimulation(@RequestBody SimulationDeCredit s) {
        return SimulationService.updateSimulation(s);
    }



    @DeleteMapping("/removeSimulation/{idSimulation}")
    public void removeSimulation(@PathVariable("idSimulation")Long id) {
        SimulationService.removeSimulation(id);
    }



    @GetMapping("/retrieveSimulation/{idSimulation}")
    public SimulationDeCredit retrieveSimulation(@PathVariable("idSimulation")Long id) {
        return SimulationService.retrieveSimulation(id);
    }
    @PostMapping("/getAllByNames/{name}")
    @ResponseBody
    public List<String> getAllByNames(@PathVariable("name") String name){
        return SimulationService.getAllSimulationByNames(name);
    }




}