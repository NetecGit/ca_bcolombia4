
package demos;


abstract class A {
    
    int m() {
        return 100;
    }
}

public class DedmoClaseAbstracta {
    public static void main(String[] args) {
        A a = new A(){
            int m () {
                return 5;
            }
        };   // Clase anidada y anonima, que extiende la clase A
        
        System.out.println(a.m());
    }
}
