/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airportsimulator;

/**
 *
 * @author Marius Geitle
 */
public class AirportSimulator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int landingQueueSize = 20;
        int takeofQueueSize = 20;
        int numberOfRunways = 2;
        int simulationLength = 20;
        double planeArrivalMean = 2.5;
        
        
        Simulator simulator = new Simulator(landingQueueSize, takeofQueueSize, numberOfRunways, simulationLength, planeArrivalMean);
        simulator.executeSimulation();
    }
}
