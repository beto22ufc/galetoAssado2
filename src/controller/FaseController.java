/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Model;
import views.JFase1Frame;
import views.JFaseFrame;

/**
 *
 * @author Wallison Carlos
 */
public class FaseController implements Observer{
    private Model model;
    private JFaseFrame view;
    public FaseController(Model model, JFaseFrame view){
        this.model = model;
        this.view = view;
        this.init();
        this.model.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Teste");
        this.view.getPlayer().setBounds(this.model.getJogo().getJogador().getLocalizacao().getX()*60, this.model.getJogo().getJogador().getLocalizacao().getY()*60, 60,60);
    }
    
    public void init(){
        
    }
    
    public void KeyEvent(KeyEvent e){
        if(e.getKeyCode() == 39){
            //Right
            this.model.moveJogadorDireita();
        }else if(e.getKeyCode() == 40){
            //Down
            this.model.moveJogadorParaBaixo();
        }else if(e.getKeyCode() == 37){
            //Left
            this.model.moveJogadorParaEsquerda();
        }else if(e.getKeyCode() == 38){
            //Up
            this.model.moveJogadorParaCima();
        }
    }
    
}
