
package unicauca.kwic.presentation;
import unicauca.kwic.domain.Sentence;
import unicauca.kwic.domain.Sorter;
/**
 *
 * @author Milthon F Caicedo Jurado 
 */
public class TestKWIC {

    /**
     * @param args the command line arguments
     */
    Sorter objSorter;
    public static void main(String[] args) {
        // TODO code application logic here
        Sorter objSorter = new Sorter();
        objSorter.crearSentence("Hola soy milthon");
        objSorter.crearSentence("ada es una serie");
        
        System.out.println("Frases sin rotaciones");
        for(Sentence objSentence : objSorter.getLstSentences()){
            System.out.println(" " + objSentence.getSentence());
        }
        //Rotación sentencia 1 
        objSorter.getLstSentences().get(0).shift(); //out -> milthon Hola soy 
        objSorter.getLstSentences().get(0).shift(); //out -> soy mithon Hola 
        
        //Rotación setencia 2 
        objSorter.getLstSentences().get(1).shift(); //put -> serie ada es una
        System.out.println("Frases luego de aplicar las rotaciones");
        for (Sentence objSentence : objSorter.getLstSentences()) {
            System.out.println(" " + objSentence.getSentence());
        }
        
        int der = objSorter.getLstSentences().size() - 1;
        objSorter.sort(objSorter.getLstSentences(), 0, der);
        
        System.out.println("Frases ordenadas alfabéticamente sin distinguir mayúsculas de minúsculas");
        for (int i = 0; i< objSorter.getLstSentences().size(); i++) {
            System.out.println(" " + objSorter.getLstSentences().get(i).getSentence());
        }
        //Estoy desde el main 
    }
    
}
