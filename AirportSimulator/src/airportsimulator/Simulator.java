/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airportsimulator;

import java.util.*;

/**
 *
 * @author Marius Geitle
 */
public class Simulator {
    private int maxLandingQueueSize;
    private int maxTakeofQueueSize;
    private int numberOfRunways;
    private int simulationLength;
    private double planeArrivalMean;
    private int planeId = 0;
    
    private Queue<Plane> landingQueue = new Queue<>();
    private Queue<Plane> takeofQueue = new Queue<>();
    
    public Simulator(int landingQueueSize, 
                int takeofQueueSize, 
                int numberOfRunways,
                int simulationLength,
                double planeArrivalMean) {
        this.maxLandingQueueSize = landingQueueSize;
        this.maxTakeofQueueSize = takeofQueueSize;
        this.numberOfRunways = numberOfRunways;
        this.simulationLength = simulationLength;
        this.planeArrivalMean = planeArrivalMean;
    }
    
    public void executeSimulation() {
        for(int i = 0; i < simulationLength; i++) {
            tic(i);
        }
    }
    
    public void tic(int ticId) {
        System.out.println(ticId + ": ");
        
        int runwaysLeft = this.numberOfRunways;
        
        processArrivingPlanes();
        processDepartingPlanes();
        
        runwaysLeft -= processLandingQueue(runwaysLeft);
        runwaysLeft -= processTakeofQueue(runwaysLeft);
    }
    
    private void processArrivingPlanes() {
        int newArrivals = getPoissonRandom(planeArrivalMean);
        
        int queueSpace = this.maxLandingQueueSize - this.landingQueue.size();
        
        int planesToQueue = Math.min(newArrivals, queueSpace);
        int planesToTurnAway = newArrivals - planesToQueue;
        
        for(int i = 0; i < planesToQueue; i++){
            Plane plane = new Plane(planeId++);
            landingQueue.enqueue(plane);
            System.out.println("Plane " + plane.getId() + " is ready to land, Ventetid " + this.landingQueue.size());
        }
        
        if(planesToTurnAway > 0)
            System.out.println(planesToTurnAway + " is turned away");
        
    }
    
    private void processDepartingPlanes() {
        int newDepartures = getPoissonRandom(planeArrivalMean);
        
        int queueSpace = this.maxTakeofQueueSize - this.takeofQueue.size();
        
        int planesToQueue = Math.min(newDepartures, queueSpace);
        int planesToTurnAway = newDepartures - planesToQueue;
        
        for(int i = 0; i < newDepartures; i++) {
            Plane plane = new Plane(planeId++);
            this.takeofQueue.enqueue(plane);
            System.out.println("Plane " + plane.getId() + " is ready to take of!");
        }
        
        if(planesToTurnAway > 0)
            System.out.println(planesToTurnAway + " is denied takeof");
    }
    
    private int processLandingQueue(int runwaysLeft) {
        int processedPlanes = 0;
        
        while(runwaysLeft > 0 && this.landingQueue.size() > 0) {
            Plane plane = this.landingQueue.dequeue();
            System.out.println("Plane " + plane.getId() + " has landed");
            processedPlanes++;
            runwaysLeft--;
        }
        
        return processedPlanes;
    }
    
    private int processTakeofQueue(int runwaysLeft) {
        int processedPlanes = 0;
        
        while(runwaysLeft > 0 && this.takeofQueue.size() > 0){
            Plane plane = this.takeofQueue.dequeue();
            System.out.println("Plane " + plane.getId() + " has landed");
            processedPlanes++;
            runwaysLeft--;
        }
        
        return processedPlanes;
    }
    
    private static int getPoissonRandom(double mean)
    {
	Random r = new Random();
	double L = Math.exp(-mean);
	int k = 0;
	double p = 1.0;
	do
        {
	    p = p * r.nextDouble();
	    k++;
	} while (p > L);
	return k - 1;
    }
}