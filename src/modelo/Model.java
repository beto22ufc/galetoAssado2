/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controller.Observer;
import java.util.ArrayList;
import views.JFaseFrame;

/**
 *
 * @author Wallison Carlos
 */
public class Model {
    private ArrayList<Observer> observers = new ArrayList<>();
    private static Model model;
    private Jogo jogo; 
    public static Model getInstance(Jogo jogo){
        model = new Model(jogo);
        return model;
    }
    
    private Model(){}
    private Model(Jogo jogo){
        this.jogo = jogo;
    }
    
    public void moveJogadorDireita(JFaseFrame fase){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveDireita();
            i+=2;
        }
        notifyObservers();
    }
    
    public void moveJogadorParaBaixo(){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveBaixo();
            i+=2;
        }
        notifyObservers();
    }
        
    public void moveJogadorParaCima(){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveCima();
            i+=2;
        }
        notifyObservers();
    }
    
    public void moveJogadorParaEsquerda(){
        int i=0;
        while(i<120){
            this.getJogo().getJogador().moveEsquerda();
            i+=2;
        }
        notifyObservers();
    }
    
    public int detectaColisao(){
        for(int i=0;i<this.getJogo().getArmadilhas().size();i++){
            Armadilha armadilha = this.getJogo().getArmadilhas().get(i);
            if(this.getJogo().gameOver(this.getJogo().getJogador(), armadilha) && !armadilha.isColidiu()){
                this.getJogo().getJogador().setVida(this.getJogo().getJogador().getVida()-1);
                System.out.println("Jogador:\n\tX: "+this.getJogo().getJogador().getLocalizacao().getX()+""
                        + "\n\tY: "+this.getJogo().getJogador().getLocalizacao().getY()+"\n"
                                + "Armadilha: \n\tX: "+armadilha.getLocalizacao().getX()+""
                                        + "\n\tY: "+armadilha.getLocalizacao().getY());
                armadilha.setColidiu(true);
                return i;
            }
        }
        return -1;
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
