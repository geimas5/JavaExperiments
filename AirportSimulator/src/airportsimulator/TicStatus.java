/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airportsimulator;

/**
 *
 * @author Marius Geitle
 */
public class TicStatus {
    private int runwaysLeft = 0;
    
    private int planesArrived = 0;
    private int planesDeparted = 0;
    private int planesDeniedTakeof = 0;
    private int planedDeniedArrival = 0;
    
    public TicStatus(int runwaysLeft){
        this.runwaysLeft = runwaysLeft;
    }
    
    public void incrementPlanesArrived() {
        this.planesArrived++;
    }
    
    public void incrementPlanesDeparted(){
        this.planesDeparted++;
    }
}
