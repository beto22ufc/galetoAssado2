/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JLabel;
import modelo.Model;
import views.JFase1Frame;

/**
 *
 * @author Wallison Carlos
 */
public class Fase1Controller implements Observer{
    private Model model;
    private JFase1Frame view;
    private JLabel player;
    public Fase1Controller(Model model, JFase1Frame view){
        this.model = model;
        this.view = view;
        this.init();
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void init(){
        
    }
    
}
