/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelo.Model;
import views.JInicialFrame;
import java.awt.event.MouseEvent;
import views.JFaseFrame;

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
        JFaseFrame initial = new JFaseFrame(this.model);
        this.view.dispose();
        initial.setVisible(true);
        initial.setResizable(false);
        initial.setLocationRelativeTo(null);
    }
}
