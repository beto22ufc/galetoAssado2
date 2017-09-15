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
        if(this.x >0){
            this.x = x;
        }else{this.x = 0;}
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
         if(this.y >0){
            this.y = y;
        }else{this.y = 0;}
    }
    
    
}
