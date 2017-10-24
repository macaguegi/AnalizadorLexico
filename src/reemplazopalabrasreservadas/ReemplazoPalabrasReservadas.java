/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reemplazopalabrasreservadas;

import java.io.File;

/**
 *
 * @author Camila
 */
public class ReemplazoPalabrasReservadas {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        String path ="C:/Users/Camila/Documents/NetBeansProjects/reemplazoPalabrasReservadas/src/reemplazopalabrasreservadas/lexer.flex";
        generarLexer(path);
    }

 public static void generarLexer(String path){
     
     File file = new File(path);
     JFlex.Main.generate(file);
 }
    
}
