/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Armadilha;
import modelo.Jogo;
import modelo.Model;
import modelo.Vida;
import views.JFaseFrame;
import views.JGameOverFrame;

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
        this.view.getPlayer().setBounds(this.model.getJogo().getJogador().getLocalizacao().getX(), this.model.getJogo().getJogador().getLocalizacao().getY(), 60,60);
        System.out.println(this.model.getJogo().getJogador().getLocalizacao().getX()+" "+this.model.getJogo().getJogador().getLocalizacao().getY());
        if(this.model.getJogo().ganhou()){
            JOptionPane.showMessageDialog(null, "Você ganhou!");
            this.view.dispose();
            Jogo.start();
        }
        int colisao =this.model.detectaColisao();
        if(colisao>=0){
            Armadilha a = this.model.getJogo().getArmadilhas().get(colisao);
            this.view.getArmadilhas().get(colisao).setIcon(a.getSprite());           
            ImageIcon dead = new ImageIcon(getClass().getResource("/imagem/dead.png"));
            this.view.getVidas().get(this.model.getJogo().getJogador().getVida()).setIcon(dead);
        }
        int colisaoVida = this.model.getJogo().plusVida(this.model.getJogo().getJogador());
        if(colisaoVida>=0){ 
            ImageIcon vazio = new ImageIcon(getClass().getResource("/imagem/vazio.png"));
            this.view.getNewvidas().get(colisaoVida).setIcon(vazio);
            ImageIcon heart = new ImageIcon(getClass().getResource("/imagem/heart.png"));
            this.view.getVidas().get(this.model.getJogo().getJogador().getVida()-1).setIcon(heart);
        }
        if(this.model.getJogo().getJogador().getVida()==0){
            JGameOverFrame gameOver = new JGameOverFrame();
            gameOver.setVisible(true);
            gameOver.setResizable(false);
            gameOver.setLocationRelativeTo(null);
            this.view.dispose();
        }
        
    }
    
    public void init(){
        
    }
    
    public void KeyEvent(KeyEvent e){
        if(e.getKeyCode() == 39){
            //Right
            this.model.moveJogadorDireita(this.view);
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
