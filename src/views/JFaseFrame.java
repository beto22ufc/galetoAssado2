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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Armadilha;
import modelo.Model;
import modelo.Vida;

/**
 *
 * @author Wallison
 */
public class JFaseFrame extends JFrame{
    private JLabel player = new JLabel();
    private ArrayList<JLabel> armadilhas = new ArrayList<>();
    private ArrayList<JLabel> vidas = new ArrayList<>();
    private ArrayList<JLabel> newvidas = new ArrayList<>();
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
        campo.setSize(1200, 600);
        campo.setBounds(0, 0, 1200, 660);
        player.setBackground(Color.red);
        player.setBounds(0, this.model.getJogo().getJogador().getLocalizacao().getY(), 60, 60);
        player.setIcon(this.model.getJogo().getJogador().getSprite());
        initVidas();
        addVidas();
        this.background.setBounds(0, 0, 1200, 660);
        for(Armadilha a : this.model.getJogo().getArmadilhas()){
            JLabel armadilha = new JLabel();
            armadilha.setBounds(a.getLocalizacao().getX()*60, a.getLocalizacao().getY()*60, 60, 60);
            armadilhas.add(armadilha);
            armadilha = armadilhas.get(armadilhas.indexOf(armadilha));
            campo.add(armadilha);
        }
        campo.add(player);
        campo.add(background);
        getContentPane().add(campo);
    }
    
    public void initVidas(){
        ImageIcon heart = new ImageIcon(getClass().getResource("/imagem/heart.png"));
        for(int i=0;i<3;i++){
            JLabel vida = new JLabel(heart);
            vida.setBounds(i*25, 9*60, 20, 20);
            vidas.add(vida);
        }
        for(JLabel vida : vidas){
            campo.add(vida);
        }
    }
    
    public void addVidas(){
        ImageIcon life = new ImageIcon(getClass().getResource("/imagem/life.png"));
        for(int i=0;i<this.model.getJogo().getVidas().size();i++){
            Vida v = this.model.getJogo().getVidas().get(i);
            JLabel vida = new JLabel(life);
            vida.setBounds(v.getLocalizacao().getX()*60, v.getLocalizacao().getY()*60, 60, 60);
            newvidas.add(vida);
        }
        for(JLabel vida : newvidas){
            campo.add(vida);
        }
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

    public ArrayList<JLabel> getArmadilhas() {
        return armadilhas;
    }

    public void setArmadilhas(ArrayList<JLabel> armadilhas) {
        this.armadilhas = armadilhas;
    }
    
    public JPanel getCampo(){
        return this.campo;
    }

    public ArrayList<JLabel> getVidas() {
        return vidas;
    }

    public void setVidas(ArrayList<JLabel> vidas) {
        this.vidas = vidas;
    }

    public ArrayList<JLabel> getNewvidas() {
        return newvidas;
    }

    public void setNewvidas(ArrayList<JLabel> newvidas) {
        this.newvidas = newvidas;
    }
    
    
    
}
