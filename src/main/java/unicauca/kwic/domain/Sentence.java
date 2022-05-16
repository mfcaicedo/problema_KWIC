
package unicauca.kwic.domain;

import java.util.ArrayList;

/**
 *
 * @author Milthon F Caicedo Jurado 
 */
public class Sentence {
    
    /**
     * Atributos 
     */
    private String sentence;
    ArrayList<String> lstCadenas; 
    
    /**
     * Constructor 
     */
    public Sentence(String sentence){
        this.sentence = sentence; 
        this.lstCadenas = new ArrayList<String>();
    }
    public Sentence(){
        this.lstCadenas = new ArrayList<String>();
    }
    /**
     * Getters and setters 
     */
    public String getSentence(){
        return sentence;
    }
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    public ArrayList<String> getLstCadenas() {
        return lstCadenas;
    }
    public void setLstCadenas(ArrayList<String> lstCadenas) {
        this.lstCadenas = lstCadenas;
    }

    
    /**
     * Devuelve otra sentencia eliminado la parte final y colocandola al principio 
     * @return sentence aplicando KWIC 
     */
    public String shift(){
        String[] partes; 
        partes = this.getSentence().split(" ");
        String auxPosAnt = partes[0];
        int tamanio = partes.length;
        String auxPosFinal = partes[tamanio - 1];
        partes[0] = auxPosFinal;        
        for (int i = 1; i < tamanio; i++) { 
            //actualizo posiciones 
            String auxActual = partes[i];
            partes[i] = auxPosAnt;
            auxPosAnt = auxActual;
        }
        sentence = ""; 
        for (int i = 0; i < tamanio; i++) {
            sentence += partes[i] +  " ";
        }
 
        return sentence;
    }
    
}
