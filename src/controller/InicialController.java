/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import modelo.Model;
import views.JFase1Frame;
import views.JInicialFrame;
import java.awt.event.MouseEvent;

/**
 *
 * @author Wallison Carlos
 */
public class InicialController implements Observer{
    private Model model;
    private JInicialFrame view;
    
    public InicialController(Model model, JInicialFrame view){
        this.model = model;
        this.view = view;
    }

    @Override
    public void update() {
        
    }
    
    public void getMouseEvent(MouseEvent evt){
        JFase1Frame initial = new JFase1Frame(this.model);
        initial.setVisible(true);
        initial.setResizable(false);
        initial.setLocationRelativeTo(null);
    }
}
