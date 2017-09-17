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
    
    public void moveJogadorDireita(){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveDireita();
            System.out.println(this.getJogo().getJogador().getLocalizacao().getX()+" "+this.getJogo().getJogador().getLocalizacao().getY());
            i+=2;
            notifyObservers();
        }
    }
    
    public void moveJogadorParaBaixo(){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveBaixo();
            System.out.println(this.getJogo().getJogador().getLocalizacao().getX()+" "+this.getJogo().getJogador().getLocalizacao().getY());
            i+=2;
            notifyObservers();
        }
    }
        
    public void moveJogadorParaCima(){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveCima();
            i+=2;
            System.out.println(this.getJogo().getJogador().getLocalizacao().getX()+" "+this.getJogo().getJogador().getLocalizacao().getY());
            notifyObservers();
        }
    }
    
    public void moveJogadorParaEsquerda(){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveEsquerda();
            i+=2;
            System.out.println(this.getJogo().getJogador().getLocalizacao().getX()+" "+this.getJogo().getJogador().getLocalizacao().getY());
            notifyObservers();
        }
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
