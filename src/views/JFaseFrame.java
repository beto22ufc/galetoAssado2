/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.FaseController;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Armadilha;
import modelo.Model;

/**
 *
 * @author Wallison
 */
public class JFaseFrame extends JFrame{
    private JLabel player = new JLabel();
    private FaseController controller;
    private Model model;
    private final JLabel background = new JLabel(new ImageIcon(getClass().getResource("/imagem/bg_fase.png")));
    private final JPanel campo = new JPanel();
    
    public JFaseFrame(){
        super("Fase 1");
    }
   
    public JFaseFrame(Model model){
        this();
        this.model = model;
        this.controller = new FaseController(model, this);
        init();
    }
    
    public void init(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 600);
        this.addKeyListener(new KeysEvents(this));
        campo.setLayout(null);
        player.setBackground(Color.red);
        player.setBounds(0, 0, 60, 60);
        player.setIcon(this.model.getJogo().getJogador().getSprite());
        this.background.setBounds(0, 0, 1200, 600);
        campo.add(player);
        for(Armadilha a : this.model.getJogo().getArmadilhas()){
            JLabel armadilha = new JLabel(a.getSprite());
            armadilha.setBounds(a.getLocalizacao().getX()*60, a.getLocalizacao().getY()*60, 60, 60);
            campo.add(armadilha);
        }
        campo.add(background);
        getContentPane().add(campo);
    }
    
    public class KeysEvents implements KeyListener{
        private JFaseFrame view;
        public KeysEvents(){
        
        }
        
        public KeysEvents(JFaseFrame view){
            this.view = view;
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            JOptionPane.showMessageDialog(null, 
                "Uma tecla foi typed!");
        }

        @Override
        public void keyPressed(KeyEvent e) {
           this.view.getController().KeyEvent(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
             
        }
    
    }

    public FaseController getController() {
        return controller;
    }

    public void setController(FaseController controller) {
        this.controller = controller;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public JLabel getPlayer() {
        return player;
    }

    public void setPlayer(JLabel player) {
        this.player = player;
    }
    
    
    
}
