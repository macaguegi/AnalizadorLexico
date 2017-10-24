/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reemplazopalabrasreservadas;

/**
 *
 * @author Camila
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogicaAnalizador {
    String texto;
    
    public String leerArchivo(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      texto="";
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
          texto+=cadena+ "\r\n";
      }
      b.close();
      return texto;
}
    
    
  public String cambiar(String te){
      String reemplazo="";
      reemplazo = te.replaceAll("while", "WHILE");
      reemplazo = reemplazo.replaceAll("do", "DO");
      reemplazo = reemplazo.replaceAll("if", "IF");
      reemplazo = reemplazo.replaceAll("else", "ELSE");
      return reemplazo;
  }
  
  public void crearArchivo(String p) throws IOException{
  File ficheroNuevo = new File ("C:/Users/Camila/Documents/NetBeansProjects/reemplazoPalabrasReservadas/ficheroN.txt");
  FileWriter w = new FileWriter(ficheroNuevo);
  BufferedWriter bw = new BufferedWriter(w);
  PrintWriter wr = new PrintWriter(bw);  

  try {

  if (ficheroNuevo.exists()){
    wr.write(p);
    System.out.println("El fichero se ha creado correctamente");
    wr.close();
    bw.close();
  }
  else{
    System.out.println("No ha podido ser creado el fichero");
    System.out.println(p);
}
  }catch (IOException ioe) {
    ioe.printStackTrace();
}
  }
  
    public String ProbarLexerFile(String text) throws IOException{
        File fichero=new File("fichero.txt");//creando fichero txt en raiz
        PrintWriter writer;
        
        try{
            writer=new PrintWriter(fichero);
            writer.print(text);//ingresado ecuacion
            writer.close();
        }
        catch(FileNotFoundException ex){
            Logger.getLogger(LogicaAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Reader reader;
        reader = new BufferedReader(new FileReader("fichero.txt"));
        Lexer lexer=new Lexer(reader);
        String Resultados="";
        //se comienza a evaluar cada caracter
        while(true){
            Token token=lexer.yylex();
        if(token==null){Resultados=Resultados+"FIN";
            System.out.print(Resultados);//mostrando los resultados
            return Resultados;
        }//termina evaluacion
        
        switch(token){
        case ERROR://aqui se guardan los errores de lo que no coincide 
            Resultados=Resultados+"Error, el simbolo no coincide \n";
            break;
            
        case Variable: case Numero: //aqui se guardan las variables y los numeros
            Resultados=Resultados+"Token:"+token+" "+lexer.lexeme+"\n";
            break;
        
        case While:
            Resultados=Resultados+"Token:"+token+"\n";
            break;
            
        case Do:
            Resultados=Resultados+"Token:"+token+"\n";
            break;
            
        case If:
            Resultados=Resultados+"Token:"+token+"\n";
            break;
            
        case Else:
            Resultados=Resultados+"Token:"+token+"\n";
            
        default:
            Resultados=Resultados+"Token:"+token+"\n";//se guardan los operandos +- etc
                
                    }	
        
                        }	
        }


}