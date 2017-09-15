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
    private Jogo jogo; 
    public static Model getInstance(Jogo jogo){
        if(model == null)
            model = new Model(jogo);
        return model;
    }
    
    private Model(){}
    private Model(Jogo jogo){
        this.jogo = jogo;
    }
    
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
    public Jogo getJogo(){
        return this.jogo;
    }
}
