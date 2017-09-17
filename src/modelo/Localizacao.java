/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author N2S-PC03
 */
public class Localizacao {
    private int x,y;
    
    public Localizacao(){}
    
    public Localizacao(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        if(this.x<=0){
            this.x =0;
        }
        if(this.x>=1140){
            this.x =1140;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        if(this.y>=480){
            this.y =480;
        }
        if(this.y<=0){
            this.y =0;
        }
    }
    
    
}
