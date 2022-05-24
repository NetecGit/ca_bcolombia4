
package demos;

class ASin {
    private static final ASin instancia = new ASin();
    
    private ASin() {
        
    }
    
    public static ASin getInstance() {
        return instancia;
    }
}

public class DemoSinglenton {
    public static void main(String[] args) {
       // ASin a = new ASin();
       
       ASin a = ASin.getInstance();
    }
}
