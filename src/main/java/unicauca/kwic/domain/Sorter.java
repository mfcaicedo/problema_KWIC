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
        /**
         * def quicksort(lista_notas, izq, der):
        pivote = lista_notas[izq] # tomamos primer elemento como pivote
        i = izq                   # i realiza la busqueda de izquierda a derecha
        j = der                   # j realiza la búsqueda de derecha a izquierda
        aux = 0

        while(i < j):                                         # Mientras no se crucen las búsquedas
            while(lista_notas[i] >= pivote and i < j): i += 1 # Busca elemento mayor que el pivote
            while(lista_notas[j] < pivote): j -= 1            # Busca elemento menor que el pivote 
            if(i < j):                                        # si no se han cruzado
                aux = lista_notas[i]                          # los intercambia
                lista_notas[i] = lista_notas[j]
                lista_notas[j] = aux

        lista_notas[izq] = lista_notas[j]      # Se coloca el pivote en su lugar de forma que tendremos
        lista_notas[j] = pivote                # los menores a su izquierda y los mayores a su derecha

        if(izq < j-1):
            quicksort(lista_notas, izq, j-1)   # ordenamos subarray izquierdo 
        if(j+1 < der):                         
            quicksort(lista_notas, j+1, der)   # ordenamos subarray derecho 
         */ 
        
    }
}
