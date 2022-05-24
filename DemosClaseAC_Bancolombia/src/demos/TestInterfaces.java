package demos;

interface I {

    int sum(int a, int b);   //  Firma: sum (int,int)
}

interface O {

    int res(int a, int b);
}

interface Ope extends I, O {

}

class OpeImp implements Ope {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int res(int a, int b) {
        return a - b;
    }

}

public class TestInterfaces {

    public static void main(String[] args) {
        Ope op = new OpeImp();
        
        System.out.println(op.sum(5,5) + " " + op.res(3,4));

    }
}
