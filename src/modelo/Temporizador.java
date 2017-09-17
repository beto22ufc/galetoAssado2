/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Timer;

/**
 *
 * @author Wallison
 */
public class Temporizador {  
    private Timer timer;     
    public static void exibirMensagem(int tempo, String mensagem, int tipo) {  
        Timer timer = new Timer();  
        timer.schedule(new TarefaRepetida(mensagem, tipo), 0, tempo * 1000);  
    }     
} 
