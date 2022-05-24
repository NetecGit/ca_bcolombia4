package demos;

@FunctionalInterface
abstract interface OP {

    public abstract int m(int a, int b);
}

public class DemoLambdas {

    public static void main(String[] args) {
        OP op = new OP() {
            @Override
            public int m(int a, int b) {
                return a + b;
            }
        };

        OP pp = (a, b) -> a * b;

        System.out.println(pp.m(4, 5));
        System.out.println(op.m(2, 1));

    }
}
