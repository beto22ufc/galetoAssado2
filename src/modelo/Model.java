/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controller.Observer;
import java.util.ArrayList;

/**
 *
 * @author Wallison Carlos
 */
public class Model {
    private ArrayList<Observer> observers = new ArrayList<>();
    private static Model model;
    
    public static Model getInstance(){
        if(model == null)
            model = new Model();
        return model;
    }
    
    private Model(){}
    
    public void attach(Observer observer){
        if(!observers.contains(observer))
            observers.add(observer);
    }
    
    public void dettach(Observer observer){
        observers.remove(observer);
    }
    
    public void notifyObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }
}
