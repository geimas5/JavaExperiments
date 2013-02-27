/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airportsimulator;

/**
 *
 * @author Marius Geitle
 */
public class Plane {
    private int _id;
    
    public Plane(int id){
        this._id = id;
    }
 
    public int getId(){
        return this._id;
    }
}
