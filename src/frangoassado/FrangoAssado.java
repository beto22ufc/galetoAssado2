/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frangoassado;

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
        JInicialFrame initial = new JInicialFrame(Model.getInstance());
        initial.setVisible(true);
        initial.setResizable(false);
        initial.setLocationRelativeTo(null);
    }
    
}
