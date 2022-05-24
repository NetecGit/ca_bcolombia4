
package demos;

class Animal {}
class Gato extends Animal {}
class Perro extends Animal {}


public class DemoAsignaciones {
    public static void main(String[] args) {
        //  Asignación Fuertemente tipificada    
        Animal animal = new Animal ();
        Gato gato = new Gato();
        Perro perro = new Perro ();
    
        // Asignaciones no válidas.
        // Perro p = (Perro) new Gato();
        // Gato g = (Gato) new Perro();
        
        // Asignaciones Covariante
        Animal a = new Gato();
        Animal q = new Perro();
        
        // Asignaciones 
        Animal b = new Gato();
        Gato gg = (Gato) b;   // Casting (tipo)
        
        Animal c = new Gato ();
        Perro pp = (Perro)c;   // ClassCastException
    
    }
}
