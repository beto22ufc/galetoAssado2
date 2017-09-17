/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frangoassado;

import java.util.ArrayList;
import modelo.Armadilha;
import modelo.Jogador;
import modelo.Jogo;
import modelo.Localizacao;
import modelo.Model;
import views.JInicialFrame;

/**
 *
 * @author N2S-PC03
 */
public class FrangoAssado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jogador jogador = new Jogador("Wallison Carlos", new Localizacao(0,0));
        ArrayList<Armadilha> armadilhas = new ArrayList<>();
        for(int i=0;i<40;i++){
            armadilhas.add(new Armadilha("Fire", new Localizacao(((int)(Math.random()*20)), ((int)(Math.random()*10)))));
        }
        JInicialFrame initial = new JInicialFrame(Model.getInstance(new Jogo(jogador, armadilhas)));
        initial.setVisible(true);
        initial.setResizable(false);
        initial.setLocationRelativeTo(null);
    }
    
}
