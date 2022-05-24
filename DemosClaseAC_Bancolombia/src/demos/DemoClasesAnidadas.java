/*
   Classes anidadas

   * Inner Class Member
   * Static Nested
   * Local Inner
   * Anonymous Inner

*/
package demos;

class Afuera {   // Top-level | Outer class
    
    class A {   // Member de Afuera
        
        class B {  // Member de A
            
        }
        
        B b;
    }
    
    A a = this.new A();
    
    
    static class SA {
        
    }
    
    SA sa = new Afuera.SA();
    
    
    int m () {
        class Local {
            
        }
        
        return new Local().hashCode();
        
    }
}

public class DemoClasesAnidadas {
    public static void main(String[] args) throws Exception {
        
        System.out.println ( new Object () { @Override public String toString () { return "Hola";}});
        
        Runnable r = new Runnable (){
             @Override
             public void run () {
                 System.out.println("Runnable");
             }
        };
        
        Thread t = new Thread (r);
        t.start ();
        t.join();
        System.out.println("FIN");
    }
}
