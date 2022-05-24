package demos;

class Box<T> {
    private T regalo;
    
    public Box (T regalo) {
        this.regalo= regalo;
                
    }
    
    public T getRegalo() {
        return regalo;
    }
    
    public void setRagalo(T regalo) {
        this.regalo = regalo;
    }
}

class BoxString {

    private String regalo;

    public BoxString(String regalo) {
        this.regalo = regalo;
    }

    public String getRegalo() {
        return regalo;
    }

    public void setRegalo(String regalo) {
        this.regalo = regalo;
    }
}

class BoxInteger {

    private Integer regalo;

    public BoxInteger(Integer regalo) {
        this.regalo = regalo;
    }

    public Integer getRegalo() {
        return regalo;
    }

    public void setRegalo(Integer regalo) {
        this.regalo = regalo;
    }

}

public class DemoGenerics {

    public static void main(String[] args) {
        
        // Codigo no generico
        BoxString  s = new BoxString("Colores");
        BoxInteger b = new BoxInteger(10);
    
        // Codigo Generico, Java 1.5
        Box<String> sa = new Box<>("Colores");
        Box<Integer> ba = new Box<Integer> (10);
        
        Box<Box<Integer>> bb = new Box<> (ba);
    }
}
