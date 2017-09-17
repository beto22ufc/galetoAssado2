/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author N2S-PC03
 */
public class Jogo {
    private Jogador jogador;
    private ArrayList<Armadilha> armadilhas = new ArrayList<>();
    
    public Jogo(){
    
    }
    
    public Jogo(Jogador jogador, ArrayList<Armadilha> armadilhas){
        this.jogador = jogador;
        this.armadilhas = armadilhas;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public ArrayList<Armadilha> getArmadilhas() {
        return armadilhas;
    }

    public void setArmadilhas(ArrayList<Armadilha> armadilhas) {
        this.armadilhas = armadilhas;
    }
    
    public boolean colisao(Localizacao localizacao, Localizacao localizacao1){
        return (localizacao.getX()==localizacao1.getX() && localizacao.getY()==localizacao1.getY());
    }
    
}
