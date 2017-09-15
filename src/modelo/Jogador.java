/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author N2S-PC03
 */
public class Jogador {
    private ImageIcon sprite;
    private String nome;
    private Pontuacao pontos;
    private Localizacao localizacao;

    public Jogador(){}
    
    public Jogador( String nome, Pontuacao pontos, Localizacao localizacao) {
        this.sprite = new ImageIcon(getClass().getResource("/imagem/player.png"));
        this.nome = nome;
        this.pontos = pontos;
        this.localizacao = localizacao;
    }

    
    
    public ImageIcon getSprite() {
        return sprite;
    }

    public void setSprite(ImageIcon sprite) {
        this.sprite = sprite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pontuacao getPontos() {
        return pontos;
    }

    public void setPontos(Pontuacao pontos) {
        this.pontos = pontos;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
    
    
    public Localizacao moveDireita(){
        this.getLocalizacao().setX(getLocalizacao().getX()+1);
        return this.localizacao;
    }
    public Localizacao moveEsquerda(){
        this.getLocalizacao().setX(getLocalizacao().getX()-1);
        return this.localizacao;
    }
    public Localizacao moveCima(){
        this.getLocalizacao().setY(getLocalizacao().getY()+1);
        return this.localizacao;
    }
    public Localizacao moveBaixo(){
        this.getLocalizacao().setY(getLocalizacao().getY()-1);
        return this.localizacao;
    }
    
    
}
