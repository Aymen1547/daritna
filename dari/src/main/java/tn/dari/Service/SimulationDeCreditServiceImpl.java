package tn.dari.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.dari.Model.SimulationDeCredit;
import tn.dari.Repository.SimulationDeCreditRepository;
@Service
@Slf4j
public class SimulationDeCreditServiceImpl implements SimulationDeCreditDeService{

    @Autowired
    SimulationDeCreditRepository simulation;

    @Override
    public List<SimulationDeCredit> retrieveAllSimulation() {
        // TODO Auto-generated method stub
        return (List<SimulationDeCredit>) simulation.findAll();
    }

    @Override
    public SimulationDeCredit addSimulation(SimulationDeCredit s) {
        // TODO Auto-generated method stub
        return simulation.save(s);
    }

    @Override
    public SimulationDeCredit updateSimulation(SimulationDeCredit s) {
        // TODO Auto-generated method stub
        return simulation.save(s);
    }

    @Override
    public SimulationDeCredit retrieveSimulation(Long aLong) {
        // TODO Auto-generated method stub
        SimulationDeCredit o = simulation.findById(aLong).orElse(null);
        return o;
    }

    @Override
    public void removeSimulation(Long id) {
        // TODO Auto-generated method stub
        simulation.deleteById(id);
    }

    public List<String> getAllSimulationByNames(String name) {

        return simulation.getAllSimulationByNames(name);
    }


}