
package demos;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class DemoFlat {
    public static void main(String[] args) {
        Path archivo = new File ("dialogos.txt").toPath();
        
        // Objects, Math, System, Arrays, Collections
        try {
            long mat = Files.lines (archivo)
                    .flatMap (li -> Stream.of(li.split(" ")))
                    .filter ( w -> w.contains("yo"))
                    .peek(System.out::println)
                    .count();
            
            System.out.println("# de concidendicas: " + mat);
        } catch (Exception e){
            System.err.println(e);
        }
    }
}
