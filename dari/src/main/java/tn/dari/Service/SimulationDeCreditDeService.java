package tn.dari.Service;

import java.util.List;


import tn.dari.Model.SimulationDeCredit;

public interface  SimulationDeCreditDeService {
        List<SimulationDeCredit> retrieveAllSimulation();

        SimulationDeCredit addSimulation (SimulationDeCredit s);

        SimulationDeCredit updateSimulation (SimulationDeCredit s);

        SimulationDeCredit retrieveSimulation (Long id);

        void removeSimulation (Long id);

        List<String> getAllSimulationByNames(String name);




        

}