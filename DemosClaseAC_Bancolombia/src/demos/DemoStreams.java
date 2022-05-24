
package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class DemoStreams {
    public static void main(String[] args) {
        String[] nombres = {
            "Carlos", "Anibal", "Daniel", "Danny", "German",
            "Jorge", "Jose", "Luis", "Marlon" , "Santiago"
        };
        
        ArrayList<String> lista = new ArrayList(Arrays.asList(nombres));
        
        lista.add("Blanca");
        //System.out.println(lista);
        
        long res = lista.stream()   // Stream sincronos
             .filter(s -> !s.startsWith("J"))
             .filter (s -> s.contains("n"))
             .sorted(Comparator.reverseOrder())
             .mapToInt(s -> s.length())
             .peek(System.out::println)
             .sum();
        
        System.out.println("------------");
        System.out.println("res "+ res);
             
            
            
        
        
    }
}
