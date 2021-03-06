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
    private Localizacao localizacao;
    private int vida = 3;
    public Jogador(){}
    
    public Jogador( String nome, Localizacao localizacao) {
        this.sprite = new ImageIcon(getClass().getResource("/imagem/player.png"));
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if(this.vida>3){
            this.vida = 3;
        }
        if(this.vida<0){
            this.vida =0;
        }
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
        this.getLocalizacao().setY(getLocalizacao().getY()-1);
        return this.localizacao;
    }
    public Localizacao moveBaixo(){
        this.getLocalizacao().setY(getLocalizacao().getY()+1);
        return this.localizacao;
    }
    
    
}
