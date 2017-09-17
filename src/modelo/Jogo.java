/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import views.JInicialFrame;

/**
 *
 * @author N2S-PC03
 */
public class Jogo {
    private Jogador jogador;
    private ArrayList<Armadilha> armadilhas = new ArrayList<>();
    private ArrayList<Vida> vidas = new ArrayList<>();
    
    public Jogo(){
    
    }
    
    public Jogo(Jogador jogador, ArrayList<Armadilha> armadilhas,ArrayList<Vida> vidas){
        this.jogador = jogador;
        this.armadilhas = armadilhas;
        this.vidas = vidas;
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
    
    public boolean colisaoJogado(Localizacao localizacao, Localizacao localizacao1){
        return (((localizacao.getX()/60)==localizacao1.getX() && (localizacao.getY()/60)==localizacao1.getY()));
    }
    public boolean colisaoVida(Localizacao localizacao, Localizacao localizacao1){
        return (((localizacao.getX())==localizacao1.getX() && (localizacao.getY())==localizacao1.getY()));
    }

    public ArrayList<Vida> getVidas() {
        return vidas;
    }

    public void setVidas(ArrayList<Vida> vidas) {
        this.vidas = vidas;
    }
    
    
    
    public boolean gameOver(Jogador jogador, Armadilha armadilha){
        return colisaoJogado(jogador.getLocalizacao(), armadilha.getLocalizacao());
    }
    
    public boolean ganhou(){
        return (this.getJogador().getLocalizacao().getX()>=1020);
    }
    
    public int plusVida(Jogador jogador){
        int plus = -1;
        for(int i=0;i<vidas.size();i++){
            Vida v = this.vidas.get(i);
            if(colisaoJogado(jogador.getLocalizacao(), v.getLocalizacao()) && !v.isPega()){
                plus = i;
                v.setPega(true);
                break;
            }
        }
        if(plus>-1){
            jogador.setVida(jogador.getVida()+1);
        }
        return plus;
    }
    public static void start(){
        int yj = ((int)(Math.random()*9));
        Jogador jogador = new Jogador("Wallison Carlos", new Localizacao(0,yj*60));
        ArrayList<Armadilha> armadilhas = new ArrayList<>();
        ArrayList<Vida> vidas = new ArrayList<>();
        Jogo jogo = new Jogo();
        jogo.setJogador(jogador);
        for(int i=0;i<40;i++){
            int x = ((int)(Math.random()*17)), y = ((int)(Math.random()*9));
            x = (x >0) ?  x : 1;
            x = ((x*60)>=1020) ? x-1 : x;
            armadilhas.add(new Armadilha("Fire", new Localizacao(x,y)));
        }
        jogo.setArmadilhas(armadilhas);
        int i =2;
        while(i!=0){
            int x = ((int)(Math.random()*17)), y = ((int)(Math.random()*9));
            x = (x >3) ?  x : 10;
            x = ((x*60)>=840) ? x-1 : x;
            Vida vida = new Vida(new Localizacao(x, y));
            boolean colisao = false;
            for(Armadilha a: armadilhas){
                colisao = jogo.colisaoVida(vida.getLocalizacao(), a.getLocalizacao());
            }
            if(!colisao){
                i--;
                vidas.add(vida);
            }
        }
        jogo.setVidas(vidas);
        JInicialFrame initial = new JInicialFrame(Model.getInstance(jogo));
        initial.setVisible(true);
        initial.setResizable(false);
        initial.setLocationRelativeTo(null);
    }
}
