/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Wallison
 */
class TarefaRepetida extends TimerTask {  
   int vezes = 1;  
   String mensagem;  
   int tipo;  
  
   public TarefaRepetida(String mensagem, int tipo) {  
      this.mensagem = mensagem;  
      this.tipo = tipo;  
   }  
  
   public void run() {  
      if (vezes-- == 0) {  
          JOptionPane.showMessageDialog(null, mensagem, "Resultado", tipo);  
         this.cancel();  
      }  
   }  
}  
