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
public class Armadilha {
    private ImageIcon sprite;
    private String nome;
    private Localizacao localizacao;
    private boolean colidiu;
    public Armadilha(){}
    
    public Armadilha( String nome, Localizacao localizacao) {
        this.sprite = new ImageIcon(getClass().getResource("/imagem/fogo.gif"));
        this.nome = nome;
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

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isColidiu() {
        return colidiu;
    }

    public void setColidiu(boolean colidiu) {
        this.colidiu = colidiu;
    }
    
    
    
    @Override
    public boolean equals(Object a){
        Armadilha armadilha = (Armadilha)a;
        return (this.getLocalizacao().getX() == armadilha.getLocalizacao().getX() && this.getLocalizacao().getY() == armadilha.getLocalizacao().getY());
    }
}
