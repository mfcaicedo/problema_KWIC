package unicauca.kwic.domain;

import java.util.ArrayList;
import unicauca.kwic.domain.Sentence;

/**
 *
 * @author Milthon F Caicedo Jurado 
 */
public class Sorter {
    
    /**
     * Atributos 
     */
    ArrayList<Sentence> lstSentences;
    /**
     * Constructor
     */
    public Sorter(){
        this.lstSentences = new ArrayList<Sentence>();
    }
    /**
     * Getters and setters
     */
    public ArrayList<Sentence> getLstSentences() {
        return lstSentences;
    }
    public void setLstSentences(ArrayList<Sentence> lstSentences) {
        this.lstSentences = lstSentences;
    }
    /**
     * Crear Sentences
    */
    public void crearSentence(String sentence){
        Sentence objSentence = new Sentence(sentence); 
        if(objSentence != null){
            this.lstSentences.add(objSentence);
        }
    }
    /**
     * Ordena los objetos sentence por orden alfabético sin diferenciar 
     * mayúsculas de minúsculas 
     */
    public void sort(ArrayList<Sentence> lstSentences, int izq, int der){
        
        Sentence pivote = lstSentences.get(izq);
        int i = izq;
        int j = der;
        Sentence aux;
        while( i < j){
            while(lstSentences.get(i).getSentence().compareToIgnoreCase(pivote.getSentence()) <= 0 && i < j) i++;
            while(lstSentences.get(j).getSentence().compareToIgnoreCase(pivote.getSentence()) > 0) j--;
            if(i < j){
                aux = lstSentences.get(i);
                lstSentences.set(i, lstSentences.get(j));
                lstSentences.set(j, aux);
            }
        }
        lstSentences.set(izq, lstSentences.get(j));
        lstSentences.set(j, pivote);
        if(izq < j-1){
            sort(lstSentences, izq, j-1);
        }
        if(j+1 < der){
            sort(lstSentences, j+1, der);
        }
    }
}
