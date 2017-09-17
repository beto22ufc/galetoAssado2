/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author Wallison
 */
public class Vida {
    private ImageIcon sprite;
    private Localizacao localizacao;
    private boolean pega;
    public Vida(){}
    
    public Vida(Localizacao localizacao) {
        this.sprite = new ImageIcon(getClass().getResource("/imagem/life.png"));
        this.localizacao = localizacao;
    }

    public ImageIcon getSprite() {
        return sprite;
    }

    public void setSprite(ImageIcon sprite) {
        this.sprite = sprite;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isPega() {
        return pega;
    }

    public void setPega(boolean pega) {
        this.pega = pega;
    }
    
    
    
    @Override
    public boolean equals(Object v){
        Vida vida = (Vida)v;
        return (this.getLocalizacao().getX() == vida.getLocalizacao().getX() && this.getLocalizacao().getY() == vida.getLocalizacao().getY());
    }
}
